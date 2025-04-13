package me.dio.santander_dev_week_2023.DTO.Write;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransferRequestDTO {

    @JsonProperty("cpf")
    public String cpf;

    @JsonProperty("password")
    public String password;
}
