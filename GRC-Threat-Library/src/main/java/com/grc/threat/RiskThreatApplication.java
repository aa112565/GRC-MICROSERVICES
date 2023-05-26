package com.grc.threat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RiskThreatApplication {

	public static void main(String[] args) {
		SpringApplication.run(RiskThreatApplication.class, args);
	}

}
