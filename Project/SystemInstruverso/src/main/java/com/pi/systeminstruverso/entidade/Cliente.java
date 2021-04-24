 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.systeminstruverso.entidade;

import lombok.Getter;
import lombok.Setter;


/**
 *
 * @author victor
 */
public class Cliente {
        
    private String nome;
    private String email;
    private String cpf;

    
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    

    public Cliente(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }
    
    public boolean validarCPF(){
        return true;
    }

    @Override
    public String toString() {
        //To change body of generated methods, choose Tools | Templates.
        return String.format("Nome: %s <br/> Email: %s <br/> CPF: %s ", nome, email, cpf);
    }
    
    
    
    
}
