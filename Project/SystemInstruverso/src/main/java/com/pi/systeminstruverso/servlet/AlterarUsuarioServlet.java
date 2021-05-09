package com.pi.systeminstruverso.servlet;

import com.pi.systeminstruverso.dao.UsuarioDAO;
import com.pi.systeminstruverso.entidade.Usuario;
import com.pi.systeminstruverso.utils.Convert;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author victor
 */
public class AlterarUsuarioServlet extends HttpServlet {
    
    // Carregar infos do usuario
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cod = request.getParameter("cod");
        Usuario usuario = UsuarioDAO.getUsuario(cod);
        request.setAttribute("usuario", usuario);
        request.getRequestDispatcher("usuarios/cadastrar.jsp").forward(request, response);
    }
    
    // Persistir novos dados no BD
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int cod;
        cod = Convert.ToInt(request.getParameter("cod"));
        String nome = request.getParameter("nome");
        String perfil = request.getParameter("perfil");
        int filial = Convert.ToInt(request.getParameter("filial"));
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String telefone = request.getParameter("telefone");
        String email = login+"@instruverso.com";
        String cpf = request.getParameter("cpf");
        String status = request.getParameter("status");
        
        Usuario usuario =  new Usuario(cod, nome, filial, perfil, login, senha, telefone, email, cpf, status);
        boolean ok = UsuarioDAO.atualizar(usuario);
        
        
        if (ok) {
            response.sendRedirect("retornos/sucesso.jsp");
        }
        else {
            String msgErro = "Não foi possivel realizar o exclusao desse Usuario.";
            request.setAttribute("msgErro", msgErro);
            request.getRequestDispatcher("retornos/cerro.jsp").forward(request, response);
        }
        
    }

}
