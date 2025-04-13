package me.dio.santander_dev_week_2023.Repository;


import me.dio.santander_dev_week_2023.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByContaOrigemId(Long contaOrigemId);
    List<Transaction> findByContaDestinoId(Long contaDestinoId);
}