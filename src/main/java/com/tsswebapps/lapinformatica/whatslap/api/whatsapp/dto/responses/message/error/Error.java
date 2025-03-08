package com.tsswebapps.lapinformatica.whatslap.api.whatsapp.dto.responses.message.error;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Error(

	@JsonProperty("code")
	int code,

	@JsonProperty("message")
	String message,

	@JsonProperty("type")
	String type,

	@JsonProperty("fbtrace_id")
	String fbtraceId,

	@JsonProperty("error_data")
	ErrorData errorData
) {
}