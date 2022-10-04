package ericauction.ericaution.interfaces.rest.auction;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import ericauction.ericaution.domain.persistence.auction.FileEntity;
import ericauction.ericaution.domain.response.auction.FileUploadResponseDto;
import ericauction.ericaution.service.Auction.FileService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequiredArgsConstructor
public class FileController {
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    private final FileService service;

    @GetMapping("/")
    public String controllerMain() {
        return "Hello~ File Upload Test.";
    }

    @GetMapping("/uploadFile/{id}")
    public Optional<FileEntity> getUploadFile(@PathVariable Long id){
        return service.getUploadFile(id);
    }


    @GetMapping("/uploadFiles")
    public Iterable<FileEntity> getUploadFileList(){
        return service.getFileList();
    }


    @PostMapping("/uploadFile")
    public FileEntity uploadFile(@RequestParam("file") MultipartFile file) {
        FileEntity fileEntity = service.storeFile(file);

//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(fileName)
//                .toUriString();
//
//        return new FileUploadResponseDto(fileName, fileDownloadUri, file.getContentType(), file.getSize());
        return fileEntity;
    }

    @PostMapping("/uploadMultipleFiles")
    public List<FileEntity> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files){
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request){
        // Load file as Resource
        Resource resource = service.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());    //resource 파일의 MimeType을 얻어와서 저장
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }


        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    // 여기가 지금 삽질하고 있는 부분...
    @GetMapping("/downloadFiles")
    public ResponseEntity<List<Resource>> downloadFiles(@RequestParam("fileNames") String[] fileNames, HttpServletRequest request){

        List<Resource> resources = Arrays.asList(fileNames)
                                    .stream()
                                    .map(fileName -> service.loadFileAsResource(fileName))
                                    .collect(Collectors.toList());

        // Try to determine file's content type
        String contentType = null;
        String getResultOfFileNames = "";

        for(Resource resource : resources){

            try {
                contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());    //resource 파일의 MimeType을 얻어와서 저장
            } catch (IOException ex) {
                logger.info("Could not determine file type.");
            }

            // Fallback to the default content type if type could not be determined
            if(contentType == null) {
                contentType = "application/octet-stream";
            }
            getResultOfFileNames += resource.getFilename() + ",";
        }
        getResultOfFileNames = getResultOfFileNames.substring(0,getResultOfFileNames.length()-2);   // 마지막 콤마 삭제

        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(contentType))
//                .contentType(MediaType.parseMediaType("ArrayList"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filenames=\"" + getResultOfFileNames + "\"")
                .body(resources);
    }
}
