<%-- 
    Document   : listarProdutos
    Created on : May 14, 2021, 3:38:26 AM
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
        <h1>Produtos</h1>

        <c:if test="${tipo == 'categoria'}">
            <form action="RelatorioCategoriasServlet" method="GET">
                <label for="busca">  Filtrar por Intervalo: </label>
                <div class="container">  
                    <input type="date" id="data_inicial" name="data_inicial" required="true">
                    <input type="date" id="data_final" name="data_final" required="true">
                    <label class="form-label">Categoria: </label>
                    <select name="categoria" required="true">
                        <option value="none"> </option>
                        <c:forEach items="${listaCategoria}" var="categoria">
                            <option value="${categoria.getCategoria()}">${categoria.getCategoria()}</option>
                        </c:forEach>
                    </select>
                    
                    <button type="submit" name="intervalo" value="dates">Filtrar</button>
                </div>
            </form>
        </c:if>

        <c:if test="${tipo == 'cliente'}">
            <form action="RelatorioClienteServlet" method="GET">
                <label for="busca">  Filtrar por Intervalo: </label>
                <div class="container">
                    <input type="date" id="data_inicial" name="data_inicial" required="true">
                    <input type="date" id="data_final" name="data_final" required="true">

                    <label class="form-label">Cliente: </label>
                    <select name="cliente" required="true">
                        <option value="none"> </option>
                        <c:forEach items="${listaCliente}" var="cliente">
                            <option value="${cliente.getCod_cliente()}">${cliente.getNome_cliente()}</option>
                        </c:forEach>
                    </select>
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
                    
                    <button type="submit" name="intervalo" value="dates">Filtrar</button>
                </div>
            </form>
        </c:if>
            

        <br>

        
        <table class="table table-striped table-bordered table-sm ">
            <thead>
                <th scope="col">Nome Cliente</th>
                <th scope="col">Data Venda</th>
                <th scope="col">Filial</th>
                <th scope="col">Produto</th>
                <th scope="col">Categoria</th>
                <th scope="col">Preço Unitario</th>
                <th scope="col">Qtd</th>
                <th scope="col"> </th>

            </thead>
            <c:forEach items="${listaProdutosVenda}" var="produto">
                <tr>
                    <td>${produto.nomeCliente}</td>
                    <td>${produto.data_venda}</td>
                    <td>${produto.filial}</td>
                    <td>${produto.produto}</td>
                    <td>${produto.categoria}</td>
                    <td>${produto.preco_unitario}</td>
                    <td>${produto.quantidade}</td>
                </tr>
            </c:forEach>
        </table>
        <br><br><br>
        
        <h2>Receita no Periodo: R$${soma_preco}</h2>
        <h2>Numero de Itens Vendidos no Periodo: ${itens}</h2>

        
        <c:import url="/footer.jsp"/>
    </body>
</html>
