package com.tsswebapps.lapinformatica.whatslap.domain.repository;

import com.tsswebapps.lapinformatica.whatslap.domain.model.UserApi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserApi, Long> {
    Optional<UserApi> findByUsername(String username);
}
