package com.emergentes.dao;

import com.emergentes.modelo.Carreras;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarrerasDAOimpl extends ConexionDB implements CarrerasDAO {

    @Override
    public void insert(Carreras carreras) throws Exception {

        try {
            this.conectar();
            String sql;
            sql = "INSERT INTO carrera (area) VALUES (?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, carreras.getArea());
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void upate(Carreras carreras) throws Exception {
        try {
            this.conectar();
            String sql;
            sql = "UPDATE carrera SET area = ? WHERE id_c = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, carreras.getArea());
            ps.setInt(2, carreras.getId_c());
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id_c) throws Exception {
        try {
            this.conectar();
            String sql;
            sql = "DELETE FROM carrera WHERE id_c = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id_c);
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Carreras getById(int id_c) throws Exception {
        Carreras car = new Carreras();
        try {
            this.conectar();
            String sql;
            sql = "SELECT * FROM carrera WHERE id_c = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id_c);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                car.setId_c(rs.getInt("id_c"));
                car.setArea(rs.getString("area"));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return car;
    }

    @Override
    public List<Carreras> getAll() throws Exception {

        List<Carreras> lista = null;
        try {
            this.conectar();
            String sql;
            sql = "SELECT * FROM carrera ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Carreras>();

            while (rs.next()) {
                Carreras car = new Carreras();
                car.setId_c(rs.getInt("id_c"));
                car.setArea(rs.getString("area"));

                lista.add(car);
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
