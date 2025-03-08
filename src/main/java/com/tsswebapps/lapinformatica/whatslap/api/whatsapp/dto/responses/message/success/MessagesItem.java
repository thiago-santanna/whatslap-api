package com.tsswebapps.lapinformatica.whatslap.api.whatsapp.dto.responses.message.success;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MessagesItem(

	@JsonProperty("message_status")
	String messageStatus,

	@JsonProperty("id")
	String id
) {
}