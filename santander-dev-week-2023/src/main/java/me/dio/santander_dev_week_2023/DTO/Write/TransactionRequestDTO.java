package me.dio.santander_dev_week_2023.DTO.Write;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;

import java.math.BigDecimal;

public class TransactionRequestDTO {
    public TransactionRequestDTO(Long contaOrigemId, Long contaDestinoId, BigDecimal saldoContaAntes, BigDecimal saldoContaApos, BigDecimal valor) {
        this.contaOrigemId = contaOrigemId;
        this.contaDestinoId = contaDestinoId;
        this.saldoContaAntes = saldoContaAntes;
        this.saldoContaApos  = saldoContaApos;
        this.valor = valor;
    }

    public TransactionRequestDTO() {
    }

    @JsonProperty("contaOrigemId")
    public Long contaOrigemId;

    @JsonProperty("contaDestinoId")
    public Long contaDestinoId;

    @JsonProperty("valor")
    public BigDecimal valor;

    @JsonProperty("saldo_conta_antes")
    private BigDecimal saldoContaAntes;

    @JsonProperty("saldo_conta_apos")
    private BigDecimal saldoContaApos;
}