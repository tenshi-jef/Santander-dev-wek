package me.dio.santander_dev_week_2023.Models;

import jakarta.persistence.*;
import me.dio.santander_dev_week_2023.Enums.PaymentEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_transacoes")
public class Transaction {
    public Transaction(Long id, Long contaOrigemId, Long contaDestinoId, BigDecimal valor, BigDecimal saldoContaAntes, BigDecimal saldoContaApos, LocalDateTime dataHora) {
        this.id = id;
        this.contaOrigemId = contaOrigemId;
        this.contaDestinoId = contaDestinoId;
        this.valor = valor;
        this.saldoContaAntes = saldoContaAntes;
        this.saldoContaApos = saldoContaApos;
        this.dataHora = dataHora;
    }

    public Transaction() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "conta_origem_id")
    private Long contaOrigemId;

    @Column(name = "conta_destino_id")
    private Long contaDestinoId;

    // saldo em conta, após a transação
    @Column(name = "saldo_conta_antes")
    private BigDecimal saldoContaAntes;

    @Column(name = "saldo_conta_apos")
    private BigDecimal saldoContaApos;

    @Column(name = "paymentType")
    private PaymentEnum paymentType;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    public PaymentEnum getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentEnum paymentType) {
        this.paymentType = paymentType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContaOrigemId() {
        return contaOrigemId;
    }

    public void setContaOrigemId(Long contaOrigemId) {
        this.contaOrigemId = contaOrigemId;
    }

    public Long getContaDestinoId() {
        return contaDestinoId;
    }

    public void setContaDestinoId(Long contaDestinoId) {
        this.contaDestinoId = contaDestinoId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getSaldoContaAntes() {
        return saldoContaAntes;
    }

    public void setSaldoContaAntes(BigDecimal saldoContaAntes) {
        this.saldoContaAntes = saldoContaAntes;
    }

    public BigDecimal getSaldoContaApos() {
        return saldoContaApos;
    }

    public void setSaldoContaApos(BigDecimal saldoContaApos) {
        this.saldoContaApos = saldoContaApos;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}

