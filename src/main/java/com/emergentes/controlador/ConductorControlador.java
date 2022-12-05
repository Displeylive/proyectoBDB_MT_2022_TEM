package com.emergentes.controlador;

import com.emergentes.dao.ConductorDAO;
import com.emergentes.dao.ConductorDAOimpl;
import com.emergentes.modelo.Conductor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ConductorControlador", urlPatterns = {"/ConductorControlador"})
public class ConductorControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Conductor c = new Conductor();
            int id_con;
            ConductorDAO dao = new ConductorDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("conductor", c);
                    request.getRequestDispatcher("frmconductor.jsp").forward(request, response);
                    break;
                case "edit":
                    id_con = Integer.parseInt(request.getParameter("id_con"));
                    c = dao.getById(id_con);
                    request.setAttribute("conductor", c);
                    request.getRequestDispatcher("frmconductor.jsp").forward(request, response);
                    break;
                case "delete":
                    id_con = Integer.parseInt(request.getParameter("id_con"));
                    dao.delete(id_con);
                    response.sendRedirect("ConductorControlador");
                    break;
                case "view":
                    // optener la lista de objetos
                    List<Conductor> lista = dao.getAll();
                    request.setAttribute("conductor", lista);
                    request.getRequestDispatcher("conductor.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error ..." + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     int id_con = Integer.parseInt(request.getParameter("id_con"));
     String ci_chofer = request.getParameter("ci_chofer");
     String nombre = request.getParameter("nombre");
     String apellido = request.getParameter("apellido");
     int edad = Integer.parseInt(request.getParameter("edad"));
     String celular = request.getParameter("celular");
     
     Conductor c = new Conductor();
     c.setId_con(id_con);
     c.setCi_chofer(ci_chofer);
     c.setNombre(nombre);
     c.setApellido(apellido);
     c.setEdad(edad);
     c.setCelular(celular);
     
     ConductorDAO dao = new ConductorDAOimpl();
     if (id_con == 0){
         try {
             // nuevo reguistro
             dao.insert(c);
         } catch (Exception ex) {
             System.out.println("Error al incertar" +ex.getMessage());
         }
        
     }else{
         try {
             //edion de reguistro
             dao.upate(c);
         } catch (Exception ex) {
             System.out.println("Error al Edidat" +ex.getMessage());
         }
         
     }
     response.sendRedirect("ConductorControlador");
    }

}
