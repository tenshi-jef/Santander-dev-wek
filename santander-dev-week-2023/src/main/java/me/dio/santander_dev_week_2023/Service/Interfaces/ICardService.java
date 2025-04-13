package me.dio.santander_dev_week_2023.Service.Interfaces;

import me.dio.santander_dev_week_2023.Response.ApiResponse;

public interface ICardService {
    ApiResponse getCard(Long id);

    ApiResponse delete(Long id);
}
