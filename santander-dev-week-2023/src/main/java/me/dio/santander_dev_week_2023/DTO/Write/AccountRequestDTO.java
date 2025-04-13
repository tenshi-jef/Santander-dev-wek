package me.dio.santander_dev_week_2023.DTO.Write;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class AccountRequestDTO {
    public AccountRequestDTO(Long usuarioId, String numero, BigDecimal saldo, Boolean bloqueado) {
        this.usuarioId = usuarioId;
        this.numero = numero;
        this.saldo = saldo;
        this.bloqueado = bloqueado;
    }

    public AccountRequestDTO() {
    }

    @JsonProperty("usuarioId")
    public Long usuarioId;

    @JsonIgnore
    public String numero;

    @JsonIgnore
    public BigDecimal saldo;

    @JsonIgnore
    public Boolean bloqueado;
}
