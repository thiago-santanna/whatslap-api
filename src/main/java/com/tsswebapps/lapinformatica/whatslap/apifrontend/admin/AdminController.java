package com.tsswebapps.lapinformatica.whatslap.apifrontend.admin;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String adminHome(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        model.addAttribute("message", "Bem-vindo ! ".concat(username).concat(" à Página de Administração") );
        model.addAttribute("username", username);
        return "adminHome";
    }

    @GetMapping("/admin/empresa-whats")
    public String configuracoes(Model model) {
        model.addAttribute("message", "Configurações");
        return "empresa-whats";
    }
}

