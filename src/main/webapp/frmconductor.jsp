<%
    if (session.getAttribute("login") != "ok"){
    response.sendRedirect("login.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
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
            <h1>FORMULARIO DE CONDUCTOR</h1>
            <jsp:include page="META-INF/menu.jsp" >
                <jsp:param name="opcion"  value="conductor"/>

            </jsp:include>
            <br>
            <a  href="ConductorControlador" class="btn btn-info btn-info" ><i class="fa fa-undo" aria-hidden="true"></i>CANCELAR</a>
            <br><br>
            <form action="ConductorControlador" method="POST">
                <input type="hidden" name="id_con" value="${conductor.id_con}">
                <div class="form-group">
                    <label for="" class="form-label">CI IDENTIDAD</label>
                    <input type="text" class="form-control"  name="ci_chofer" value="${conductor.ci_chofer}" placeholder="Escriba el numero de carnet" >
                </div>
                <div class="form-group">
                    <label for="" class="form-label">NOMBRE</label>
                    <input type="text" class="form-control"  name="nombre" value="${conductor.nombre}" placeholder="Escriba el Nombre" >
                </div>
                <div class="form-group">
                    <label for="" class="form-label">APELLIDOS</label>
                    <input type="text" class="form-control"  name="apellido" value="${conductor.apellido}" placeholder="Escriba los apellidos" >
                </div>
                 <div class="form-group">
                    <label for="" class="form-label">EDAD</label>
                    <input type="text" class="form-control"  name="edad" value="${conductor.edad}" placeholder="entruducca edad" >
                </div> 
                <div class="form-group">
                    <label for="" class="form-label">Nro CELULAR</label>
                    <input type="text" class="form-control"  name="celular" value="${conductor.celular}" placeholder="Escriba numero de calular" >

                </div>
                <br>
                <button type="submit" class="btn btn-primary">ENVIAR</button>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>
</html>
