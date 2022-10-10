package ericauction.ericaution.domain.response.auction;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FileUploadResponseDto {
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private Long size;

    public FileUploadResponseDto(String fileName, String fileDownloadUri, String fileType, Long size) {
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }
}
