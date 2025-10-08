package com.ifsul.aproximei.entity;

import io.swagger.v3.oas.annotations.media.Schema;

public class AvaliacaoMongoDB {

    @Schema(description = "Nome do cliente", example = "João")
    private String cliente;

    @Schema(description = "Nota do serviço", example = "5")
    private int nota;

    @Schema(description = "Comentário do cliente", example = "Ótimo serviço!")
    private String comentario;

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public int getNota() { return nota; }
    public void setNota(int nota) { this.nota = nota; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
}
