/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.systeminstruverso.servlet;

import com.pi.systeminstruverso.dao.FornecedorDAO;
import com.pi.systeminstruverso.entidade.Fornecedor;
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
public class CadastrarFornecedorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recuperar os parametros
        int cod = -1;
        if (!request.getParameter("cod").equals("")) {
            cod = Convert.ToInt(request.getParameter("cod"));
        }        String razao_social = request.getParameter("razao_social");
        String nome_fantasia = request.getParameter("nome_fantasia");
        String data_registro = request.getParameter("data_registro");
        String nome_contato = request.getParameter("nome_contato");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String site = request.getParameter("site");
        String cnpj = request.getParameter("cnpj");
        String cep = request.getParameter("cep");
        String endereco = request.getParameter("endereco");
        int numero = Convert.ToInt(request.getParameter("numero"));
        String pais = request.getParameter("pais");
        String uf = request.getParameter("uf");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        int filial_cadastro = Convert.ToInt(request.getParameter("filial_cadastro"));
        
        // Inserir oi cliente no BD
        Fornecedor fornecedor = new Fornecedor(cod, razao_social, nome_fantasia, data_registro, nome_contato, telefone, email, site, cnpj, cep, endereco, numero, pais, uf, bairro, cidade, filial_cadastro);
        boolean ok = FornecedorDAO.cadastrar(fornecedor);
        
        // Redirecionar para sucesso/erro
        if (ok) {
            response.sendRedirect("retornos/sucesso.jsp");
        }
        else {
            String msgErro = "Não foi possivel realizar o cadastro desse Fornecedor.";
            request.setAttribute("msgErro", msgErro);
            request.getRequestDispatcher("retornos/erro.jsp").forward(request, response);
        }
    }

}
