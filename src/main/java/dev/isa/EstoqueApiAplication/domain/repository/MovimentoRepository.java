/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dev.isa.EstoqueApiAplication.domain.repository;

import dev.isa.EstoqueApiAplication.domain.model.Movimento;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author digma
 */
@Repository
public interface MovimentoRepository extends JpaRepository<Movimento, Long> {

    List<Movimento> findByDate(Date data_movto);

    List<Movimento> findByQtd(Long qtd);

}
