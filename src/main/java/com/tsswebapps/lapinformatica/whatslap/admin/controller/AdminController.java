package com.tsswebapps.lapinformatica.whatslap.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String adminHome(Model model) {
        model.addAttribute("message", "Bem-vindo à Página de Administração");
        return "adminHome";
    }

    @GetMapping("/admin/configuracoes")
    public String configuracoes(Model model) {
        model.addAttribute("message", "Configurações");
        return "configuracoes";
    }
}

