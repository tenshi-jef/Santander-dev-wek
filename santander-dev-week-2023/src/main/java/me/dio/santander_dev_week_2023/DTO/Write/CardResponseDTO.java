package me.dio.santander_dev_week_2023.DTO.Write;

import java.math.BigDecimal;

public record CardResponseDTO(

        Long id,
        Long contaId,
        String numero,
        BigDecimal limite
) {}