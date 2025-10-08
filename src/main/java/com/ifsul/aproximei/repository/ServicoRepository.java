package com.ifsul.aproximei.repository;

import com.ifsul.aproximei.dto.home.ServicoDTO;
import com.ifsul.aproximei.dto.prestador.PrestadorBuscaResponseDTO;
import com.ifsul.aproximei.dto.prestador.ServicoResumoDTO;
import com.ifsul.aproximei.entity.Servico;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
    @Query("""
        SELECT new com.ifsul.aproximei.dto.home.ServicoDTO(s.id, s.nome, s.descricao, ac.totalAcessos)
        FROM Servico s
        JOIN AcessosServico ac ON ac.servico.id = s.id
        ORDER BY ac.totalAcessos DESC
    """)
    List<ServicoDTO> buscarMaisAcessados(Pageable pageable);

    @Query("""
    SELECT new com.ifsul.aproximei.dto.prestador.ServicoResumoDTO(
        s.id,
        s.nome
    )
    FROM Servico s
    WHERE s.prestador.id = :prestadorId
""")
    List<ServicoResumoDTO> buscarServicosDoPrestador(@Param("prestadorId") Integer prestadorId);
}

