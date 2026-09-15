/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.isa.EstoqueApiAplication.domain.service;

import dev.isa.EstoqueApiAplication.domain.dto.MaiorSaidaDTO;
import dev.isa.EstoqueApiAplication.domain.dto.RelatorioPeriodoDTO;
import dev.isa.EstoqueApiAplication.domain.model.Movimento;
import dev.isa.EstoqueApiAplication.domain.model.Produto;
import dev.isa.EstoqueApiAplication.domain.repository.MovimentoRepository;
import dev.isa.EstoqueApiAplication.domain.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
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

    @Transactional
    public Movimento atualizaSaldo(Long idProduto, Double qtd) {
        Produto produto = produtoRepository.findById(idProduto).orElseThrow(() -> new RuntimeException("Produto nao encontrado com ID: " + idProduto));

        Movimento movto = new Movimento(produto, qtd);
        movimentoRepository.save(movto);

        produto.atualizaSaldo(qtd);
        produtoRepository.save(produto);

        return movto;
    }

    public List<RelatorioPeriodoDTO> findRelatorioEstoqueViaJPQL(LocalDateTime dataInicio, LocalDateTime dataFim) {
        return movimentoRepository.findRelatorioEstoqueViaJPQL(dataInicio, dataFim);
    }

    public List<MaiorSaidaDTO> findMaioresSaidasPorPeriodo(LocalDateTime dataInicio, LocalDateTime dataFim) {
        return movimentoRepository.findMaioresSaidasPorPeriodo(dataInicio, dataFim);

    }

}
