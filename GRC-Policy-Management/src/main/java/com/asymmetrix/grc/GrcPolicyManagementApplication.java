package com.asymmetrix.grc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

@ComponentScan
@SpringBootApplication
@EnableJpaAuditing
public class GrcPolicyManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrcPolicyManagementApplication.class, args);
	}

}
