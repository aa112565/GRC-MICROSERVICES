package com.asymmetrix.grc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GRCTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(GRCTemplateApplication.class, args);
	}

}
