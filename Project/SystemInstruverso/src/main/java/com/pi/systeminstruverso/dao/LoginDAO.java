/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.systeminstruverso.dao;

import com.pi.systeminstruverso.conexao.Conexao;
import com.pi.systeminstruverso.entidade.Usuario;
import com.pi.systeminstruverso.utils.Convert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victor
 */
public class LoginDAO {
    
    public static Usuario validar(String user, String pass){
        String query = "SELECT * FROM usuario WHERE login = ? AND senha = ? AND status = 'Ativo'";
        
        Usuario usuario = null;
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                int cod = rs.getInt("cod");
                String nome = rs.getString("nome");
                int filial = rs.getInt("filial");
                String perfil = rs.getString("perfil");
                String login = rs.getString("login");
                String senha = rs.getString("senha");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                String status = rs.getString("status");

                
                usuario =  new Usuario(cod, nome, filial, perfil, login, senha, telefone, email, cpf, status);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
    
}
