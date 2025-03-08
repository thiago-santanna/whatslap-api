package com.tsswebapps.lapinformatica.whatslap.api.whatsapp.dto.responses.message.error;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseErrorMessageTemplate(

	@JsonProperty("error")
	Error error
) {
}