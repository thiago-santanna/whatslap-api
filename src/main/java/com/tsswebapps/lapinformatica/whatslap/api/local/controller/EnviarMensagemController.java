package com.tsswebapps.lapinformatica.whatslap.api.local.controller;

import com.tsswebapps.lapinformatica.whatslap.api.local.dto.MensagemComMidia;
import com.tsswebapps.lapinformatica.whatslap.api.local.dto.MensagemPadrao;
import com.tsswebapps.lapinformatica.whatslap.api.whatsapp.dto.ResponseSendMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("messages")
public class EnviarMensagemController implements SendMessages {
    @Override
    @PostMapping("/text")
    public ResponseEntity<ResponseSendMessage> enviarMensagemTexto(MensagemPadrao menssagemPadrao) {
        return null;
    }

    @Override
    @PostMapping("/pdf")
    public ResponseEntity<ResponseSendMessage> enviarMensagemTextoPdf(MensagemComMidia mensagemComPdf) {
        return null;
    }

    @Override
    @PostMapping("/img")
    public ResponseEntity<ResponseSendMessage> enviarMensagemTextoImg(MensagemComMidia mensagemComImg) {
        return null;
    }
}
