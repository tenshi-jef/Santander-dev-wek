package me.dio.santander_dev_week_2023.Service;

import java.util.ArrayList;

import me.dio.santander_dev_week_2023.DTO.Read.UserResponseDTO;
import me.dio.santander_dev_week_2023.DTO.Write.UserRequestDTO;

public interface IUserService {
    public ArrayList<UserResponseDTO> getUsers();

    public UserResponseDTO getUser(Long id);

    public Long create(UserRequestDTO newUser);

    public Long update(Long id);
}