package me.dio.santander_dev_week_2023.Service.Interfaces;

import me.dio.santander_dev_week_2023.Enums.PaymentEnum;
import me.dio.santander_dev_week_2023.Response.ApiResponse;

import java.math.BigDecimal;

public interface ITransactionService {
     ApiResponse getTransactions(Long userId);
     ApiResponse transferir(String cpf, String destinyCpf, String password, PaymentEnum paymentType, BigDecimal value);
}
