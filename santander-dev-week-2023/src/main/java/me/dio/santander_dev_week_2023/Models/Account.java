package me.dio.santander_dev_week_2023.Models;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_conta")
public class Account {
    public Account(Long id, Long usuarioId, String numero, BigDecimal saldoContaCorrente, Boolean bloqueado) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.numero = numero;
        this.saldoContaCorrente = saldoContaCorrente;
        this.bloqueado = bloqueado;
    }

    public Account() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "numero")
    private String numero;

    @Column(name = "saldoContaCorrente")
    private BigDecimal saldoContaCorrente;

    @Column(name = "bloqueado")
    private Boolean bloqueado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BigDecimal getSaldoContaCorrente() {
        return saldoContaCorrente;
    }

    public void setSaldoContaCorrente(BigDecimal saldoContaCorrente) {
        this.saldoContaCorrente = saldoContaCorrente;
    }

    public Boolean getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(Boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
}
