package me.dio.santander_dev_week_2023.DTO.Read;

import com.fasterxml.jackson.annotation.JsonProperty;
import me.dio.santander_dev_week_2023.Models.Transaction;

import java.math.BigDecimal;
import java.util.List;


public class AccountResponseDTO {
    public AccountResponseDTO(Long id, Long usuarioId, String numero, BigDecimal saldo, Integer codigoSeguranca, Boolean bloqueado, List<TransactionResponseDTO> transacoes, CardResponseDTO cartao) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.numero = numero;
        this.saldo = saldo;
        this.codigoSeguranca = codigoSeguranca;
        this.bloqueado = bloqueado;
        this.transacoes = transacoes;
        this.cartao = cartao;
    }

    public AccountResponseDTO() {
    }

    @JsonProperty("id")
    public Long id;

    @JsonProperty("usuarioId")
    public Long usuarioId;

    @JsonProperty("numero")
    public String numero;

    @JsonProperty("saldo")
    public BigDecimal saldo;

    @JsonProperty("bloqueado")
    public Boolean bloqueado;

    @JsonProperty("codigoSeguranca")
    public Integer codigoSeguranca;

    @JsonProperty("cartao")
    public CardResponseDTO cartao;

    @JsonProperty("transacoes")
    public List<TransactionResponseDTO> transacoes;
}