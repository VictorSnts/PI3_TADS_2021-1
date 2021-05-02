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
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Cadastro de Usuario</title>
    </head>
    <body class="container">
        <c:import url="../header.jsp"/>
        
        <h1>Cadastro de Usuarios</h1><br/><br/> 
        <!-- CADASTRO -->
        <c:if test="${empty usuario}">
            <form action="../CadastrarUsuarioServlet" method="POST">
                
                <h3>-| Dados do Usuario |-</h3>
                
               <label class="form-label">Codigo: </label>
                <input type="text" name ="cod" readonly="true">
                <label class="form-label">Nome: </label>
                <input type="text" name ="nome" required="true">
                
                <br><br>
                
                <label class="form-label">Matricula: </label>
                <input type="text" name ="matricula" required="true">
                <label class="form-label">Perfil: </label>
                <input type="text" name ="perfil" required="true">
                                
                <br><br>
                
                <label class="form-label">Login: </label>
                <input type="text" name ="login" required="true">
                <label class="form-label">Senha: </label>
                <input type="text" name ="senha" required="true">
                                
                <br><br>
                
                <label class="form-label">Telefone: </label>
                <input type="text" name ="telefone" required="true">
                <label class="form-label">Email: </label>
                <input type="text" name ="email" required="true">
                <label class="form-label">CPF: </label>
                <input type="text" name ="cpf" required="true">
                                
                <br><br>
                
                <label class="form-label">Status: </label>
                <input type="text" name ="status" required="true">
                <label class="form-label">Filial </label>
                <input type="text" name ="filial" required="true">
                                
                <br><br>
                
                
                

                <button type="submit" class="btn-primary">Cadastrar</button>
                
            </form>
        </c:if>
        
        <!-- ATUALIZACAO -->
        <c:if test="${not empty usuario}">
            <form action="AlterarUsuarioServlet" method="POST">
                
                <h3>-| Dados da Empresa |-</h3>
                
                <label class="form-label">Codigo: </label>
                <input type="text" name ="cod" readonly="true" value=${usuario.cod}>
                <label class="form-label">Nome: </label>
                <input type="text" name ="nome" required="true" value=${usuario.nome}>
                
                <br><br>
                
                <label class="form-label">Matricula: </label>
                <input type="text" name ="matricula" required="true" value=${usuario.matricula}>
                <label class="form-label">Perfil: </label>
                <input type="text" name ="perfil" required="true" value=${usuario.perfil}>
                                
                <br><br>
                
                <label class="form-label">Login: </label>
                <input type="text" name ="login" required="true" value=${usuario.login}>
                <label class="form-label">Senha: </label>
                <input type="text" name ="senha" required="true" value=${usuario.senha}>
                                
                <br><br>
                
                <label class="form-label">Telefone: </label>
                <input type="text" name ="telefone" required="true" value=${usuario.telefone}>
                <label class="form-label">Email: </label>
                <input type="text" name ="email" required="true" value=${usuario.email}>
                <label class="form-label">CPF: </label>
                <input type="text" name ="cpf" required="true" value=${usuario.cpf}>
                                
                <br><br>
                
                <label class="form-label">Status: </label>
                <input type="text" name ="status" required="true" value=${usuario.status}>
                <label class="form-label">Filial </label>
                <input type="text" name ="filial" required="true" value=${usuario.filial}>
                                
                <br><br>
            <button type="submit" class="btn-primary">Atualizar</button>
            </form>
        </c:if>
        
        
        
        <c:import url="../footer.jsp"/>
    </body>
</html>
