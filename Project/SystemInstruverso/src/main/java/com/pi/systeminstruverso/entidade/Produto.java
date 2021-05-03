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
    private String nome;
    private String marca;
    private double custo;
    private double preco;
    private int quantidade;
    private double comissao;
    
    public Produto(int cod, String nome, String marca, double custo, double preco, int quantidade, double comissao){
        this.cod = cod;
        this.nome = nome;
        this.marca = marca;
        this.custo = custo;
        this.preco = preco;
        this.quantidade = quantidade;
        this.comissao = comissao;
    }
    
}