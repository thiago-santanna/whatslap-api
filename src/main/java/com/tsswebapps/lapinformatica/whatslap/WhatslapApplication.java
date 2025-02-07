package com.tsswebapps.lapinformatica.whatslap;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @io.swagger.v3.oas.annotations.info.Info(
				title = "Whatslap API",
				version = "1.0",
				description = "API de acesso a API do Whatslap"
		)
)
public class WhatslapApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhatslapApplication.class, args);
	}

}
