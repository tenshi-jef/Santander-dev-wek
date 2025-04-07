package me.dio.santander_dev_week_2023.DTO.Write;

import java.math.BigDecimal;

public record PaymentRequestDTO(
        Long contaId,
        BigDecimal valor,
        String descricao
) {}