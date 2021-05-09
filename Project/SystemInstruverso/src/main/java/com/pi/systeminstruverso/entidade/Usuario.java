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
public class Usuario {
    
    private int cod;
    private String nome;
    private int filial;
    private String perfil;
    private String login;
    private String senha;
    private String telefone;
    private String email;
    private String cpf;
    private String status;
    
    public Usuario(int cod,String nome, int filial, String perfil,String login,String senha,String telefone,String email,String cpf,String status) {
        this.cod = cod;
        this.nome = nome;
        this.filial = filial;
        this.perfil = perfil;
        this.login = login;
        this.senha = senha;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.status = status;
    }
}
