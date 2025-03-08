package com.tsswebapps.lapinformatica.whatslap.api.whatsapp.dto.responses.message.error;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ErrorData(

	@JsonProperty("messaging_product")
	String messagingProduct,

	@JsonProperty("details")
	String details
) {
}