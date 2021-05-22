<%-- 
    Document   : index
    Created on : May 18, 2021, 12:39:14 PM
    Author     : victor
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<html lang="pt-br">
<head>
        <meta charset="utf-8">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/login.css">
        <title>Tela de Login</title>
</head>
<body>
    <div id="login">
        <h3 class="text-center text-info pt-5">INSTRUVERSO</h3>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action="LoginServlet" method="post">
                            <h3 class="text-center text-info">Login</h3>
                            <c:if test="${not empty erro}">
                                <h4 id="alert_erro">${erro}</h4>
                            </c:if>
                            <div class="form-group">
                                <label for="username" class"="text-info">Usuario: </label><br>
                                <input type="text" name="username" id="username" class="form-control" required="true">
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Senha: </label><br>
                                <input type="password" name="password" id="password" class="form-control"  required="true">
                            </div>
                            <div class="form-group">
                                <input type="submit" name="submit" class="btn btn-info btn-md" value="Entrar">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
