package com.ifsul.aproximei.repository;

import com.ifsul.aproximei.dto.home.CategoriaDTO;
import com.ifsul.aproximei.entity.Categoria;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    @Query("""
    SELECT new com.ifsul.aproximei.dto.home.CategoriaDTO(
        c.id,
        c.nome,
        c.descricao,
        ac.totalAcessos
    )
    FROM Categoria c
    JOIN com.ifsul.aproximei.entity.AcessosCategoria ac ON ac.categoria.id = c.id
    ORDER BY ac.totalAcessos DESC
    """)
    List<CategoriaDTO> buscarMaisAcessadas(Pageable pageable);

}
