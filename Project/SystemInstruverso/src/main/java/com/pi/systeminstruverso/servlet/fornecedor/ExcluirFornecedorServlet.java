package com.pi.systeminstruverso.servlet.fornecedor;

import com.pi.systeminstruverso.dao.FornecedorDAO;
import com.pi.systeminstruverso.entidade.Usuario;
import com.pi.systeminstruverso.utils.Convert;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author victor
 */
public class ExcluirFornecedorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recuperar os parametros
        int cod = Convert.ToInt(request.getParameter("cod"));
        
        HttpSession session = request.getSession();
        Usuario usuario_logado = (Usuario) session.getAttribute("usuario_logado");
        
        System.out.println(cod);
        
        // deleatr o cliente no BD
        
        if (usuario_logado.getPerfil().equals("BACKOFFICE")) {
            boolean ok = FornecedorDAO.deletar(cod);
            if (ok) {
                response.sendRedirect("retornos/sucesso.jsp");
            }
            else {
                String msgErro = "Não foi possivel realizar o exclusao desse fornecedor.";
                request.setAttribute("msgErro", msgErro);
                request.getRequestDispatcher("retornos/erro.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/retornos/erro_auth.jsp");
        }
        
    }

}
