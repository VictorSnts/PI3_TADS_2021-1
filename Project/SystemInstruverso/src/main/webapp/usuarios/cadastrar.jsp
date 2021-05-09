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
                <input type="text" name ="cod" readonly="true" size="6">
                <label class="form-label">Filial </label>
                <select name="filial" required="true">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                </select>
                <br><br>
                
                <label class="form-label">Nome: </label>
                <input type="text" name ="nome" required="true" size="50">
                <br><br>
                
                <label class="form-label">Perfil: </label>
                <input type="text" name ="perfil" required="true" size="25">
                <label class="form-label">CPF: </label>
                <input type="text" name ="cpf" required="true" size="13">
                <br><br>
                
                <label class="form-label">Login: </label>
                <input type="text" name ="login" required="true">
                <label class="form-label">Senha: </label>
                <input type="password" name ="senha" required="true">
                <br><br>
                
                <label class="form-label">Telefone: </label>
                <input type="text" name ="telefone" required="true"size="13">
                <label class="form-label">Status: </label>
                <select name="status" required="true">
                    <option value="Ativo" selected="selected">Ativo</option>
                    <option value="Inativo">Inativo</option>
                </select>      
                <br><br>

                <button type="submit" class="btn-primary">Cadastrar</button>
            </form>
        </c:if>
        
        <!-- ATUALIZACAO -->
        <c:if test="${not empty usuario}">
            <form action="AlterarUsuarioServlet" method="POST">
                
                <h3>-| Dados do Usuario |-</h3>
                
                <label class="form-label">Codigo: </label>
                <input type="text" name ="cod" readonly="true" size="6" value="${usuario.cod}">
                <label class="form-label">Filial </label>
                <select name="filial" required="true">
                    <c:if test="${usuario.filial == '1'}">
                        <option value="1" selected="selected">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </c:if>
                    <c:if test="${usuario.filial == '2'}">
                        <option value="1">1</option>
                        <option value="2" selected="selected">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </c:if>
                    <c:if test="${usuario.filial == '3'}">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3" selected="selected">3</option>
                        <option value="4">4</option>
                    </c:if>
                     <c:if test="${usuario.filial == '4'}">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4"  selected="selected">4</option>
                    </c:if>
                </select>
                <br><br>
                
                <label class="form-label">Nome: </label>
                <input type="text" name ="nome" required="true" size="50" value="${usuario.nome}">
                <br><br>
                
                <label class="form-label">Perfil: </label>
                <input type="text" name ="perfil" required="true" size="25" value=${usuario.perfil}>
                <label class="form-label">CPF: </label>
                <input type="text" name ="cpf" required="true" size="13" value=${usuario.cpf}>
                <br><br>
                
                <label class="form-label">Login: </label>
                <input type="text" name ="login" required="true" value=${usuario.login}>
                <label class="form-label">Senha: </label>
                <input type="password" name ="senha" required="true" value=${usuario.senha}>
                <br><br>
                
                <label class="form-label">Telefone: </label>
                <input type="text" name ="telefone" required="true"size="13" value=${usuario.telefone}>
                <label class="form-label">Status: </label>
                <select name="status" required="true">
                    <c:if test="${usuario.status == 'Ativo'}">
                        <option value="Ativo" selected="selected">Ativo</option>
                        <option value="Inativo">Inativo</option>
                    </c:if>
                     <c:if test="${usuario.status == 'Inativo'}">
                        <option value="Ativo">Ativo</option>
                        <option value="Inativo" selected="selected">Inativo</option>
                    </c:if>
                </select>
                <br><br>
            <button type="submit" class="btn-primary">Atualizar</button>
            </form>
        </c:if>
        
        
        
        <c:import url="../footer.jsp"/>
    </body>
</html>
