package ericauction.ericaution.domain.persistence.auction;

import ericauction.ericaution.domain.persistence.base.AuditableEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class FileEntity extends AuditableEntity {
    private String fileName;
    private Long size;
    private String mimeType;

    @Builder
    public FileEntity(String fileName, Long size, String mimeType){
        this.fileName = fileName;
        this.size = size;
        this.mimeType = mimeType;
    }

    @Override
    public String toString(){
        return "UploadFile [id=" + this.getId() + ", fileName=" + fileName + ", size=" + size + ", mimeType=" + mimeType + "]";
    }
}
