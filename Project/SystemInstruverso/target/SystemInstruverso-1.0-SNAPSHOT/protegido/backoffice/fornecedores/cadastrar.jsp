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
    <title>Cadastro de Fornecedores</title>
</head>
<body>
    <c:import url="/header.jsp"/>



    <!-- CADASTRO -->
    <c:if test="${empty fornecedor}">
        <form action="<c:url value="/CadastrarFornecedorServlet"/>" method="POST">
 
            <div>
                <h1 id="titulo">Cadastro de Fornecedores</h1>
                <p id="subtitulo">Insira as informações do Fornecedor</p>
                <br>
            </div>

            <hr/>

            <h4 id="item">Dados Da Empresa:</h4>
            <fieldset class="grupo">

                <div class="campo">
                    <label for="razao_social"><strong>Razao Social: </strong> </label>
                    <input type="text" name="razao_social" id="razao_social" required="true" size="30">

                    <label for="nome_fantasia"><strong>Nome Fantasia: </strong> </label>
                    <input type="text" name="nome_fantasia" id="nome_fantasia" required="true" size="30">

                    <label for="cnpj"><strong>CNPJ: </strong> </label>
                    <input type="text" name="cnpj" id="cnpj" required="true" size="15" maxlength="11"><br><br>
                </div>

                <div class="campo">
                    <label for="nome_contato"><strong>Nome Para Contato: </strong> </label>
                    <input type="text" name="nome_contato" id="nome_contato" required="true" size="20">

                    <label for="email"><strong>E-Mail: </strong></label>
                    <input type="email" name="email" id="email" required="true" size="25">

                    <label for="site"><strong>Site: </strong> </label>
                    <input type="text" name="site" id="site" required="true" size="25">

                    <label for="telefone"><strong>Telefone:</strong> </label>
                    <input type="text" name="telefone" id="telefone" required="true" size="15" maxlength="11"> 
                </div>

            </fieldset>
            <hr>

            <h4 id="item">Endereço: </h4>
            <fieldset class="grupo">

                <div class="campo">
                    <label for="endereco"><strong>Logradouro:</strong> </label>
                    <input type="text" name="endereco" id="endereco" required="true" size="60">

                    <label for="numero"><strong>Numero:</strong> </label>
                    <input type="text" name="numero" id="numero" required="true" size="10">
                    
                    <label for="bairro"><strong>Bairro:</strong> </label>
                    <input type="text" name="bairro" id="bairro" required="true" size="25"><br><br>
                </div>

                <div class="campo">
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

    <c:if test="${not empty fornecedor}">
    <form action="AlterarFornecedorServlet" method="POST">
 
        <div>
            <h1 id="titulo">Atualização de Fornecedores</h1>
            <p id="subtitulo">Altere as informações do Fornecedor</p>
            <br>
        </div>

        <fieldset class="grupo">
            <div class="campo">            
                <label for="cod"><strong>Código:</strong> </label>
                <input type="text" name="cod" id="cod" readonly="true" size="10" value="${fornecedor.cod}">
            </div>
        </fieldset>
        <hr/>

        <h4 id="item">Dados da Empresa</h4>
        <fieldset class="grupo">

            <div class="campo">
                <label for="razao_social"><strong>Razao Social: </strong> </label>
                <input type="text" name="razao_social" id="razao_social" required="true" size="30" value="${fornecedor.razao_social}">

                <label for="nome_fantasia"><strong>Nome Fantasia: </strong> </label>
                <input type="text" name="nome_fantasia" id="nome_fantasia" required="true" size="30" value="${fornecedor.nome_fantasia}">

                <label for="cnpj"><strong>CNPJ: </strong> </label>
                <input type="text" name="cnpj" id="cnpj" required="true" size="15" maxlength="14" value="${fornecedor.cnpj}"><br><br>
            </div>

            <div class="campo">
                <label for="nome_contato"><strong>Nome Para Contato: </strong> </label>
                <input type="text" name="nome_contato" id="nome_contato" required="true" size="20" value="${fornecedor.nome_contato}">

                <label for="email"><strong>E-Mail: </strong></label>
                <input type="email" name="email" id="email" required="true" size="25" value="${fornecedor.email}">

                <label for="site"><strong>Site: </strong> </label>
                <input type="text" name="site" id="site" required="true" size="25" value="${fornecedor.site}">

                <label for="telefone"><strong>Telefone:</strong> </label>
                <input type="text" name="telefone" id="telefone" required="true" size="15" maxlength="11" value="${fornecedor.telefone}"> 
            </div>

        </fieldset>
        <hr>

        <h4 id="item">Endereço: </h4>
        <fieldset class="grupo">

            <div class="campo">
                <label for="endereco"><strong>Logradouro: </strong> </label>
                <input type="text" name="endereco" id="endereco" required="true" size="60" value="${fornecedor.endereco}">

                <label for="numero"><strong>Numero:</strong> </label>
                <input type="text" name="numero" id="numero" required="true" size="10" value="${fornecedor.numero}">

                <label for="bairro"><strong>Bairro:</strong> </label>
                <input type="text" name="bairro" id="bairro" required="true" size="25"  value="${fornecedor.bairro}"><br><br>
            </div>

            <div class="campo">
                <label for="cidade"><strong>Cidade:</strong> </label>
                <input type="text" name="cidade" id="cidade" required="true" size="30" value="${fornecedor.cidade}"> 

                <label for="uf"><strong>UF:</strong> </label>
                <input type="text" name="uf" id="uf" required="true" size="4" maxlength="2"  value="${fornecedor.uf}"> 
                
                <label for="cep"><strong>CEP:</strong> </label>
                <input type="text" name="cep" id="cep" required="true" size="17" maxlength="8" value="${fornecedor.cep}">
                
                <label for="pais"><strong>Pais: </strong> </label>
                <input type="text" name="pais" id="pais" required="true" size="17" value="${fornecedor.pais}">
                
            </div>

        </fieldset>
        <hr/>
        
        <button class="botao" type="submit"><strong>Atualizar</strong></button>
    </form>
</c:if>
    
    

</body>
</html>