<%
    String opcion = request.getParameter("opcion");
%>
<header>
    <link href="ccs/menu.css" rel="stylesheet">
    <h1>BIENVENIDO A BUSES UPEA</h1>

    <nav>
        <a href="index.jsp">INICIO</a>
        <a href="Vista">PORTADA</a>
        <a href="blog.jsp">Blog</a>
        <a href="perfiles.jsp">PERFILES</a>
        <a href="contactos.jsp">CONTACTOS</a>
        <div class="animation start-home"></div>
    </nav>
   
<ul class="nav nav-tabs">
    <li class="nav-item">
        <a class="nav-link <%= (opcion.equals("destinos") ? "active" : "")%>" href="DestinosControlador">Destinos</a>
    </li>
    <li class="nav-item">
        <a class="nav-link <%= (opcion.equals("buses") ? "active" : "")%>" href="BusesControlador">Buses</a>
    </li>
    <li class="nav-item">
        <a class="nav-link <%= (opcion.equals("conductor") ? "active" : "")%>" href="ConductorControlador">Conductor</a>
    </li>
    <li class="nav-item">
        <a class="nav-link <%= (opcion.equals("encargado") ? "active" : "")%>" href="EncargadoControlador">Encargado</a>
    </li>
    <li class="nav-item">
        <a class="nav-link <%= (opcion.equals("carreras") ? "active" : "")%>" href="CarrerasControlador">Carreras</a>
    </li>
    <li class="nav-item">
        <a class="nav-link <%= (opcion.equals("tipo_buses") ? "active" : "")%>" href="Tipo_busesControlador">Tipo_buses</a>
    </li>
    <li class="nav-item">
        <a class="nav-link <%= (opcion.equals("usuarios") ? "active" : "")%>" href="UsuarioControlador">Usuarios</a>
    </li>
     <a  href="Login" class="btn btn-outline-success" ><i class="fa fa-undo" aria-hidden="true"></i>INICIAR SESION</a>
     
    <a  href="Vista" class="btn btn-outline-danger " ><i class="fa fa-undo" aria-hidden="true"></i>CERRAR SESION</a>
<div class="animation start-home"></div>
</ul>

</header>
