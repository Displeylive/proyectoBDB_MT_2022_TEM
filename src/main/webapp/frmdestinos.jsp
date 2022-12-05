<%
    if (session.getAttribute("login") != "ok"){
    response.sendRedirect("login.jsp");
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            <h1>FORMULARIO DE DESTINOS UPEA</h1>
            <jsp:include page="META-INF/menu.jsp" >
                <jsp:param name="opcion"  value="destinos"/>
            </jsp:include>
            <br>
            <a  href="DestinosControlador" class="btn btn-info btn-info" ><i class="fa fa-undo" aria-hidden="true"></i>CANCELAR</a>
            <br><br>
            <form action="DestinosControlador" method="POST">
                <input type="hidden" name="id_des" value="${destinos.id_des}">
                <div class="form-group">
                    <label for="" class="form-label">PUNTO PARADA</label>
                    <input type="text" class="form-control"  name="parada" value="${destinos.parada}" placeholder="Escriba el punto parada inicio" >
                </div>
                <div class="form-group">
                    <label for="" class="form-label">PUNTO DESTINO</label>
                    <input type="text" class="form-control"  name="lugar_destino" value="${destinos.lugar_destino}" placeholder="Escriba el punto de llegada final" >
                </div>
                <div class="form-group">
                    <label for="" class="form-label">COSTO PASAGE</label>
                    <input type="text" class="form-control"  name="costo_pasaje" value="${destinos.costo_pasaje}" placeholder="Escriba EL MONDO DE PASAGE Bs." >
                </div>
                <div class="form-group">
                    <label for="" class="form-label">FECHA DE PARTIDA</label>
                    <input type="text" class="form-control"  name="fecha_partida" value="${destinos.fecha_partida}" placeholder="intrudusca la fechade partida" >

                    <div class="form-group">
                        <label for="" class="form-label">FECAH DE LLEGADA</label>
                        <input type="text" class="form-control"  name="fecha_llegada" value="${destinos.fecha_llegada}" placeholder="introdusca la fecha de llegada" >

                    </div>
                    <div class="form-group">
                        <label for="" class="form-label"> PLACA MODELO BUS</label>
                        <select name="id_bus" class="form-control">
                            <option value="">-- selecvione --</option>
                            <c:forEach var="item" items="${lista_buses}">
                                <option  value="${item.id_bus}"
                                         <c:if test="${destinos.id_bus == item.id_bus}" >
                                             selected
                                         </c:if>>
                                    > ${item.nro_placa} </option>
                                </c:forEach> 

                        </select>
                    </div>
                    <div class="form-group">
                        <label for="" class="form-label">ENCARGADO</label>
                        <select name="id_encargado" class="form-control">
                            <option value="">-- selecvione --</option>
                            <c:forEach var="item" items="${lista_encargado}">
                                <option  value="${item.id_en}"
                                         <c:if test="${destinos.id_encargado == item.id_en}" >
                                             selected
                                         </c:if>>
                                    > ${item.nombre} </option>
                                </c:forEach> 

                        </select>
                    </div>
                    <br>
                    <button type="submit" class="btn btn-primary">ENVIAR</button>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>
</html>
