package com.tsswebapps.lapinformatica.whatslap.domain.service;

import com.tsswebapps.lapinformatica.whatslap.domain.model.EmpresaWhatsApp;
import com.tsswebapps.lapinformatica.whatslap.api.local.dto.EmpresaWhatsDto;
import com.tsswebapps.lapinformatica.whatslap.domain.repository.EmpresaWhatsRepository;
import com.tsswebapps.lapinformatica.whatslap.mappers.EmpresaWhatsMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.Optional;

public class EmpresaWhatsServiceImpl implements EmpresaWhatsService {

    private final EmpresaWhatsRepository repository;
    private final EmpresaWhatsMapper mapper;

    public EmpresaWhatsServiceImpl(EmpresaWhatsRepository empresaWhatsRepositori, EmpresaWhatsMapper mapper) {
        this.repository = empresaWhatsRepositori;
        this.mapper = mapper;
    }

    @Override
    public EmpresaWhatsApp CadastrarEmpresaWhats(EmpresaWhatsDto empresa) {
        try {
            return this.repository.save(mapper.toEntity(empresa));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @CachePut(value = "tokens", key = "#idEmpresa")
    public EmpresaWhatsApp AlterarEmpresa(EmpresaWhatsDto empresaDto, Long idEmpresa) {
        try {
            EmpresaWhatsApp empresaWhatsApp = this.repository.findById(idEmpresa).orElseThrow(RuntimeException::new);
            mapper.updateFromDto(empresaDto, empresaWhatsApp);
            return this.repository.save(empresaWhatsApp);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @CacheEvict(value = "tokens", key = "#idEmpresa")
    public void removerEmpresaWhats(Long idEmpresa) {
        try {
            this.repository.deleteById(idEmpresa);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Cacheable(value = "tokens", key = "#idEmpresa")
    public EmpresaWhatsApp findEmpresaWhats(Long idEmpresa) {
        return this.repository.findById(idEmpresa).orElseThrow(RuntimeException::new);
    }
}
