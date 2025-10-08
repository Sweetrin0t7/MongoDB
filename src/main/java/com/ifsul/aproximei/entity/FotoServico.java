package com.ifsul.aproximei.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fotos_servico")
public class FotoServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "url_imagem", columnDefinition = "TEXT")
    private String urlImagem;

    @Column(name = "imagem_blob")
    @Lob
    private byte[] imagemBlob;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servicos_id", nullable = false)
    private Servico servico;
}
