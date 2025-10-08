package com.ifsul.aproximei.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "avaliacoes")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer nota;

    @Column(length = 500)
    private String comentario;

    @Column(name = "data_avaliacao", updatable = false)
    private LocalDateTime dataAvaliacao = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servicos_id", nullable = false)
    private Servico servico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientes_mensagem_id", nullable = false)
    private ClienteMensagem clienteMensagem;
}
