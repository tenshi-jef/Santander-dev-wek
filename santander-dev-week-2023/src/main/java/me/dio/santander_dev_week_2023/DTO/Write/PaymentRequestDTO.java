package me.dio.santander_dev_week_2023.DTO.Write;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class PaymentRequestDTO {
    public PaymentRequestDTO(Long contaId, BigDecimal valor, String descricao) {
        this.contaId = contaId;
        this.valor = valor;
        this.descricao = descricao;
    }

    public PaymentRequestDTO() {
    }

    @JsonProperty("contaId")
    public  Long contaId;

    @JsonProperty("valor")
    public BigDecimal valor;

    @JsonProperty("descricao")
    public  String descricao;
}