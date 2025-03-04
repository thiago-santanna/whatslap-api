package com.tsswebapps.lapinformatica.whatslap;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
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
