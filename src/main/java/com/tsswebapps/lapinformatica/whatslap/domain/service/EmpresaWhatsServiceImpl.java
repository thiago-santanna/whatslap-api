package com.tsswebapps.lapinformatica.whatslap.domain.service;

import com.tsswebapps.lapinformatica.whatslap.domain.model.EmpresaWhatsApp;
import com.tsswebapps.lapinformatica.whatslap.domain.model.EmpresaWhatsDto;
import com.tsswebapps.lapinformatica.whatslap.domain.repository.EmpresaWhatsRepository;
import com.tsswebapps.lapinformatica.whatslap.mappers.EmpresaWhatsMapper;

import java.util.Optional;

public class EmpresaWhatsServiceImpl implements EmpresaWhatsService {

    private final EmpresaWhatsRepository repository;
    private final EmpresaWhatsMapper mapper;

    public EmpresaWhatsServiceImpl(EmpresaWhatsRepository empresaWhatsRepositori, EmpresaWhatsMapper mapper) {
        this.repository = empresaWhatsRepositori;
        this.mapper = mapper;
    }

    @Override
    public void CadastrarEmpresaWhats(EmpresaWhatsDto empresa) {
        try {
            this.repository.save(mapper.toEntity(empresa));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void AlterarEmpresa(EmpresaWhatsDto empresaDto, Long idEMpresa) {
        try {
            EmpresaWhatsApp empresaWhatsApp = this.repository.findById(idEMpresa).orElseThrow(RuntimeException::new);
            mapper.updateFromDto(empresaDto, empresaWhatsApp);
            this.repository.save(empresaWhatsApp);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removerEmpresaWhats(Long idEmpresa) {
        try {
            this.repository.deleteById(idEmpresa);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<EmpresaWhatsApp> findEmpresaWhats(Long idEmpresa) {
        return this.repository.findById(idEmpresa);
    }
}
