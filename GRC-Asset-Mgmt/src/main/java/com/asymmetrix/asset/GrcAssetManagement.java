package com.asymmetrix.asset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GrcAssetManagement {

	public static void main(String[] args) {
		SpringApplication.run(GrcAssetManagement.class, args);
	}

}
