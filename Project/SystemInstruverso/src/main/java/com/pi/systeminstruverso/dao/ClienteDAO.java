
package com.pi.systeminstruverso.dao;

import com.pi.systeminstruverso.conexao.Conexao;
import com.pi.systeminstruverso.entidade.Cliente;
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
public class ClienteDAO {
    
    public static boolean atualizar(Cliente cliente){
        boolean ok = false;
        
        String query = "UPDATE cliente SET nome=?, telefone=?, email=?, cep=?, endereco=?, numero=?, uf=?, bairro=?, cidade=?, filial_cadastro=?, data_nasc=?, cpf=? WHERE cod=?";
        
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getTelefone());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getCep());
            ps.setString(5, cliente.getEndereco());
            ps.setInt(6, cliente.getNumero());
            ps.setString(7, cliente.getUf());
            ps.setString(8, cliente.getBairro());
            ps.setString(9, cliente.getCidade());
            ps.setInt(10, cliente.getFilial_cadastro());
            ps.setString(11, cliente.getData_nasc());
            ps.setString(12, cliente.getCpf());
            ps.setInt(13, cliente.getCod());
            ps.executeUpdate();
            
            ok = true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }
    
    public static Cliente getCliente(String cod) throws SQLException{
        String query = "SELECT * FROM cliente WHERE cod = ?";
        
        Cliente cliente = null;
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cod);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                int cod_cli = Convert.ToInt(rs.getString("cod"));
                String nome = rs.getString("nome");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                String cep = rs.getString("cep");
                String endereco = rs.getString("endereco");
                int numero = Convert.ToInt(rs.getString("numero"));
                String uf = rs.getString("uf");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                int filial_cadastro = Convert.ToInt(rs.getString("filial_cadastro"));
                String data_nasc = rs.getString("data_nasc");
                
                cliente = new Cliente(cod_cli, nome, telefone, email, cpf, cep, endereco, numero, uf, bairro, cidade, filial_cadastro, data_nasc);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }    
    
    public static boolean deletar(int cod){
        boolean ok = false;
        
        String query = "DELETE FROM cliente WHERE cod=?";
        
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setInt(1, cod);
            ps.executeUpdate();

            ok = true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }
    
    public static boolean cadastrar(Cliente cliente){
        boolean ok = false;
        
        String query = "INSERT INTO CLIENTE (NOME, DATA_NASC, TELEFONE, EMAIL, CPF, CEP, ENDERECO, NUMERO, UF, BAIRRO, CIDADE, FILIAL_CADASTRO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getData_nasc());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getCpf());
            ps.setString(6, cliente.getCep());
            ps.setString(7, cliente.getEndereco());
            ps.setInt(8, cliente.getNumero());
            ps.setString(9, cliente.getUf());
            ps.setString(10, cliente.getBairro());
            ps.setString(11, cliente.getCidade());
            ps.setInt(12, cliente.getFilial_cadastro());
            ps.executeUpdate();
            
            ok = true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ok;
    }
    
    public static List<Cliente> getClientes() throws SQLException{
        String query = "SELECT * FROM cliente";
        
        List<Cliente> clientes = new ArrayList();
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int cod = rs.getInt("cod");
                String nome = rs.getString("nome");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                String cep = rs.getString("cep");
                String endereco = rs.getString("endereco");
                int numero = Convert.ToInt(rs.getString("numero"));
                String uf = rs.getString("uf");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                int filial_cadastro = Convert.ToInt(rs.getString("filial_cadastro"));
                String data_nasc = rs.getString("data_nasc");
                
                Cliente cliente =  new Cliente(cod, nome, telefone, email, cpf, cep, endereco, numero, uf, bairro, cidade, filial_cadastro, data_nasc);
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }
    
    public static List<Cliente> searchClientes(String busca) throws SQLException{
        String query = "SELECT * FROM cliente WHERE nome LIKE '%"+busca+"%' OR cpf LIKE '%"+busca+"%'";
            
        
        List<Cliente> clientes = new ArrayList();
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int cod = rs.getInt("cod");
                String nome = rs.getString("nome");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                String cep = rs.getString("cep");
                String endereco = rs.getString("endereco");
                int numero = Convert.ToInt(rs.getString("numero"));
                String uf = rs.getString("uf");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                int filial_cadastro = Convert.ToInt(rs.getString("filial_cadastro"));
                String data_nasc = rs.getString("data_nasc");
                
                Cliente cliente =  new Cliente(cod, nome, telefone, email, cpf, cep, endereco, numero, uf, bairro, cidade, filial_cadastro, data_nasc);
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }
    
    
}
