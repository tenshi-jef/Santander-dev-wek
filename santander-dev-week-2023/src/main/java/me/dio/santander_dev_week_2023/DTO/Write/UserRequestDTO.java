package me.dio.santander_dev_week_2023.DTO.Write;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRequestDTO {
    public UserRequestDTO(String cpf, String nome, String email, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public UserRequestDTO() {
    }

    @JsonProperty("cpf")
    public String cpf;

    @JsonProperty("nome")
    public  String nome;

    @JsonProperty("email")
    public String email;

    @JsonProperty("senha")
    public String senha;
}

