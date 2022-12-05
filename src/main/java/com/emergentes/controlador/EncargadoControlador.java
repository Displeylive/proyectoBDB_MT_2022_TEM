
package com.emergentes.controlador;

import com.emergentes.dao.CarrerasDAO;
import com.emergentes.dao.CarrerasDAOimpl;
import com.emergentes.dao.EncargadoDAO;
import com.emergentes.dao.EncargadoDAOimpl;
import com.emergentes.modelo.Carreras;
import com.emergentes.modelo.Encargado;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EncargadoControlador", urlPatterns = {"/EncargadoControlador"})
public class EncargadoControlador extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            EncargadoDAO dao = new EncargadoDAOimpl();
            CarrerasDAO daoCarreras = new CarrerasDAOimpl();           
            int id_en;
            List<Carreras> lista_carreras = null;
        
            Encargado encargado = new Encargado();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    lista_carreras = daoCarreras.getAll();
                   
                    request.setAttribute("lista_carreras", lista_carreras);
                    request.setAttribute("encargado", encargado);
                    request.getRequestDispatcher("frmencargado.jsp").forward(request, response);
                    break;
                case "edit":
                    id_en = Integer.parseInt(request.getParameter("id_en"));
                    encargado = dao.getById(id_en);
                    lista_carreras = daoCarreras.getAll();
                  
                    request.setAttribute("lista_carreras", lista_carreras);
                    request.setAttribute("encargado", encargado);
                    request.getRequestDispatcher("frmencargado.jsp").forward(request, response);
                    
                    break;
                case "delete":
                    break;
                case "view":
                    // optener la lista de objetos
                    List<Encargado> lista = dao.getAll();
                    request.setAttribute("encargado", lista);
                    request.getRequestDispatcher("encargado.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error ...bucesControlador" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       /* int id_bus = Integer.getInteger(request.getParameter("id_bus"));
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
        response.sendRedirect("BusesControlador");*/
    }

}
