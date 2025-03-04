package com.tsswebapps.lapinformatica.whatslap.api.local.controller;

import com.tsswebapps.lapinformatica.whatslap.api.local.dto.EmpresaWhatsDto;
import com.tsswebapps.lapinformatica.whatslap.domain.model.EmpresaWhatsApp;
import com.tsswebapps.lapinformatica.whatslap.domain.service.EmpresaWhatsService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("empresa-whatsapp")
public class EmpresaWhatsController {

    private final EmpresaWhatsService empresaWhatsService;

    public EmpresaWhatsController(EmpresaWhatsService empresaWhatsService) {
        this.empresaWhatsService = empresaWhatsService;
    }

    @GetMapping
    public Page<EmpresaWhatsApp> listarTodas(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return empresaWhatsService.listarTodas(page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findEmpresaWhats(@PathVariable Long id) {
        var empresaWhats = empresaWhatsService.findEmpresaWhats(id);
        return ResponseEntity.ok(empresaWhats);
    }

    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<?> cadastrarEmpresaWhats(@RequestBody EmpresaWhatsDto empresa) {
        var empresaWhatsApp = empresaWhatsService.cadastrarEmpresaWhats(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaWhatsApp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterarEmpresa(
            @PathVariable Long id,
            @RequestBody EmpresaWhatsDto empresa
            ) {
        var empresaWhatsApp = empresaWhatsService.alterarEmpresa(empresa, id);
        return ResponseEntity.status(HttpStatus.OK).body(empresaWhatsApp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerEmpresaWhats(@PathVariable Long id) {
        empresaWhatsService.removerEmpresaWhats(id);
        return ResponseEntity.noContent().build();
    }
}
