package com.ifsul.aproximei.controller;

import com.ifsul.aproximei.dto.home.CategoriaDTO;
import com.ifsul.aproximei.dto.home.PrestadorDTO;
import com.ifsul.aproximei.dto.home.ServicoDTO;
import com.ifsul.aproximei.service.HomeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
@Tag(name = "Home Controller")
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/categorias-mais-acessadas")
    public List<CategoriaDTO> categoriasMaisAcessadas() {
        return homeService.buscarCategoriasMaisAcessadas(10);
    }

    @GetMapping("/servicos-mais-acessados")
    public List<ServicoDTO> servicosMaisAcessados() {
        return homeService.buscarServicosMaisAcessados(10);
    }

    @GetMapping("/prestadores/melhores-da-semana")
    public List<PrestadorDTO> getMelhoresDaSemana(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return homeService.buscarMelhoresDaSemana(pageable);
    }
}


