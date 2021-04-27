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

        <title>Pagina Inicial</title>
        <style>
            div.scrollmenu {
                background-color: #333;
                overflow: auto;
                white-space: nowrap;
            }

            div.scrollmenu a {
                display: inline-block;
                color: white;
                text-align: center;
                padding: 14px;
                text-decoration: none;
            }

            div.scrollmenu a:hover {
                background-color: #777;
            }
            
            
            /* Style the sidebar - fixed full height */
            .sidebar {
              height: 100%;
              width: 200px;
              position: fixed;
              z-index: 1;
              top: 0;
              left: 0;
              background-color: #111;
              overflow-x: hidden;
              padding-top: 16px;
            }

            /* Style sidebar links */
            .sidebar a {
              padding: 6px 8px 6px 16px;
              text-decoration: none;
              font-size: 20px;
              color: #818181;
              display: block;
            }

            /* Style links on mouse-over */
            .sidebar a:hover {
              color: #f1f1f1;
            }

            /* Style the main content */
            .main {
              margin-left: 160px; /* Same as the width of the sidenav */
              padding: 0px 10px;
            }

            /* Add media queries for small screens (when the height of the screen is less than 450px, add a smaller padding and font-size) */
            @media screen and (max-height: 450px) {
              .sidebar {padding-top: 15px;}
              .sidebar a {font-size: 18px;}
            }
        </style>
    </head>
    <body>
        <c:import url="header.jsp"/>
        <h1>Pagina Inicial</h1>
            
        <div class="sidebar">
            <a href="ClienteServlet"><i class="fa fa-fw fa-user"></i> Clientes</a>
            <a href="FornecedorServlet"><i class="fa fa-fw fa-industry"></i> Fornecedores</a>
        </div>
  
        <br/>
        
        <br/>
        <br/>
        

    </body>
</html>
