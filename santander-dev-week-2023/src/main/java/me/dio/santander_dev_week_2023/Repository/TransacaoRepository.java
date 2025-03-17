package me.dio.santander_dev_week_2023.Repository;

import me.dio.santander_dev_week_2023.Models.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransacaoRepository extends JpaRepository<Transacao, Long> {}
