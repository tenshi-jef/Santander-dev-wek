package me.dio.santander_dev_week_2023.DTO.Write;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountRequestDTO {
    public Long usuarioId;
    public String numero;
    public BigDecimal saldo;
}
