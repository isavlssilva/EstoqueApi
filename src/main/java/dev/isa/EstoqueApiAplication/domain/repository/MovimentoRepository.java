/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dev.isa.EstoqueApiAplication.domain.repository;

import dev.isa.EstoqueApiAplication.domain.dto.MaiorSaidaDTO;
import dev.isa.EstoqueApiAplication.domain.dto.RelatorioPeriodoDTO;
import dev.isa.EstoqueApiAplication.domain.model.Movimento;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author digma
 */
@Repository
public interface MovimentoRepository extends JpaRepository<Movimento, Long> {

    List<Movimento> findByDataMovto(Date dataMovto);

    List<Movimento> findByQtd(Long qtd);

    List<Movimento> findByQtdLessThanOrderByDataMovtoDesc(Double qtd);

    @Query("SELECT new dev.isa.EstoqueApiAplication.domain.dto.RelatorioPeriodoDTO("
            + "p.id, p.nome, p.valor_unitario, "
            + "SUM(CASE WHEN m.qtd > 0 THEN m.qtd ELSE 0.0 END), "
            + "SUM(CASE WHEN m.qtd < 0 THEN -m.qtd ELSE 0.0 END)) "
            + "FROM Movimento m JOIN m.produto p "
            + "WHERE (:dataInicio IS NULL OR m.dataMovto >= :dataInicio) "
            + "AND (:dataFim IS NULL OR m.dataMovto <= :dataFim) "
            + "GROUP BY p.id, p.nome, p.valor_unitario "
            + "ORDER BY p.nome")
    List<RelatorioPeriodoDTO> findRelatorioEstoqueViaJPQL(
            @Param("dataInicio") LocalDateTime dataInicio,
            @Param("dataFim") LocalDateTime dataFim);

    @Query("SELECT new dev.isa.EstoqueApiAplication.domain.dto.MaiorSaidaDTO("
            + "p.nome, "
            + "SUM(CASE WHEN m.qtd < 0 THEN -m.qtd ELSE 0.0 END), "
            + "SUM(CASE WHEN m.qtd < 0 THEN (-m.qtd * p.valor_unitario) ELSE 0.0 END)) "
            + "FROM Movimento m JOIN m.produto p "
            + "WHERE (:dataInicio IS NULL OR m.dataMovto >= :dataInicio) "
            + "AND (:dataFim IS NULL OR m.dataMovto <= :dataFim) "
            + "GROUP BY p.id, p.nome, p.valor_unitario "
            + "HAVING SUM(CASE WHEN m.qtd < 0 THEN -m.qtd ELSE 0.0 END) > 0 "
            + "ORDER BY SUM(CASE WHEN m.qtd < 0 THEN -m.qtd ELSE 0.0 END) DESC")
    List<MaiorSaidaDTO> findMaioresSaidasPorPeriodo(@Param("dataInicio") LocalDateTime dataInicio,
            @Param("dataFim") LocalDateTime dataFim);

}
