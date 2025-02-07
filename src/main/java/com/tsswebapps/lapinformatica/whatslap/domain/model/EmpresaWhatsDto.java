package com.tsswebapps.lapinformatica.whatslap.domain.model;

import jakarta.persistence.Column;

public record EmpresaWhatsDto(
    String tokenFIxo,
    String idTelefone,
    String versaoApiWhats,
    String name
) {
}
