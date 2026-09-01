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
public class MaiorSaidaDTO {

    private String nomeProduto;
    private Double quantidadeTotalSaida;
    private BigDecimal valorTotalFinanceiroSaidas;

    public MaiorSaidaDTO() {
    }

    // Construtor compatível com o retorno do JPQL (Double no 3º parâmetro)
    public MaiorSaidaDTO(String nomeProduto, Double quantidadeTotalSaida, Double valorTotalFinanceiroSaidas) {
        this.nomeProduto = nomeProduto;
        this.quantidadeTotalSaida = quantidadeTotalSaida;
        this.valorTotalFinanceiroSaidas = (valorTotalFinanceiroSaidas != null)
                ? BigDecimal.valueOf(valorTotalFinanceiroSaidas)
                : BigDecimal.ZERO;
    }

    public MaiorSaidaDTO(String nomeProduto, Double quantidadeTotalSaida, BigDecimal valorTotalFinanceiroSaidas) {
        this.nomeProduto = nomeProduto;
        this.quantidadeTotalSaida = quantidadeTotalSaida;
        this.valorTotalFinanceiroSaidas = valorTotalFinanceiroSaidas;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getQuantidadeTotalSaida() {
        return quantidadeTotalSaida;
    }

    public void setQuantidadeTotalSaida(Double quantidadeTotalSaida) {
        this.quantidadeTotalSaida = quantidadeTotalSaida;
    }

    public BigDecimal getValorTotalFinanceiroSaidas() {
        return valorTotalFinanceiroSaidas;
    }

    public void setValorTotalFinanceiroSaidas(BigDecimal valorTotalFinanceiroSaidas) {
        this.valorTotalFinanceiroSaidas = valorTotalFinanceiroSaidas;
    }

}
