package me.dio.santander_dev_week_2023.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "features")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Features {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "descriçao")
    private String description;
}
