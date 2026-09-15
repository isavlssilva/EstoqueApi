package dev.isa.EstoqueApiAplication.domain.dto;

import java.math.BigDecimal;

/**
 *
 * @author digma
 */
public class TotalCategoriaDTO {

    private String nomeCategoria;
    private BigDecimal quantidadeTotal;
    private BigDecimal valorTotal;

    public TotalCategoriaDTO() {
    }

    // Construtor para projeção JPQL (converte o Double retornado pelo SUM em BigDecimal)
    public TotalCategoriaDTO(String nomeCategoria, BigDecimal quantidadeTotal, BigDecimal valorTotal) {
        this.nomeCategoria = nomeCategoria;
        this.quantidadeTotal = quantidadeTotal;
        this.valorTotal = valorTotal;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public BigDecimal getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(BigDecimal quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
