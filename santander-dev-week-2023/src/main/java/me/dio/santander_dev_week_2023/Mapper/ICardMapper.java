package me.dio.santander_dev_week_2023.Mapper;

import me.dio.santander_dev_week_2023.DTO.Read.CardResponseDTO;
import me.dio.santander_dev_week_2023.DTO.Write.CardRequestDTO;
import me.dio.santander_dev_week_2023.Models.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICardMapper {

    CardResponseDTO toDto(Card entity);

    Card toEntity(CardRequestDTO card);
}
