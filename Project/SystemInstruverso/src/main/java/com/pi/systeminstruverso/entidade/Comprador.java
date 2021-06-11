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
public class Comprador {
    
    private int cod_cliente;
    private String nome_cliente;
    

    public Comprador(int cod_cliente, String nome_cliente) {
        this.cod_cliente = cod_cliente;
        this.nome_cliente = nome_cliente;
    }
}
