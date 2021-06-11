/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.systeminstruverso.servlet.relatorio;

import com.pi.systeminstruverso.dao.RelatorioDAO;
import com.pi.systeminstruverso.entidade.Comprador;
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
public class RelatorioClientesServlet extends HttpServlet {


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
            List<Comprador> listaCliente = null;   


            String intervalo = request.getParameter("intervalo");

            if(intervalo.equals("full")){
                if(usuario_logado.isGerente()){
                    listaProdutosVenda = RelatorioDAO.getVendas(usuario_logado.getFilial());
                    listaCliente = RelatorioDAO.getCompradores(usuario_logado.getFilial());
                }
                else if(usuario_logado.isGerenteGeral()){
                    listaProdutosVenda = RelatorioDAO.getVendas();
                    listaCliente = RelatorioDAO.getCompradores();
                }
            } else if(intervalo.equals("dates")){
                String data_inicial = request.getParameter("data_inicial");
                String data_final = request.getParameter("data_final");
                String cliente = request.getParameter("cliente");
                int codCliente = 0;
                if(!cliente.equals("none")) codCliente = Integer.parseInt(cliente);

                if(usuario_logado.isGerente()){
                    if(cliente.equals("none")) listaProdutosVenda = RelatorioDAO.getVendasIntervalo(usuario_logado.getFilial(), data_inicial, data_final);
                    else listaProdutosVenda = RelatorioDAO.getVendasIntervalo(usuario_logado.getFilial(), data_inicial, data_final, codCliente);
                    listaCliente = RelatorioDAO.getCompradoresIntervalo(usuario_logado.getFilial(), data_inicial, data_final);
                }
                else if(usuario_logado.isGerenteGeral()){
                    if(cliente == null) listaProdutosVenda = RelatorioDAO.getVendasIntervalo(data_inicial, data_final);
                    else listaProdutosVenda = RelatorioDAO.getVendasIntervalo(data_inicial, data_final, codCliente);
                    listaCliente = RelatorioDAO.getCompradoresIntervalo(data_inicial, data_final);
                }
            }       

            // se o usuario for Gerente, a lista é por filial, se for Geral é completa
            if(usuario_logado.isGerente()){
                listaProdutosVenda = RelatorioDAO.getVendas(usuario_logado.getFilial());
                listaCliente = RelatorioDAO.getCompradores(usuario_logado.getFilial());
            }
            else if(usuario_logado.isGerenteGeral()){
                listaProdutosVenda = RelatorioDAO.getVendas();
                listaCliente = RelatorioDAO.getCompradores();
            }

            // Resultados no periodo
            for (Relatorio produto : listaProdutosVenda) {
                soma_preco += (produto.getPreco_unitario() * produto.getQuantidade());
                itens += produto.getQuantidade();
            }

            String tipo = "cliente";
            request.setAttribute("soma_preco", new DecimalFormat("#,##0.00").format(soma_preco));
            request.setAttribute("itens", itens);
            request.setAttribute("tipo", tipo);
            request.setAttribute("listaProdutosVenda", listaProdutosVenda);
            request.setAttribute("listaCliente", listaCliente);

            request.getRequestDispatcher("/protegido/gerentes/relatorios/listarProdutos.jsp").forward(request, response);
        } else{
            response.sendRedirect(request.getContextPath() + "/retornos/erro_auth.jsp");
        }
    }
}
