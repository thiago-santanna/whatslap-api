package com.tsswebapps.lapinformatica.whatslap.mappers;

import com.tsswebapps.lapinformatica.whatslap.domain.model.EmpresaWhatsApp;
import com.tsswebapps.lapinformatica.whatslap.domain.model.EmpresaWhatsDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EmpresaWhatsMapper {
    EmpresaWhatsApp toEntity(EmpresaWhatsDto empresaWhatsDto);
    EmpresaWhatsDto toDto(EmpresaWhatsApp empresaWhatsApp);
    void updateFromDto(EmpresaWhatsDto dto, @MappingTarget EmpresaWhatsApp entity);
}
