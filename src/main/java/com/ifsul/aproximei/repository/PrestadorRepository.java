package com.ifsul.aproximei.repository;

import com.ifsul.aproximei.dto.home.PrestadorDTO;
import com.ifsul.aproximei.dto.prestador.PrestadorBuscaResponseDTO;
import com.ifsul.aproximei.entity.Prestador;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PrestadorRepository extends JpaRepository<Prestador, Integer> {

    @Query("""
        SELECT new com.ifsul.aproximei.dto.home.PrestadorDTO(
            p.id,
            p.usuario.nomeUsuario,
            AVG(a.nota)
        )
        FROM Prestador p
        JOIN p.servicos s
        JOIN s.avaliacoes a
        WHERE a.dataAvaliacao >= :dataInicio
        GROUP BY p.id, p.usuario.nomeUsuario
        ORDER BY AVG(a.nota) DESC
    """)
    List<PrestadorDTO> buscarMelhoresDaSemana(@Param("dataInicio") LocalDateTime dataInicio, Pageable pageable);

    @Query("""
    SELECT new com.ifsul.aproximei.dto.prestador.PrestadorBuscaResponseDTO(
        p.id,
        u.nomeUsuario,
        p.sobreMim,
        CAST(COALESCE(AVG(a.nota), 0.0) AS double),
        p.latitude,
        p.longitude
    )
    FROM Prestador p
    JOIN p.usuario u
    JOIN p.servicos s
    LEFT JOIN s.avaliacoes a
    LEFT JOIN s.palavrasChave pc
    JOIN s.categoriaServico cs
    JOIN cs.categoria c
    WHERE
        LOWER(p.sobreMim) LIKE LOWER(CONCAT('%', :termo, '%')) OR
        LOWER(s.nome) LIKE LOWER(CONCAT('%', :termo, '%')) OR
        LOWER(s.descricao) LIKE LOWER(CONCAT('%', :termo, '%')) OR
        LOWER(pc.palavra) LIKE LOWER(CONCAT('%', :termo, '%')) OR
        LOWER(cs.nome) LIKE LOWER(CONCAT('%', :termo, '%')) OR
        LOWER(cs.descricao) LIKE LOWER(CONCAT('%', :termo, '%')) OR
        LOWER(c.nome) LIKE LOWER(CONCAT('%', :termo, '%')) OR
        LOWER(c.descricao) LIKE LOWER(CONCAT('%', :termo, '%'))
    GROUP BY p.id, u.nomeUsuario, p.sobreMim, p.latitude, p.longitude
""")
    List<PrestadorBuscaResponseDTO> buscarPrestadoresPorPalavra(@Param("termo") String termo);

}


