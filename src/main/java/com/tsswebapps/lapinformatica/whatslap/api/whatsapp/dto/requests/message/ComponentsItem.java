package com.tsswebapps.lapinformatica.whatslap.api.whatsapp.dto.requests.message;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public record ComponentsItem(

	@JsonProperty("type")
	String type,

	@JsonProperty("parameters")
	List<ParametersItem> parameters
) {
}