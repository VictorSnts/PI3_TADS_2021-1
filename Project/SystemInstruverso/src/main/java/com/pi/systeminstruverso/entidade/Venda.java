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
public class Venda {
    private int cod;
    private String data_venda;
    private int cod_usuario;
    private String usuario;
    private int cod_cliente;
    private String cliente;
    private boolean finalizada;

    public Venda(int cod, String data_venda, int cod_usuario, String usuario, int cod_cliente, String cliente, boolean finalizada) {
        this.cod = cod;
        this.data_venda = data_venda;
        this.cod_usuario = cod_usuario;
        this.usuario = usuario;
        this.cod_cliente = cod_cliente;
        this.cliente = cliente;
        this.finalizada = finalizada;
    }
}
