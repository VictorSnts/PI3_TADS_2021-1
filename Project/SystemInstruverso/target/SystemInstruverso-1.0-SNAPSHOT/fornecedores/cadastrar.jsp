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

        <title>Cadastro de Fornecedores</title>
    </head>
    <body class="container">
        <c:import url="../header.jsp"/>
        
        <h1>Cadastro de Fornecedores</h1><br/><br/>
        <!-- CADASTRO -->
        <c:if test="${empty fornecedor}">
            <form action="../CadastrarFornecedorServlet" method="POST">
                
                <h3>-| Dados da Empresa |-</h3>
                
                <label class="form-label">Filial de Cadastro: </label>
                <input type="text" name ="filial_cadastro"required="true">
                <br><br>
                <label class="form-label">Razao Social: </label>
                <input type="text" name ="razao_social"required="true">
                <br><br>
                
                <label class="form-label">Nome Fantasia: </label>
                <input type="text" name ="nome_fantasia"required="true">
                <label class="form-label">Cnpj: </label>
                <input type="text" name ="cnpj"required="true"/>
                <label class="form-label">Data Registro: </label >
                <input type="text" name ="data_registro" required="true">
                <br><br>
                
                <label class="form-label">Nome Contato: </label>
                <input type="text" name ="nome_contato"required="true">
                <label class="form-label">Telefone: </label>
                <input type="text" name ="telefone"required="true">
                <br><br>
                
                <label class="form-label">Email: </label>
                <input type="text" name ="email"required="true">
                <label class="form-label">Site: </label>
                <input type="text" name ="site"required="true">
                <br><br>
                <h3>-| Endereco |-</h3>
                <label class="form-label">Cep: </label>
                <input type="text" name ="cep"required="true">
                <label class="form-label">Endereco: </label>
                <input type="text" name ="endereco"required="true">
                <br><br>
                
                <label class="form-label">Numero: </label>
                <input type="text" name ="numero"required="true">
                <label class="form-label">Bairro: </label>
                <input type="text" name ="bairro"required="true">
                <label class="form-label">Cidade: </label>
                <input type="text" name ="cidade"required="true">
                <br><br>
                
                <label class="form-label">UF: </label>
                <input type="text" name ="uf"required="true">
                <label class="form-label">Pais: </label>
                <input type="text" name ="pais"required="true">
                
                
                

                <button type="submit" class="btn-primary">Cadastrar</button>
                
            </form>
        </c:if>
        
        <!-- ATUALIZACAO -->
        <c:if test="${not empty fornecedor}">
            <form action="AlterarFornecedorServlet" method="POST">
                
                <h3>-| Dados da Empresa |-</h3>
                
                <label class="form-label">Filial de Cadastro: </label>
                <input type="text" name ="filial_cadastro"required="true" value=${fornecedor.filial_cadastro}>
                <br><br>
                <label class="form-label">Razao Social: </label>
                <input type="text" name ="razao_social"required="true" value=${fornecedor.razao_social}>
                <br><br>
                
                <label class="form-label">Nome Fantasia: </label>
                <input type="text" name ="nome_fantasia"required="true" value=${fornecedor.nome_fantasia}>
                <label class="form-label">Cnpj: </label>
                <input type="text" name ="cnpj"required="true" value=${fornecedor.cnpj}>
                <label class="form-label">Data Registro: </label >
                <input type="text" name ="data_registro"required="true" value=${fornecedor.data_registro} readonly="true">
                <br><br>
                
                <label class="form-label">Nome Contato: </label>
                <input type="text" name ="nome_contato"required="true" value=${fornecedor.nome_contato}>
                <label class="form-label">Telefone: </label>
                <input type="text" name ="telefone"required="true" value=${fornecedor.telefone}>
                <br><br>
                
                <label class="form-label">Email: </label>
                <input type="text" name ="email"required="true" value=${fornecedor.email}>
                <label class="form-label">Site: </label>
                <input type="text" name ="site"required="true" value=${fornecedor.site}>
                
                <h3>-| Endereco |-</h3>
                <label class="form-label">Cep: </label>
                <input type="text" name ="cep"required="true" value=${fornecedor.cep}>
                <label class="form-label">Endereco: </label>
                <input type="text" name ="endereco"required="true" value=${fornecedor.endereco}>
                <br><br>
                
                <label class="form-label">Numero: </label>
                <input type="text" name ="numero"required="true" value=${fornecedor.numero}>"
                <label class="form-label">Bairro: </label>
                <input type="text" name ="bairro"required="true" value=${fornecedor.bairro}>
                <label class="form-label">Cidade: </label>
                <input type="text" name ="cidade"required="true" value=${fornecedor.cidade}>
                <br><br>
                
                <label class="form-label">UF: </label>
                <input type="text" name ="uf"required="true" value=${fornecedor.uf}>
                <label class="form-label">Pais: </label>
                <input type="text" name ="pais"required="true" value=${fornecedor.pais}>
            
            <button type="submit" class="btn-primary">Atualizar</button>
            </form>
        </c:if>
        
        
        
        <c:import url="../footer.jsp"/>
    </body>
</html>
