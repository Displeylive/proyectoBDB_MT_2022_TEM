package com.emergentes.controlador;

import com.emergentes.dao.Tipo_busesDAO;
import com.emergentes.dao.Tipo_busesDAOimpl;
import com.emergentes.modelo.Tipo_buses;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Tipo_busesControlador", urlPatterns = {"/Tipo_busesControlador"})
public class Tipo_busesControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Tipo_buses t = new Tipo_buses();
            int id_t;
            Tipo_busesDAO dao = new Tipo_busesDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("tipo_buses", t);
                    request.getRequestDispatcher("frmtipo_buses.jsp").forward(request, response);

                    break;
                case "edit":
                    id_t = Integer.parseInt(request.getParameter("id_t"));
                    t = dao.getById(id_t);
                    request.setAttribute("tipo_buses", t);
                    request.getRequestDispatcher("frmtipo_buses.jsp").forward(request, response);
                    break;
                case "delete":
                    id_t = Integer.parseInt(request.getParameter("id_t"));
                    dao.delete(id_t);
                    response.sendRedirect("Tipo_busesControlador");
                    break;
                case "view":
                    // optener la lista de objetos
                    List<Tipo_buses> lista = dao.getAll();
                    request.setAttribute("tipo_bus", lista);
                    request.getRequestDispatcher("tipo_buses.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error ..." + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_t = Integer.parseInt(request.getParameter("id_t"));
        String modelo = request.getParameter("modelo");
        String marca = request.getParameter("marca");

        Tipo_buses t = new Tipo_buses();
        t.setId_t(id_t);
        t.setModelo(modelo);
        t.setMarca(marca);
        

        Tipo_busesDAO dao = new Tipo_busesDAOimpl();
        if (id_t == 0) {
            try {
                // nuevo reguistro
                dao.insert(t);
            } catch (Exception ex) {
                System.out.println("Error al incertar" + ex.getMessage());
            }

        } else {
            try {
                //edion de reguistro
                dao.upate(t);
            } catch (Exception ex) {
                System.out.println("Error al Edidat" + ex.getMessage());
            }

        }
        response.sendRedirect("Tipo_busesControlador");
    }

}
