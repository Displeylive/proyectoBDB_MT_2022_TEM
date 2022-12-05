package com.emergentes.controlador;

import com.emergentes.dao.BusesDAO;
import com.emergentes.dao.BusesDAOimpl;
import com.emergentes.dao.ConductorDAO;
import com.emergentes.dao.ConductorDAOimpl;
import com.emergentes.dao.Tipo_busesDAO;
import com.emergentes.dao.Tipo_busesDAOimpl;
import com.emergentes.modelo.Buses;
import com.emergentes.modelo.Conductor;
import com.emergentes.modelo.Tipo_buses;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BusesControlador", urlPatterns = {"/BusesControlador"})
public class BusesControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            BusesDAO dao = new BusesDAOimpl();
            Tipo_busesDAO daoTipo = new Tipo_busesDAOimpl();
            ConductorDAO daoCond = new ConductorDAOimpl();
            int id_bus;
            List<Tipo_buses> lista_tbuses = null;
            List<Conductor> lista_conductor = null;

            Buses buses = new Buses();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    lista_tbuses = daoTipo.getAll();
                    lista_conductor = daoCond.getAll();
                    request.setAttribute("lista_tbuses", lista_tbuses);
                    request.setAttribute("lista_conductor", lista_conductor);
                    request.setAttribute("buses", buses);
                    request.getRequestDispatcher("frmbuses.jsp").forward(request, response);
                    break;
                case "edit":
                    id_bus = Integer.parseInt(request.getParameter("id_bus"));
                    buses = dao.getById(id_bus);
                    lista_tbuses = daoTipo.getAll();
                    lista_conductor = daoCond.getAll();
                    request.setAttribute("lista_tbuses", lista_tbuses);
                    request.setAttribute("lista_conductor", lista_conductor);
                    request.setAttribute("buses", buses);
                    request.getRequestDispatcher("frmbuses.jsp").forward(request, response);

                    break;
                case "delete":
                    id_bus = Integer.parseInt(request.getParameter("id_bus"));
                    dao.delete(id_bus);
                    response.sendRedirect("BusesControlador");
                    break;
                case "view":
                    // optener la lista de objetos
                    List<Buses> lista = dao.getAll();
                    request.setAttribute("buses", lista);
                    request.getRequestDispatcher("buses.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error ...bucesControlador" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_bus = Integer.getInteger(request.getParameter("id_bus"));
        String nro_placa = request.getParameter("nro_placa");
        int id_tbus = Integer.getInteger(request.getParameter("id_tbus"));
        String descripcion = request.getParameter("descripcion");
        int id_cond = Integer.getInteger(request.getParameter("id_cond"));
        
        
        Buses buses = new  Buses();
        buses.setId_bus(id_bus);
        buses.setNro_placa(nro_placa);
        buses.setId_tbus(id_tbus);
        buses.setDescripcion(descripcion);
        buses.setId_cond(id_cond);
       
        BusesDAO dao = new BusesDAOimpl();
        if (id_bus == 0) {
            try {
                // nuevo reguistro
                dao.insert(buses);
            } catch (Exception ex) {
                System.out.println("Error al incertar" + ex.getMessage());
            }

        } else {
            try {
                //edion de reguistro
                dao.upate(buses);
            } catch (Exception ex) {
                System.out.println("Error al Edidat" + ex.getMessage());
            }

        }
        response.sendRedirect("BusesControlador");
        
    }

}
