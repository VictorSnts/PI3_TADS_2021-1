/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.systeminstruverso.dao;

import com.pi.systeminstruverso.conexao.Conexao;
import com.pi.systeminstruverso.entidade.Categorias;
import com.pi.systeminstruverso.entidade.Comprador;
import com.pi.systeminstruverso.entidade.Relatorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victor
 */
public class RelatorioDAO {
    
    public static List<Relatorio> getVendas(int filial_usuario) {
        String query = "SELECT VENDA.COD AS COD_VENDA, VENDA.DATA_VENDA, CLIENTE.COD AS CODIGO_CLIENTE, CLIENTE.NOME AS NOME_CLIENTE, VENDA.FILIAL, PRODUTO.NOME AS PRODUTO, PRODUTO.CATEGORIA, VENDA_PRODUTO.PRECO_UNITARIO, VENDA_PRODUTO.QUANTIDADE  FROM VENDA_PRODUTO INNER JOIN PRODUTO ON VENDA_PRODUTO.COD =  PRODUTO.COD INNER JOIN VENDA ON VENDA.COD = VENDA_PRODUTO.COD_VENDA INNER JOIN cliente ON venda.COD_cliente = cliente.COD WHERE venda.finalizada = true AND VENDA.FILIAL = "+filial_usuario;
        
        List<Relatorio> relat = new ArrayList();
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet re = ps.executeQuery();
            
            while(re.next()){
                int cod_venda = re.getInt("COD_VENDA");
                String data_venda = re.getString("DATA_VENDA");
                int codCliente = re.getInt("CODIGO_CLIENTE");
                String nomeCliente = re.getString("NOME_CLIENTE");
                int filial = re.getInt("FILIAL");
                String produto = re.getString("PRODUTO");
                String categoria = re.getString("CATEGORIA");
                double preco_unitario = re.getDouble("PRECO_UNITARIO");
                int quantidade = re.getInt("QUANTIDADE");
                                
                Relatorio rc =  new Relatorio(cod_venda, data_venda, codCliente, nomeCliente, filial, produto, categoria, preco_unitario, quantidade);
                relat.add(rc);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return relat;
    }
    
    public static List<Relatorio> getVendas() {
        String query = "SELECT VENDA.COD AS COD_VENDA, VENDA.DATA_VENDA, CLIENTE.COD AS CODIGO_CLIENTE, CLIENTE.NOME AS NOME_CLIENTE, VENDA.FILIAL, PRODUTO.NOME AS PRODUTO, PRODUTO.CATEGORIA, VENDA_PRODUTO.PRECO_UNITARIO, VENDA_PRODUTO.QUANTIDADE  FROM VENDA_PRODUTO INNER JOIN PRODUTO ON VENDA_PRODUTO.COD =  PRODUTO.COD INNER JOIN VENDA ON VENDA.COD = VENDA_PRODUTO.COD_VENDA INNER JOIN cliente ON venda.COD_cliente = cliente.COD WHERE venda.finalizada = true ";
        
        List<Relatorio> relat = new ArrayList();
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet re = ps.executeQuery();
            
            while(re.next()){
                int cod_venda = re.getInt("COD_VENDA");
                String data_venda = re.getString("DATA_VENDA");
                int codCliente = re.getInt("CODIGO_CLIENTE");
                String nomeCliente = re.getString("NOME_CLIENTE");
                int filial = re.getInt("FILIAL");
                String produto = re.getString("PRODUTO");
                String categoria = re.getString("CATEGORIA");
                double preco_unitario = re.getDouble("PRECO_UNITARIO");
                int quantidade = re.getInt("QUANTIDADE");
                                
                Relatorio rc =  new Relatorio(cod_venda, data_venda, codCliente, nomeCliente, filial, produto, categoria, preco_unitario, quantidade);
                relat.add(rc);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return relat;
    }
    
    public static List<Relatorio> getVendasIntervalo(int filial_usuario, String data_inicial, String data_final) {
        String query = "SELECT VENDA.COD AS COD_VENDA, VENDA.DATA_VENDA, CLIENTE.COD AS CODIGO_CLIENTE, CLIENTE.NOME AS NOME_CLIENTE, VENDA.FILIAL, PRODUTO.NOME AS PRODUTO, PRODUTO.CATEGORIA, VENDA_PRODUTO.PRECO_UNITARIO, VENDA_PRODUTO.QUANTIDADE  FROM VENDA_PRODUTO INNER JOIN PRODUTO ON VENDA_PRODUTO.COD =  PRODUTO.COD INNER JOIN VENDA ON VENDA.COD = VENDA_PRODUTO.COD_VENDA INNER JOIN cliente ON venda.COD_cliente = cliente.COD WHERE venda.finalizada = true AND VENDA.FILIAL = "+filial_usuario+" AND DATA_VENDA >= '"+data_inicial+"' AND DATA_VENDA <= '"+data_final+"'";
        
        List<Relatorio> relat = new ArrayList();
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet re = ps.executeQuery();
            
            while(re.next()){
                int cod_venda = re.getInt("COD_VENDA");
                String data_venda = re.getString("DATA_VENDA");
                int codCliente = re.getInt("CODIGO_CLIENTE");
                String nomeCliente = re.getString("NOME_CLIENTE");
                int filial = re.getInt("FILIAL");
                String produto = re.getString("PRODUTO");
                String categoria = re.getString("CATEGORIA");
                double preco_unitario = re.getDouble("PRECO_UNITARIO");
                int quantidade = re.getInt("QUANTIDADE");
                                
                Relatorio rc =  new Relatorio(cod_venda, data_venda, codCliente, nomeCliente, filial, produto, categoria, preco_unitario, quantidade);
                relat.add(rc);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return relat;
    }
    
    public static List<Relatorio> getVendasIntervalo(int filial_usuario, String data_inicial, String data_final, String categoria_selecionada) {
        String query = "SELECT VENDA.COD AS COD_VENDA, VENDA.DATA_VENDA, CLIENTE.COD AS CODIGO_CLIENTE, CLIENTE.NOME AS NOME_CLIENTE, VENDA.FILIAL, PRODUTO.NOME AS PRODUTO, PRODUTO.CATEGORIA, VENDA_PRODUTO.PRECO_UNITARIO, VENDA_PRODUTO.QUANTIDADE  FROM VENDA_PRODUTO INNER JOIN PRODUTO ON VENDA_PRODUTO.COD =  PRODUTO.COD INNER JOIN VENDA ON VENDA.COD = VENDA_PRODUTO.COD_VENDA INNER JOIN cliente ON venda.COD_cliente = cliente.COD WHERE venda.finalizada = true AND VENDA.FILIAL = "+filial_usuario+" AND DATA_VENDA >= '"+data_inicial+"' AND DATA_VENDA <= '"+data_final+"' AND PRODUTO.CATEGORIA = '"+categoria_selecionada+"'";
        
        List<Relatorio> relat = new ArrayList();
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet re = ps.executeQuery();
            
            while(re.next()){
                int cod_venda = re.getInt("COD_VENDA");
                String data_venda = re.getString("DATA_VENDA");
                int codCliente = re.getInt("CODIGO_CLIENTE");
                String nomeCliente = re.getString("NOME_CLIENTE");
                int filial = re.getInt("FILIAL");
                String produto = re.getString("PRODUTO");
                String categoria = re.getString("CATEGORIA");
                double preco_unitario = re.getDouble("PRECO_UNITARIO");
                int quantidade = re.getInt("QUANTIDADE");
                                
                Relatorio rc =  new Relatorio(cod_venda, data_venda, codCliente, nomeCliente, filial, produto, categoria, preco_unitario, quantidade);
                relat.add(rc);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return relat;
    }
    
    public static List<Relatorio> getVendasIntervalo(String data_inicial, String data_final) {
        String query = "SELECT VENDA.COD AS COD_VENDA, VENDA.DATA_VENDA, CLIENTE.COD AS CODIGO_CLIENTE, CLIENTE.NOME AS NOME_CLIENTE, VENDA.FILIAL, PRODUTO.NOME AS PRODUTO, PRODUTO.CATEGORIA, VENDA_PRODUTO.PRECO_UNITARIO, VENDA_PRODUTO.QUANTIDADE  FROM VENDA_PRODUTO INNER JOIN PRODUTO ON VENDA_PRODUTO.COD =  PRODUTO.COD INNER JOIN VENDA ON VENDA.COD = VENDA_PRODUTO.COD_VENDA INNER JOIN cliente ON venda.COD_cliente = cliente.COD WHERE venda.finalizada = true AND DATA_VENDA >= '"+data_inicial+"' AND DATA_VENDA <= '"+data_final+"'";
        
        List<Relatorio> relat = new ArrayList();
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet re = ps.executeQuery();
            
            while(re.next()){
                int cod_venda = re.getInt("COD_VENDA");
                String data_venda = re.getString("DATA_VENDA");
                int codCliente = re.getInt("CODIGO_CLIENTE");
                String nomeCliente = re.getString("NOME_CLIENTE");
                int filial = re.getInt("FILIAL");
                String produto = re.getString("PRODUTO");
                String categoria = re.getString("CATEGORIA");
                double preco_unitario = re.getDouble("PRECO_UNITARIO");
                int quantidade = re.getInt("QUANTIDADE");
                                
                Relatorio rc =  new Relatorio(cod_venda, data_venda, codCliente, nomeCliente, filial, produto, categoria, preco_unitario, quantidade);
                relat.add(rc);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return relat;
    }
    
    public static List<Relatorio> getVendasIntervalo(String data_inicial, String data_final, String categoria_selecionada) {
        String query = "SELECT VENDA.COD AS COD_VENDA, VENDA.DATA_VENDA, CLIENTE.COD AS CODIGO_CLIENTE, CLIENTE.NOME AS NOME_CLIENTE, VENDA.FILIAL, PRODUTO.NOME AS PRODUTO, PRODUTO.CATEGORIA, VENDA_PRODUTO.PRECO_UNITARIO, VENDA_PRODUTO.QUANTIDADE  FROM VENDA_PRODUTO INNER JOIN PRODUTO ON VENDA_PRODUTO.COD =  PRODUTO.COD INNER JOIN VENDA ON VENDA.COD = VENDA_PRODUTO.COD_VENDA INNER JOIN cliente ON venda.COD_cliente = cliente.COD WHERE venda.finalizada = true AND DATA_VENDA >= '"+data_inicial+"' AND DATA_VENDA <= '"+data_final+"' AND PRODUTO.CATEGORIA = '"+categoria_selecionada+"'";
        
        List<Relatorio> relat = new ArrayList();
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet re = ps.executeQuery();
            
            while(re.next()){
                int cod_venda = re.getInt("COD_VENDA");
                String data_venda = re.getString("DATA_VENDA");
                int codCliente = re.getInt("CODIGO_CLIENTE");
                String nomeCliente = re.getString("NOME_CLIENTE");
                int filial = re.getInt("FILIAL");
                String produto = re.getString("PRODUTO");
                String categoria = re.getString("CATEGORIA");
                double preco_unitario = re.getDouble("PRECO_UNITARIO");
                int quantidade = re.getInt("QUANTIDADE");
                                
                Relatorio rc =  new Relatorio(cod_venda, data_venda, codCliente, nomeCliente, filial, produto, categoria, preco_unitario, quantidade);
                relat.add(rc);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return relat;
    }
    
    
    
    
    public static List<Comprador> getCompradores() {
        String query = "SELECT DISTINCT VENDA.COD_CLIENTE, CLIENTE.NOME AS NOME_CLIENTE FROM VENDA INNER JOIN VENDA_PRODUTO ON VENDA_PRODUTO.COD_VENDA = VENDA.COD INNER JOIN CLIENTE ON VENDA.COD_CLIENTE = CLIENTE.COD WHERE VENDA.FINALIZADA = TRUE";
        
        List<Comprador> relat = new ArrayList();
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet re = ps.executeQuery();
            
            while(re.next()){
                int codCliente = re.getInt("COD_CLIENTE");
                String nomeCliente = re.getString("NOME_CLIENTE");
                
                Comprador rc = new Comprador(codCliente, nomeCliente);
                relat.add(rc);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return relat;
    }
    
    public static List<Comprador> getCompradores(int filial_usuario) {
        String query = "SELECT DISTINCT VENDA.COD_CLIENTE, CLIENTE.NOME AS NOME_CLIENTE FROM VENDA INNER JOIN VENDA_PRODUTO ON VENDA_PRODUTO.COD_VENDA = VENDA.COD INNER JOIN CLIENTE ON VENDA.COD_CLIENTE = CLIENTE.COD WHERE VENDA.FINALIZADA = TRUE AND VENDA.FILIAL = "+filial_usuario;
        
        List<Comprador> relat = new ArrayList();
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet re = ps.executeQuery();
            
            while(re.next()){
                int codCliente = re.getInt("COD_CLIENTE");
                String nomeCliente = re.getString("NOME_CLIENTE");
                
                Comprador rc = new Comprador(codCliente, nomeCliente);
                relat.add(rc);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return relat;
    }
    
    public static List<Categorias> getCategorias() {
        String query = "SELECT DISTINCT PRODUTO.CATEGORIA FROM PRODUTO INNER JOIN VENDA_PRODUTO ON VENDA_PRODUTO.COD_PRODUTO = PRODUTO.COD INNER JOIN VENDA ON VENDA_PRODUTO.COD_VENDA = VENDA.COD WHERE VENDA.FINALIZADA = TRUE";
        
        List<Categorias> relat = new ArrayList();
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet re = ps.executeQuery();
            
            while(re.next()){
                String categoria = re.getString("CATEGORIA");
                
                Categorias rc = new Categorias(categoria);
                relat.add(rc);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return relat;
    }
    
    public static List<Categorias> getCategorias(int filial_usuario) {
        String query = "SELECT DISTINCT PRODUTO.CATEGORIA FROM PRODUTO INNER JOIN VENDA_PRODUTO ON VENDA_PRODUTO.COD_PRODUTO = PRODUTO.COD INNER JOIN VENDA ON VENDA_PRODUTO.COD_VENDA = VENDA.COD WHERE VENDA.FINALIZADA = TRUE AND VENDA.FILIAL = "+filial_usuario;
        
        List<Categorias> relat = new ArrayList();
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet re = ps.executeQuery();
            
            while(re.next()){
                String categoria = re.getString("CATEGORIA");
                
                Categorias rc = new Categorias(categoria);
                relat.add(rc);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return relat;
    }
    
    public static List<Categorias> getCategoriasIntervalo(int filial_usuario, String data_inicial, String data_final) {
        String query = "SELECT DISTINCT PRODUTO.CATEGORIA FROM PRODUTO INNER JOIN VENDA_PRODUTO ON VENDA_PRODUTO.COD_PRODUTO = PRODUTO.COD INNER JOIN VENDA ON VENDA_PRODUTO.COD_VENDA = VENDA.COD WHERE VENDA.FINALIZADA = TRUE AND VENDA.FILIAL = "+filial_usuario+" AND DATA_VENDA >= '"+data_inicial+"' AND DATA_VENDA <= '"+data_final+"'";
        
        List<Categorias> relat = new ArrayList();
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet re = ps.executeQuery();
            
            while(re.next()){
                String categoria = re.getString("CATEGORIA");
                
                Categorias rc = new Categorias(categoria);
                relat.add(rc);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return relat;
    }

    public static List<Categorias> getCategoriasIntervalo(String data_inicial, String data_final) {
        String query = "SELECT DISTINCT PRODUTO.CATEGORIA FROM PRODUTO INNER JOIN VENDA_PRODUTO ON VENDA_PRODUTO.COD_PRODUTO = PRODUTO.COD INNER JOIN VENDA ON VENDA_PRODUTO.COD_VENDA = VENDA.COD WHERE VENDA.FINALIZADA = TRUE AND DATA_VENDA >= '"+data_inicial+"' AND DATA_VENDA <= '"+data_final+"'";
        
        List<Categorias> relat = new ArrayList();
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet re = ps.executeQuery();
            
            while(re.next()){
                String categoria = re.getString("CATEGORIA");
                
                Categorias rc = new Categorias(categoria);
                relat.add(rc);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return relat;
    }

}
