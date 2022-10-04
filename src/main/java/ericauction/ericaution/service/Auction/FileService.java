package ericauction.ericaution.service.Auction;

import ericauction.ericaution.domain.persistence.auction.FileEntity;
import ericauction.ericaution.exception.FileDownloadException;
import ericauction.ericaution.exception.FileUploadException;
import ericauction.ericaution.interfaces.repository.auction.FileRepository;
import ericauction.ericaution.interfaces.repository.auction.ProductRepository;
import ericauction.ericaution.property.FileUploadProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
@Slf4j
//@RequiredArgsConstructor
public class FileService {

    private final FileRepository fileRepository;
    private final Path fileLocation;

    @Autowired
    public FileService(FileUploadProperties prop, FileRepository fileRepository){
        this.fileRepository = fileRepository;
        this.fileLocation = Paths.get(prop.getUploadDir())
                .toAbsolutePath().normalize();

        try{
            Files.createDirectories(this.fileLocation);
        }catch(Exception e){
            throw new FileUploadException("파일을 업로드할 디렉토리를 생성하지 못했습니다.", e);
        }
    }

    public FileEntity storeFile(MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try{
            if(fileName.contains(".."))
                throw new FileUploadException("파일명에 부적합한 문자가 포함되어 있습니다. "+fileName);

            Path targetLocation = this.fileLocation.resolve(fileName);

            // 나중에는 REPLACE_EXISTING 옵션 변경 필요성 존재
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            FileEntity fileEntity = new FileEntity(fileName, file.getSize(), file.getContentType());
            fileRepository.save(fileEntity);
            return fileEntity;  //Dto 객체로 바꿔주기
        }catch(Exception e){
            throw new FileUploadException("["+fileName+"] 파일 업로드에 실패하였습니다. 다시 시도하십시오.", e);
        }
    }

    public Iterable<FileEntity> getFileList(){
        Iterable<FileEntity> iterable = fileRepository.findAll();

        if(null == iterable) {
            throw new FileDownloadException("업로드 된 파일이 존재하지 않습니다.");
        }

        return  iterable;
    }

    public Optional<FileEntity> getUploadFile(Long id) {
        Optional<FileEntity> uploadFile = fileRepository.findById(id);

        if(null == uploadFile) {
            throw new FileDownloadException("해당 아이디["+id+"]로 업로드 된 파일이 존재하지 않습니다.");
        }
        return uploadFile;
    }


    public Resource loadFileAsResource(String fileName){
        try{
            Path filePath = this.fileLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if(resource.exists()){
                return resource;
            }else{
                throw new FileDownloadException(fileName+" 파일을 찾을 수 없습니다.");
            }
        }catch(MalformedURLException e){
            throw new FileDownloadException(fileName+" 파일을 찾을 수 없습니다.", e);
        }
    }

    public Resource loadFilesAsResource(String fileName){
        try{
            Path filePath = this.fileLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if(resource.exists()){
                return resource;
            }else{
                throw new FileDownloadException(fileName+" 파일을 찾을 수 없습니다.");
            }
        }catch(MalformedURLException e){
            throw new FileDownloadException(fileName+" 파일을 찾을 수 없습니다.", e);
        }
    }
}
