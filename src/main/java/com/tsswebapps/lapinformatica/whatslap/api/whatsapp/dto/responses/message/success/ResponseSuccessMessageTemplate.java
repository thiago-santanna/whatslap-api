package com.tsswebapps.lapinformatica.whatslap.api.whatsapp.dto.responses.message.success;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseSuccessMessageTemplate(

	@JsonProperty("messaging_product")
	String messagingProduct,

	@JsonProperty("messages")
	List<MessagesItem> messages,

	@JsonProperty("contacts")
	List<ContactsItem> contacts
) {
}