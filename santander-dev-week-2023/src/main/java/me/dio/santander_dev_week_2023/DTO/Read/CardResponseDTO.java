package me.dio.santander_dev_week_2023.DTO.Read;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardResponseDTO {
      public CardResponseDTO(Long id, Long contaId, String numero, LimitResponseDTO limite) {
            this.id = id;
            this.contaId = contaId;
            this.numero = numero;
            this.limite = limite;
      }

      public CardResponseDTO() {
      }

      @JsonProperty("id")
      public Long id;

      @JsonProperty("contaId")
      public Long contaId;

      @JsonProperty("numero")
      public String numero;

      @JsonProperty("limite")
      public LimitResponseDTO limite;
}