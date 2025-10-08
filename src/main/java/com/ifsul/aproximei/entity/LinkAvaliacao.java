package com.ifsul.aproximei.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "links_avaliacao")
public class LinkAvaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 100)
    private String token;

    @Column(nullable = false)
    private Boolean usado = false;

    @Column(name = "criado_em", updatable = false)
    private LocalDateTime criadoEm = LocalDateTime.now();

    @Column(name = "usado_em")
    private LocalDateTime usadoEm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientes_mensagem_id", nullable = false)
    private ClienteMensagem clienteMensagem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servicos_id", nullable = false)
    private Servico servico;
}
