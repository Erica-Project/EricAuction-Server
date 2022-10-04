package ericauction.ericaution.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@Primary
@ConfigurationProperties(prefix="file")
public class FileUploadProperties {
    private String uploadDir;


}
