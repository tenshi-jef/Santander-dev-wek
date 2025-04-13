package me.dio.santander_dev_week_2023.Repository;

import me.dio.santander_dev_week_2023.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsuarioId(Long usuarioId);

    long deleteByUsuarioId(Long usuarioId);
}