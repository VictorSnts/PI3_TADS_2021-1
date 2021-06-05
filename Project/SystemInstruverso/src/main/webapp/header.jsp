<%-- 
    Document   : header
    Created on : Apr 23, 2021, 9:09:57 PM
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
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body class="container">
        <h1>  ---||| INSTRUVERSO |||---</h1>
        <h3>Usuario: ${usuario_logado.nome}</h3>
        <div class="sidebar">
            <a href="<c:url value="/protegido/inicio.jsp"/>"><i class="fa fa-fw fa-home"></i> Inicio</a>
            <a href="<c:url value="/ClienteServlet"/>"><i class="fa fa-fw fa-user"></i> Clientes</a>
            <a href="<c:url value="/FornecedorServlet"/>" ><i class="fa fa-fw fa-industry"></i> Fornecedores</a>
            <a href="<c:url value="/UsuarioServlet"/>"><i class="fa fa-fw fa-users"></i> Usuarios</a>
            <a href="<c:url value="/ProdutoServlet"/>"><i class="fa fa-fw fa-headphones"></i> Produtos</a>
            <a href="<c:url value="/ClienteServlet?action=select"/>"><i class="fa fa-fw fa-shopping-cart"></i> Vender</a>
            <a href="<c:url value="/RelatorioServlet?intervalo=full"/>"><i class="fa fa-fw fa-line-chart"></i> Relatorios</a>
            <br><br><br><br>
            <a href="<c:url value="/LogoutServlet"/>"><i class="fa fa-fw fa-sign-out"></i> Sair</a>
        </div>
    </body>
</html>
