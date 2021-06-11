package com.pi.systeminstruverso.dao;

import com.pi.systeminstruverso.conexao.Conexao;
import com.pi.systeminstruverso.entidade.Usuario;
import com.pi.systeminstruverso.utils.Convert;
import com.pi.systeminstruverso.utils.Criptografia;
import com.pi.systeminstruverso.utils.CryptoUtils;
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
public class UsuarioDAO {
    
    
    
    public static boolean cadastrar(Usuario usuario){
        boolean ok = false;
        
        String query = "INSERT INTO USUARIO (NOME, FILIAL, PERFIL, NIVEL, LOGIN, SENHA, TELEFONE, EMAIL, CPF, STATUS) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            
            String sc = usuario.getSenha();
            
           ps.setString(1, usuario.getNome());
            ps.setInt(2, usuario.getFilial());
            ps.setString(3, usuario.getPerfil());
            ps.setString(4, usuario.getNivel());
            ps.setString(5, usuario.getLogin());
            ps.setString(6, Criptografia.hashSenha(sc));
            ps.setString(7, usuario.getTelefone());
            ps.setString(8, usuario.getEmail());
            ps.setString(9, usuario.getCpf());
            ps.setString(10, usuario.getStatus());
            ps.executeUpdate();
            
            ok = true;
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ok;
    }
    
    
    public static List<Usuario> getUsuarios() throws SQLException{
        String query = "SELECT * FROM usuario";
        
        List<Usuario> usuarios = new ArrayList();
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int cod = rs.getInt("cod");
                String nome = rs.getString("nome");
                int filial = rs.getInt("filial");
                String nivel = rs.getString("nivel");
                String perfil = rs.getString("perfil");
                String login = rs.getString("login");
                String senha = rs.getString("senha");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                String status = rs.getString("status");

                Usuario usuario =  new Usuario(cod, nome, filial, perfil, nivel, login, senha, telefone, email, cpf, status);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    public static Usuario getUsuario(String cod_usuario) {
        String query = "SELECT * FROM usuario WHERE cod = ?";
        
        Usuario usuario = null;
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, Convert.ToInt(cod_usuario));
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                int cod = rs.getInt("cod");
                String nome = rs.getString("nome");
                int filial = rs.getInt("filial");
                String perfil = rs.getString("perfil");
                String nivel = rs.getString("nivel");
                String login = rs.getString("login");
                String senha = rs.getString("senha");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                String status = rs.getString("status");

                
                usuario =  new Usuario(cod, nome, filial, perfil, nivel, login, senha, telefone, email, cpf, status);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
    
     public static boolean atualizar(Usuario usuario){
        boolean ok = false;
        
        String query = "UPDATE usuario SET NOME=?, FILIAL=?, PERFIL=?, NIVEL=?, LOGIN=?, SENHA=?, TELEFONE=?, EMAIL=?, CPF=?, STATUS=? WHERE cod=?";
        
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, usuario.getNome());
            ps.setInt(2, usuario.getFilial());
            ps.setString(3, usuario.getPerfil());
            ps.setString(4, usuario.getNivel());
            ps.setString(5, usuario.getLogin());
            ps.setString(6, usuario.getSenha());
            ps.setString(7, usuario.getTelefone());
            ps.setString(8, usuario.getEmail());
            ps.setString(9, usuario.getCpf());
            ps.setString(10, usuario.getStatus());
            ps.setInt(11, usuario.getCod());
            ps.executeUpdate();
            
            ok = true;
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }
     
   public static boolean deletar(int cod){
        boolean ok = false;
        
        String query = "DELETE FROM usuario WHERE cod=?";
        
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
   
   public static List<Usuario> searchUsuario(String busca) throws SQLException{
        String query = "SELECT * FROM usuario WHERE nome LIKE '%"+busca+"%' OR cpf LIKE '%"+busca+"%' OR perfil LIKE '%"+busca+"%' OR login LIKE '%"+busca+"%'";
            
        
        List<Usuario> usuarios = new ArrayList();
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int cod = rs.getInt("cod");
                String nome = rs.getString("nome");
                int filial = rs.getInt("filial");
                String perfil = rs.getString("perfil");
                String nivel = rs.getString("nivel");
                String login = rs.getString("login");
                String senha = rs.getString("senha");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                String status = rs.getString("status");
                
                Usuario usuario =  new Usuario(cod, nome, filial, perfil, nivel, login, senha, telefone, email, cpf, status);
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }
}
