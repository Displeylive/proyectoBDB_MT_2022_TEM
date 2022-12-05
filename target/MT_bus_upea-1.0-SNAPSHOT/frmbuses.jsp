<%
    if (session.getAttribute("login") != "ok"){
    response.sendRedirect("login.jsp");
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
            <h1>FORMULARIO DE BUSES UPEA</h1>
            <jsp:include page="META-INF/menu.jsp" >
                <jsp:param name="opcion"  value="buses"/>

            </jsp:include>
            <br>
            <a  href="BusesControlador" class="btn btn-info btn-info" ><i class="fa fa-undo" aria-hidden="true"></i>CANCELAR</a>
            <br><br>
            <form action="BusesControlador" method="POST">
                <input type="hidden" name="id_bus" value="${buses.id_bus}">
                <div class="form-group">
                    <label for="" class="form-label">NRO PLACA</label>
                    <input type="text" class="form-control"  name="nro_placa" value="${buses.nro_placa}" placeholder="Escriba el numero de placa de bus" >
                </div>
                <div class="form-group">
                    <label for="" class="form-label">TIPO DE BUSES</label>
                    <select name="id_tbus" class="form-control">
                        <option value="">-- selecvione --</option>
                        <c:forEach var="item" items="${lista_tbuses}">
                            <option value="${item.id_t}"
                                    <c:if test="${buses.id_tbus == item.id_t}" >
                                        selected
                                    </c:if>>
                                    > ${item.modelo} </option>
                        </c:forEach> 
                    </select>
                </div>
                <div class="form-group">
                    <label for="" class="form-label">DESCRIPCION</label>
                    <input type="text" class="form-control"  name="descripcion" value="${buses.descripcion}" placeholder="Escriba la descripcion del bus" >
                </div>

                <div class="form-group">
                    <label for="" class="form-label">ID CONDUCTOR NOMBRE</label>
                    <select name="id_cond" class="form-control">
                        <option value="">-- selecvione --</option>
                        <c:forEach var="item" items="${lista_conductor}">
                            <option  value="${item.id_con}"
                                      <c:if test="${buses.id_cond == item.id_con}" >
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
