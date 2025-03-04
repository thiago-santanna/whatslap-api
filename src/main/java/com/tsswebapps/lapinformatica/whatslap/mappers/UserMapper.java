package com.tsswebapps.lapinformatica.whatslap.mappers;

import com.tsswebapps.lapinformatica.whatslap.api.local.dto.UserRequest;
import com.tsswebapps.lapinformatica.whatslap.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserRequest userRequest);
    UserRequest toDto(User user);
}
