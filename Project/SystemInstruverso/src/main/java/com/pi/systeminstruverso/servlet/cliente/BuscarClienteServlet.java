package com.pi.systeminstruverso.servlet.cliente;

import com.pi.systeminstruverso.dao.ClienteDAO;
import com.pi.systeminstruverso.entidade.Cliente;
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
public class BuscarClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String busca = request.getParameter("busca");
            
            System.out.println(busca);
            
            List<Cliente> listaClientes = ClienteDAO.searchClientes(busca);
            request.setAttribute("listaClientes", listaClientes);
            
            String action = request.getParameter("action");
            request.setAttribute("action", action);
            System.out.println(action);
            
            request.getRequestDispatcher("/clientes/buscar.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
