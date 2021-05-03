package com.pi.systeminstruverso.servlet;

import com.pi.systeminstruverso.dao.ClienteDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author victor
 */
public class ExcluirClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recuperar os parametros
        String cpf = request.getParameter("cpf");
        
        // deleatr o cliente no BD
        boolean ok = ClienteDAO.deletar(cpf);
              
        // Redirecionar para sucesso/erro
        if (ok) {
            response.sendRedirect("retornos/sucesso.jsp");
        }
        else {
            String msgErro = "Não foi possivel realizar o exclusao desse cliente.";
            request.setAttribute("msgErro", msgErro);
            request.getRequestDispatcher("retornos/erro.jsp").forward(request, response);
        }
        
        
    }

}
