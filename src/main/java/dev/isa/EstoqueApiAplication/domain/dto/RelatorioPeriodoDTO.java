/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.isa.EstoqueApiAplication.domain.dto;

import java.math.BigDecimal;

/**
 *
 * @author digma
 */
public class RelatorioPeriodoDTO {

    private Long id;
    private String nome;
    private BigDecimal valorUnitario;
    private Double totalEntradas;
    private Double totalSaidas;

    public RelatorioPeriodoDTO() {
    }

    public RelatorioPeriodoDTO(Long id, String nome, BigDecimal valorUnitario, Double totalEntradas, Double totalSaidas) {
        this.id = id;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.totalEntradas = totalEntradas;
        this.totalSaidas = totalSaidas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getTotalEntradas() {
        return totalEntradas;
    }

    public void setTotalEntradas(Double totalEntradas) {
        this.totalEntradas = totalEntradas;
    }

    public Double getTotalSaidas() {
        return totalSaidas;
    }

    public void setTotalSaidas(Double totalSaidas) {
        this.totalSaidas = totalSaidas;
    }

}
