package com.emergentes.dao;

import com.emergentes.modelo.Encargado;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EncargadoDAOimpl extends ConexionDB implements EncargadoDAO {

    @Override
    public void insert(Encargado encargado) throws Exception {
        try {
            this.conectar();
            String sql;
            sql = "INSERT INTO encargado (nombre,id_carrera,celular,funcion) VALUES (?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, encargado.getNombre());
            ps.setInt(2, encargado.getId_carrera());
            ps.setString(3, encargado.getCelular());
            ps.setString(4, encargado.getFuncion());
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void upate(Encargado encargado) throws Exception {
        try {
            this.conectar();
            String sql;
            sql = "UPDATE encargado SET nombre = ?, id_carrera = ?, celular = ?, funcion = ? WHERE id_en = ? ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, encargado.getNombre());
            ps.setInt(2, encargado.getId_carrera());
            ps.setString(3, encargado.getCelular());
            ps.setString(4, encargado.getFuncion());
            ps.setInt(5, encargado.getId_en());
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

    }

    @Override
    public void delete(int id_en) throws Exception {

        try {
            this.conectar();
            String sql;
            sql = "DELETE FROM encargado WHERE id_en = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id_en);
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Encargado getById(int id_en) throws Exception {
        Encargado en = new Encargado();
        try {
            this.conectar();
            String sql;
            sql = "SELECT * FROM encargado WHERE id_en = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id_en);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                en.setId_en(rs.getInt("id_en"));
                en.setNombre(rs.getString("nombre"));
                en.setId_carrera(rs.getInt("id_carrera"));
                en.setCelular(rs.getString("celular"));
                en.setFuncion(rs.getString("funcion"));

            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return en;

    }

    @Override
    public List<Encargado> getAll() throws Exception {
        List<Encargado> lista = null;
        try {
            this.conectar();
            String sql;
            sql = "SELECT e.*,c.area as carrera  FROM encargado e LEFT JOIN carrera c on e.id_en = c.id_c";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Encargado>();

            while (rs.next()) {
                Encargado en = new Encargado();
                en.setId_en(rs.getInt("id_en"));
                en.setNombre(rs.getString("nombre"));
                en.setId_carrera(rs.getInt("id_carrera"));
                en.setCelular(rs.getString("celular"));
                en.setFuncion(rs.getString("funcion"));            
                en.setCarrera(rs.getString("carrera"));

                lista.add(en);
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }

}
