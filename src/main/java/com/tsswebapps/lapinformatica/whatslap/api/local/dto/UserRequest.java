package com.tsswebapps.lapinformatica.whatslap.api.local.dto;

import com.tsswebapps.lapinformatica.whatslap.domain.model.TypeUser;

public record UserRequest(
        String username,
        String password,
        TypeUser typeUser
) {}
