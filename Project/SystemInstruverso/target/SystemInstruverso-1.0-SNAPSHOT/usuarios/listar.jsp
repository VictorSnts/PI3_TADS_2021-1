<%-- 
    Document   : lista
    Created on : Apr 23, 2021, 8:43:33 PM
    Author     : victor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Lista de Usuarios</title>
    </head>
    <body class="container">
        <c:import url="../header.jsp"/>
        <h1>Usuarios</h1>
        
        <div class="scrollmenu">
            <a href="usuarios/cadastrar.jsp">Cadastrar Usuarios</a>
        </div>   
        
        
        <table class="table table-striped table-bordered table-sm ">
            <thead>
                <th scope="col">Cod</th>
                <th scope="col">Nome</th>
                <th scope="col">Filial</th>
                <th scope="col">Perfil</th>
                <th scope="col">Login</th>
                <th scope="col">Senha</th>
                <th scope="col">Telefone</th>
                <th scope="col">Email</th>
                <th scope="col">Cpf</th>
                <th scope="col">Status</th>
                <th scope="col"> </th>
                <th scope="col"> </th>

                
            </thead>
            <c:forEach items="${listaUsuario}" var="usuario">
                <tr>
                    <td>${usuario.cod}</td>
                    <td>${usuario.nome}</td>
                    <td>${usuario.filial}</td>
                    <td>${usuario.perfil}</td>
                    <td>${usuario.login}</td>
                    <td>${usuario.senha}</td>
                    <td>${usuario.telefone}</td>
                    <td>${usuario.email}</td>
                    <td>${usuario.cpf}</td>
                    <td>${usuario.status}</td>
                    <td><a href="AlterarUsuarioServlet?cod=${usuario.cod}">Atualizar</a></td>
                    <td><a href="ExcluirUsuarioServlet?cod=${usuario.cod}">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        
        <c:import url="/footer.jsp"/>
    </body>
</html>
