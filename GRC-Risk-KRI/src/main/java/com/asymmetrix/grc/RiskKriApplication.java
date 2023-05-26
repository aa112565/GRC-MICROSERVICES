package com.asymmetrix.grc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RiskKriApplication {

	public static void main(String[] args) {
		SpringApplication.run(RiskKriApplication.class, args);
	}

}
