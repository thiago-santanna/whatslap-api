package com.tsswebapps.lapinformatica.whatslap.api.whatsapp.dto.requests.message;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Text(

	@JsonProperty("body")
	String body
) {
}