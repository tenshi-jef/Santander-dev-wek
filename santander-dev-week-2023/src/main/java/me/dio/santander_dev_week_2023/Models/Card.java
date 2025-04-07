package me.dio.santander_dev_week_2023.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_cartao")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "conta_id")
    private Long contaId;

    @Column(name = "numero")
    private String numero;

    @Column(name = "limite")
    private BigDecimal limite;
}