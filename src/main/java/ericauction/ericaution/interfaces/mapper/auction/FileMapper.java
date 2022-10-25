package ericauction.ericaution.interfaces.mapper.auction;

import ericauction.ericaution.domain.persistence.auction.FileEntity;
import ericauction.ericaution.domain.response.auction.UploadFileResponseDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class FileMapper {

    public UploadFileResponseDto fileEntityToUploadFileResponseDto(FileEntity fileEntity){

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileEntity.getFileName())
                .toUriString();

        return UploadFileResponseDto.builder()
                .id(fileEntity.getId())
                .fileName(fileEntity.getFileName())
                .fileDownloadUri(fileDownloadUri)
                .fileType(fileEntity.getMimeType())
                .size(fileEntity.getSize())
                .build();
    }
}
