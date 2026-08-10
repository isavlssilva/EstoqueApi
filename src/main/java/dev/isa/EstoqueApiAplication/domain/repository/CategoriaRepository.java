/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dev.isa.EstoqueApiAplication.domain.repository;

import dev.isa.EstoqueApiAplication.domain.model.Categoria;
import dev.isa.EstoqueApiAplication.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author digma
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
