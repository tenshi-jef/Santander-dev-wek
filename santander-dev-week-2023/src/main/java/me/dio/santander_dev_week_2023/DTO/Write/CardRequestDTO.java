package me.dio.santander_dev_week_2023.DTO.Write;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import me.dio.santander_dev_week_2023.DTO.Read.LimitResponseDTO;

import java.math.BigDecimal;

public class CardRequestDTO {

    public CardRequestDTO(Long id, Long contaId, String numero, int codigoSeguranca, boolean bloqueado) {
        this.id = id;
        this.contaId = contaId;
        this.numero = numero;
        this.codigoSeguranca = codigoSeguranca;
        this.bloqueado = bloqueado;
    }

    public CardRequestDTO() {
    }

    @JsonProperty("id")
    public Long id;

    @JsonProperty("contaId")
    public Long contaId;

    @JsonIgnore
    public String numero;

    @JsonIgnore
    private int codigoSeguranca;

    @JsonIgnore
    private boolean bloqueado;
}