package com.emergentes.controlador;

import com.emergentes.dao.CarrerasDAO;
import com.emergentes.dao.CarrerasDAOimpl;
import com.emergentes.modelo.Carreras;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CarrerasControlador", urlPatterns = {"/CarrerasControlador"})
public class CarrerasControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Carreras c = new Carreras();
            int id_c;
            CarrerasDAO dao = new CarrerasDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("carreras", c);
                    request.getRequestDispatcher("frmcarreras.jsp").forward(request, response);
                    break;
                case "edit":
                    id_c = Integer.parseInt(request.getParameter("id_c"));
                    c = dao.getById(id_c);
                    request.setAttribute("carreras", c);
                    request.getRequestDispatcher("frmcarreras.jsp").forward(request, response);                  
                    break;
                case "delete":
                     id_c = Integer.parseInt(request.getParameter("id_c"));
                     dao.delete(id_c);
                     response.sendRedirect("CarrerasControlador");
                    break;
                case "view":
                    // optener la lista de objetos
                    List<Carreras> lista = dao.getAll();
                    request.setAttribute("carreras", lista);
                    request.getRequestDispatcher("carreras.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error ..." + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_c = Integer.parseInt(request.getParameter("id_c"));
        String area = request.getParameter("area");
       
        Carreras c = new Carreras();
        c.setId_c(id_c);
        c.setArea(area);
       
        CarrerasDAO dao = new CarrerasDAOimpl();
        if (id_c == 0) {
            try {
                // nuevo reguistro
                dao.insert(c);
            } catch (Exception ex) {
                System.out.println("Error al incertar" + ex.getMessage());
            }

        } else {
            try {
                //edion de reguistro
                dao.upate(c);
            } catch (Exception ex) {
                System.out.println("Error al Edidat" + ex.getMessage());
            }

        }
        response.sendRedirect("CarrerasControlador");
    }

}
