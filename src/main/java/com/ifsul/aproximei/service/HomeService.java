package com.ifsul.aproximei.service;

import com.ifsul.aproximei.dto.home.CategoriaDTO;
import com.ifsul.aproximei.dto.home.PrestadorDTO;
import com.ifsul.aproximei.dto.home.ServicoDTO;
import com.ifsul.aproximei.repository.CategoriaRepository;
import com.ifsul.aproximei.repository.PrestadorRepository;
import com.ifsul.aproximei.repository.ServicoRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HomeService {

    private final CategoriaRepository categoriaRepository;
    private final ServicoRepository servicoRepository;
    private final PrestadorRepository prestadorRepository;

    public HomeService(
            CategoriaRepository categoriaRepository,
            ServicoRepository servicoRepository,
            PrestadorRepository prestadorRepository
    ) {
        this.categoriaRepository = categoriaRepository;
        this.servicoRepository = servicoRepository;
        this.prestadorRepository = prestadorRepository;
    }

    public List<CategoriaDTO> buscarCategoriasMaisAcessadas(int limite) {
        return categoriaRepository.buscarMaisAcessadas(PageRequest.of(0, limite));
    }

    public List<ServicoDTO> buscarServicosMaisAcessados(int limite) {
        return servicoRepository.buscarMaisAcessados(PageRequest.of(0, limite));
    }

    public List<PrestadorDTO> buscarMelhoresDaSemana(Pageable pageable) {
        LocalDateTime dataInicio = LocalDateTime.now().minusDays(7);
        return prestadorRepository.buscarMelhoresDaSemana(dataInicio, pageable);
    }
}
