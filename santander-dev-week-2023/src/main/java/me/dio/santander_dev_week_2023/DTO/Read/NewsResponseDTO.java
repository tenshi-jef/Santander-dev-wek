package me.dio.santander_dev_week_2023.DTO.Read;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class NewsResponseDTO {
    public NewsResponseDTO(Long id, String titulo, String conteudo, LocalDateTime dataPublicacao) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.dataPublicacao = dataPublicacao;
    }

    public NewsResponseDTO() {
    }

    @JsonProperty("id")
    public Long id;

    @JsonProperty("titulo")
    public String titulo;

    @JsonProperty("conteudo")
    public String conteudo;

    @JsonProperty("dataPublicacao")
    public LocalDateTime dataPublicacao;
}
