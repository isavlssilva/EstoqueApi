/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.isa.EstoqueApiAplication.api.controller;

import dev.isa.EstoqueApiAplication.domain.model.Categoria;
import dev.isa.EstoqueApiAplication.domain.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digma
 */
@RestController
public class CategoriaController {

    @PersistenceContext
    private EntityManager manager;

    List<Categoria> listaCategoria;

    @GetMapping("/categoria")
    public List<Categoria> listas() {

        listaCategoria = new ArrayList<Categoria>();

        return listaCategoria;

    }
}
