package me.dio.santander_dev_week_2023.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_cartao")
public class Card {
    public Card(Long id, Long contaId, String numero, int codigoSeguranca, boolean bloqueado) {
        this.id = id;
        this.contaId = contaId;
        this.numero = numero;
        this.codigoSeguranca = codigoSeguranca;
        this.bloqueado = bloqueado;
    }

    public Card() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "conta_id")
    private Long contaId;

    @Column(name = "numero")
    private String numero;

    @Column(name = "codigoSeguranca")
    private int codigoSeguranca;

    @Column(name = "bloqueado")
    private boolean bloqueado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContaId() {
        return contaId;
    }

    public void setContaId(Long contaId) {
        this.contaId = contaId;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(int codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
}