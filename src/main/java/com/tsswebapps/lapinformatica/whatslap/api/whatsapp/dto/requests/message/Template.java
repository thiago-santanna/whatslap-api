package com.tsswebapps.lapinformatica.whatslap.api.whatsapp.dto.requests.message;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public record Template(

	@JsonProperty("components")
	List<ComponentsItem> components,

	@JsonProperty("name")
	String name,

	@JsonProperty("language")
	Language language
) {
}