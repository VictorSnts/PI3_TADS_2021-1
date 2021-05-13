<%-- 
    Document   : listaClientes
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
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Lista de Clientes</title>
    </head>
    <body class="container">
        <c:import url="../header.jsp"/>
        
        <c:if test="${empty action}">
            <h1>Selecione o Cliente</h1>


            <div class="scrollmenu">
                <a href="clientes/cadastrar.jsp">Cadastrar Clientes</a>
            </div>

            <form action="BuscarClienteServlet" method="GET">
                <label for="busca">  Busca: </label>

                <div class="container">  
                    <input type="search" id="busca" name="busca">
                    <button type="submit">OK</button>
                </div>
            </form>
        <br>
        </c:if>

        
        <c:if test="${action.equals('select')}">

            <h1>Selecione o Cliente</h1>


            <div class="scrollmenu">
                <a href="clientes/cadastrar.jsp">Cadastrar Clientes</a>
            </div>

            <form action="BuscarClienteServlet" method="HET">
                <label for="busca">  Busca: </label>

                <div class="container">  
                    <input type="search" id="busca" name="busca">
                    <button type="submit" name="action" value="select">OK</button>
                </div>
            </form>
        <br>
        </c:if>
        
        <table class="table table-striped table-bordered table-sm">
            <thead>
                <th scope="col">cod</th>
                <th scope="col">Nome</th>
                <th scope="col">Data_nasc</th>
                <th scope="col">Telefone</th>
                <th scope="col">Email</th>
                <th scope="col">Cpf</th>
                <th scope="col">Cep</th>
                <th scope="col">Endereco</th>
                <th scope="col">Numero</th>
                <th scope="col">Uf</th>
                <th scope="col">Bairro</th>
                <th scope="col">Cidade</th>
                <th scope="col">Filial</th>
                <th scope="col"></th>
                <th scope="col"></th>
                
            </thead>
            
            <c:if test="${empty action}">
                <c:forEach items="${listaClientes}" var="cliente">
                    <tr>
                        <td>${cliente.cod}</td>
                        <td>${cliente.nome}</td>
                        <td>${cliente.data_nasc}</td>
                        <td>${cliente.telefone}</td>
                        <td>${cliente.email}</td>
                        <td>${cliente.cpf}</td>
                        <td>${cliente.cep}</td>
                        <td>${cliente.endereco}</td>
                        <td>${cliente.numero}</td>
                        <td>${cliente.uf}</td>
                        <td>${cliente.bairro}</td>
                        <td>${cliente.cidade}</td>
                        <td>${cliente.filial_cadastro}</td>
                        <td><a href="AlterarClienteServlet?cod=${cliente.cod}">Atualizar</a></td>
                        <td><a href="ExcluirClienteServlet?cod=${cliente.cod}">Excluir</a></td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${action.equals('select')}">
                <c:forEach items="${listaClientes}" var="cliente">
                        <td>${cliente.cod}</td>
                        <td>${cliente.nome}</td>
                        <td>${cliente.data_nasc}</td>
                        <td>${cliente.telefone}</td>
                        <td>${cliente.email}</td>
                        <td>${cliente.cpf}</td>
                        <td>${cliente.cep}</td>
                        <td>${cliente.endereco}</td>
                        <td>${cliente.numero}</td>
                        <td>${cliente.uf}</td>
                        <td>${cliente.bairro}</td>
                        <td>${cliente.cidade}</td>
                        <td>${cliente.filial_cadastro}</td>
                        <td><a href="VendaServlet?venda=none&cliente=${cliente.cod}">Selecionar</a></td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
        
        <c:import url="/footer.jsp"/>
    </body>
</html>
