package com.ifsul.aproximei.controller;

import com.ifsul.aproximei.entity.PrestadorMongoDB;
import com.ifsul.aproximei.repository.PrestadorMongoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/mongodb/prestadores")
public class PrestadorMongoController {

    private final PrestadorMongoRepository repository;

    public PrestadorMongoController(PrestadorMongoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<PrestadorMongoDB> listar() {
        return repository.findAll();
    }

    @PostMapping
    public PrestadorMongoDB salvar(@RequestBody PrestadorMongoDB prestador) {
        return repository.save(prestador);
    }

    @PutMapping("/{id}")
    public PrestadorMongoDB atualizar(@PathVariable String id, @RequestBody PrestadorMongoDB novo) {
        return repository.findById(id)
                .map(p -> {
                    p.setNome(novo.getNome());
                    p.setEndereco(novo.getEndereco());
                    p.setDescricao(novo.getDescricao());
                    p.setServicos(novo.getServicos());
                    return repository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Prestador não encontrado"));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        repository.deleteById(id);
    }
}
