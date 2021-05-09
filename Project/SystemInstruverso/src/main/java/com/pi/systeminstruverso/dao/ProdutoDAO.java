/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.systeminstruverso.dao;

import com.pi.systeminstruverso.conexao.Conexao;
import com.pi.systeminstruverso.entidade.Produto;
import com.pi.systeminstruverso.utils.Convert;
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

public class ProdutoDAO {
    
    public static boolean deletar(int cod){
        boolean ok = false;
        
        String query = "DELETE FROM produto WHERE cod=?";
        
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setInt(1, cod);
            ps.executeUpdate();

            ok = true;
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }
    
    
    public static boolean atualizar(Produto produto){
        boolean ok = false;
        
        String query = "UPDATE PRODUTO SET NOME=?, MARCA=?, CUSTO=?, PRECO=?, QUANTIDADE=?, COMISSAO=? WHERE cod=?";
        
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getMarca());
            ps.setDouble(3, produto.getCusto());
            ps.setDouble(4, produto.getPreco());
            ps.setInt(5, produto.getQuantidade());
            ps.setDouble(6, produto.getComissao());
            ps.setInt(7, produto.getCod());
            ps.executeUpdate();
            
            ok = true;
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }
    
    public static List<Produto> getProdutos() throws SQLException{
        String query = "SELECT PRODUTO.COD, PRODUTO.NOME, PRODUTO.MARCA, PRODUTO.COD_FORNECEDOR, FORNECEDOR.RAZAO_SOCIAL AS FORNECEDOR, PRODUTO.CUSTO, PRODUTO.PRECO, PRODUTO.QUANTIDADE, PRODUTO.COMISSAO FROM PRODUTO Inner JOIN FORNECEDOR ON FORNECEDOR.COD = PRODUTO.COD_FORNECEDOR";
        
        List<Produto> produtos = new ArrayList();
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int cod = rs.getInt("cod");
                String nome = rs.getString("nome");
                String marca = rs.getString("marca");
                int codFornecedor = rs.getInt("cod_fornecedor");
                String fornecedor = rs.getString("fornecedor");
                double custo = rs.getDouble("custo");
                double preco = rs.getDouble("preco");
                int quantidade = rs.getInt("quantidade");
                double comissao = rs.getDouble("comissao");

                Produto produto =  new Produto(cod, nome, marca, codFornecedor, fornecedor, custo, preco, quantidade, comissao);
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }
    
    public static boolean cadastrar(Produto produto){
        boolean ok = false;
        
        String query = "INSERT INTO INSTRUVERSE.PRODUTO (NOME, MARCA, CUSTO, PRECO, QUANTIDADE, COMISSAO) VALUES (?, ?, ?, ?, ?, ?)";
        
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getMarca());
            ps.setDouble(3, produto.getCusto());
            ps.setDouble(4, produto.getPreco());
            ps.setInt(5, produto.getQuantidade());
            ps.setDouble(6, produto.getComissao());
            ps.executeUpdate();
            
            ok = true;
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ok;
    }
    
    public static Produto getProduto(String cod_usuario) {
        String query = "SELECT * FROM produto WHERE cod = ?";
        
        Produto produto = null;
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, Convert.ToInt(cod_usuario));
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                int cod = rs.getInt("cod");
                String nome = rs.getString("nome");
                String marca = rs.getString("marca");
                double custo = rs.getDouble("custo");
                double preco = rs.getDouble("preco");
                int quantidade = rs.getInt("quantidade");
                double comissao = rs.getDouble("comissao");

                
                produto =  new Produto(cod, nome, marca, custo, preco, quantidade, comissao);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }
}
