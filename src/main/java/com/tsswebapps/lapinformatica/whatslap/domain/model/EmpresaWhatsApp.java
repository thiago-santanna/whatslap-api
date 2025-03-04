package com.tsswebapps.lapinformatica.whatslap.domain.model;

import com.tsswebapps.lapinformatica.whatslap.api.local.dto.EmpresaWhatsDto;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "empresas_whatsapp")
public class EmpresaWhatsApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "token_fixo")
    private String tokenFIxo;

    @Column(name = "id_telefone")
    private String idTelefone;

    @Column(name = "versao_api_whats")
    private String versaoApiWhats;

    @Column(name = "name")
    private String name;

    public EmpresaWhatsApp() {
    }

    public EmpresaWhatsApp(Long id, String tokenFIxo, String idTelefone, String versaoApiWhats, String name) {
        this.id = id;
        this.tokenFIxo = tokenFIxo;
        this.idTelefone = idTelefone;
        this.versaoApiWhats = versaoApiWhats;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTokenFIxo() {
        return tokenFIxo;
    }

    public void setTokenFIxo(String tokenFIxo) {
        this.tokenFIxo = tokenFIxo;
    }

    public String getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(String idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getVersaoApiWhats() {
        return versaoApiWhats;
    }

    public void setVersaoApiWhats(String versaoApiWhats) {
        this.versaoApiWhats = versaoApiWhats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EmpresaWhatsApp that = (EmpresaWhatsApp) o;
        return Objects.equals(id, that.id) && Objects.equals(idTelefone, that.idTelefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idTelefone);
    }

    @Override
    public String toString() {
        return "EmpresaWhatsApp{" +
                "id=" + id +
                ", tokenFIxo='" + tokenFIxo + '\'' +
                ", idTelefone='" + idTelefone + '\'' +
                ", idApiWhats='" + versaoApiWhats + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public void parseDataFromDto(EmpresaWhatsDto empresaDto) {
        if(Objects.nonNull(empresaDto.idTelefone())) {
            this.setIdTelefone(empresaDto.idTelefone());
        }

        if(Objects.nonNull(empresaDto.tokenFIxo())) {
            this.setTokenFIxo(empresaDto.tokenFIxo());
        }

        if(Objects.nonNull(empresaDto.versaoApiWhats())) {
            this.setVersaoApiWhats(empresaDto.versaoApiWhats());
        }

        if(Objects.nonNull(empresaDto.name())) {
            this.setName(empresaDto.name());
        }
    }
}
