package me.dio.santander_dev_week_2023.Repository;

import me.dio.santander_dev_week_2023.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario, Long> {}

