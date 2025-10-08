package com.ifsul.aproximei.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class ServicoMongoDB {

    @Schema(description = "Nome do serviço", example = "Design Gráfico")
    private String nome;

    @Schema(description = "Preço do serviço", example = "150.0")
    private double preco;

    @Schema(description = "Avaliações do serviço")
    private List<AvaliacaoMongoDB> avaliacoes;

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    public List<AvaliacaoMongoDB> getAvaliacoes() { return avaliacoes; }
    public void setAvaliacoes(List<AvaliacaoMongoDB> avaliacoes) { this.avaliacoes = avaliacoes; }
}
