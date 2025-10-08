package com.ifsul.aproximei.dto.home;

public class ServicoDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private Integer totalAcessos;

    public ServicoDTO() {}

    public ServicoDTO(Integer id, String nome, String descricao, Integer totalAcessos) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.totalAcessos = totalAcessos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getTotalAcessos() {
        return totalAcessos;
    }

    public void setTotalAcessos(Integer totalAcessos) {
        this.totalAcessos = totalAcessos;
    }
}
