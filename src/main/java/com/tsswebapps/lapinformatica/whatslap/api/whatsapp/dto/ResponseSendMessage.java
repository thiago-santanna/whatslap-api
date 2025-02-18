package com.tsswebapps.lapinformatica.whatslap.api.whatsapp.dto;

import java.util.Set;

public record ResponseSendMessage(
     String messaging_product,
     Set<WhatsAppContacts> contacts,
     Set<MessagesIds> messages
) {
}
