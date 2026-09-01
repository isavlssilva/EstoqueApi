/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.isa.EstoqueApiAplication.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author digma
 */
@Entity
public class Movimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "id_produto")
    private long id_produto;

    private Double qtd;

    @NotNull
    @Column(name = "data_movto")
    private Date dataMovto;

    @ManyToOne
    @JoinColumn(name = "id_produto", insertable = false, updatable = false)
    private Produto produto;

    //Construtor personalizado para resolver a integração com o produto
    public Movimento(Produto produto, Double qtd) {
        this.produto = produto;
        this.id_produto = (produto != null) ? produto.getId() : 0L;
        this.qtd = qtd;
        this.dataMovto = new Date();
    }

    public Movimento() {
    }

    public Movimento(Long id, long id_produto, Double qtd, Date data_movto, Produto produto) {
        this.id = id;
        this.id_produto = id_produto;
        this.qtd = qtd;
        this.dataMovto = data_movto;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getId_produto() {
        return id_produto;
    }

    public void setId_produto(long id_produto) {
        this.id_produto = id_produto;
    }

    public Double getQtd() {
        return qtd;
    }

    public void setQtd(Double qtd) {
        this.qtd = qtd;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movimento other = (Movimento) obj;
        return Objects.equals(this.id, other.id);
    }
}
