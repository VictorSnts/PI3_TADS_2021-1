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
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Lista de Vendas</title>
    </head>
    <body class="container">
        <c:import url="../header.jsp"/>
        <h1>Produtos</h1>
        
        <form action="RelatorioCategoriasServlet" method="GET">
            <label for="busca">  Filtrar por Intervalo: </label>
            
            <div class="container">  
                <input type="date" id="data_inicial" name="data_inicial" required="true">
                <input type="date" id="data_final" name="data_final" required="true">
                <label class="form-label">Categoria: </label>
                <select name="categoria" required="true">
                    <option value="none"> </option>
                    <option value="Audio">Audio</option>
                    <option value="Cordas">Cordas</option>
                    <option value="Teclas">Teclas</option>
                    <option value="Baterias">Baterias</option>
                    <option value="Percursao">Percursao</option>
                    <option value="Sopro">Sopro</option>
                    <option value="Iluminacao">Iluminacao</option>
                    <option value="Outros">Outros</option>
                </select>
                
                <button type="submit" name="intervalo" value="dates">Filtrar</button>
            </div>
        </form>
        
        <br>

        
        <table class="table table-striped table-bordered table-sm ">
            <thead>
                <th scope="col">Cod Venda</th>
                <th scope="col">Filial</th>
                <th scope="col">Data Venda</th>
                <th scope="col">produto</th>
                <th scope="col">categoria</th>
                <th scope="col">preco_unitario</th>
                <th scope="col">quantidade</th>
                <th scope="col"> </th>

            </thead>
            <c:forEach items="${listaProdutosVenda}" var="produto">
                <tr>
                    <td>${produto.cod_venda}</td>
                    <td>${produto.data_venda}</td>
                    <td>${produto.filial}</td>
                    <td>${produto.produto}</td>
                    <td>${produto.categoria}</td>
                    <td>${produto.preco_unitario}</td>
                    <td>${produto.quantidade}</td>
                    <td><a href="AlterarUsuarioServlet?cod=${usuario.cod}">Detalhar</a></td>
                </tr>
            </c:forEach>
        </table>
        
        <c:import url="/footer.jsp"/>
    </body>
</html>
