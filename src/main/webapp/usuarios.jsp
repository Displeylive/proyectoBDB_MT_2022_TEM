<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : usuarios
    Created on : 1 dic. de 2022, 20:02:41
    Author     : MARCO_T_EMERGENTES
--%>
<%
    if (session.getAttribute("login") != "ok"){
    response.sendRedirect("login.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" rel="stylesheet"  >

        <title>BIENVENIDO A BUSESE UPEA</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        <div class="container" >
            <h1>VISTA TABLA DE AREA CARRERA </h1>
            <jsp:include page="META-INF/menu.jsp" >
                <jsp:param name="opcion"  value="carreras"/>

            </jsp:include>
            <br>
            <a  href="UsuarioControlador?action=add" class="btn btn-info btn-info" ><i class="fa-solid fa-cart-plus"></i>Nuevo</a>
            <br> <br>
            <table class="table table-dark table-striped table-bordered border-primary" >
                <tr>
                    <th>ID</th>
                    <th>NOMBRE</th>
                     <th>APELLIDOS</th>
                    <th>EMAIL CORREO</th>

                </tr>
                <c:forEach var="item" items="${usuario}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.nombre}</td>    
                         <td>${item.apellido}</td>
                        <td>${item.email}</td>
                        <td><a href="UsuarioControlador?action=edit&id_c=${item.id}"><i class="fa-solid fa-pen-clip"></i></a></td>
                        <td><a href="UsuarioControlador?action=delete&id_c=${item.id}"
                               onclick="return confirm('esta seguro de eliminar ?')"><i class="fa-solid fa-trash-can"></i></a></td>
                    </tr>
                </c:forEach>
                               
            </table>
        </div>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>
</html>