/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.systeminstruverso.servlet;

import com.pi.systeminstruverso.dao.ProdutoDAO;
import com.pi.systeminstruverso.dao.UsuarioDAO;
import com.pi.systeminstruverso.entidade.Produto;
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
public class CadastrarProdutoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recuperar os parametros
        int cod = -1;
        if (!request.getParameter("cod").equals("")) {
            cod = Convert.ToInt(request.getParameter("cod"));
        }
        String nome = request.getParameter("nome");
        String marca = request.getParameter("marca");
        double custo = Convert.ToDouble(request.getParameter("custo"));
        double preco = Convert.ToDouble(request.getParameter("preco"));
        int quantidade = Convert.ToInt(request.getParameter("quantidade"));
        double comissao = Convert.ToDouble(request.getParameter("comissao"));
        
        // Inserir oi cliente no BD
        Produto produto =  new Produto(cod, nome, marca, custo, preco, quantidade, comissao);
        boolean ok = ProdutoDAO.cadastrar(produto);
        
        // Redirecionar para sucesso/erro
        if (ok) {
            response.sendRedirect("retornos/sucesso.jsp");
        }
        else {
            String msgErro = "Não foi possivel realizar o cadastro desse produto.";
            request.setAttribute("msgErro", msgErro);
            request.getRequestDispatcher("retornos/erro.jsp").forward(request, response);
        }
    }

}
