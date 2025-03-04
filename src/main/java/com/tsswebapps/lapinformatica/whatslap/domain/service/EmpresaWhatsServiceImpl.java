package com.tsswebapps.lapinformatica.whatslap.domain.service;

import com.tsswebapps.lapinformatica.whatslap.domain.model.EmpresaWhatsApp;
import com.tsswebapps.lapinformatica.whatslap.api.local.dto.EmpresaWhatsDto;
import com.tsswebapps.lapinformatica.whatslap.domain.repository.EmpresaWhatsRepository;
import com.tsswebapps.lapinformatica.whatslap.exception.BadRequestException;
import com.tsswebapps.lapinformatica.whatslap.exception.NotFoundResourceException;
import com.tsswebapps.lapinformatica.whatslap.mappers.EmpresaWhatsMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class EmpresaWhatsServiceImpl implements EmpresaWhatsService {

    private final EmpresaWhatsRepository repository;
    private final EmpresaWhatsMapper mapper;

    public EmpresaWhatsServiceImpl(EmpresaWhatsRepository empresaWhatsRepositori, EmpresaWhatsMapper mapper) {
        this.repository = empresaWhatsRepositori;
        this.mapper = mapper;
    }

    @Override
    public EmpresaWhatsApp cadastrarEmpresaWhats(EmpresaWhatsDto empresa) {
        try {
            if (Objects.isNull(empresa.tokenFIxo())) {
                throw new BadRequestException("Dados inválidos ou não informados.");
            }
            return this.repository.save(mapper.toEntity(empresa));
        } catch (BadRequestException ex) {
            throw new BadRequestException(ex.getMessage());
        }
    }

    @Override
    @CachePut(value = "tokens", key = "#idEmpresa")
    public EmpresaWhatsApp alterarEmpresa(EmpresaWhatsDto empresaDto, Long idEmpresa) {
        try {
            EmpresaWhatsApp empresaWhatsApp = findEmpresaWhats(idEmpresa);
            empresaWhatsApp.parseDataFromDto(empresaDto);
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
        return this.repository.findById(idEmpresa).orElseThrow(
                () -> new NotFoundResourceException("Empresa não encontrada"));
    }

    @Override
    @Cacheable
    public Page<EmpresaWhatsApp> listarTodas(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }
}
