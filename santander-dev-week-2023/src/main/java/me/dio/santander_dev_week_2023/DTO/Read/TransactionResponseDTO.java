package me.dio.santander_dev_week_2023.DTO.Read;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionResponseDTO {
    public TransactionResponseDTO(Long id, Long contaOrigemId, Long contaDestinoId, BigDecimal valor, BigDecimal saldoContaAntes, BigDecimal saldoContaApos, LocalDateTime dataHora) {
        this.id = id;
        this.contaOrigemId = contaOrigemId;
        this.contaDestinoId = contaDestinoId;
        this.valor = valor;
        this.saldoContaAntes = saldoContaAntes;
        this.saldoContaApos = saldoContaApos;
        this.dataHora = dataHora;
    }

    public TransactionResponseDTO() {
    }

    @JsonProperty("id")
    public Long id;

    @JsonProperty("contaOrigemId")
    public Long contaOrigemId;

    @JsonProperty("contaDestinoId")
    public Long contaDestinoId;

    @JsonProperty("valor")
    public BigDecimal valor;

    @JsonProperty("saldoContaAntes")
    public BigDecimal saldoContaAntes;

    @JsonProperty("saldoContaApos")
    public BigDecimal saldoContaApos;

    @JsonProperty("dataHora")
    public LocalDateTime dataHora;
}