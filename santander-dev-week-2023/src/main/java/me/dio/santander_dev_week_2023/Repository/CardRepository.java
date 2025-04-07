package me.dio.santander_dev_week_2023.Repository;

import me.dio.santander_dev_week_2023.Models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByContaId(Long contaId);
}