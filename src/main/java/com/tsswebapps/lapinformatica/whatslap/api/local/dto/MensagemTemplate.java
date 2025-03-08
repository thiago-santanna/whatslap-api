package com.tsswebapps.lapinformatica.whatslap.api.local.dto;

import com.tsswebapps.lapinformatica.whatslap.api.whatsapp.dto.requests.message.MessageTemplate;

public class MensagemTemplate extends MensagemPadrao {
    private MessageTemplate messageTemplate;

    public MensagemTemplate(MessageTemplate messageTemplate) {
        super();
        this.messageTemplate = messageTemplate;
    }

    public MessageTemplate getMessage() {
        return messageTemplate;
    }

    @Override
    public String toString() {
        return "MensagemTemplateTexto{" +
                "message=" + messageTemplate +
                '}';
    }
}
