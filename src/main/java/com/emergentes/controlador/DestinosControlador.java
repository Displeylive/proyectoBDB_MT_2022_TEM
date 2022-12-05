package com.emergentes.controlador;

import com.emergentes.dao.BusesDAO;
import com.emergentes.dao.BusesDAOimpl;
import com.emergentes.dao.DestinosDAO;
import com.emergentes.dao.DestinosDAOimpl;
import com.emergentes.dao.EncargadoDAO;
import com.emergentes.dao.EncargadoDAOimpl;
import com.emergentes.dao.Tipo_busesDAO;
import com.emergentes.dao.Tipo_busesDAOimpl;
import com.emergentes.modelo.Buses;
import com.emergentes.modelo.Destinos;
import com.emergentes.modelo.Encargado;
import com.emergentes.modelo.Tipo_buses;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DestinosControlador", urlPatterns = {"/DestinosControlador"})
public class DestinosControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            DestinosDAO dao = new DestinosDAOimpl();
            BusesDAO daoBuses = new BusesDAOimpl();
            Tipo_busesDAO daomodelos = new Tipo_busesDAOimpl();
            EncargadoDAO daoencargado = new EncargadoDAOimpl();
            int id_des;
            List<Buses> lista_buses = null;
            List<Tipo_buses> lista_modelo = null;
            List<Encargado> lista_encargado = null;
            Destinos destinos = new Destinos();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    lista_buses = daoBuses.getAll();
                    lista_modelo = daomodelos.getAll();
                    lista_encargado = daoencargado.getAll();
                    request.setAttribute("lista_buses", lista_buses);
                    request.setAttribute("lista_modelo", lista_modelo);
                    request.setAttribute("lista_encargado", lista_encargado);
                    request.setAttribute("destinos", destinos);
                    request.getRequestDispatcher("frmdestinos.jsp").forward(request, response);
                    break;
                case "edit":
                    id_des = Integer.parseInt(request.getParameter("id_des"));
                    destinos = dao.getById(id_des);
                    lista_buses = daoBuses.getAll();
                    lista_modelo = daomodelos.getAll();
                    lista_encargado = daoencargado.getAll();
                    request.setAttribute("lista_buses", lista_buses);
                    request.setAttribute("lista_modelo", lista_modelo);
                    request.setAttribute("lista_encargado", lista_encargado);
                    request.setAttribute("destinos", destinos);
                    request.getRequestDispatcher("frmdestinos.jsp").forward(request, response);

                    break;
                case "delete":
                    id_des = Integer.parseInt(request.getParameter("id_des"));
                    dao.delete(id_des);
                    response.sendRedirect("DestinosControlador");
                    break;
                case "view":
                    // optener la lista de objetos
                    List<Destinos> lista = dao.getAll();
                    request.setAttribute("destinos", lista);
                    request.getRequestDispatcher("destinos.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error ...bucesControlador" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_des = Integer.parseInt(request.getParameter("id_des"));
        String parada = request.getParameter("parada");
        String lugar_destino = request.getParameter("lugar_destino");
        int costo_pasaje = Integer.parseInt(request.getParameter("costo_pasaje"));
        String fecha_partida = request.getParameter("fecha_partida");
        String fecha_llegada = request.getParameter("fecha_llegada");
        int id_bus = Integer.parseInt(request.getParameter("id_bus"));
        int id_encargado = Integer.parseInt(request.getParameter("id_encargado"));

        Destinos destinos = new Destinos();
        destinos.setId_des(id_des);
        destinos.setParada(parada);
        destinos.setLugar_destino(lugar_destino);
        destinos.setCosto_pasaje(costo_pasaje);
        destinos.setFecha_partida(convierteFecha(fecha_partida));
        destinos.setFecha_llegada(convierteFecha(fecha_llegada));
        destinos.setId_bus(id_bus);
        destinos.setId_encargado(id_encargado);
        
        if(id_des ==0){
            //nuevo
            DestinosDAO dao = new DestinosDAOimpl();
            try {
                dao.insert(destinos);
                response.sendRedirect("DestinosControlador");
            } catch (Exception ex) {
                Logger.getLogger(DestinosControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }else{
            //editar
             DestinosDAO dao = new DestinosDAOimpl();
            try {
                dao.upate(destinos);
                response.sendRedirect("DestinosControlador");
            } catch (Exception ex) {
                Logger.getLogger(DestinosControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public Date convierteFecha(String fecha) {
        Date fechaBD = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date fechaTMP;
        try {
            fechaTMP = formato.parse(fecha);
            fechaBD = new Date(fechaTMP.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(DestinosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fechaBD;
    }
}
