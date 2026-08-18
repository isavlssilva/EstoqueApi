/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.isa.EstoqueApiAplication.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    @JoinColumn(name = "id_produto")
    private long id_produto;

    private Double qtd;

    @NotNull
    @JoinColumn(name = "data_movto")
    private Date data_movto;

    private Produto produto;

    public Movimento() {
    }

    public Movimento(Produto produto, Double qtd) {
        this.produto = produto;
        this.qtd = qtd;
        this.data_movto = data_movto; 
    }

    public Movimento(Long id, long id_produto, Double qtd, Date data_movto) {
        this.id = id;
        this.id_produto = id_produto;
        this.qtd = qtd;
        this.data_movto = data_movto;
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

    public Date getData_movto() {
        return data_movto;
    }

    public void setData_movto(Date data_movto) {
        this.data_movto = data_movto;
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
