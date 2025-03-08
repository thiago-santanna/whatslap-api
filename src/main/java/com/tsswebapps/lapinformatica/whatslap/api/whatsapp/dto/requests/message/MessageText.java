package com.tsswebapps.lapinformatica.whatslap.api.whatsapp.dto.requests.message;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MessageText(

	@JsonProperty("recipient_type")
	String recipientType,

	@JsonProperty("messaging_product")
	String messagingProduct,

	@JsonProperty("to")
	String to,

	@JsonProperty("text")
	Text text,

	@JsonProperty("type")
	String type
) {
}