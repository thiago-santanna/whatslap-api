package com.tsswebapps.lapinformatica.whatslap.api.whatsapp.web.resources;

import com.tsswebapps.lapinformatica.whatslap.api.whatsapp.dto.requests.message.MessageTemplate;
import com.tsswebapps.lapinformatica.whatslap.api.whatsapp.dto.responses.message.success.ResponseSuccessMessageTemplate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "messagesWP", url = "https://graph.facebook.com")
public interface MessageResource {

    @PostMapping("/{version}/{phoneNumberID}/messages")
    ResponseSuccessMessageTemplate sendMessageTemplate(
            @PathVariable String version,
            @PathVariable String phoneNumberID,
            @RequestHeader(required = true, name = "Authorization") String token,
            @RequestBody MessageTemplate messageTemplate);
}
