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
        <title>Cadastro de Fornecedores</title>
    </head>
    <body class="container">
        <c:import url="../header.jsp"/>
        
        <h1>Cadastro de Fornecedores</h1><br/><br/>
        <!-- CADASTRO -->
        <c:if test="${empty fornecedor}">
            <form action="../CadastrarFornecedorServlet" method="POST">
                
                <h3>-| Dados da Empresa |-</h3>
                
                <label class="form-label">Filial: </label>                
                <select name="filial_cadastro" required="true">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                </select>
                <label class="form-label">Codigo: </label>
                <input type="text" name="cod" size="6" readonly="true">
                <br><br>
                
                <label class="form-label">Razao Social: </label>
                <input type="text" name ="razao_social"required="true" size="52">
                <br><br>
                
                <label class="form-label">Nome Fantasia: </label>
                <input type="text" name ="nome_fantasia" required="true" size="50">
                <br><br>
                
                <label class="form-label">Cnpj: </label>
                <input type="text" name ="cnpj"required="true" size="15" maxlength="14"/>
                <label class="form-label">Data Registro: </label >
                <input type="date" name ="data_registro" required="true">
                <br><br>
                
                <label class="form-label">Nome para Contato: </label>
                <input type="text" name ="nome_contato"required="true" size="20">
                <label class="form-label">Telefone: </label>
                <input type="text" name ="telefone"required="true" size="13" maxlength="11">
                <br><br>
                
                <label class="form-label">Email: </label>
                <input type="text" name ="email"required="true" size="25">
                <label class="form-label">Site: </label>
                <input type="text" name ="site"required="true" size="25">
                <br><br>
                
                <h3>-| Endereco |-</h3>
                <label class="form-label">Endereco: </label>
                <input type="text" name ="endereco"required="true" size="50">
                <label class="form-label">Numero: </label>
                <input type="text" name ="numero"required="true" size="5">
                <br><br>

                <label class="form-label">Cep: </label>
                <input type="text" name ="cep"required="true" size="10" maxlength="8">               
                <label class="form-label">Bairro: </label>
                <input type="text" name ="bairro"required="true" size="15">
                <label class="form-label">Cidade: </label>
                <input type="text" name ="cidade"required="true" size="15">
                <label class="form-label">UF: </label>
                <input type="text" name ="uf"required="true" size="3" maxlength="2">
                <br><br>
                
                <label class="form-label">Pais: </label>
                <input type="text" name ="pais"required="true" size="15">
                <br><br>
                
                

                <button type="submit" class="btn-primary">Cadastrar</button>
                
            </form>
        </c:if>
        
        <!-- ATUALIZACAO -->
        <c:if test="${not empty fornecedor}">
            <form action="AlterarFornecedorServlet" method="POST">
                
                <h3>-| Dados da Empresa |-</h3>
                


                <label class="form-label">Filial: </label>                
                <select name="filial_cadastro" required="true">
                    
                    <c:if test="${fornecedor.filial_cadastro == '1'}">
                        <option value="1" selected="selected">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </c:if>
                    <c:if test="${fornecedor.filial_cadastro == '2'}">
                        <option value="1">1</option>
                        <option value="2" selected="selected">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </c:if>
                    <c:if test="${fornecedor.filial_cadastro == '3'}">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3" selected="selected">3</option>
                        <option value="4">4</option>
                    </c:if>
                     <c:if test="${fornecedor.filial_cadastro == '4'}">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4"  selected="selected">4</option>
                    </c:if>
                    
                    
                </select>
                <label class="form-label">Codigo: </label>
                <input type="text" name="cod" size="6" readonly="true" value="${fornecedor.cod}">
                <br><br>

                <label class="form-label">Razao Social: </label>
                <input type="text" name ="razao_social"required="true" size="52" value=${fornecedor.razao_social}>
                <br><br>  

                <label class="form-label">Nome Fantasia: </label>
                <input type="text" name ="nome_fantasia" required="true" size="50" value=${fornecedor.nome_fantasia}>
                <br><br>

                <label class="form-label">Cnpj: </label>
                <input type="text" name ="cnpj"required="true" size="15" maxlength="14" value="${fornecedor.cnpj}"/>
                <label class="form-label">Data Registro: </label >
                <input type="date" name ="data_registro" required="true" value=${fornecedor.data_registro}>
                <br><br>

                <label class="form-label">Nome para Contato: </label>
                <input type="text" name ="nome_contato"required="true" size="20" value=${fornecedor.nome_contato}>
                <label class="form-label">Telefone: </label>
                <input type="text" name ="telefone"required="true" size="13" maxlength="11" value=${fornecedor.telefone}>
                <br><br>

                <label class="form-label">Email: </label>
                <input type="text" name ="email"required="true" size="25" value=${fornecedor.email}>
                <label class="form-label">Site: </label>
                <input type="text" name ="site"required="true" size="25" value=${fornecedor.site}>
                <br><br>


                <h3>-| Endereco |-</h3>
                <label class="form-label">Endereco: </label>
                <input type="text" name ="endereco"required="true" size="50" value=${fornecedor.endereco}>
                <label class="form-label">Numero: </label>
                <input type="text" name ="numero"required="true" size="5" value=${fornecedor.numero}>
                <br><br>

                <label class="form-label">Cep: </label>
                <input type="text" name ="cep"required="true" size="10" maxlength="8" value=${fornecedor.cep}>               
                <label class="form-label">Bairro: </label>
                <input type="text" name ="bairro"required="true" size="15" value=${fornecedor.bairro}>
                <label class="form-label">Cidade: </label>
                <input type="text" name ="cidade"required="true" size="15" value=${fornecedor.cidade}>
                <label class="form-label">UF: </label>
                <input type="text" name ="uf"required="true" size="3" maxlength="2" value=${fornecedor.uf}>
                <br><br>

                <label class="form-label">Pais: </label>
                <input type="text" name ="pais"required="true" size="15" value=${fornecedor.pais}>
                <br><br>
            
            <button type="submit" class="btn-primary">Atualizar</button>
            </form>
        </c:if>
        
        
        
        <c:import url="../footer.jsp"/>
    </body>
</html>
