package me.dio.santander_dev_week_2023.Service.Interfaces;

import me.dio.santander_dev_week_2023.DTO.Read.AccountResponseDTO;
import me.dio.santander_dev_week_2023.DTO.Write.AccountRequestDTO;
import me.dio.santander_dev_week_2023.Response.ApiResponse;

public interface IAccountService {

    ApiResponse get(Long id);

    ApiResponse create(Long userId);

    ApiResponse update(Long id, AccountRequestDTO requestDTO);

    ApiResponse deleteByUserId(Long id);
}
