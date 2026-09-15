/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.isa.EstoqueApiAplication.domain.dto;

import dev.isa.EstoqueApiAplication.domain.model.Produto;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

/**
 *
 * @author digma
 */
public class MovimentoDTO {

    @NotNull
    @JoinColumn(name = "id_produto")
    Long idProduto;

    @JoinColumn(name = "qtd")
    private Double quantidade;

    @NotNull
    private Date dataMovto;

    @ManyToOne
    @JoinColumn(name = "id_produto", insertable = false, updatable = false)
    private Produto produto;

    public MovimentoDTO() {
    }

    public MovimentoDTO(Long idProduto, Double quantidade, Date dataMovto, Produto produto) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.dataMovto = dataMovto;
        this.produto = produto;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataMovto() {
        return dataMovto;
    }

    public void setDataMovto(Date dataMovto) {
        this.dataMovto = dataMovto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
