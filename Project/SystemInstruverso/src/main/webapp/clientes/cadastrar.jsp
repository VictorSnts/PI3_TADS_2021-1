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

        <title>Cadastro de Clientes</title>
    </head>
    <body class="container">
        <c:import url="../header.jsp"/>
        
        <h1>Cadastro de Clientes</h1><br/><br/>
        <!-- CADASTRO -->
        <c:if test="${empty cliente}">
            <form action="../CadastrarClienteServlet" method="POST">
                
                <h3>-| Dados Pessoais |-</h3>
                <label class="form-label">Nome: </label>
                <input type="text" name="nome" required="true"/>
                <label class="form-label">Telefone: </label>
                <input type="text" name="telefone" required="true"/>
                <label class="form-label">Filial: </label>
                <input type="text" name="filial_cadastro" required="true"/>
                <br><br>
                
                <label class="form-label">E-Mail: </label>
                <input type="text" name="email" required="true"/>
                <br><br>
                
                <label class="form-label">CPF: </label>
                <input type="text" name="cpf" required="true"/>
                <label class="form-label">Data de Nascimento: </label>
                <input type="text" name="data_nasc" required="true"/>
                
                <br/><br/>
                
                <h3>-| Endereco |-</h3>
                <label class="form-label">Endereco: </label>
                <input type="text" name="endereco" required="true"/>
                <br/><br/>
                
                <label class="form-label">Numero: </label>
                <input type="text" name="numero" required="true"/>
                <label class="form-label">CEP: </label>
                <input type="text" name="cep" required="true"/>
                <label class="form-label">UF: </label>
                <input type="text" name="uf" required="true"/>
                <br><br>
                
                <label class="form-label">Bairro: </label>
                <input type="text" name="bairro" required="true"/>
                <label class="form-label">Cidade: </label>
                <input type="text" name="cidade" required="true"/>
                <br><br>

                <button type="submit" class="btn-primary">Cadastrar</button>
                
            </form>
        </c:if>
        
        <!-- ATUALIZACAO -->
        <c:if test="${not empty cliente}">
            <form action="AlterarClienteServlet" method="POST">
                
                <h3>-| Dados Pessoais |-</h3>
                <label class="form-label">Nome: </label>
                <input type="text" name="nome" required="true" value=${cliente.nome}"/>
                <label class="form-label">Telefone: </label>
                <input type="text" name="telefone" required="true" value=${cliente.telefone}"/>
                <label class="form-label">Filial: </label>
                <input type="text" name="filial_cadastro" required="true" value=${cliente.filial_cadastro}"/>
                <br><br>
                
                <label class="form-label">E-Mail: </label>
                <input type="text" name="email" required="true" value=${cliente.email}"/>
                <br><br>
                
                <label class="form-label">CPF: </label>
                <input type="text" name="cpf" required="true" value=${cliente.cpf}"/>
                <label class="form-label">Data de Nascimento: </label>
                <input type="text" name="data_nasc" required="true" value=${cliente.data_nasc}"/>
                
                <br/><br/>
                
                <h3>-| Endereco |-</h3>
                <label class="form-label">Endereco: </label>
                <input type="text" name="endereco" required="true" value=${cliente.endereco}"/>
                <br/><br/>
                
                <label class="form-label">Numero: </label>
                <input type="text" name="numero" required="true" value=${cliente.numero}"/>
                <label class="form-label">CEP: </label>
                <input type="text" name="cep" required="true" value=${cliente.cep}"/>
                <label class="form-label">UF: </label>
                <input type="text" name="uf" required="true" value=${cliente.uf}"/>
                <br><br>
                
                <label class="form-label">Bairro: </label>
                <input type="text" name="bairro" required="true" value=${cliente.bairro}"/>
                <label class="form-label">Cidade: </label>
                <input type="text" name="cidade" required="true" value=${cliente.cidade}"/>
                <br><br>
            
            <button type="submit" class="btn-primary">Atualizar</button>
            </form>
        </c:if>
        
        
        
        <c:import url="../footer.jsp"/>
    </body>
</html>
