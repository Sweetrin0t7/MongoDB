package com.ifsul.aproximei.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "acessos_categorias")
public class AcessosCategoria {
    @Id
    @Column(name = "categorias_id")
    private Integer id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "categorias_id")
    private Categoria categoria;

    private Integer totalAcessos;

    private LocalDateTime ultimoAcesso;
}
