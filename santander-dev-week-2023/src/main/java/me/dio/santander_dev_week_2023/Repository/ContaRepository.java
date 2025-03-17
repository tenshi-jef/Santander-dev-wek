package me.dio.santander_dev_week_2023.Repository;

import me.dio.santander_dev_week_2023.Models.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {}