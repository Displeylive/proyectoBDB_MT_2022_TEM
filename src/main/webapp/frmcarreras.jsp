<%
    if (session.getAttribute("login") != "ok"){
    response.sendRedirect("login.jsp");
    }
%>
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
            <h1>FORMULARIO DE AREA CARRERAS</h1>
            <jsp:include page="META-INF/menu.jsp" >
                <jsp:param name="opcion"  value="carreras"/>

            </jsp:include>
            <br>
             <a  href="CarrerasControlador" class="btn btn-info btn-info" ><i class="fa fa-undo" aria-hidden="true"></i>CANCELAR</a>
             <br><br>
            <form action="CarrerasControlador" method="POST">
                <input type="hidden" name="id_c" value="${carreras.id_c}">
                <div class="form-group">
                    <label for="" class="form-label">AREA CARRERA</label>
                    <input type="text" class="form-control"  name="area" value="${carreras.area}" placeholder="Escriba el area o carrera " >
                </div>
              
                    <br>
                <button type="submit" class="btn btn-primary">ENVIAR</button>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>
</html>

