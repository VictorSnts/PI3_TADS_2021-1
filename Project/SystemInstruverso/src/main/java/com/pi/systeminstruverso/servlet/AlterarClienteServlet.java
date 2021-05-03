package com.pi.systeminstruverso.servlet;

import com.pi.systeminstruverso.dao.ClienteDAO;
import com.pi.systeminstruverso.entidade.Cliente;
import com.pi.systeminstruverso.utils.Convert;
import java.io.IOException;
import java.sql.SQLException;
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
public class AlterarClienteServlet extends HttpServlet {
    
    // Carregar infos do cliente
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        try {
            Cliente cliente = ClienteDAO.getCliente(cpf);            
            request.setAttribute("cliente", cliente);
            
            request.getRequestDispatcher("clientes/cadastrar.jsp").forward(request, response);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AlterarClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Persistir novos dados no BD
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        int filial_cadastro = Convert.ToInt(request.getParameter("filial_cadastro"));
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String data_nasc = request.getParameter("data_nasc");
        String endereco = request.getParameter("endereco");
        int numero = Convert.ToInt(request.getParameter("numero"));
        String cep = request.getParameter("cep");
        String uf = request.getParameter("uf");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        
        System.out.println(cpf);

        Cliente cliente = new Cliente(nome, telefone, email, cpf, cep, endereco, numero, uf, bairro, cidade, filial_cadastro, data_nasc);
        boolean ok = ClienteDAO.atualizar(cliente);
        
        
        if (ok) {
            response.sendRedirect("retornos/sucesso.jsp");
        }
        else {
            String msgErro = "Não foi possivel realizar o exclusao desse cliente.";
            request.setAttribute("msgErro", msgErro);
            request.getRequestDispatcher("retornos/cerro.jsp").forward(request, response);
        }
        
    }

}
