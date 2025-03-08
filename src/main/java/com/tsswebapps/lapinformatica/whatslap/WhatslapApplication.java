package com.tsswebapps.lapinformatica.whatslap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableFeignClients
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class WhatslapApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhatslapApplication.class, args);
	}

}
