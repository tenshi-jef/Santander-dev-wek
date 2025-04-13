package me.dio.santander_dev_week_2023.Repository;

import me.dio.santander_dev_week_2023.Models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICardRepository extends JpaRepository<Card, Long> {
    Card findByContaId(Long contaId);
}