package ericauction.ericaution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EricautionApplication {

	public static void main(String[] args) {
		SpringApplication.run(EricautionApplication.class, args);
	}

}
