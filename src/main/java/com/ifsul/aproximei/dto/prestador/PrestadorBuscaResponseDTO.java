package com.ifsul.aproximei.dto.prestador;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PrestadorBuscaResponseDTO {

    private Integer id;
    private String nomeUsuario;
    private String sobreMim;
    private Double mediaNota;

    // Latitude e Longitude do prestador (vindo do banco)
    private Double latitude;
    private Double longitude;

    // Distância calculada entre cliente e prestador (em km)
    private Double distanciaKm;

    private List<ServicoResumoDTO> servicos;

    public PrestadorBuscaResponseDTO(Integer id, String nomeUsuario, String sobreMim, Double mediaNota, Double latitude, Double longitude) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.sobreMim = sobreMim;
        this.mediaNota = mediaNota;
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
