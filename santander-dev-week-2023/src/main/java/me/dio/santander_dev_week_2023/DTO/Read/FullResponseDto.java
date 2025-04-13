package me.dio.santander_dev_week_2023.DTO.Read;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FullResponseDto {
    public FullResponseDto(Long id, String cpf, String nome, String email, AccountResponseDTO conta) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.conta = conta;
    }

    public FullResponseDto() {
    }

    @JsonProperty("id")
    public Long id;

    @JsonProperty("cpf")
    public String cpf;

    @JsonProperty("nome")
    public String nome;

    @JsonProperty("email")
    public String email;

    @JsonProperty("conta")
    public AccountResponseDTO conta;
}
