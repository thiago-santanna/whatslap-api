package com.tsswebapps.lapinformatica.whatslap.domain.service;

import com.tsswebapps.lapinformatica.whatslap.domain.model.EmpresaWhatsApp;
import com.tsswebapps.lapinformatica.whatslap.api.local.dto.EmpresaWhatsDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface EmpresaWhatsService {
    EmpresaWhatsApp CadastrarEmpresaWhats(EmpresaWhatsDto empresa);
    EmpresaWhatsApp AlterarEmpresa(EmpresaWhatsDto empresa, Long idEMpresa);
    void removerEmpresaWhats(Long idEmpresa);
    EmpresaWhatsApp findEmpresaWhats(Long idEmpresa);
}
