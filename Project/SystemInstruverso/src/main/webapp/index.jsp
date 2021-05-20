<%-- 
    Document   : index
    Created on : May 18, 2021, 12:39:14 PM
    Author     : victor
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/login.css"/>">
        
        <title>Tela de Login</title>
    </head>
    <body>        
        <div id="login">
            <h1>Login</h1>
            <form action="Inicio.jsp">
                <label for="usuario">Usuario</label>
                <input type="text" name="usuario" id="usuario">
                
                
                <label for="senha">Senha</label>
                <input type="password" name="senha" id="senha">

                
                <button type="submit" class="btn-primary">Entrar</button>
            </form>
            
        </div>
        
        
        
        
    </body>
</html>
