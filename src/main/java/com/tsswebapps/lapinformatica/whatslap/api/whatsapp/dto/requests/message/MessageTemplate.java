package com.tsswebapps.lapinformatica.whatslap.api.whatsapp.dto.requests.message;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MessageTemplate(

	@JsonProperty("template")
	Template template,

	@JsonProperty("messaging_product")
	String messagingProduct,

	@JsonProperty("to")
	String to,

	@JsonProperty("type")
	String type
) {
}