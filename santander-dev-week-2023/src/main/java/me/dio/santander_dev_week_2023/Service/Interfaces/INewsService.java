package me.dio.santander_dev_week_2023.Service.Interfaces;

import me.dio.santander_dev_week_2023.DTO.Read.NewsResponseDTO;
import me.dio.santander_dev_week_2023.DTO.Read.UserResponseDTO;
import me.dio.santander_dev_week_2023.DTO.Write.NewsRequestDTO;
import me.dio.santander_dev_week_2023.DTO.Write.UserRequestDTO;
import me.dio.santander_dev_week_2023.Response.ApiResponse;

import java.util.ArrayList;

public interface INewsService {

    public ArrayList<NewsResponseDTO> getNews();

    public NewsResponseDTO getNew(Long id);

    public Long create(NewsRequestDTO newNews);

    Long update(Long id);

    void delete(Long id);
}
