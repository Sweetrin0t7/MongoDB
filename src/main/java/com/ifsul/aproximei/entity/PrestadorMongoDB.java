package com.ifsul.aproximei.entity;

import com.ifsul.aproximei.dto.home.ServicoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "prestadores")
public class PrestadorMongoDB {

    @Id
    @Schema(description = "ID do prestador", example = "1")
    private String id;

    @Schema(description = "Nome do prestador", example = "Renata Oliveira")
    private String nome;

    @Schema(description = "Endereço do prestador", example = "Rua Teste, 123")
    private String endereco;

    @Schema(description = "Descrição do prestador", example = "Prestadora de serviços de tecnologia")
    private String descricao;

    @Schema(description = "Serviços oferecidos pelo prestador")
    private List<ServicoMongoDB> servicos;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public List<ServicoMongoDB> getServicos() { return servicos; }
    public void setServicos(List<ServicoMongoDB> servicos) { this.servicos = servicos; }
}
