<%-- 
    Document   : cadastrar
    Created on : Apr 23, 2021, 9:50:14 PM
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
        <title>Cadastro de Produtos</title>
    </head>
    <body class="container">
        <c:import url="/header.jsp"/>
        
        <h1>Cadastro de Produtos</h1><br/><br/>
        <!-- CADASTRO -->
        <c:if test="${empty produto}">
            <form action="<c:url value="/CadastrarProdutoServlet"/>" method="POST">
                
                <h3>-| Dados do Produto |-</h3>
                
                <label class="form-label">Filial: </label>                
                <select name="filial" required="true">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                </select>
                <label class="form-label">Codigo: </label>
                <input type="text" name="cod" size="6" required="true" readonly="true"> 
                <label class="form-label">Codigo Fornecedor: </label>
                <input type="text" name="codFornecedor" size="5" required="true"> 
                <br><br>

                <label class="form-label">Marca: </label>
                <input type="text" name="marca" size="20" required="true"> 
                <label class="form-label">Nome: </label>
                <input type="text" name="nome" size="20" required="true">
                <label class="form-label">Categoria: </label>
                <select name="categoria" required="true">
                    <option value="audio">Audio</option>
                    <option value="cordas">Cordas</option>
                    <option value="teclas">Teclas</option>
                    <option value="baterias">Baterias</option>
                    <option value="percursao">Percursao</option>
                    <option value="sopro">Sopro</option>
                    <option value="iluminacao">Iluminacao</option>
                    <option value="outros">Outros</option>
                </select>
                <br><br>
                
                <label class="form-label">Custo: </label>
                <input type="text" name="custo" size="8" required="true"> 
                <label class="form-label">Preco: </label>
                <input type="text" name="preco" size="8" required="true"> 
                <label class="form-label">Quantidade: </label>
                <input type="text" name="quantidade" size="5" required="true"> 
                <br><br>

                <label class="form-label">Comissao pela venda: </label>
                <input type="text" name="comissao" size="5" required="true"> 

                <br><br>
                

                <button type="submit" class="btn-primary">Cadastrar</button>
                
            </form>
        </c:if>
        
        <!-- ATUALIZACAO -->
        <c:if test="${not empty produto}">
            <form action="<c:url value="/AlterarProdutoServlet"/>" method="POST">
                
                <h3>-| Dados do Produto |-</h3>
                
                <label class="form-label">Filial: </label>                
                <select name="filial" required="true">
                    <c:if test="${produto.filial == '1'}">
                        <option value="1" selected="selected">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </c:if>
                    <c:if test="${produto.filial == '2'}">
                        <option value="1">1</option>
                        <option value="2" selected="selected">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </c:if>
                    <c:if test="${produto.filial == '3'}">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3" selected="selected">3</option>
                        <option value="4">4</option>
                    </c:if>
                     <c:if test="${produto.filial == '4'}">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4"  selected="selected">4</option>
                    </c:if>
                </select>
                <label class="form-label">Codigo: </label>
                <input type="text" name="cod" size="6" required="true" readonly="true" value="${produto.cod}"> 
                <label class="form-label">Codigo Fornecedor: </label>
                <input type="text" name="codFornecedor" size="5" required="true" value="${produto.codFornecedor}"> 
                <br><br>

                <label class="form-label">Marca: </label>
                <input type="text" name="marca" size="20" required="true" value="${produto.marca}"> 
                <label class="form-label">Nome: </label>
                <input type="text" name="nome" size="20" required="true" value="${produto.nome}">
                <label class="form-label">Categoria: </label>
                <select name="categoria" required="true">
                    <option value="audio">Audio</option>
                    <option value="cordas">Cordas</option>
                    <option value="teclas">Teclas</option>
                    <option value="baterias">Baterias</option>
                    <option value="percursao">Percursao</option>
                    <option value="sopro">Sopro</option>
                    <option value="iluminacao">Iluminacao</option>
                    <option value="outros">Outros</option>
                
                    <c:if test="${produto.categoria == 'audio'}">
                        <option value="audio" selected="selected">Audio</option>
                        <option value="cordas">Cordas</option>
                        <option value="teclas">Teclas</option>
                        <option value="baterias">Baterias</option>
                        <option value="percursao">Percursao</option>
                        <option value="sopro">Sopro</option>
                        <option value="iluminacao">Iluminacao</option>
                        <option value="outros">Outros</option>
                    </c:if>
                    <c:if test="${produto.categoria == 'cordas'}">
                        <option value="audio">Audio</option>
                        <option value="cordas" selected="selected">Cordas</option>
                        <option value="teclas">Teclas</option>
                        <option value="baterias">Baterias</option>
                        <option value="percursao">Percursao</option>
                        <option value="sopro">Sopro</option>
                        <option value="iluminacao">Iluminacao</option>
                        <option value="outros">Outros</option>
                    </c:if>
                    <c:if test="${produto.categoria == 'teclas'}">
                        <option value="audio">Audio</option>
                        <option value="cordas">Cordas</option>
                        <option value="teclas" selected="selected">Teclas</option>
                        <option value="baterias">Baterias</option>
                        <option value="percursao">Percursao</option>
                        <option value="sopro">Sopro</option>
                        <option value="iluminacao">Iluminacao</option>
                        <option value="outros">Outros</option>
                    </c:if>
                    <c:if test="${produto.categoria == 'baterias'}">
                        <option value="audio">Audio</option>
                        <option value="cordas">Cordas</option>
                        <option value="teclas">Teclas</option>
                        <option value="baterias" selected="selected">Baterias</option>
                        <option value="percursao">Percursao</option>
                        <option value="sopro">Sopro</option>
                        <option value="iluminacao">Iluminacao</option>
                        <option value="outros">Outros</option>
                    </c:if>
                    <c:if test="${produto.categoria == 'percursao'}">
                        <option value="audio">Audio</option>
                        <option value="cordas">Cordas</option>
                        <option value="teclas">Teclas</option>
                        <option value="baterias">Baterias</option>
                        <option value="percursao" selected="selected">Percursao</option>
                        <option value="sopro">Sopro</option>
                        <option value="iluminacao">Iluminacao</option>
                        <option value="outros">Outros</option>
                    </c:if>
                    <c:if test="${produto.categoria == 'sopro'}">
                        <option value="audio">Audio</option>
                        <option value="cordas">Cordas</option>
                        <option value="teclas">Teclas</option>
                        <option value="baterias">Baterias</option>
                        <option value="percursao">Percursao</option>
                        <option value="sopro" selected="selected">Sopro</option>
                        <option value="iluminacao">Iluminacao</option>
                        <option value="outros">Outros</option>
                    </c:if>
                    <c:if test="${produto.categoria == 'iluminacao'}">
                        <option value="audio">Audio</option>
                        <option value="cordas">Cordas</option>
                        <option value="teclas">Teclas</option>
                        <option value="baterias">Baterias</option>
                        <option value="percursao">Percursao</option>
                        <option value="sopro">Sopro</option>
                        <option value="iluminacao" selected="selected">Iluminacao</option>
                        <option value="outros">Outros</option>
                    </c:if>
                    <c:if test="${produto.categoria == 'outros'}">
                        <option value="audio">Audio</option>
                        <option value="cordas">Cordas</option>
                        <option value="teclas">Teclas</option>
                        <option value="baterias">Baterias</option>
                        <option value="percursao">Percursao</option>
                        <option value="sopro">Sopro</option>
                        <option value="iluminacao">Iluminacao</option>
                        <option value="outros" selected="selected">Outros</option>
                    </c:if>
                </select>
                        
                <br><br>
                
                <label class="form-label">Custo: </label>
                <input type="text" name="custo" size="8" required="true" value="${produto.custo}"> 
                <label class="form-label">Preco: </label>
                <input type="text" name="preco" size="8" required="true" value="${produto.preco}"> 
                <label class="form-label">Quantidade: </label>
                <input type="text" name="quantidade" size="5" required="true" value="${produto.quantidade}"> 
                <br><br>

                <label class="form-label">Comissao pela venda: </label>
                <input type="text" name="comissao" size="5" required="true" value="${produto.comissao}"> 

                <br><br>
                

                <button type="submit" class="btn-primary">Atualizar</button>
            </form>
        </c:if>
        
        
        
        <c:import url="/footer.jsp"/>
    </body>
</html>
