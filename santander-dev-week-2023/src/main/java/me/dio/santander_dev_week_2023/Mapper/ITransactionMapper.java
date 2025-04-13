package me.dio.santander_dev_week_2023.Mapper;

import me.dio.santander_dev_week_2023.DTO.Read.TransactionResponseDTO;
import me.dio.santander_dev_week_2023.Models.Transaction;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITransactionMapper {

    List<TransactionResponseDTO> toDtoList(List<Transaction> requestEntity);
}
