/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.systeminstruverso.servlet.venda;

import com.pi.systeminstruverso.dao.ClienteDAO;
import com.pi.systeminstruverso.dao.ProdutoDAO;
import com.pi.systeminstruverso.dao.VendaDAO;
import com.pi.systeminstruverso.entidade.Cliente;
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
        int num_venda = 0;
        int cod_cliente = 0;
        
        // Definindo cliente
        cod_cliente = Convert.ToInt(request.getParameter("cliente"));
        try {
            Cliente cliente = ClienteDAO.getCliente(Integer.toString(cod_cliente));
            request.setAttribute("cod_cliente", cliente.getCod());
            request.setAttribute("nome_cliente", cliente.getNome());
        } catch (SQLException ex) {
            Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        // Definindo nro venda
        boolean primeira_exec = request.getParameter("venda").equals("none");
        if(primeira_exec){
            num_venda = VendaDAO.novaVenda(1, 50, cod_cliente); // NovaVenda recebe a filal o cod de usuario e cliente. Por enqunato ta padrao 50,50
        } else{
            num_venda = Convert.ToInt(request.getParameter("venda"));
        }
        request.setAttribute("num_venda", num_venda);
        
        
        // Popula tabela de produtos
        try {
            List<Produto> listaProdutos;
            listaProdutos = ProdutoDAO.getProdutos();
            request.setAttribute("listaProdutos", listaProdutos);
        } catch (SQLException ex) {
            Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         int cod_produto = 0;
         boolean ja_adicionado = false;

        if(!primeira_exec){
            // Pega o codigo do produto adicionado
            if (!request.getParameter("cod").equals("")){
                cod_produto = Convert.ToInt(request.getParameter("cod"));
            }
            // verifica se ja o produto ja foi adicionado
            try {
                ja_adicionado = VendaDAO.verificarProdutoVenda(num_venda, cod_produto);
            } catch (SQLException ex) {
                Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);
            } // Se ja foi adicionado
            if(ja_adicionado){
                //somar qtd
                VendaDAO.adicionarItem(num_venda, cod_produto);
            } else{
                // Busca info do produto no BD
                Produto produto = ProdutoDAO.getProduto(Integer.toString(cod_produto));

                // Cadastra item da venda
                VendaProduto vp = new VendaProduto(num_venda, produto.getCod(), produto.getPreco(), 1);
                VendaDAO.cadastrarProdutoVenda(vp);
            }
        }
        // Lista os produtos do carrinho para a venda corrente
        List<VendaProduto> listaItem;
        listaItem = VendaDAO.getItensVenda(num_venda);
        request.setAttribute("listaItem", listaItem);

        // Calcula o total da nota para venda corrente
        double total_venda = VendaDAO.getTotalVenda(num_venda);
        request.setAttribute("total_venda", total_venda);
        
        request.getRequestDispatcher("/vendas/vender.jsp").forward(request, response);

    }
}
