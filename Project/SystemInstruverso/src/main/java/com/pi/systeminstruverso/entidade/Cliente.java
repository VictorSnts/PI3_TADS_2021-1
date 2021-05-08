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
public class Cliente {
    
    private int cod;
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private String cep;
    private String endereco;
    private int numero;
    private String uf;
    private String bairro;
    private String cidade;
    private int filial_cadastro;
    private String data_nasc;
    

    public Cliente(int cod, String nome, String telefone, String email, String cpf, String cep, String endereco, 
            int numero, String uf, String bairro, String cidade, int filial_cadastro, String data_nasc) {
        this.cod = cod;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.uf = uf;
        this.bairro = bairro;
        this.cidade = cidade;
        this.filial_cadastro = filial_cadastro;
        this.data_nasc = data_nasc;
    }
    
    public boolean validarCPF(){
        return true;
    }

    @Override
    public String toString() {
        //To change body of generated methods, choose Tools | Templates.
        return String.format("Nome: %s <br/> Telefone: %s <br/> Email: %s <br/> CPF: %s <br/> CEP: %s <br/> Endereco: %s <br/> Numero: %d  <br/> UF: %s  <br/> Bairro: %s <br/> Filial: %d <br/> Data de Nascimento: %s <br/>", 
                nome,telefone,email,cpf,cep,endereco,numero,uf,bairro,filial_cadastro,data_nasc );
    }
    
    
    
    
}
