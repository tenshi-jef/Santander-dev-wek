package me.dio.santander_dev_week_2023.Service.Interfaces;

import java.util.ArrayList;

import me.dio.santander_dev_week_2023.DTO.Read.UserResponseDTO;
import me.dio.santander_dev_week_2023.DTO.Write.UserRequestDTO;
import me.dio.santander_dev_week_2023.Response.ApiResponse;

public interface IUserService {

    ApiResponse getInfos(Long userId);

    ApiResponse getUsers();

    ApiResponse getUser(Long id);

    ApiResponse create(UserRequestDTO newUser);

    ApiResponse update(Long id, UserRequestDTO updatedUser);

    ApiResponse delete(Long id);
}
