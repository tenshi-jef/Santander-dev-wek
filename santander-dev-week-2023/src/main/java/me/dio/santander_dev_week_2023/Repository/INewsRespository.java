package me.dio.santander_dev_week_2023.Repository;

import me.dio.santander_dev_week_2023.Models.NewsFeed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INewsRespository extends JpaRepository <NewsFeed,Long>{
}
