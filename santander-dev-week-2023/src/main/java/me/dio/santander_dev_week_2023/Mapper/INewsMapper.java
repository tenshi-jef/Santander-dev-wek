package me.dio.santander_dev_week_2023.Mapper;


import me.dio.santander_dev_week_2023.DTO.Read.NewsResponseDTO;
import me.dio.santander_dev_week_2023.DTO.Write.NewsRequestDTO;
import me.dio.santander_dev_week_2023.Models.NewsFeed;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface INewsMapper {

    NewsResponseDTO toDto(NewsFeed newsFeed);

    NewsFeed toEntity(NewsRequestDTO dto);
}