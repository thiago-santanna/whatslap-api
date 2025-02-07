package com.tsswebapps.lapinformatica.whatslap.domain.service;

import com.tsswebapps.lapinformatica.whatslap.domain.model.EmpresaWhatsApp;
import com.tsswebapps.lapinformatica.whatslap.domain.model.EmpresaWhatsDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface EmpresaWhatsService {
    void CadastrarEmpresaWhats(EmpresaWhatsDto empresa);
    void AlterarEmpresa(EmpresaWhatsDto empresa, Long idEMpresa);
    void removerEmpresaWhats(Long idEmpresa);
    Optional<EmpresaWhatsApp> findEmpresaWhats(Long idEmpresa);
}
