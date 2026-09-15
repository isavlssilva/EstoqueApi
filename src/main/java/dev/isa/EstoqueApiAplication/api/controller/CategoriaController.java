/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.isa.EstoqueApiAplication.api.controller;

import dev.isa.EstoqueApiAplication.domain.dto.TotalCategoriaDTO;
import dev.isa.EstoqueApiAplication.domain.model.Categoria;
import dev.isa.EstoqueApiAplication.domain.repository.CategoriaRepository;
import dev.isa.EstoqueApiAplication.domain.service.CategoriaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digma
 */
@RestController
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaService categoriaService;

    //--------------------------ver todas -----------------------
    @GetMapping("/categoria")
    public List<Categoria> listas() {

        return categoriaRepository.findAll();
    }

//------------------------Salvar---------------------------------
    @PostMapping("/categoria")
    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

//------------------------Atualizar---------------------------------
    @PutMapping("/categoria/{categoriaId}")
    public Optional<Categoria> atualizar(Long categoriaId, Categoria categoriaComNovosDados) {
        return categoriaRepository.findById(categoriaId).map(categoriaExistente -> {
            BeanUtils.copyProperties(categoriaComNovosDados, categoriaExistente, "id");
            return categoriaRepository.save(categoriaExistente);
        });
    }

//------------------------Listar por id---------------------------------------
    @GetMapping("/categoria/{categoriaID}")
    public ResponseEntity<Categoria> buscar(@PathVariable Long categoriaID) {

        Optional<Categoria> categoria = categoriaRepository.findById(categoriaID);

        if (categoria.isPresent()) {
            return ResponseEntity.ok(categoria.get());
        } else {

            return ResponseEntity.notFound().build();
        }

    }

//------------------------Buscar por valor total--------------------------------
    @GetMapping("/relatorio-total")
    public ResponseEntity<List<TotalCategoriaDTO>> buscarValorTotalPorCategoria() {
        List<TotalCategoriaDTO> relatorio = categoriaService.buscarValorTotalPorCategoria();
        return ResponseEntity.ok(relatorio);
    }
}
