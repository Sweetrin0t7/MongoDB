package com.ifsul.aproximei.service;

import com.ifsul.aproximei.dto.prestador.PrestadorBuscaResponseDTO;
import com.ifsul.aproximei.dto.prestador.ServicoResumoDTO;
import com.ifsul.aproximei.repository.PrestadorRepository;
import com.ifsul.aproximei.repository.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PrestadorSearchService {

    private final PrestadorRepository prestadorRepository;
    private final ServicoRepository servicoRepository;

    public List<PrestadorBuscaResponseDTO> buscarPrestadoresPorPalavra(String termo, Double lat, Double lng) {
        List<PrestadorBuscaResponseDTO> resultados = prestadorRepository.buscarPrestadoresPorPalavra(termo);

        for (PrestadorBuscaResponseDTO dto : resultados) {
            List<ServicoResumoDTO> servicos = servicoRepository.buscarServicosDoPrestador(dto.getId());
            dto.setServicos(servicos);
        }

        // Se latitude/longitude do cliente foram fornecidas
        if (lat != null && lng != null) {
            for (PrestadorBuscaResponseDTO dto : resultados) {
                if (dto.getLatitude() != null && dto.getLongitude() != null) {
                    double distancia = calcularDistanciaKm(lat, lng, dto.getLatitude(), dto.getLongitude());
                    dto.setDistanciaKm(distancia);
                } else {
                    dto.setDistanciaKm(null);
                }
            }
            // Ordenar por distância, se desejado
            resultados.sort(Comparator.comparing(
                    PrestadorBuscaResponseDTO::getDistanciaKm,
                    Comparator.nullsLast(Comparator.naturalOrder()))
            );
        }

        return resultados;
    }


    //fórmula haversine para distância em km
    private double calcularDistanciaKm(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // raio da Terra em km
        double latDist = Math.toRadians(lat2 - lat1);
        double lonDist = Math.toRadians(lon2 - lon1);

        double a = Math.sin(latDist / 2) * Math.sin(latDist / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(lonDist / 2) * Math.sin(lonDist / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}
