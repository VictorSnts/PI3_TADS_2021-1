<%-- 
    Document   : cadastrar
    Created on : Apr 23, 2021, 9:50:14 PM
    Author     : victor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

        <title>Cadastro de Clientes</title>
    </head>
    <body class="container">
        <c:import url="../header.jsp"/>
        
        <h1>Cadastro de Clientes</h1>
        <!-- CADASTRO -->
        <c:if test="${empty cliente}">
            <form action="../CadastrarClienteServlet" method="POST">
            <label>Nome</label>
            <input type="text" name="nome" required="true"/>
            <br><br>
            <label>Email</label>
            <input type="text" name="email" required="true"/>
            <br><br>
            <label>CPF</label>
            <input type="text" name="cpf" required="true"/>
            <br><br>
            
            <button type="submit" class="btn-primary">Cadastrar</button>
        </form>
        </c:if>
        
        <!-- ATUALIZACAO -->
        <c:if test="${not empty cliente}">
            <form action="AlterarClienteServlet" method="POST">
            <label>Nome</label>
            <input type="text" name="nome" required="true" value="${cliente.nome}"/>
            <br><br>
            <label>Email</label>
            <input type="text" name="email" required="true" value="${cliente.email}"/>
            <br><br>
            <label>CPF</label>
            <input type="text" name="cpf" required="true" value="${cliente.cpf}" readonly="true"/>
            <br><br>
            
            <button type="submit" class="btn-primary">Atualizar</button>
        </form>
        </c:if>
        
        
        
        <c:import url="../footer.jsp"/>
    </body>
</html>
