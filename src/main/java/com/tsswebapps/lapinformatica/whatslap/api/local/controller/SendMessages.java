package com.tsswebapps.lapinformatica.whatslap.api.local.controller;


import com.tsswebapps.lapinformatica.whatslap.api.local.dto.MensagemPadrao;
import com.tsswebapps.lapinformatica.whatslap.api.local.dto.MensagemTemplate;
import com.tsswebapps.lapinformatica.whatslap.api.whatsapp.dto.responses.message.success.ResponseSuccessMessageTemplate;
import org.springframework.http.ResponseEntity;

public interface SendMessages {
    ResponseEntity<ResponseSuccessMessageTemplate> enviarMensagemTemplate(MensagemTemplate mensagemTemplate);
    ResponseEntity<ResponseSuccessMessageTemplate> enviarMensagemTexto(MensagemPadrao menssagemPadrao);
}
