package com.pi.systeminstruverso.servlet.fornecedor;

import com.pi.systeminstruverso.dao.FornecedorDAO;
import com.pi.systeminstruverso.entidade.Fornecedor;
import com.pi.systeminstruverso.entidade.Usuario;
import com.pi.systeminstruverso.utils.Convert;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author victor
 */
public class AlterarFornecedorServlet extends HttpServlet {
    
    // Carregar infos do Fornecedor
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cod = Convert.ToInt(request.getParameter("cod"));
        try {
            Fornecedor fornecedor = FornecedorDAO.getFornecedor(cod);            
            request.setAttribute("fornecedor", fornecedor);
            
            request.getRequestDispatcher("protegido/backoffice/fornecedores/cadastrar.jsp").forward(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(AlterarFornecedorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Persistir novos dados no BD
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Usuario usuario_logado = (Usuario) session.getAttribute("usuario_logado");

        if (usuario_logado.getPerfil().equals("BACKOFFICE")) {
            int cod = Convert.ToInt(request.getParameter("cod"));
            String razao_social = request.getParameter("razao_social");
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
            String pais = "";
            String uf = request.getParameter("uf");
            String bairro = request.getParameter("bairro");
            String cidade = request.getParameter("cidade");
            int filial_cadastro = usuario_logado.getFilial();


            Fornecedor fornecedor = new Fornecedor(cod, razao_social, nome_fantasia, data_registro, nome_contato, telefone, email, site, cnpj, cep, endereco, numero, pais, uf, bairro, cidade, filial_cadastro);
            boolean ok = FornecedorDAO.atualizar(fornecedor);


            if (ok) {
                response.sendRedirect("retornos/sucesso.jsp");
            }
            else {
                String msgErro = "Não foi possivel realizar o exclusao desse Fornecedor.";
                request.setAttribute("msgErro", msgErro);
                request.getRequestDispatcher("retornos/cerro.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/retornos/erro_auth.jsp");
        }

        
        
    }

}
