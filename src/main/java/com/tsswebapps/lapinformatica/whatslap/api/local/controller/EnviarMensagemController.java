package com.tsswebapps.lapinformatica.whatslap.api.local.controller;

import com.tsswebapps.lapinformatica.whatslap.api.local.dto.MensagemPadrao;
import com.tsswebapps.lapinformatica.whatslap.api.local.dto.MensagemTemplate;
import com.tsswebapps.lapinformatica.whatslap.api.whatsapp.dto.responses.message.success.ResponseSuccessMessageTemplate;
import com.tsswebapps.lapinformatica.whatslap.api.whatsapp.web.SendMessagesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("messages")
public class EnviarMensagemController implements SendMessages {

    private final SendMessagesService messagesService;

    public EnviarMensagemController(SendMessagesService messagesService) {
        this.messagesService = messagesService;
    }

    @Override
    @PostMapping("/template")
    public ResponseEntity<ResponseSuccessMessageTemplate> enviarMensagemTemplate(MensagemTemplate mensagemTemplate) {
        return messagesService.sendMessageTemplate(mensagemTemplate);
    }

    @Override
    @PostMapping("/text")
    public ResponseEntity<ResponseSuccessMessageTemplate> enviarMensagemTexto(MensagemPadrao menssagemPadrao) {
        return null;
    }

}
