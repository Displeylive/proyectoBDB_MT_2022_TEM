<%
    if (session.getAttribute("login") != "ok"){
    response.sendRedirect("login.jsp");
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
            <h1>VISTA TABLA DE DESTINOS </h1>
            <jsp:include page="META-INF/menu.jsp" >
                <jsp:param name="opcion"  value="destinos"/>

            </jsp:include>
             <br>
            
            <br> <br>
            <a  href="DestinosControlador?action=add" class="btn btn-info btn-info" ><i class="fa-solid fa-cart-plus"></i>Nuevo</a>
            <br><br>
            <table class="table table-dark table-striped table-bordered border-primary" >
                <tr>
                    <th>ID</th>
                    <th>PARADA</th>
                    <th>LUGAR DESTINO</th>
                    <th>COSTO PASAGE</th>
                    <th>FECHA PARTIDA</th>
                    <th>FECHA LLEGADA</th>
                    <th>MODELO BUS</th>
                    <th>ENCARGADO</th>
                </tr>
                <c:forEach var="item" items="${destinos}">
                    <tr>
                        <td>${item.id_des}</td>
                        <td>${item.parada}</td>
                        <td>${item.lugar_destino}</td>
                        <td>${item.costo_pasaje}</td>
                        <td>${item.fecha_partida}</td>
                        <td>${item.fecha_llegada}</td>
                        <td>${item.modelo}</td>
                        <td>${item.encargado}</td>
                        <td><a href="DestinosControlador?action=edit&id_des=${item.id_des}"><i class="fa-solid fa-pen-clip"></i></a></td>
                        <td><a href="DestinosControlador?action=delete&id_des=${item.id_des}"
                               onclick="return confirm('esta seguro de eliminar ?')"><i class="fa-solid fa-trash-can"></i></a></td>
                    </tr>
                </c:forEach>


            </table>
        </div>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>
</html>