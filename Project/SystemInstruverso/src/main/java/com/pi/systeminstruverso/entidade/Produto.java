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
public class Produto {
    private int cod;
    private int filial;
    private String nome;
    private String marca;
    private int codFornecedor;
    private String fornecedor;
    private double custo;
    private double preco;
    private int quantidade;
    private double comissao;
    
    public Produto(int cod, int filial, String nome, String marca, int codFornecedor, String fornecedor, double custo, double preco, int quantidade, double comissao){
        this.cod = cod;
        this.filial = filial;
        this.nome = nome;
        this.marca = marca;
        this.codFornecedor = codFornecedor;
        this.fornecedor = fornecedor;
        this.custo = custo;
        this.preco = preco;
        this.quantidade = quantidade;
        this.comissao = comissao;
    }
    
}
