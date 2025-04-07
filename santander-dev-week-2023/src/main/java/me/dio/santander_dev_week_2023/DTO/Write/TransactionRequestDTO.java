package me.dio.santander_dev_week_2023.DTO.Write;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@Data
public class TransactionRequestDTO {
    private Long contaOrigemId;
    private Long contaDestinoId;
    private BigDecimal valor;
}