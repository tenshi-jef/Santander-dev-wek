package me.dio.santander_dev_week_2023.DTO.Read;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserResponseDTO {

    public Long id;
    private String cpf;
    public String nome;
    public String email;
}
