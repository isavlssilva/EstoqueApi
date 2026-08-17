/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.isa.EstoqueApiAplication.domain.service;

import dev.isa.EstoqueApiAplication.domain.model.Movimento;
import dev.isa.EstoqueApiAplication.domain.model.Produto;
import dev.isa.EstoqueApiAplication.domain.repository.MovimentoRepository;
import dev.isa.EstoqueApiAplication.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author digma
 */
@Service
public class MovimentoService {

    @Autowired
    ProdutoRepository produtoRepository;
    @Autowired
    MovimentoRepository movimentoRepository;

    public Movimento atualizaSaldo(Long idProduto, Double qtd) {

        Produto p = produtoRepository.findById(idProduto).orElseThrow(() -> new RuntimeException("Produto nao encontrado com ID:" + idProduto));

        Movimento movto = new Movimento(p, qtd);

        movimentoRepository.save(movto);
        p.atualizaSaldo(qtd);
    }

}
