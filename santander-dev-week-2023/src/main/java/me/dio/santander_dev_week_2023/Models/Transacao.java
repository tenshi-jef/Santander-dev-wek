package me.dio.santander_dev_week_2023.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_transacao")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "conta_origem_id")
    private Long contaOrigemId;

    @Column(name = "conta_destino_id")
    private Long contaDestinoId;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;
}


