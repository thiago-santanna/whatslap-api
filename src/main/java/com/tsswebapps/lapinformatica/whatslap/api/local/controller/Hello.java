package com.tsswebapps.lapinformatica.whatslap.api.local.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping("/api/saudacao")
    public String saudacao() {
        return "Olá, bem-vindo à API!";
    }
}

