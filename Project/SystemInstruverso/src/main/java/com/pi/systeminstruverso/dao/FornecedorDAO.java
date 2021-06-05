package com.pi.systeminstruverso.dao;

import com.pi.systeminstruverso.conexao.Conexao;
import com.pi.systeminstruverso.entidade.Fornecedor;
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
public class FornecedorDAO {
    
    public static Fornecedor getFornecedor(int cod) throws SQLException{
        String query = "SELECT * FROM fornecedor WHERE cod = ?";
        
        Fornecedor fornecedor = null;
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                String razao_social = rs.getString("razao_social");
                String nome_fantasia = rs.getString("nome_fantasia");
                String data_registro = rs.getString("data_registro");
                String nome_contato = rs.getString("nome_contato");
                String cnpj = rs.getString("cnpj");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String site = rs.getString("site");
                String cep = rs.getString("cep");
                String endereco = rs.getString("endereco");
                int numero = rs.getInt("numero");
                String pais = rs.getString("pais");
                String uf = rs.getString("uf");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                int filial_cadastro = rs.getInt("filial_cadastro");
                
                fornecedor = new Fornecedor(cod, razao_social, nome_fantasia, data_registro, nome_contato, telefone, email, site, cnpj, cep, endereco, numero, pais, uf, bairro, cidade, filial_cadastro);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fornecedor;
    }    
    
    public static boolean atualizar(Fornecedor fornecedor){
        boolean ok = false;
        
        String query = "UPDATE fornecedor SET RAZAO_SOCIAL=?, NOME_FANTASIA=?, DATA_REGISTRO=?, NOME_CONTATO=?, TELEFONE=?, EMAIL=?, SITE=?, CEP=?, ENDERECO=?, NUMERO=?, PAIS=?, UF=?, BAIRRO=?, CIDADE=?, FILIAL_CADASTRO=?, CNPJ=? WHERE cod=?";
        
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, fornecedor.getRazao_social());
            ps.setString(2, fornecedor.getNome_fantasia());
            ps.setString(3, fornecedor.getData_registro());
            ps.setString(4, fornecedor.getNome_contato());
            ps.setString(5, fornecedor.getTelefone());
            ps.setString(6, fornecedor.getEmail());
            ps.setString(7, fornecedor.getSite());
            ps.setString(8, fornecedor.getCep());
            ps.setString(9, fornecedor.getEndereco());
            ps.setInt(10, fornecedor.getNumero());
            ps.setString(11, fornecedor.getPais());
            ps.setString(12, fornecedor.getUf());
            ps.setString(13, fornecedor.getBairro());
            ps.setString(14, fornecedor.getCidade());
            ps.setInt(15, fornecedor.getFilial_cadastro());
            ps.setString(16, fornecedor.getCnpj());
            ps.setInt(17, fornecedor.getCod());
            ps.executeUpdate();
            
            ok = true;
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }
    
    public static boolean cadastrar(Fornecedor fornecedor){
        boolean ok = false;
        
        String query = "INSERT INTO FORNECEDOR (RAZAO_SOCIAL, NOME_FANTASIA, DATA_REGISTRO, NOME_CONTATO, TELEFONE, EMAIL, SITE, CNPJ, CEP, ENDERECO, NUMERO, PAIS, UF, BAIRRO, CIDADE, FILIAL_CADASTRO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, fornecedor.getRazao_social());
            ps.setString(2, fornecedor.getNome_fantasia());
            ps.setString(3, fornecedor.getData_registro());
            ps.setString(4, fornecedor.getNome_contato());
            ps.setString(5, fornecedor.getTelefone());
            ps.setString(6, fornecedor.getEmail());
            ps.setString(7, fornecedor.getSite());
            ps.setString(8, fornecedor.getCnpj());
            ps.setString(9, fornecedor.getCep());
            ps.setString(10, fornecedor.getEndereco());
            ps.setInt(11, fornecedor.getNumero());
            ps.setString(12, fornecedor.getPais());
            ps.setString(13, fornecedor.getUf());
            ps.setString(14, fornecedor.getBairro());
            ps.setString(15, fornecedor.getCidade());
            ps.setInt(16, fornecedor.getFilial_cadastro());
            ps.executeUpdate();
            
            ok = true;
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ok;
    }
    
    public static boolean deletar(int cod){
        boolean ok = false;
        
        String query = "DELETE FROM fornecedor WHERE cod=?";
        
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
    
    public static List<Fornecedor> getFornecedores(int filial_usuario) throws SQLException{
        String query = "SELECT * FROM fornecedor WHERE FILIAL_CADASTRO = " + filial_usuario + " OR FILIAL_CADASTRO = 1";
        
        List<Fornecedor> fornecedores = new ArrayList();
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int cod = rs.getInt("cod");
                String razao_social = rs.getString("razao_social");
                String nome_fantasia = rs.getString("nome_fantasia");
                String data_registro = rs.getString("data_registro");
                String nome_contato = rs.getString("nome_contato");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String site = rs.getString("site");
                String cnpj = rs.getString("cnpj");
                String cep = rs.getString("cep");
                String endereco = rs.getString("endereco");
                int numero = rs.getInt("numero");
                String pais = rs.getString("pais");
                String uf = rs.getString("uf");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                int filial_cadastro = rs.getInt("filial_cadastro");
                
                Fornecedor fornecedor =  new Fornecedor(cod, razao_social, nome_fantasia, data_registro, nome_contato, telefone, email, site, cnpj, cep, endereco, numero, pais, uf, bairro, cidade, filial_cadastro);
                fornecedores.add(fornecedor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fornecedores;
    }
    
    
    public static List<Fornecedor> searchFornecedor(String busca) throws SQLException{
        String query = "SELECT * FROM fornecedor WHERE razao_social LIKE '%"+busca+"%' OR nome_fantasia LIKE '%"+busca+"%' OR cnpj LIKE '%"+busca+"%'";
            
        
        List<Fornecedor> fornecedores = new ArrayList();
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int cod = rs.getInt("cod");
                String razao_social = rs.getString("razao_social");
                String nome_fantasia = rs.getString("nome_fantasia");
                String data_registro = rs.getString("data_registro");
                String nome_contato = rs.getString("nome_contato");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String site = rs.getString("site");
                String cnpj = rs.getString("cnpj");
                String cep = rs.getString("cep");
                String endereco = rs.getString("endereco");
                int numero = rs.getInt("numero");
                String pais = rs.getString("pais");
                String uf = rs.getString("uf");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                int filial_cadastro = rs.getInt("filial_cadastro");
                
                Fornecedor fornecedor =  new Fornecedor(cod, razao_social, nome_fantasia, data_registro, nome_contato, telefone, email, site, cnpj, cep, endereco, numero, pais, uf, bairro, cidade, filial_cadastro);
                fornecedores.add(fornecedor);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fornecedores;
    }
}