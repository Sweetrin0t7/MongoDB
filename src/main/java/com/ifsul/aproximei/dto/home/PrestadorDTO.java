package com.ifsul.aproximei.dto.home;

public class PrestadorDTO {

    private Integer id;
    private String nome;
    private Double mediaNota;

    public PrestadorDTO() {}

    public PrestadorDTO(Integer id, String nome, Double mediaNota) {
        this.id = id;
        this.nome = nome;
        this.mediaNota = mediaNota;
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

    public Double getMediaNota() {
        return mediaNota;
    }

    public void setMediaNota(Double mediaNota) {
        this.mediaNota = mediaNota;
    }
}
