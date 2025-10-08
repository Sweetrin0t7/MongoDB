package com.ifsul.aproximei.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "acessos_servicos")
public class AcessosServico {
    @Id
    @Column(name = "servicos_id")
    private Integer id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "servicos_id")
    private Servico servico;

    private Integer totalAcessos;

    private LocalDateTime ultimoAcesso;
}
