package com.pi.systeminstruverso.dao;

import com.pi.systeminstruverso.conexao.Conexao;
import com.pi.systeminstruverso.entidade.Cliente;
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
    
    public static boolean deletar(String cnpj){
        boolean ok = false;
        
        String query = "DELETE FROM fornecedor WHERE cnpj=?";
        
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, cnpj);
            ps.executeUpdate();

            ok = true;
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }
    
    public static List<Fornecedor> getFornecedores() throws SQLException{
        String query = "SELECT * FROM fornecedor";
        
        List<Fornecedor> fornecedores = new ArrayList();
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
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
                
                Fornecedor fornecedor =  new Fornecedor(razao_social, nome_fantasia, data_registro, nome_contato, telefone, email, site, cnpj, cep, endereco, numero, pais, uf, bairro, cidade, filial_cadastro);
                fornecedores.add(fornecedor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fornecedores;
    }
}