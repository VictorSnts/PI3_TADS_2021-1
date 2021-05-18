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
    <title>Cadastro de Clientes</title>
</head>
<body>
    <c:import url="/header.jsp"/>



    <!-- CADASTRO -->
    <c:if test="${empty cliente}">
        <form action="../CadastrarClienteServlet" method="POST">
 
            <div>
                <h1 id="titulo">Cadastro de Clientes</h1>
                <p id="subtitulo">Insira as informações do Cliente</p>
                <br>
            </div>

            <fieldset class="grupo">
                <div class="campo">
                    <label for="filial_cadastro"><strong>Filial:</strong></label>
                    <select name="filial_cadastro" id="filial_cadastro" required="true">
                        <option value="" selected disabled> </option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </select>
                    
                </div>
            </fieldset>
            <hr/>

            <h4 id="item">Dados Pessoais</h4>
            <fieldset class="grupo">

                <div class="campo">
                    <label for="nome"><strong>Nome:</strong> </label>
                    <input type="text" name="nome" id="nome" required="true" size="60">
                    <label for="cpf"><strong>CPF:</strong> </label>
                    <input type="text" name="cpf" id="cpf" required="true" size="30" maxlength="11"><br><br>
                    <label for="data_nasc"><strong>Data de Nascimento:</strong> </label>
                    <input type="date" name="data_nasc" id="data_nasc" required="true"><br><br>
                </div>

                <div class="campo">
                    <label for="email"><strong>E-Mail: </strong></label>
                    <input type="email" name="email" id="email" required="true" size="60">
                    <label for="telefone"><strong>Telefone:</strong> </label>
                    <input type="text" name="telefone" id="telefone" required="true" size="30" maxlength="11"> 
                </div>

            </fieldset>
            <hr>

            <h4 id="item">Endereço: </h4>
            <fieldset class="grupo">

                <div class="campo">
                    <label for="endereco"><strong>Logradouro:</strong> </label>
                    <input type="text" name="endereco" id="endereco" required="true" size="60">                
                    <label for="numero"><strong>Numero:</strong> </label>
                    <input type="text" name="numero" id="numero" required="true" size="10"><br><br>
                </div>

                <div class="campo">
                    <label for="bairro"><strong>Bairro:</strong> </label>
                    <input type="text" name="bairro" id="bairro" required="true" size="30">
                    <label for="cidade"><strong>Cidade:</strong> </label>
                    <input type="text" name="cidade" id="cidade" required="true" size="30"> 
                    <label for="uf"><strong>UF:</strong> </label>
                    <input type="text" name="uf" id="uf" required="true" size="4" maxlength="2"> 
                    <label for="cep"><strong>CEP:</strong> </label>
                    <input type="text" name="cep" id="cep" required="true" size="17" maxlength="8">
                </div>

            </fieldset>
            <hr/>
            
            <button class="botao" type="submit"><strong>Cadastrar</strong></button>
        </form>
    </c:if>

    <c:if test="${not empty cliente}">
    <form action="AlterarClienteServlet" method="POST">
 
        <div>
            <h1 id="titulo">Atualização de Clientes</h1>
            <p id="subtitulo">Altere as informações do Cliente</p>
            <br>
        </div>

        <fieldset class="grupo">
            <div class="campo">
                <label for="filial_cadastro"><strong>Filial:</strong></label>
                <select name="filial_cadastro" id="filial_cadastro" required="true" value="${cliente.filial_cadastro}">
                    <c:if test="${cliente.filial_cadastro == '1'}">
                        <option value="1" selected="selected">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </c:if>
                    <c:if test="${cliente.filial_cadastro == '2'}">
                        <option value="1">1</option>
                        <option value="2" selected="selected">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </c:if>
                    <c:if test="${cliente.filial_cadastro == '3'}">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3" selected="selected">3</option>
                        <option value="4">4</option>
                    </c:if>
                     <c:if test="${cliente.filial_cadastro == '4'}">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4"  selected="selected">4</option>
                    </c:if>
                </select>
                <label for="cod"><strong>Código:</strong> </label>
                <input type="text" name="cod" id="cod" readonly="true" size="10" value="${cliente.cod}">
                <!-- Retirar essa parte na realizacao do cadastro -->
            </div>
        </fieldset>
        <hr/>

        <h4 id="item">Dados Pessoais</h4>
        <fieldset class="grupo">

            <div class="campo">
                <label for="nome"><strong>Nome:</strong> </label>
                <input type="text" name="nome" id="nome" required="true" size="60" value="${cliente.nome}">
                <label for="cpf"><strong>CPF:</strong> </label>
                <input type="text" name="cpf" id="cpf" required="true" size="30" maxlength="11" value="${cliente.cpf}"><br><br>
                <label for="data_nasc"><strong>Data de Nascimento:</strong> </label>
                <input type="date" name="data_nasc" id="data_nasc" required="true" value="${cliente.data_nasc}"><br><br>
            </div>

            <div class="campo">
                <label for="email"><strong>E-Mail: </strong></label>
                <input type="email" name="email" id="email" required="true" size="60" value="${cliente.email}">
                <label for="telefone"><strong>Telefone:</strong> </label>
                <input type="text" name="telefone" id="telefone" required="true" size="30" maxlength="11" value="${cliente.telefone}"> 
            </div>

        </fieldset>
        <hr>

        <h4 id="item">Endereço: </h4>
        <fieldset class="grupo">

            <div class="campo">
                <label for="endereco"><strong>Logradouro:</strong> </label>
                <input type="text" name="endereco" id="endereco" required="true" size="60" value="${cliente.endereco}">                
                <label for="numero"><strong>Numero:</strong> </label>
                <input type="text" name="numero" id="numero" required="true" size="10" value="${cliente.numero}"><br><br>
            </div>

            <div class="campo">
                <label for="bairro"><strong>Bairro:</strong> </label>
                <input type="text" name="bairro" id="bairro" required="true" size="30"  value="${cliente.bairro}">
                <label for="cidade"><strong>Cidade:</strong> </label>
                <input type="text" name="cidade" id="cidade" required="true" size="30" value="${cliente.cidade}"> 
                <label for="uf"><strong>UF:</strong> </label>
                <input type="text" name="uf" id="uf" required="true" size="4" maxlength="2"  value="${cliente.uf}"> 
                <label for="cep"><strong>CEP:</strong> </label>
                <input type="text" name="cep" id="cep" required="true" size="17" maxlength="8" value="${cliente.cep}">
            </div>

        </fieldset>
        <hr/>
        
        <button class="botao" type="submit"><strong>Cadastrar</strong></button>
    </form>
</c:if>
    
    

</body>
</html>