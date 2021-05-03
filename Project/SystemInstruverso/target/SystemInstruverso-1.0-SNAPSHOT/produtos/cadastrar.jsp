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
        <title>Cadastro de Fornecedores</title>
    </head>
    <body class="container">
        <c:import url="../header.jsp"/>
        
        <h1>Cadastro de Fornecedores</h1><br/><br/>
        <!-- CADASTRO -->
        <c:if test="${empty produto}">
            <form action="../CadastrarProdutoServlet" method="POST">
                
                <h3>-| Dados do Produto |-</h3>
                
                <label class="form-label">Codigo: </label>
                <input type="text" name="cod"  required="true" readonly="true"> 

                <label class="form-label">Nome: </label>
                <input type="text" name="nome"  required="true"> 
                
                <br><br>

                <label class="form-label">Marca: </label>
                <input type="text" name="marca"  required="true"> 

                <label class="form-label">Custo: </label>
                <input type="text" name="custo"  required="true"> 
                
                <br><br>

                <label class="form-label">Preco: </label>
                <input type="text" name="preco"  required="true"> 

                <label class="form-label">Quantidade: </label>
                <input type="text" name="quantidade"  required="true"> 

                <label class="form-label">Comissao: </label>
                <input type="text" name="comissao"  required="true"> 

                <br><br>
                

                <button type="submit" class="btn-primary">Cadastrar</button>
                
            </form>
        </c:if>
        
        <!-- ATUALIZACAO -->
        <c:if test="${not empty produto}">
            <form action="AlterarProdutoServlet" method="POST">
                
                <h3>-| Dados do Produto |-</h3>
                
                <label class="form-label">Codigo: </label>
                <input type="text" name="cod"  required="true" readonly="true" value=${produto.cod}> 

                <label class="form-label">Nome: </label>
                <input type="text" name="nome"  required="true" value=${produto.nome}> 
                
                <br><br>

                <label class="form-label">Marca: </label>
                <input type="text" name="marca"  required="true" value=${produto.marca}> 

                <label class="form-label">Custo: </label>
                <input type="text" name="custo"  required="true" value=${produto.custo}> 
                
                <br><br>

                <label class="form-label">Preco: </label>
                <input type="text" name="preco"  required="true" value=${produto.preco}> 

                <label class="form-label">Quantidade: </label>
                <input type="text" name="quantidade"  required="true" value=${produto.quantidade}> 

                <label class="form-label">Comissao: </label>
                <input type="text" name="comissao"  required="true" value=${produto.comissao}> 

                <br><br>
                
                

                <button type="submit" class="btn-primary">Atualizar</button>
            </form>
        </c:if>
        
        
        
        <c:import url="../footer.jsp"/>
    </body>
</html>
