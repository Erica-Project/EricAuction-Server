package ericauction.ericaution;

import ericauction.ericaution.property.FileUploadProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties({
		FileUploadProperties.class
})
public class EricautionApplication {

	public static void main(String[] args) {
		SpringApplication.run(EricautionApplication.class, args);
	}

}
