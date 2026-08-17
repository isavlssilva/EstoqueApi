/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.isa.EstoqueApiAplication.api.controller;

import dev.isa.EstoqueApiAplication.domain.dto.MovimentoDTO;
import dev.isa.EstoqueApiAplication.domain.model.Movimento;
import dev.isa.EstoqueApiAplication.domain.repository.MovimentoRepository;
import dev.isa.EstoqueApiAplication.domain.service.MovimentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digma
 */
@RestController
@RequestMapping("/movto")
public class MovimentoController {

    @Autowired
    private MovimentoService movtoService;

    @Autowired
    private MovimentoRepository movtoRepository;

    @PostMapping
    public ResponseEntity<Movimento> atualizaSaldo(@RequestBody @Valid MovimentoDTO movtoDTO) {
        Movimento newMovimento = movtoService.atualizaSaldo(movtoDTO.getIdProduto(), movtoDTO.getQuantidade());

        return ResponseEntity.status(HttpStatus.CREATED).body(newMovimento);
    }
}
