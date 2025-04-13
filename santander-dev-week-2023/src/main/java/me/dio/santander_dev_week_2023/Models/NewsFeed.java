package me.dio.santander_dev_week_2023.Models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "news")
public class NewsFeed {
    public NewsFeed(Long id, String titulo, String conteudo, LocalDateTime dataPublicacao) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.dataPublicacao = dataPublicacao;
    }

    public NewsFeed() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "conteudo")
    private String conteudo;

    @Column(name = "data_publicacao")
    private LocalDateTime dataPublicacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDateTime dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
}