/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.systeminstruverso.entidade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 *
 * @author victor
 */
public class RelatorioCategoria {
    private int cod_venda;
    private String data_venda;
    private int filial;
    private String produto;
    private String categoria;
    private double preco_unitario;
    private int quantidade;

    public RelatorioCategoria(int cod_venda, String data_venda, int filial, String produto, String categoria, double preco_unitario, int quantidade) {
        this.cod_venda = cod_venda;
        this.data_venda = data_venda;
        this.filial = filial;
        this.produto = produto;
        this.categoria = categoria;
        this.preco_unitario = preco_unitario;
        this.quantidade = quantidade;
    }


    
    
}
