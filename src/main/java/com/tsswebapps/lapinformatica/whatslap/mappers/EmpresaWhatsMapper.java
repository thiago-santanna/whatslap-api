package com.tsswebapps.lapinformatica.whatslap.mappers;

import com.tsswebapps.lapinformatica.whatslap.domain.model.EmpresaWhatsApp;
import com.tsswebapps.lapinformatica.whatslap.api.local.dto.EmpresaWhatsDto;
import org.mapstruct.*;

import java.util.Objects;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface EmpresaWhatsMapper {
    EmpresaWhatsApp toEntity(EmpresaWhatsDto empresaWhatsDto);
    EmpresaWhatsDto toDto(EmpresaWhatsApp empresaWhatsApp);
}
