/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.systeminstruverso.entidade;
import com.pi.systeminstruverso.utils.Convert;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

/**
 *
 * @author victor
 */
public class VendaProduto {
    private int cod;
    private int cod_venda;
    private int cod_produto;
    private String produto;
    private double preco_unitario;
    private int quantidade;
    private double total;

    public VendaProduto(int cod, int cod_venda, int cod_produto, String produto, double preco_unitario, int quantidade) {
        this.cod = cod;
        this.cod_venda = cod_venda;
        this.cod_produto = cod_produto;
        this.produto = produto;
        this.preco_unitario = preco_unitario;
        this.quantidade = quantidade;
        this.total = Convert.RoundDecimal(preco_unitario * quantidade);
    }

    public VendaProduto(int cod_venda, int cod_produto, double preco_unitario, int quantidade) {
        this.cod_venda = cod_venda;
        this.cod_produto = cod_produto;
        this.preco_unitario = preco_unitario;
        this.quantidade = quantidade;
    }

    
    


}
