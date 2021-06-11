package com.pi.systeminstruverso.servlet.usuario;

import com.pi.systeminstruverso.dao.UsuarioDAO;
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
public class AlterarUsuarioServlet extends HttpServlet {
    
    // Carregar infos do usuario
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario usuario_logado = (Usuario) session.getAttribute("usuario_logado");
        if (usuario_logado.isTI()){
            String cod = request.getParameter("cod");
            Usuario usuario = UsuarioDAO.getUsuario(cod);
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("protegido/ti/usuarios/cadastrar.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/retornos/erro_auth.jsp");

        }
    }
    
    // Persistir novos dados no BD
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Usuario usuario_logado = (Usuario) session.getAttribute("usuario_logado");
        
        int cod;
        cod = Convert.ToInt(request.getParameter("cod"));
        String nome = request.getParameter("nome");
        String perfil = request.getParameter("perfil");
        int filial = usuario_logado.getFilial();
        String nivel = request.getParameter("nivel");
        String login = request.getParameter("login");
        System.out.println(login);
        String telefone = request.getParameter("telefone");
        String email = login+"@instruverso.com";
        String cpf = request.getParameter("cpf");
        String status = request.getParameter("status");
        
        Usuario usuario =  new Usuario(cod, nome, filial, perfil, nivel, login, "", telefone, email, cpf, status);
        boolean ok = UsuarioDAO.atualizar(usuario);
        
        
        if (ok) {
            response.sendRedirect("retornos/sucesso.jsp");
        }
        else {
            String msgErro = "Não foi possivel realizar o exclusao desse Usuario.";
            request.setAttribute("msgErro", msgErro);
            request.getRequestDispatcher("retornos/erro.jsp").forward(request, response);
        }
        
    }

}
