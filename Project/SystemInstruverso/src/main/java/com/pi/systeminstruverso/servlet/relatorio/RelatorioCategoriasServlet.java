/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.systeminstruverso.servlet.relatorio;

import com.pi.systeminstruverso.dao.VendaDAO;
import com.pi.systeminstruverso.entidade.RelatorioCategoria;
import com.pi.systeminstruverso.entidade.Venda;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author victor
 */
public class RelatorioCategoriasServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String intervalo = request.getParameter("intervalo");
        System.out.println(intervalo);
        List<RelatorioCategoria> listaProdutosVenda = null ;
        if(intervalo.equals("full")){
            listaProdutosVenda = VendaDAO.getVendasCategoria();
        } else if(intervalo.equals("dates")){
            String data_inicial = request.getParameter("data_inicial");
            String data_final = request.getParameter("data_final");
            String categoria = request.getParameter("categoria");
            if(categoria.equals("none")){
                listaProdutosVenda = VendaDAO.getVendasCategoria(data_inicial, data_final);
            } else {
                listaProdutosVenda = VendaDAO.getVendasCategoria(data_inicial, data_final, categoria);
                System.out.println("tem categotia");
            }
        }
        request.setAttribute("listaProdutosVenda", listaProdutosVenda);
        request.getRequestDispatcher("/relatorios/listarProdutos.jsp").forward(request, response);

    }
}
