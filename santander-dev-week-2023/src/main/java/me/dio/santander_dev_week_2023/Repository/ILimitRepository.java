package me.dio.santander_dev_week_2023.Repository;

import me.dio.santander_dev_week_2023.Models.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILimitRepository extends JpaRepository<Limit, Long> {
    Limit findByCartaoId(long cartaoId);
}
