package com.pi.systeminstruverso.servlet.cliente;

import com.pi.systeminstruverso.dao.ClienteDAO;
import com.pi.systeminstruverso.entidade.Cliente;
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
public class CadastrarClienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario usuario_logado = (Usuario) session.getAttribute("usuario_logado");
        
        // Recuperar os parametros      
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        int filial_cadastro = usuario_logado.getFilial();
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String data_nasc = request.getParameter("data_nasc");
        String endereco = request.getParameter("endereco");
        int numero = Convert.ToInt(request.getParameter("numero"));
        String cep = request.getParameter("cep");
        String uf = request.getParameter("uf");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");

        
        // Inserir oi cliente no BD
        Cliente cliente = new Cliente(-1, nome, telefone, email, cpf, cep, endereco, numero, uf, bairro, cidade, filial_cadastro, data_nasc);
        boolean ok = ClienteDAO.cadastrar(cliente);
              
        // Redirecionar para sucesso/erro
        if (ok) {
            response.sendRedirect("retornos/sucesso.jsp");
        }
        else {
            String msgErro = "Não foi possivel realizar o cadastro desse cliente.";
            request.setAttribute("msgErro", msgErro);
            request.getRequestDispatcher("retornos/erro.jsp").forward(request, response);
        }
        
        
    }

   
}
