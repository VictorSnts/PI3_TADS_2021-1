/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.systeminstruverso.servlet.venda;

import com.pi.systeminstruverso.dao.ProdutoDAO;
import com.pi.systeminstruverso.dao.VendaDAO;
import com.pi.systeminstruverso.servlet.cliente.ClienteServlet;
import com.pi.systeminstruverso.entidade.Produto;
import com.pi.systeminstruverso.entidade.VendaProduto;
import com.pi.systeminstruverso.utils.Convert;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author victor
 */
public class VendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // GET do num da venda, caso ja tenha iniciado
        int num_venda;
        if(request.getParameter("venda").equals("none")){
            num_venda = 0;
        } else{
            num_venda = Convert.ToInt(request.getParameter("venda"));
        }
        
        try {
            // Cria a venda
            String status = request.getParameter("status");
            if(status.equals("init")){
                num_venda = VendaDAO.novaVenda(50, 50); // NovaVenda recebe o cod de usuario e cliente. Por enqunato ta padrao 50,50
                if(num_venda==0) System.out.println("ERRO NO CADASTRO DA VENDA");
                else request.setAttribute("num_venda", num_venda);
            }
            
        } catch (NullPointerException ex) {
            System.out.println("Venda aberta");
        }
        
        // Popula tabela de produtos
        List<Produto> listaProdutos;
        try {
            listaProdutos = ProdutoDAO.getProdutos();
            request.setAttribute("num_venda", num_venda);
            request.setAttribute("listaProdutos", listaProdutos);
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            // Pega o codigo do produto adicionado
            String cod = "";
            if (!request.getParameter("cod").equals("")) cod = request.getParameter("cod");
            
            int cod_produto = Convert.ToInt(cod);
            
            
            // verifica se ja o produto ja foi adicionado
            boolean ja_adicionado = false;
            try {
                ja_adicionado = VendaDAO.verificarProdutoVenda(num_venda, cod_produto);
            } catch (SQLException ex) {
                Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            if(ja_adicionado){
                //somar qtd
                VendaDAO.adicionarItem(num_venda, cod_produto);
            } else{
                // Busca info do produto no BD
                Produto produto = ProdutoDAO.getProduto(cod);

                // Cadastra item da venda
                VendaProduto vp = new VendaProduto(num_venda, produto.getCod(), produto.getPreco(), 1);
                VendaDAO.cadastrarProdutoVenda(vp);
            }
            
            List<VendaProduto> listaItem;
            listaItem = VendaDAO.getItensVenda(num_venda);
            request.setAttribute("listaItem", listaItem);
            
            double total_venda = VendaDAO.getTotalVenda(num_venda);
            request.setAttribute("total_venda", total_venda);

            

            
        } catch (NullPointerException ex) {
            System.out.println("Falta do parm cod, carrinho nao populado");
        }
        
        request.getRequestDispatcher("/vendas/vender.jsp").forward(request, response);

        
        
            
        
        
    }
}
