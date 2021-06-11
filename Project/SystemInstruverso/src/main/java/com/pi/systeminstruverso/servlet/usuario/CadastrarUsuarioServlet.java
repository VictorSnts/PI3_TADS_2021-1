/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class CadastrarUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario usuario_logado = (Usuario) session.getAttribute("usuario_logado");
        // Recuperar os parametros
        
        String nome = request.getParameter("nome");
        String perfil = request.getParameter("perfil");
        String nivel = request.getParameter("nivel");
        int filial = usuario_logado.getFilial();
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String telefone = request.getParameter("telefone");
        String email = login+"@instruverso.com";
        String cpf = request.getParameter("cpf");
        String status = request.getParameter("status");
        
        // Inserir oi cliente no BD
        Usuario usuario =  new Usuario(0, nome, filial, perfil, nivel, login, senha, telefone, email, cpf, status);
        boolean ok = UsuarioDAO.cadastrar(usuario);
        
        // Redirecionar para sucesso/erro
        if (ok) {
            response.sendRedirect("retornos/sucesso.jsp");
        }
        else {
            String msgErro = "Não foi possivel realizar o cadastro desse Usuario.";
            request.setAttribute("msgErro", msgErro);
            request.getRequestDispatcher("retornos/erro.jsp").forward(request, response);
        }
    }

}
