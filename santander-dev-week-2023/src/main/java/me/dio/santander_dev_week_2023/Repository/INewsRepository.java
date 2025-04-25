package me.dio.santander_dev_week_2023.Repository;


import me.dio.santander_dev_week_2023.Models.NewsFeed;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface INewsRepository extends JpaRepository<NewsFeed, Long> {

    List<NewsFeed> findTop3ByOrderByDataPublicacaoDesc();
}