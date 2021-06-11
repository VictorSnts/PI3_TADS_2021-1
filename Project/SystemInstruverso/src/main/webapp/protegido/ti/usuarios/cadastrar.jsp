<%-- 
    Document   : cadastrar
    Created on : Apr 23, 2021, 9:50:14 PM
    Author     : victor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>">
    <title>Cadastro de Usuarios</title>
</head>
<body>
    <c:import url="/header.jsp"/>



    <!-- CADASTRO -->
    <c:if test="${empty usuario}">
        <form action="<c:url value="/CadastrarUsuarioServlet"/>" method="POST">
 
            <div>
                <h1 id="titulo">Cadastro de Usuarios</h1>
                <p id="subtitulo">Insira as informações do Usuario</p>
                <br>
            </div>

            <hr/>

            <h4 id="item">Dados Da Usuario:</h4>
            <fieldset class="grupo">

                <div class="campo">
                    <label for="nome"><strong>Nome: </strong> </label>
                    <input type="text" name="nome" id="nome" required="true" size="30">

                    <label for="perfil"><strong>Area: </strong> </label>
                    <input type="text" name="perfil" id="perfil" required="true" size="30">

                    <label for="nivel"><strong>Nivel: </strong> </label>
                    <input type="text" name="nivel" id="nivel" required="true" size="30">

                    <label for="cpf"><strong>CPF: </strong> </label>
                    <input type="text" name="cpf" id="cpf" required="true" size="15" maxlength="11"><br><br>
                </div>

                <div class="campo">
                    <label for="login"><strong>Login: </strong> </label>
                    <input type="text" name="login" id="login" required="true" size="20">

                    <label for="senha"><strong>Senha: </strong></label>
                    <input type="password" name="senha" id="senha" required="true" size="25"><br><br>
                </div>

                <div class="campo">

                    <label for="telefone"><strong>Telefone: </strong> </label>
                    <input type="text" name="telefone" id="telefone" required="true" size="25" maxlength="11">

                    <label for="status"><strong>Status:</strong> </label>
                    <select name="status" required="true">
                        <option value="Ativo" selected="selected">Ativo</option>
                        <option value="Inativo">Inativo</option>
                    </select><br><br>
                </div>

            </fieldset>
            
            <hr/>
            
            <button class="botao" type="submit"><strong>Cadastrar</strong></button>
        </form>
    </c:if>

    <c:if test="${not empty usuario}">
    <form action="<c:url value="/AlterarUsuarioServlet"/>" method="POST">
 
        <div>
            <h1 id="titulo">Atualização de Usuarios</h1>
            <p id="subtitulo">Altere as informações do usuario</p>
            <br>
        </div>

        <fieldset class="grupo">
            <div class="campo">            
                <label for="cod"><strong>Código:</strong> </label>
                <input type="text" name="cod" id="cod" readonly="true" size="10" value="${usuario.cod}">
            </div>
        </fieldset>
        <hr/>

        <h4 id="item">Dados da Usuario</h4>
        <fieldset class="grupo">

            <div class="campo">

                <label for="nome"><strong>Nome: </strong> </label>
                <input type="text" name="nome" id="nome" required="true" size="30" value="${usuario.nome}">

                <label for="perfil"><strong>Area: </strong> </label>
                <input type="text" name="perfil" id="perfil" required="true" size="30" value="${usuario.perfil}">

                <label for="nivel"><strong>Nivel: </strong> </label>
                <input type="text" name="nivel" id="nivel" required="true" size="30" value="${usuario.nivel}">

                <label for="cpf"><strong>CPF: </strong> </label>
                <input type="text" name="cpf" id="cpf" required="true" size="15" maxlength="11" value="${usuario.cpf}"><br><br>
            </div>

            <div class="campo">
                <label for="login"><strong>Login: </strong> </label>
                <input type="text" name="login" id="login" required="true" size="20" value=${usuario.login}>

            </div>

            <div class="campo">

                <label for="telefone"><strong>Telefone: </strong> </label>
                <input type="text" name="telefone" id="telefone" required="true" size="25" value=${usuario.telefone}>

                <label for="status"><strong>Status:</strong> </label>
                <select name="status" required="true">
                    <c:if test="${usuario.status == 'Ativo'}">
                        <option value="Ativo" selected="selected">Ativo</option>
                        <option value="Inativo">Inativo</option>
                    </c:if>
                     <c:if test="${usuario.status == 'Inativo'}">
                        <option value="Ativo">Ativo</option>
                        <option value="Inativo" selected="selected">Inativo</option>
                    </c:if>
                </select><br><br>
            </div>

        </fieldset>
        <hr/>
        
        <button class="botao" type="submit"><strong>Atualizar</strong></button>
    </form>
</c:if>
    
    

</body>
</html>