package com.tsswebapps.lapinformatica.whatslap.api.local.controller;


import com.tsswebapps.lapinformatica.whatslap.api.local.dto.MensagemComMidia;
import com.tsswebapps.lapinformatica.whatslap.api.local.dto.MensagemPadrao;
import com.tsswebapps.lapinformatica.whatslap.api.whatsapp.dto.ResponseSendMessage;
import org.springframework.http.ResponseEntity;

public interface SendMessages {
    ResponseEntity<ResponseSendMessage> enviarMensagemTexto(MensagemPadrao menssagemPadrao);
    ResponseEntity<ResponseSendMessage> enviarMensagemTextoPdf(MensagemComMidia mensagemComPdf);
    ResponseEntity<ResponseSendMessage> enviarMensagemTextoImg(MensagemComMidia mensagemComImg);
}
