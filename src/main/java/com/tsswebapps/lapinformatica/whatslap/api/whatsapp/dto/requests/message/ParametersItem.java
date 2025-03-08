package com.tsswebapps.lapinformatica.whatslap.api.whatsapp.dto.requests.message;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ParametersItem(

	@JsonProperty("parameter_name")
	String parameterName,

	@JsonProperty("text")
	String text,

	@JsonProperty("type")
	String type
) {
}