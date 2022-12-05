package com.emergentes.dao;

import com.emergentes.modelo.Tipo_buses;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Tipo_busesDAOimpl extends ConexionDB implements Tipo_busesDAO {

    @Override
    public void insert(Tipo_buses tipo_buses) throws Exception {
        try {
            this.conectar();
            String sql;
            sql = "INSERT INTO tipo_bus (modelo,marca) VALUES (?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, tipo_buses.getModelo());
            ps.setString(2, tipo_buses.getMarca());         
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }  
    }

    @Override
    public void upate(Tipo_buses tipo_buses) throws Exception {

         try {
            this.conectar();
            String sql;
            sql = "UPDATE tipo_bus SET modelo = ?, marca = ? WHERE id_t = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, tipo_buses.getModelo());
            ps.setString(2, tipo_buses.getMarca());          
            ps.setInt(3, tipo_buses.getId_t());
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id_t) throws Exception {
           try {
            this.conectar();
            String sql;
            sql = "DELETE FROM tipo_bus WHERE id_t = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id_t);
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Tipo_buses getById(int id_t) throws Exception {

          Tipo_buses t =new Tipo_buses();
        try {
            this.conectar();
            String sql;
            sql = "SELECT * FROM tipo_bus WHERE id_t= ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id_t);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                t.setId_t(rs.getInt("id_t"));
                t.setModelo(rs.getString("modelo"));
                t.setMarca(rs.getString("marca"));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return t;
    }

    @Override
    public List<Tipo_buses> getAll() throws Exception {

        List<Tipo_buses> lista = null;
        try {
            this.conectar();
            String sql;
            sql = "SELECT * FROM tipo_bus ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Tipo_buses>();

            while (rs.next()) {
                Tipo_buses t = new Tipo_buses();
                t.setId_t(rs.getInt("id_t"));
                t.setModelo(rs.getString("modelo"));             
                t.setMarca(rs.getString("marca"));
                
                lista.add(t);
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
