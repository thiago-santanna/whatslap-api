package com.tsswebapps.lapinformatica.whatslap.domain.repository;

import com.tsswebapps.lapinformatica.whatslap.domain.model.EmpresaWhatsApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaWhatsRepository extends JpaRepository<EmpresaWhatsApp, Long> {
}
