<%-- 
    Document   : listaFornecedor
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
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>">
        <title>Lista de Produtos</title>
    </head>
    <body class="container">
        <c:import url="/header.jsp"/>
        <h1>Produtos</h1>
        <h2>Filial ${usuario_logado.filial}</h2>
        
        <div class="scrollmenu">
            <a href=<c:url value="/protegido/backoffice/produtos/cadastrar.jsp"/>>Cadastrar Produtos</a>
        </div>   
        
        <form action="BuscarProdutoServlet" method="GET">
            <label for="busca">  Busca: </label>
            
            <div class="container">  
                <input type="search" id="busca" name="busca">
                <button type="submit">OK</button>
            </div>
        </form>
        
        <table class="table table-striped table-bordered table-sm ">
            <thead>
                <th scope="col">Cod</th>
                <th scope="col">Filial</th>
                <th scope="col">Nome</th>
                <th scope="col">Marca</th>
                <th scope="col">Cod Fornecedor</th>
                <th scope="col">Fornecedor</th>
                <th scope="col">Categoria</th>
                <th scope="col">Custo</th>
                <th scope="col">Preco</th>
                <th scope="col">Quantidade</th>
                <th scope="col">Comissao</th>
            </thead>
            <c:forEach items="${listaProdutos}" var="produto">
                <tr>
                    <td>${produto.cod}</td>
                    <td>${produto.filial}</td>
                    <td>${produto.nome}</td>
                    <td>${produto.marca}</td>
                    <td>${produto.codFornecedor}</td>
                    <td>${produto.fornecedor}</td>
                    <td>${produto.categoria}</td>
                    <td>R$${produto.custo}</td>
                    <td>R$${produto.preco}</td>
                    <td>${produto.quantidade}</td>
                    <td>${produto.comissao}%</td>
                    <td><a href="AlterarProdutoServlet?cod=${produto.cod}">Atualizar</a></td>
                    <td><a href="ExcluirProdutoServlet?cod=${produto.cod}">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        
        <c:import url="/footer.jsp"/>
    </body>
</html>
