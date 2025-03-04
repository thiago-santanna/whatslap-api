package com.tsswebapps.lapinformatica.whatslap.api.local.dto;

import jakarta.validation.constraints.NotBlank;

public record EmpresaWhatsDto(
        String tokenFIxo,
        String idTelefone,
        String versaoApiWhats,
        String name
) {
}
