package com.emergentes.dao;

import com.emergentes.modelo.Conductor;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConductorDAOimpl extends ConexionDB implements ConductorDAO {

    @Override
    public void insert(Conductor conductor) throws Exception {
        try {
            this.conectar();
            String sql;
            sql = "INSERT INTO conductor (ci_chofer,nombre,apellido,edad,celular) VALUES (?,?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, conductor.getCi_chofer());
            ps.setString(2, conductor.getNombre());
            ps.setString(3, conductor.getApellido());
            ps.setInt(4, conductor.getEdad());
            ps.setString(5, conductor.getCelular());
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        } 
    }

    @Override
    public void upate(Conductor conductor) throws Exception {
        
         try {
            this.conectar();
            String sql;
            sql = "UPDATE conductor SET ci_chofer = ?, nombre = ?, apellido = ?, edad = ? ,celular = ? WHERE id_con = ? ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, conductor.getCi_chofer());
            ps.setString(2, conductor.getNombre());
            ps.setString(3, conductor.getApellido());
            ps.setInt(4, conductor.getEdad());
            ps.setString(5, conductor.getCelular());
            ps.setInt(6, conductor.getId_con());
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id_con) throws Exception {

         try {
            this.conectar();
            String sql;
            sql = "DELETE FROM conductor WHERE id_con = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id_con);
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Conductor getById(int id_con) throws Exception {
       Conductor c = new Conductor();
        try {
            this.conectar();
            String sql;
            sql = "SELECT * FROM conductor WHERE id_con = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id_con);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c.setId_con(rs.getInt("id_con"));
                c.setCi_chofer(rs.getString("ci_chofer"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setEdad(rs.getInt("edad"));
                c.setCelular(rs.getString("celular"));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return c; 
    }

    @Override
    public List<Conductor> getAll() throws Exception {
        List<Conductor> lista = null;
        try {
            this.conectar();
            String sql;
            sql = "SELECT * FROM conductor ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Conductor>();

            while (rs.next()) {
                Conductor c = new Conductor();
                c.setId_con(rs.getInt("id_con"));
                c.setCi_chofer(rs.getString("ci_chofer"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setEdad(rs.getInt("edad"));
                c.setCelular(rs.getString("celular"));
                lista.add(c);
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
