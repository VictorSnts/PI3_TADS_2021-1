/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.systeminstruverso.dao;

import com.pi.systeminstruverso.conexao.Conexao;
import com.pi.systeminstruverso.entidade.Cliente;
import com.pi.systeminstruverso.entidade.Produto;
import com.pi.systeminstruverso.entidade.RelatorioCategoria;
import com.pi.systeminstruverso.entidade.Venda;
import com.pi.systeminstruverso.entidade.VendaProduto;
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
public class VendaDAO {
    
    public static int novaVenda(int filial, int cod_usuario, int cod_cliente){
        
        String query = "INSERT INTO VENDA (filial, data_venda, cod_usuario, cod_cliente, finalizada, forma_pagamento, total_venda) VALUES (?, ?, ?, ?, ?, '-', 0)";
        
        Connection con;
        int last_inserted_id = 0;

        
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, filial);
            ps.setString(2, "2021-01-01"); // Incluir data atual nesse passo
            ps.setInt(3, cod_usuario);
            ps.setInt(4, cod_cliente);
            ps.setBoolean(5, false);
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();

            if(rs.next())
            {
                last_inserted_id = rs.getInt(1);
                System.out.println(last_inserted_id);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return last_inserted_id;
    }

    public static boolean cadastrarProdutoVenda(VendaProduto vp) {
        boolean ok = false;

        
        String query = "INSERT INTO venda_produto (cod_venda, cod_produto, preco_unitario, quantidade) VALUES (?, ?, ?, ?)";
        Connection con;
        
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setInt(1, vp.getCod_venda());
            ps.setInt(2, vp.getCod_produto());
            ps.setDouble(3, vp.getPreco_unitario());
            ps.setInt(4, vp.getQuantidade());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();

            ok = true;
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ok;


        
    }

    public static List<VendaProduto> getItensVenda(int num_venda) {
        String query = "SELECT VENDA_PRODUTO.COD, VENDA_PRODUTO.COD_VENDA, VENDA_PRODUTO.COD_PRODUTO, PRODUTO.NOME as produto, VENDA_PRODUTO.PRECO_UNITARIO, VENDA_PRODUTO.QUANTIDADE FROM VENDA_PRODUTO Inner JOIN PRODUTO ON VENDA_PRODUTO.COD_PRODUTO = PRODUTO.COD WHERE cod_venda = "+num_venda;
        
        List<VendaProduto> vp = new ArrayList();
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int cod = rs.getInt("cod");
                int cod_venda = rs.getInt("COD_VENDA");
                int cod_produto = rs.getInt("COD_PRODUTO");
                double preco_unitario = Convert.ToDouble(rs.getString("PRECO_UNITARIO"));
                String produto = rs.getString("produto");
                int quantidade = rs.getInt("quantidade");

                VendaProduto venda =  new VendaProduto(cod, cod_venda, cod_produto, produto, preco_unitario, quantidade);
                vp.add(venda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vp;
        
    }

    public static boolean verificarProdutoVenda(int cod_venda, int cod_produto) throws SQLException {
        String query = "SELECT * from VENDA_PRODUTO WHERE COD_PRODUTO="+cod_produto+" and COD_VENDA="+cod_venda;
       
        Connection con = Conexao.getConexao();
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        
        return rs.next();
    }

    public static void adicionarItem(int cod_venda, int cod_produto) {
        String query = "UPDATE VENDA_PRODUTO SET quantidade=? WHERE COD_PRODUTO="+cod_produto+" and COD_VENDA="+cod_venda;
       
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            
            int qtd_atual = VendaDAO.getQtd(cod_venda, cod_produto);
            ps.setInt(1, qtd_atual+1);
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public static int getQtd(int cod_venda, int cod_produto) {
        String query = "SELECT QUANTIDADE FROM VENDA_PRODUTO WHERE COD_PRODUTO="+cod_produto+" and COD_VENDA="+cod_venda;
        
        int quantidade = 0;
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                quantidade = rs.getInt("quantidade");

            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return quantidade;
    }

    public static double getTotalVenda(int cod_venda) {
        String query = "SELECT QUANTIDADE, preco_unitario FROM VENDA_PRODUTO WHERE COD_VENDA="+cod_venda;
        
        double total = 0;
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                double preco_unitario = Convert.ToDouble(rs.getString("PRECO_UNITARIO"));
                int quantidade = rs.getInt("quantidade");
                total += (preco_unitario * quantidade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Convert.RoundDecimal(total);
    }

    public static boolean fializarVenda(int cod_venda, String forma_pagamento, int filial) {
        double total = VendaDAO.getTotalVenda(cod_venda);
        
        String query = "UPDATE VENDA SET finalizada=true, forma_pagamento='"+forma_pagamento+"', total_venda="+total+", filial="+filial+" WHERE cod="+cod_venda;
        boolean ok = false;

        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            
            

            ps.executeUpdate();
            
            ok = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }

    public static void atualizaEstoque(int cod_venda) {
        String query_select = "SELECT VENDA_PRODUTO.COD, VENDA_PRODUTO.COD_VENDA, VENDA_PRODUTO.COD_PRODUTO, PRODUTO.NOME as produto, VENDA_PRODUTO.PRECO_UNITARIO, VENDA_PRODUTO.QUANTIDADE FROM VENDA_PRODUTO Inner JOIN PRODUTO ON VENDA_PRODUTO.COD_PRODUTO = PRODUTO.COD WHERE cod_venda = "+cod_venda;
                
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query_select);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int cod_produto = rs.getInt("COD_PRODUTO");
                int quantidade_vendida = rs.getInt("quantidade");
                
                Produto p = ProdutoDAO.getProduto(String.valueOf(cod_produto));
                
                String query_update = "UPDATE produto SET quantidade="+(p.getQuantidade()-quantidade_vendida)+" WHERE cod="+cod_produto;
                PreparedStatement ps_prod = con.prepareStatement(query_update);
                ps_prod.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<Venda> getVendas() {
        String query = "SELECT VENDA.COD, VENDA.FILIAL, VENDA.DATA_VENDA, VENDA.COD_USUARIO, USUARIO.NOME AS NOME_USUARIO, VENDA.COD_CLIENTE, CLIENTE.NOME AS NOME_CLIENTE, VENDA.FORMA_PAGAMENTO, VENDA.TOTAL_VENDA, VENDA.FINALIZADA FROM VENDA INNER JOIN USUARIO ON VENDA.COD_USUARIO = USUARIO.COD INNER JOIN CLIENTE ON VENDA.COD_CLIENTE = CLIENTE.COD WHERE FINALIZADA=TRUE";
        
        List<Venda> vendas = new ArrayList();
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            
            while(rs.next()){
                int cod = rs.getInt("cod");
                int filial = rs.getInt("filial");
                String data_venda = rs.getString("data_venda");
                int cod_usuario = rs.getInt("cod_usuario");
                String usuario = rs.getString("nome_usuario");
                int cod_cliente = rs.getInt("cod_cliente");
                String cliente = rs.getString("nome_cliente");
                String forma_pagamento = rs.getString("forma_pagamento");
                double total_venda = rs.getDouble("total_venda");
                                
                Venda venda =  new Venda(cod, filial, data_venda, cod_usuario, usuario, cod_cliente, cliente, forma_pagamento, total_venda, true);
                vendas.add(venda);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vendas;
    }

    public static List<Venda> getVendas(String data_inicial, String data_final) {
        String query = "SELECT VENDA.COD, VENDA.FILIAL, VENDA.DATA_VENDA, VENDA.COD_USUARIO, USUARIO.NOME AS NOME_USUARIO, VENDA.COD_CLIENTE, CLIENTE.NOME AS NOME_CLIENTE, VENDA.FORMA_PAGAMENTO, VENDA.TOTAL_VENDA, VENDA.FINALIZADA FROM VENDA INNER JOIN USUARIO ON VENDA.COD_USUARIO = USUARIO.COD INNER JOIN CLIENTE ON VENDA.COD_CLIENTE = CLIENTE.COD WHERE FINALIZADA=TRUE AND DATA_VENDA > '"+data_inicial+"' AND DATA_VENDA < '"+data_final+"'";
        
        List<Venda> vendas = new ArrayList();
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            
            while(rs.next()){
                int cod = rs.getInt("cod");
                int filial = rs.getInt("filial");
                String data_venda = rs.getString("data_venda");
                int cod_usuario = rs.getInt("cod_usuario");
                String usuario = rs.getString("nome_usuario");
                int cod_cliente = rs.getInt("cod_cliente");
                String cliente = rs.getString("nome_cliente");
                String forma_pagamento = rs.getString("forma_pagamento");
                double total_venda = rs.getDouble("total_venda");
                                
                Venda venda =  new Venda(cod, filial, data_venda, cod_usuario, usuario, cod_cliente, cliente, forma_pagamento, total_venda, true);
                vendas.add(venda);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vendas;
    }
    
    public static List<Venda> getVendas(String data_inicial, String data_final, String filial) {
        String query = "SELECT VENDA.COD, VENDA.FILIAL, VENDA.DATA_VENDA, VENDA.COD_USUARIO, USUARIO.NOME AS NOME_USUARIO, VENDA.COD_CLIENTE, CLIENTE.NOME AS NOME_CLIENTE, VENDA.FORMA_PAGAMENTO, VENDA.TOTAL_VENDA, VENDA.FINALIZADA FROM VENDA INNER JOIN USUARIO ON VENDA.COD_USUARIO = USUARIO.COD INNER JOIN CLIENTE ON VENDA.COD_CLIENTE = CLIENTE.COD WHERE FINALIZADA=TRUE AND DATA_VENDA > '"+data_inicial+"' AND DATA_VENDA < '"+data_final+"' AND VENDA.FILIAL="+filial;
        
        List<Venda> vendas = new ArrayList();
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            
            while(rs.next()){
                int cod = rs.getInt("cod");
                int filial_venda = rs.getInt("filial");
                String data_venda = rs.getString("data_venda");
                int cod_usuario = rs.getInt("cod_usuario");
                String usuario = rs.getString("nome_usuario");
                int cod_cliente = rs.getInt("cod_cliente");
                String cliente = rs.getString("nome_cliente");
                String forma_pagamento = rs.getString("forma_pagamento");
                double total_venda = rs.getDouble("total_venda");
                                
                Venda venda =  new Venda(cod, filial_venda, data_venda, cod_usuario, usuario, cod_cliente, cliente, forma_pagamento, total_venda, true);
                vendas.add(venda);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vendas;
    }

    public static List<RelatorioCategoria> getVendasCategoria() {
        String query = "SELECT VENDA_PRODUTO.COD_VENDA, VENDA.DATA_VENDA, VENDA.FILIAL, PRODUTO.NOME AS PRODUTO, PRODUTO.CATEGORIA, VENDA_PRODUTO.PRECO_UNITARIO, VENDA_PRODUTO.QUANTIDADE FROM VENDA_PRODUTO INNER JOIN PRODUTO ON VENDA_PRODUTO.COD =  PRODUTO.COD INNER JOIN VENDA ON VENDA.COD = VENDA_PRODUTO.COD_VENDA WHERE venda.finalizada = true";
        
        List<RelatorioCategoria> relat = new ArrayList();
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet re = ps.executeQuery();

            
            while(re.next()){
                int cod_venda =  re.getInt("cod_venda");
                String data_venda =  re.getString("data_venda");
                int filial =  re.getInt("filial");
                String produto =  re.getString("produto");
                String categoria =  re.getString("categoria");
                boolean preco_unitario =  re.getBoolean("preco_unitario");
                int quantidade =  re.getInt("quantidade");
                                
                RelatorioCategoria rc =  new RelatorioCategoria(cod_venda, data_venda, filial, produto, categoria, preco_unitario, quantidade);
                relat.add(rc);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return relat;
    }
    
    public static List<RelatorioCategoria> getVendasCategoria(String data_inicial, String data_final) {
        String query = "SELECT VENDA_PRODUTO.COD_VENDA, VENDA.DATA_VENDA, VENDA.FILIAL, PRODUTO.NOME AS PRODUTO, PRODUTO.CATEGORIA, VENDA_PRODUTO.PRECO_UNITARIO, VENDA_PRODUTO.QUANTIDADE FROM VENDA_PRODUTO INNER JOIN PRODUTO ON VENDA_PRODUTO.COD =  PRODUTO.COD INNER JOIN VENDA ON VENDA.COD = VENDA_PRODUTO.COD_VENDA WHERE venda.finalizada = true AND DATA_VENDA > '"+data_inicial+"' AND DATA_VENDA < '"+data_final+"'";
        
        List<RelatorioCategoria> relat = new ArrayList();
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet re = ps.executeQuery();

            
            while(re.next()){
                int cod_venda =  re.getInt("cod_venda");
                String data_venda =  re.getString("data_venda");
                int filial =  re.getInt("filial");
                String produto =  re.getString("produto");
                String categoria =  re.getString("categoria");
                boolean preco_unitario =  re.getBoolean("preco_unitario");
                int quantidade =  re.getInt("quantidade");
                                
                RelatorioCategoria rc =  new RelatorioCategoria(cod_venda, data_venda, filial, produto, categoria, preco_unitario, quantidade);
                relat.add(rc);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return relat;
    }
    
    public static List<RelatorioCategoria> getVendasCategoria(String data_inicial, String data_final, String categoria) {
        String query = "SELECT VENDA_PRODUTO.COD_VENDA, VENDA.DATA_VENDA, VENDA.FILIAL, PRODUTO.NOME AS PRODUTO, PRODUTO.CATEGORIA, VENDA_PRODUTO.PRECO_UNITARIO, VENDA_PRODUTO.QUANTIDADE FROM VENDA_PRODUTO INNER JOIN PRODUTO ON VENDA_PRODUTO.COD =  PRODUTO.COD INNER JOIN VENDA ON VENDA.COD = VENDA_PRODUTO.COD_VENDA WHERE venda.finalizada = true AND DATA_VENDA > '"+data_inicial+"' AND DATA_VENDA < '"+data_final+"' AND PRODUTO.CATEGORIA = '"+categoria+"'";
        
        List<RelatorioCategoria> relat = new ArrayList();
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet re = ps.executeQuery();

            
            while(re.next()){
                int cod_venda =  re.getInt("cod_venda");
                String data_venda =  re.getString("data_venda");
                int filial =  re.getInt("filial");
                String produto =  re.getString("produto");
                String categoria_prd =  re.getString("categoria");
                boolean preco_unitario =  re.getBoolean("preco_unitario");
                int quantidade =  re.getInt("quantidade");
                                
                RelatorioCategoria rc =  new RelatorioCategoria(cod_venda, data_venda, filial, produto, categoria_prd, preco_unitario, quantidade);
                relat.add(rc);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return relat;
    }
    
    
}
