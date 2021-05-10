package com.pi.systeminstruverso.servlet;

import com.pi.systeminstruverso.dao.ClienteDAO;
import com.pi.systeminstruverso.dao.FornecedorDAO;
import com.pi.systeminstruverso.dao.UsuarioDAO;
import com.pi.systeminstruverso.entidade.Cliente;
import com.pi.systeminstruverso.entidade.Fornecedor;
import com.pi.systeminstruverso.entidade.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author victor
 */
public class BuscarUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String busca = request.getParameter("busca");
            
            System.out.println(busca);
            
            List<Usuario> listaUsuario = UsuarioDAO.searchUsuario(busca);
            
            request.setAttribute("listaUsuario", listaUsuario);
            request.getRequestDispatcher("/usuarios/buscar.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
