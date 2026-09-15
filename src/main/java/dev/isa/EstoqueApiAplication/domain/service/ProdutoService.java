/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.isa.EstoqueApiAplication.domain.service;

import dev.isa.EstoqueApiAplication.domain.model.Produto;
import dev.isa.EstoqueApiAplication.domain.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 *
 * @author digma
 */
@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
    
    @Transactional
    public Produto salvar(Produto produto) {
        // Exemplo de regra de negócio futura:
        // if (produtoRepository.existsByNome(produto.getNome())) { throw Exception... }
        return produtoRepository.save(produto);
    }

    @Transactional
    public Optional<Produto> atualizar(Long produtoId, Produto produtoComNovosDados) {
        return produtoRepository.findById(produtoId)
                .map(produtoExistente -> {
                    // Copia os dados recebidos para o produto buscado no banco, ignorando a chave primária
                    BeanUtils.copyProperties(produtoComNovosDados, produtoExistente, "id");
                    return produtoRepository.save(produtoExistente);
                });
    }
}
