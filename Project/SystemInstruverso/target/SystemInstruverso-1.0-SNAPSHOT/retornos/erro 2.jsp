<%-- 
    Document   : sucesso
    Created on : Apr 23, 2021, 10:52:01 PM
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
        <title>Sucesso</title>
    </head>
    <body class="container">
        <h1>Oops, Algo deu errado!!</h1>
        <h3 style="color:red">${msgErro}</h3>
        
    <c:import url="../footer.jsp"/>
    </body>
</html>
