package com.pi.systeminstruverso.servlet.produto;

import com.pi.systeminstruverso.dao.ProdutoDAO;
import com.pi.systeminstruverso.entidade.Produto;
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
public class AlterarProdutoServlet extends HttpServlet {
    
    // Carregar infos do usuario
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario usuario_logado = (Usuario) session.getAttribute("usuario_logado");
        
        if (usuario_logado.isBackoffice()) {
            String cod = request.getParameter("cod");
            Produto produto = ProdutoDAO.getProduto(cod);
            request.setAttribute("produto", produto);
            request.getRequestDispatcher("protegido/backoffice/produtos/cadastrar.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/retornos/erro_auth.jsp");
        }

    }
    
    // Persistir novos dados no BD
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int cod = -1;
        if (!request.getParameter("cod").equals("")) {
            cod = Convert.ToInt(request.getParameter("cod"));
        }
        int filial = Convert.ToInt(request.getParameter("filial"));
        String nome = request.getParameter("nome");
        String marca = request.getParameter("marca");
        int codFornecedor = Convert.ToInt(request.getParameter("codFornecedor"));
        String categoria = request.getParameter("categoria");
        double custo = Convert.ToDouble(request.getParameter("custo"));
        double preco = Convert.ToDouble(request.getParameter("preco"));
        int quantidade = Convert.ToInt(request.getParameter("quantidade"));
        double comissao = Convert.ToDouble(request.getParameter("comissao"));


        Produto produto =  new Produto(cod, filial, nome, marca, codFornecedor, "", categoria, custo, preco, quantidade, comissao);
        boolean ok = ProdutoDAO.atualizar(produto);


        if (ok) {
            response.sendRedirect("retornos/sucesso.jsp");
        }
        else {
            String msgErro = "Não foi possivel realizar o exclusao desse Produto.";
            request.setAttribute("msgErro", msgErro);
            request.getRequestDispatcher("retornos/erro.jsp").forward(request, response);
        }

    }

}
