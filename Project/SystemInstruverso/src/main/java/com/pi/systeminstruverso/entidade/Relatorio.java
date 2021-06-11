package com.pi.systeminstruverso.entidade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

/**
 *
 * @author victor
 */

public class Relatorio {
    private int cod_venda;
    private String data_venda;
    private int codCliente;
    private String nomeCliente;
    private int filial;
    private String produto;
    private String categoria;
    private double preco_unitario;
    private int quantidade;

    public Relatorio(int cod_venda, String data_venda, int codCliente, String nomeCliente, int filial, String produto, String categoria, double preco_unitario, int quantidade) {
        this.cod_venda = cod_venda;
        this.data_venda = data_venda;
        this.codCliente = codCliente;
        this.nomeCliente = nomeCliente;
        this.filial = filial;
        this.produto = produto;
        this.categoria = categoria;
        this.preco_unitario = preco_unitario;
        this.quantidade = quantidade;
    }
    
}
