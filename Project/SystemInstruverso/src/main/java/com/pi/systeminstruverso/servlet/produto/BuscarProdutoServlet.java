package com.pi.systeminstruverso.servlet.produto;

import com.pi.systeminstruverso.servlet.cliente.ClienteServlet;
import com.pi.systeminstruverso.dao.ProdutoDAO;
import com.pi.systeminstruverso.entidade.Produto;
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
public class BuscarProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String busca = request.getParameter("busca");
            
            System.out.println(busca);
            
            List<Produto> listaProdutos = ProdutoDAO.searchProduto(busca);
            
            request.setAttribute("listaProdutos", listaProdutos);
            request.getRequestDispatcher("/produtos/buscar.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
