package com.tsswebapps.lapinformatica.whatslap.domain.service;

import com.tsswebapps.lapinformatica.whatslap.domain.model.EmpresaWhatsApp;
import com.tsswebapps.lapinformatica.whatslap.api.local.dto.EmpresaWhatsDto;
import org.springframework.data.domain.Page;

public interface EmpresaWhatsService {
    EmpresaWhatsApp cadastrarEmpresaWhats(EmpresaWhatsDto empresa);
    EmpresaWhatsApp alterarEmpresa(EmpresaWhatsDto empresa, Long idEMpresa);
    void removerEmpresaWhats(Long idEmpresa);
    EmpresaWhatsApp findEmpresaWhats(Long idEmpresa);
    Page<EmpresaWhatsApp> listarTodas(int page, int size);
}
