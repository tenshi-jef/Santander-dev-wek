package me.dio.santander_dev_week_2023.Mapper;

import me.dio.santander_dev_week_2023.DTO.Read.UserResponseDTO;
import me.dio.santander_dev_week_2023.DTO.Write.UserRequestDTO;
import me.dio.santander_dev_week_2023.Models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserMapper {

    UserResponseDTO toDto(User requestEntity);

    User toEntity(UserRequestDTO requestDto);
}
