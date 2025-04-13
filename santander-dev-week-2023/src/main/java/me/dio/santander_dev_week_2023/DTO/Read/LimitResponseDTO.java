package me.dio.santander_dev_week_2023.DTO.Read;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class LimitResponseDTO {
        public LimitResponseDTO(Long cartaoId, BigDecimal saldoDebito, BigDecimal limiteTotal, BigDecimal creditoEspecialDisponivel, BigDecimal creditoEspecialTotal, Boolean creditoEspecialHabilitado) {
                this.cartaoId = cartaoId;
                this.saldoDebito = saldoDebito;
                this.limiteTotal = limiteTotal;
                this.creditoEspecialDisponivel = creditoEspecialDisponivel;
                this.creditoEspecialTotal = creditoEspecialTotal;
                this.creditoEspecialHabilitado = creditoEspecialHabilitado;
        }

        public LimitResponseDTO() {
        }

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
