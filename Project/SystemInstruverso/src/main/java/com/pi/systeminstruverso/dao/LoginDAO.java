/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.systeminstruverso.dao;

import com.pi.systeminstruverso.conexao.Conexao;
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
    
    public static boolean validar(String user, String pass){
        boolean ok = false;
        String senha = "";
        
        System.out.println(user);
        System.out.println(senha);
        
        String query = "SELECT SENHA FROM USUARIO WHERE LOGIN='"+user+"'";
        
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                senha = rs.getString("SENHA");
            }
            System.out.println(senha);
            System.out.println(pass);

            if(senha.equals(pass)) ok = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }
    
}
