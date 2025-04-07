package me.dio.santander_dev_week_2023.DTO.Read;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountResponseDTO {
    public Long id;
    public Long usuarioId;
    public String numero;
    public BigDecimal saldo;
}