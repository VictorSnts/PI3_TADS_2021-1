/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.systeminstruverso.servlet.relatorio;

import com.pi.systeminstruverso.dao.RelatorioDAO;
import com.pi.systeminstruverso.entidade.Categorias;
import com.pi.systeminstruverso.entidade.Relatorio;
import com.pi.systeminstruverso.entidade.Usuario;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author victor
 */
public class RelatorioCategoriasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // pega usuario logado da sessao
        HttpSession session = request.getSession();
        Usuario usuario_logado = (Usuario) session.getAttribute("usuario_logado");
        
        if (usuario_logado.isGerenteGeral()|| usuario_logado.isGerente()){
            // Define variaveis que serao somadas para mostrar na tela
            double soma_preco = 0;
            int itens = 0;

            // Define as listas
            List<Relatorio> listaProdutosVenda = null ;
            List<Categorias> listaCategoria = null;

            String intervalo = request.getParameter("intervalo");

            if(intervalo.equals("full")){
                if(usuario_logado.isGerente()){
                    listaProdutosVenda = RelatorioDAO.getVendas(usuario_logado.getFilial());
                    listaCategoria = RelatorioDAO.getCategorias(usuario_logado.getFilial());
                }
                else if(usuario_logado.isGerenteGeral()){
                    listaProdutosVenda = RelatorioDAO.getVendas();
                    listaCategoria = RelatorioDAO.getCategorias();
                }
            } else if(intervalo.equals("dates")){
                String data_inicial = request.getParameter("data_inicial");
                String data_final = request.getParameter("data_final");
                String categoria = request.getParameter("categoria");


                if(usuario_logado.isGerente()){
                    if(categoria.equals("none")) listaProdutosVenda = RelatorioDAO.getVendasIntervalo(usuario_logado.getFilial(), data_inicial, data_final);
                    else listaProdutosVenda = RelatorioDAO.getVendasIntervalo(usuario_logado.getFilial(), data_inicial, data_final, categoria);
                    listaCategoria = RelatorioDAO.getCategoriasIntervalo(usuario_logado.getFilial(), data_inicial, data_final);
                }
                else if(usuario_logado.isGerenteGeral()){
                    if(categoria == null) listaProdutosVenda = RelatorioDAO.getVendasIntervalo(data_inicial, data_final);
                    else listaProdutosVenda = RelatorioDAO.getVendasIntervalo(data_inicial, data_final, categoria);
                    listaCategoria = RelatorioDAO.getCategoriasIntervalo(data_inicial, data_final);
                }
            }            

            for(Relatorio produto : listaProdutosVenda){
                soma_preco += (produto.getPreco_unitario() * produto.getQuantidade());
                itens += produto.getQuantidade();
            }

            String tipo = "categoria";
            request.setAttribute("soma_preco", new DecimalFormat("#,##0.00").format(soma_preco));
            request.setAttribute("itens", itens);
            request.setAttribute("tipo", tipo);
            request.setAttribute("listaCategoria", listaCategoria);
            request.setAttribute("listaProdutosVenda", listaProdutosVenda);

            request.getRequestDispatcher("/protegido/gerentes/relatorios/listarProdutos.jsp").forward(request, response);
        } else{
            response.sendRedirect(request.getContextPath() + "/retornos/erro_auth.jsp");
        }

    }
}
