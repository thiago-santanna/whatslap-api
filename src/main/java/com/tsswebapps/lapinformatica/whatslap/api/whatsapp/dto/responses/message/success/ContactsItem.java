package com.tsswebapps.lapinformatica.whatslap.api.whatsapp.dto.responses.message.success;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ContactsItem(

	@JsonProperty("input")
	String input,

	@JsonProperty("wa_id")
	String waId
) {
}