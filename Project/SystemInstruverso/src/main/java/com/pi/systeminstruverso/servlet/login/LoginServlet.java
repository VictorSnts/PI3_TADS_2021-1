/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.systeminstruverso.servlet.login;

import com.pi.systeminstruverso.dao.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author victor
 */
public class LoginServlet extends HttpServlet {
// Carregar infos do cliente
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        
        System.out.println("Servlet");
        System.out.println(user);
        System.out.println(pass);
        System.out.println("Servlet");

        
        boolean validacao =  LoginDAO.validar(user, pass);
            
        if(validacao){
             response.sendRedirect("Inicio.jsp");
        } else{
            String msg = "Usuario ou senha invalido!";
            request.setAttribute("erro", msg);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
            
    }

}
