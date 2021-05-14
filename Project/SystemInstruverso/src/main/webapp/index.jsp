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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Pagina Inicial</title>
    </head>
    <body>
        <c:import url="header.jsp"/>
        <h1>Pagina Inicial</h1>
            
        <div class="sidebar">
            <a href="ClienteServlet"><i class="fa fa-fw fa-user"></i> Clientes</a>
            <a href="FornecedorServlet"><i class="fa fa-fw fa-industry"></i> Fornecedores</a>
            <a href="UsuarioServlet"><i class="fa fa-fw fa-users"></i> Usuarios</a>
            <a href="ProdutoServlet"><i class="fa fa-fw fa-headphones"></i> Produtos</a>
            <a href="ClienteServlet?action=select"><i class="fa fa-fw fa-shopping-cart"></i> Vender</a>
            <a href="RelatorioServlet"><i class="fa fa-fw fa-line-chart"></i> Relatorios</a>

        </div>
  
        <br/>
        
        <br/>
        <br/>
        

    </body>
</html>
