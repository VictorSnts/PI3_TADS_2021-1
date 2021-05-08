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
        <title>Cadastro de Clientes</title>
    </head>
    <body class="container">
        <c:import url="../header.jsp"/>
        
        <h1>Cadastro de Clientes</h1><br/><br/>
        <!-- CADASTRO -->
        <c:if test="${empty cliente}">
            <form action="../CadastrarClienteServlet" method="POST">
                
                <h3>-| Dados Pessoais |-</h3>
                <label class="form-label">Filial: </label>                
                <select name="filial_cadastro" required="true">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                </select>
                <label class="form-label">Codigo: </label>
                <input type="text" name="cod" size="6" readonly="true">
                <br><br>
                
                <label class="form-label">Nome: </label>
                <input type="text" name="nome" required="true" size="50">
                <br><br>
                
                <label class="form-label">E-Mail: </label>
                <input type="text" name="email" required="true" size="50">
                <br><br>
                
                <label class="form-label">Telefone: </label>
                <input type="text" name="telefone" required="true" size="11" maxlength="11">
                <label class="form-label">CPF: </label>
                <input type="text" name="cpf" required="true" size="11" maxlength="11">
                <br/><br/>
                
                <label class="form-label">Data de Nascimento: </label>
                <input type="date" name="data_nasc" required="true">
                <br/><br/>
                
                <h3>-| Endereco |-</h3>
                <label class="form-label">Endereco: </label>
                <input type="text" name="endereco" required="true" size="50">                
                <label class="form-label">Numero: </label>
                <input type="text" name="numero" required="true" size="10">
                <br/><br/>

                <label class="form-label">CEP: </label>
                <input type="text" name="cep" required="true" size="9">
                <label class="form-label">UF: </label>
                <input type="text" name="uf" required="true" size="2" maxlength="2">                
                <label class="form-label">Bairro: </label>
                <input type="text" name="bairro" required="true" size="25">
                <label class="form-label">Cidade: </label>
                <input type="text" name="cidade" required="true" size="25">
                <br><br>

                <button type="submit" class="btn-primary">Cadastrar</button>
                
            </form>
        </c:if>
        
        <!-- ATUALIZACAO -->
        <c:if test="${not empty cliente}">
            <form action="AlterarClienteServlet" method="POST">
                
                <h3>-| Dados Pessoais |-</h3>
                
                <label class="form-label">Filial: </label>
                <select name="filial_cadastro" required="true" value="${cliente.filial_cadastro}">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                </select>
                
                <label class="form-label">Codigo: </label>
                <input type="text" name="cod" size="6" readonly="true" value="${cliente.cod}">
                <br><br>
                
                <label class="form-label">Nome: </label>
                <input type="text" name="nome" required="true" size="50" value="${cliente.nome}">
                <br><br>
                
                <label class="form-label">E-Mail: </label>
                <input type="text" name="email" required="true" size="50" value="${cliente.email}">
                <br><br>
                
                <label class="form-label">Telefone: </label>
                <input type="text" name="telefone" required="true" size="11" maxlength="11" value="${cliente.telefone}">
                <label class="form-label">CPF: </label>
                <input type="text" name="cpf" required="true" size="11" maxlength="11" value="${cliente.cpf}">
                <br/><br/>
                
                <label class="form-label">Data de Nascimento: </label>
                <input type="date" name="data_nasc" required="true"  value="${cliente.data_nasc}">
                <br/><br/>
                
                
                <h3>-| Endereco |-</h3>
                <label class="form-label">Endereco: </label>
                <input type="text" name="endereco" required="true" size="50" value="${cliente.endereco}">
                <label class="form-label">Numero: </label>
                <input type="text" name="numero" required="true" size="10" value="${cliente.numero}">
                <br/><br/>
                
                <label class="form-label">CEP: </label>
                <input type="text" name="cep" required="true" size="9" value="${cliente.cep}">
                <label class="form-label">UF: </label>
                <input type="text" name="uf" required="true" size="2" maxlength="2" value="${cliente.uf}">
                <label class="form-label">Bairro: </label>
                <input type="text" name="bairro" required="true" size="25" value="${cliente.bairro}">
                <label class="form-label">Cidade: </label>
                <input type="text" name="cidade" required="true" size="25" value="${cliente.cidade}">
                <br><br>

            
            <button type="submit" class="btn-primary">Atualizar</button>
            </form>
        </c:if>
        
        
        
        <c:import url="../footer.jsp"/>
    </body>
</html>
