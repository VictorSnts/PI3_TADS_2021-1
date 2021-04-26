<%-- 
    Document   : index.jsp
    Created on : Apr 22, 2021, 10:28:04 PM
    Author     : victor
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <title>Pagina Inicial</title>
    </head>
    <body class="container">
        <c:import url="header.jsp"/>
        <h1>Menu</h1>
        
        <table>
            <thead>
                <th scope="col"><b>Clientes</b></th>
                <th scope="col"><b>Fornecedores</b></th>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <a href="ClienteServlet">Listar</a>
                    </td>
                    <td>
                        <a href="FornecedorServlet">Listar</a>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="clientes/cadastrar.jsp">Cadastrar</a>
                    </td>
                    <td>
                        <a href="fornecedores/cadastrar.jsp">Cadastrar</a>
                    </td>
                </tr>
            </tbody>
        </table>
        
        
        <br/>
        
        <br/>
        <br/>
        

    </body>
</html>
