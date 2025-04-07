package me.dio.santander_dev_week_2023.DTO.Read;

import java.math.BigDecimal;

public record LimitResponseDTO(
        Long contaId,
        BigDecimal limiteDisponivel
) {}