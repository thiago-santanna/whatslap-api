package com.tsswebapps.lapinformatica.whatslap.api.local.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/saudacao")
    public String saudacao() {
        return "Olá, bem-vindo à API!";
    }
}

