package me.dio.santander_dev_week_2023.Mapper;

import me.dio.santander_dev_week_2023.DTO.Read.LimitResponseDTO;
import me.dio.santander_dev_week_2023.DTO.Write.LimitRequestDTO;
import me.dio.santander_dev_week_2023.Models.Limit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ILimitMapper {


    LimitResponseDTO toDto(Limit requestEntity);
    Limit toEntity(LimitRequestDTO requestDto);
}
