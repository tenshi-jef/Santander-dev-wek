package me.dio.santander_dev_week_2023.Models;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_limite")
public class Limit {
    public Limit(Long id, Long cartaoId, BigDecimal saldoContaCorrente, BigDecimal limiteTotal, BigDecimal creditoEspecialDisponivel, BigDecimal creditoEspecialTotal, Boolean creditoEspecialHabilitado) {
        this.id = id;
        this.cartaoId = cartaoId;
        this.saldoContaCorrente = saldoContaCorrente;
        this.limiteTotal = limiteTotal;
        this.creditoEspecialDisponivel = creditoEspecialDisponivel;
        this.creditoEspecialTotal = creditoEspecialTotal;
        this.creditoEspecialHabilitado = creditoEspecialHabilitado;
    }

    public Limit() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cartao_id")
    private Long cartaoId;

    @Column(name = "saldo_conta_corrente")
    private BigDecimal saldoContaCorrente;

    // se crédito estiver disponível, utilizar o saldo + crédito, caso contrário, somente saldo
    @Column(name = "limite_total")
    private BigDecimal limiteTotal;

    @Column(name = "credito_especial_disponivel")
    private BigDecimal creditoEspecialDisponivel;

    @Column(name = "credito_especial_total")
    private BigDecimal creditoEspecialTotal;

    @Column(name = "credito_especial_habilitado")
    private Boolean creditoEspecialHabilitado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCartaoId() {
        return cartaoId;
    }

    public void setCartaoId(Long cartaoId) {
        this.cartaoId = cartaoId;
    }

    public BigDecimal getSaldoDebito() {
        return saldoContaCorrente;
    }

    public void setSaldoDebito(BigDecimal saldoDebito) {
        this.saldoContaCorrente = saldoDebito;
    }

    public BigDecimal getLimiteTotal() {
        return limiteTotal;
    }

    public void setLimiteTotal(BigDecimal limiteTotal) {
        this.limiteTotal = limiteTotal;
    }

    public BigDecimal getCreditoEspecialDisponivel() {
        return creditoEspecialDisponivel;
    }

    public void setCreditoEspecialDisponivel(BigDecimal creditoEspecialDisponivel) {
        this.creditoEspecialDisponivel = creditoEspecialDisponivel;
    }

    public BigDecimal getCreditoEspecialTotal() {
        return creditoEspecialTotal;
    }

    public void setCreditoEspecialTotal(BigDecimal creditoEspecialTotal) {
        this.creditoEspecialTotal = creditoEspecialTotal;
    }

    public Boolean getCreditoEspecialHabilitado() {
        return creditoEspecialHabilitado;
    }

    public void setCreditoEspecialHabilitado(Boolean creditoEspecialHabilitado) {
        this.creditoEspecialHabilitado = creditoEspecialHabilitado;
    }
}
