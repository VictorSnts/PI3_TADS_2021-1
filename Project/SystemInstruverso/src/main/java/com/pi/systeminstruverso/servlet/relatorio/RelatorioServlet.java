package com.pi.systeminstruverso.servlet.relatorio;

import com.pi.systeminstruverso.dao.VendaDAO;
import com.pi.systeminstruverso.entidade.Usuario;
import com.pi.systeminstruverso.entidade.Venda;
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
public class RelatorioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Usuario usuario_logado = (Usuario) session.getAttribute("usuario_logado");
        
        String intervalo = request.getParameter("intervalo");
        List<Venda> listaVendas = null ;
        
        if(intervalo.equals("full")){
            if(usuario_logado.isGerenteGeral()){
                listaVendas = VendaDAO.getVendas();
            } else {
                listaVendas = VendaDAO.getVendas(usuario_logado.getFilial());
            }
            
            
        } else if(intervalo.equals("dates")){
            String data_inicial = request.getParameter("data_inicial");
            String data_final = request.getParameter("data_final");
            String filial = request.getParameter("filial");
            
            if(!filial.equals("none")){
                listaVendas = VendaDAO.getVendas(data_inicial, data_final, filial);
                
            } else{
                listaVendas = VendaDAO.getVendas(data_inicial, data_final);
            }
            
        }
        
        double soma_preco = 0;
        
        for(Venda venda : listaVendas){
            soma_preco += (venda.getTotal_venda());
        }
        
        request.setAttribute("soma_preco", new DecimalFormat("#,##0.00").format(soma_preco));
        request.setAttribute("listaVendas", listaVendas);
        
        request.getRequestDispatcher("/protegido/gerentes/relatorios/listaVendas.jsp").forward(request, response);
    }
    
}