
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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Vista", urlPatterns = {"/Vista"})
public class Vista extends HttpServlet {

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
                    break;
                case "edit":
                     break;
                case "delete":
                    break;
                case "view":
                    // optener la lista de objetos
                    List<Destinos> lista = dao.getAll();
                    request.setAttribute("destinos", lista);
                    request.getRequestDispatcher("1portada.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error ...bucesControlador" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    }

}
