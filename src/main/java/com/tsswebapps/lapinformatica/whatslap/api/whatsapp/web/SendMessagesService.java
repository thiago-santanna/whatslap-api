package com.tsswebapps.lapinformatica.whatslap.api.whatsapp.web;

import com.tsswebapps.lapinformatica.whatslap.api.local.dto.MensagemTemplate;
import com.tsswebapps.lapinformatica.whatslap.api.whatsapp.dto.responses.message.success.ResponseSuccessMessageTemplate;
import com.tsswebapps.lapinformatica.whatslap.api.whatsapp.web.resources.MessageResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SendMessagesService {

    private final MessageResource messageResource;

    public SendMessagesService(MessageResource messageResource) {
        this.messageResource = messageResource;
    }

    public ResponseEntity<ResponseSuccessMessageTemplate> sendMessageTemplate(MensagemTemplate messageTemplate) {
        ResponseSuccessMessageTemplate responseSendMessage = this.messageResource.sendMessageTemplate(
                messageTemplate.getVersaoApi(), messageTemplate.getPhoneNumberId(), messageTemplate.getToken(), messageTemplate.getMessage());
        return ResponseEntity.ok(responseSendMessage);
    }
}
