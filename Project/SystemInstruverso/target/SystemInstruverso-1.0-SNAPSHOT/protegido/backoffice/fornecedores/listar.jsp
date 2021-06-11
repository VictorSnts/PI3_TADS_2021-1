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
        <title>Lista de Fornecedores</title>
    </head>
    <body class="container">
        <c:import url="/header.jsp"/>
        <h1>Fornecedores</h1>
        
        <div class="scrollmenu">
            <a href="protegido/backoffice/fornecedores/cadastrar.jsp">Cadastrar Fornecedores</a>
        </div>   
        
        <form action="BuscarFornecedorServlet" method="GET">
            <label for="busca">  Busca: </label>
            
            <div class="container">  
                <input type="search" id="busca" name="busca">
                <button type="submit">OK</button>
            </div>
        </form>
        
        <table class="table table-striped table-bordered table-sm ">
            <thead>
                <th scope="col">Codigo</th>
                <th scope="col">Razao Social</th>
                <th scope="col">Nome Fantasia</th>
                <th scope="col">Data Registro</th>
                <th scope="col">Nome para Contato</th>
                <th scope="col">Telefone</th>
                <th scope="col">Email</th>
                <th scope="col">Site</th>
                <th scope="col">Cnpj</th>
                <th scope="col">Cep</th>
                <th scope="col">Endereco</th>
                <th scope="col">Numero</th>
                <th scope="col">Uf</th>
                <th scope="col">Bairro</th>
                <th scope="col">Cidade</th>
                <th scope="col">Filial de Cadastro</th>
                
            </thead>
            <c:forEach items="${listaFornecedores}" var="fornecedor">
                <tr>
                    <td>${fornecedor.cod}</td>
                    <td>${fornecedor.razao_social}</td>
                    <td>${fornecedor.nome_fantasia}</td>
                    <td>${fornecedor.data_registro}</td>
                    <td>${fornecedor.nome_contato}</td>
                    <td>${fornecedor.telefone}</td>
                    <td>${fornecedor.email}</td>
                    <td>${fornecedor.site}</td>
                    <td>${fornecedor.cnpj}</td>
                    <td>${fornecedor.cep}</td>
                    <td>${fornecedor.endereco}</td>
                    <td>${fornecedor.numero}</td>
                    <td>${fornecedor.uf}</td>
                    <td>${fornecedor.bairro}</td>
                    <td>${fornecedor.cidade}</td>
                    <td>${fornecedor.filial_cadastro}</td>
                    <td><a href="AlterarFornecedorServlet?cod=${fornecedor.cod}">Atualizar</a></td>
                    <td><a href="ExcluirFornecedorServlet?cod=${fornecedor.cod}">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        
        <c:import url="/footer.jsp"/>
    </body>
</html>
