package com.ifsul.aproximei.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prestadores")
public class Prestador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20)
    private String sexo;

    private LocalDate dataNascimento;

    @Column(length = 500)
    private String sobreMim;

    @Column(length = 100)
    private String endereco;

    @Column(length = 50)
    private String cidade;

    @Column(length = 2)
    private String estado;

    @Column(length = 10)
    private String cep;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    @Column(name = "criado_em", updatable = false)
    private LocalDateTime criadoEm = LocalDateTime.now();

    @Column(nullable = false)
    private Boolean notificacoes = false;

    @Column(nullable = false)
    private Boolean visivel = true;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarios_id", nullable = false, unique = true)
    private Usuario usuario;

    @OneToMany(mappedBy = "prestador")
    private List<Servico> servicos;

}
