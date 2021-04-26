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
public class Fornecedor {
    
    private String razao_social;
    private String nome_fantasia;
    private String data_registro;
    private String nome_contato;
    private String telefone;
    private String email;
    private String site;
    private String cnpj;
    private String cep;
    private String endereco;
    private int numero;
    private String pais;
    private String uf;
    private String bairro;
    private String cidade;
    private int filial_cadastro;
    
    public Fornecedor(String razao_social, String nome_fantasia, String data_registro, String nome_contato, String telefone, String email, String site, 
            String cnpj, String cep, String endereco, int numero, String pais, String uf, String bairro, String cidade, int filial_cadastro) {
        this.razao_social = razao_social;
        this.nome_fantasia = nome_fantasia;
        this.data_registro = data_registro;
        this.nome_contato = nome_contato;
        this.telefone = telefone;
        this.email = email;
        this.site = site;
        this.cnpj = cnpj;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.pais = pais;
        this.uf = uf;
        this.bairro = bairro;
        this.cidade = cidade;
        this.filial_cadastro = filial_cadastro;
    }
}
