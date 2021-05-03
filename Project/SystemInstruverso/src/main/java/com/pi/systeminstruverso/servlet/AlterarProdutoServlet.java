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
public class AlterarProdutoServlet extends HttpServlet {
    
    // Carregar infos do usuario
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cod = request.getParameter("cod");
        Produto produto = ProdutoDAO.getProduto(cod);
        request.setAttribute("produto", produto);
        request.getRequestDispatcher("produtos/cadastrar.jsp").forward(request, response);
    }
    
    // Persistir novos dados no BD
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
        
        Produto produto =  new Produto(cod, nome, marca, custo, preco, quantidade, comissao);
        boolean ok = ProdutoDAO.atualizar(produto);
        
        
        if (ok) {
            response.sendRedirect("retornos/sucesso.jsp");
        }
        else {
            String msgErro = "Não foi possivel realizar o exclusao desse Produto.";
            request.setAttribute("msgErro", msgErro);
            request.getRequestDispatcher("retornos/cerro.jsp").forward(request, response);
        }
        
    }

}
