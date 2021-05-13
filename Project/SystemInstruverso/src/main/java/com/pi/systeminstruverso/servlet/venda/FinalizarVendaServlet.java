/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.systeminstruverso.servlet.venda;

import com.pi.systeminstruverso.dao.VendaDAO;
import com.pi.systeminstruverso.utils.Convert;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author victor
 */
public class FinalizarVendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recuperar os parametros
        String forma_pagamento = request.getParameter("forma_pagamento");
        int cod_venda = Convert.ToInt(request.getParameter("venda"));

        // Atualiza venda no BD
        boolean ok = VendaDAO.fializarVenda(cod_venda, forma_pagamento);
        
        // Redirecionar para sucesso/erro
        if (ok) {
            response.sendRedirect("retornos/sucesso.jsp");
        }
        else {
            String msgErro = "Não foi possivel realizar a venda.";
            request.setAttribute("msgErro", msgErro);
            request.getRequestDispatcher("retornos/erro.jsp").forward(request, response);
        }
    }

}
