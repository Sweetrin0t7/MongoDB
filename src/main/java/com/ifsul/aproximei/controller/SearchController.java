package com.ifsul.aproximei.controller;

import com.ifsul.aproximei.dto.prestador.PrestadorBuscaResponseDTO;
import com.ifsul.aproximei.service.PrestadorSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/busca")
@RequiredArgsConstructor
public class SearchController {

    private final PrestadorSearchService searchService;

    @GetMapping
    public ResponseEntity<List<PrestadorBuscaResponseDTO>> buscarPorPalavra(
            @RequestParam String palavra,
            @RequestParam(required = false) Double latitude,
            @RequestParam(required = false) Double longitude
    ) {
        List<PrestadorBuscaResponseDTO> resultados = searchService.buscarPrestadoresPorPalavra(palavra, latitude, longitude);
        return ResponseEntity.ok(resultados);
    }
}
