package me.dio.santander_dev_week_2023.Mapper;

import me.dio.santander_dev_week_2023.DTO.Read.AccountResponseDTO;
import me.dio.santander_dev_week_2023.DTO.Write.AccountRequestDTO;
import me.dio.santander_dev_week_2023.Models.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IAccountMapper {

    AccountResponseDTO toDto(Account requestEntity);

    Account toEntity(AccountRequestDTO requestDto);
}