
package com.pi.systeminstruverso.dao;

import com.pi.systeminstruverso.conexao.Conexao;
import com.pi.systeminstruverso.entidade.Cliente;
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
        
        String query = "UPDATE cliente SET nome=?, email=? WHERE cpf=?";
        
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getCpf());

            ps.executeUpdate();
            
            ok = true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }
    
    public static Cliente getCliente(String cpf) throws SQLException{
        String query = "SELECT * FROM cliente where cpf=?";
        
        Cliente cliente = null;
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                cliente = new Cliente(nome, email, cpf);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }    
    
    public static boolean deletar(String cpf){
        boolean ok = false;
        
        String query = "DELETE FROM cliente WHERE cpf=?";
        
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, cpf);
            ps.executeUpdate();

            ok = true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }
    
    public static boolean cadastrar(Cliente cliente){
        boolean ok = false;
        
        String query = "INSERT INTO cliente(nome, email, cpf) VALUES (?,?,?)";
        
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getCpf());
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
                String nome =  rs.getString("nome");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                
                Cliente cliente =  new Cliente(nome, email, cpf);
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }    
}
