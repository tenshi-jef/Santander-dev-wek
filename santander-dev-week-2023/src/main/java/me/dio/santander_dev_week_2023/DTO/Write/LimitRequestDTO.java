package me.dio.santander_dev_week_2023.DTO.Write;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class LimitRequestDTO {

    @JsonProperty("cartaoId")
    public Long cartaoId;

    @JsonProperty("saldoDebito")
    public BigDecimal saldoDebito;

    @JsonProperty("limiteTotal")
    public BigDecimal limiteTotal;

    @JsonProperty("creditoEspecialDisponivel")
    public BigDecimal creditoEspecialDisponivel;

    @JsonProperty("creditoEspecialTotal")
    public BigDecimal creditoEspecialTotal;

    @JsonProperty("creditoEspecialHabilitado")
    public Boolean creditoEspecialHabilitado;
}
