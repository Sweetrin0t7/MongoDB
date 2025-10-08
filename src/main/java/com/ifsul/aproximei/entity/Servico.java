package com.ifsul.aproximei.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "servicos")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 500)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "prestadores_id")
    private Prestador prestador;

    @OneToOne(mappedBy = "servico")
    private AcessosServico acessos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_servico_id")
    private CategoriaServico categoriaServico;

    @ManyToMany
    @JoinTable(
            name = "servicos_chave",
            joinColumns = @JoinColumn(name = "servicos_id"),
            inverseJoinColumns = @JoinColumn(name = "palavras_chave_id")
    )
    private List<PalavraChave> palavrasChave;

    @OneToMany(mappedBy = "servico", cascade = CascadeType.ALL)
    private List<FotoServico> fotos;

    @OneToMany(mappedBy = "servico", cascade = CascadeType.ALL)
    private List<Avaliacao> avaliacoes;

}

