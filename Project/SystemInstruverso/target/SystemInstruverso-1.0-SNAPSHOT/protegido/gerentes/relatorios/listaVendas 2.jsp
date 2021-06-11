<%-- 
    Document   : listaVendas
    Created on : May 14, 2021, 1:23:03 AM
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
        <title>Lista de Vendas</title>
    </head>
    <body class="container">
        <c:import url="/header.jsp"/>
        <h1>Vendas</h1>
        
        <form action="RelatorioCategoriasServlet" method="GET">
            <button type="submit" name="intervalo" value="full">Filtar Produtos Vendidos por Categoria</button>
        </form>
        <br>
        <form action="RelatorioClientesServlet" method="GET">
            <button type="submit" name="intervalo" value="full">Filtar Produtos Vendidos por Cliente</button>
        </form>
        <br><br>
        
        <form action="RelatorioServlet" method="GET">
            <label for="busca">  Filtrar por Intervalo: </label>
            
            <div class="container">  
                <input type="date" id="data_inicial" name="data_inicial" required="true" >
                <input type="date" id="data_final" name="data_final" required="true">
                <label class="form-label">Filial: </label>
                <c:if test="${usuario_logado.getNivel() == 'GERENTE GERAL'}">
                    <select name="filial" required="true">
                        <option value="none"> </option>
                        <option value="1">1</option>
                        <option value="2">2</option>"
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </select>
                </c:if>
                <c:if test="${usuario_logado.getNivel() != 'GERENTE GERAL'}">
                    <input type="text" id="filial" name="filial" required="true" readyonly="true" value=${usuario_logado.getFilial()}>
                </c:if>
                
                
                
                <button type="submit" name="intervalo" value="dates">Filtrar</button>
            </div>
        </form>
        
        <br>
        
        
        <table class="table table-striped table-bordered table-sm ">
            <thead>
                <th scope="col">Cod</th>
                <th scope="col">Filial</th>
                <th scope="col">Data Venda</th>
                <th scope="col">Usuario</th>
                <th scope="col">Cliente</th>
                <th scope="col">Forma de Pagamento</th>
                <th scope="col">Total</th>
                <th scope="col"> </th>

            </thead>
            <c:forEach items="${listaVendas}" var="vendas">
                <tr>
                    <td>${vendas.cod}</td>
                    <td>${vendas.filial}</td>
                    <td>${vendas.data_venda}</td>
                    <td>${vendas.usuario}</td>
                    <td>${vendas.cliente}</td>
                    <td>${vendas.forma_pagamento}</td>
                    <td>${vendas.total_venda}</td>
                </tr>
            </c:forEach>
        </table>
        
        <h2>Receita no Periodo: R$${soma_preco}</h2>

        
        <c:import url="/footer.jsp"/>
    </body>
</html>
