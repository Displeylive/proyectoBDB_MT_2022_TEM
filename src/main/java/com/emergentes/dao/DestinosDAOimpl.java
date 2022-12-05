package com.emergentes.dao;

import com.emergentes.modelo.Destinos;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DestinosDAOimpl extends ConexionDB implements DestinosDAO {

    @Override
    public void insert(Destinos destinos) throws Exception {
        try {
            this.conectar();
            String sql;
            sql = "INSERT INTO destinos (parada,lugar_destino,costo_pasaje,fecha_partida,fecha_llegada,id_bus,id_encargado) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, destinos.getParada());
            ps.setString(2, destinos.getLugar_destino());
            ps.setInt(3, destinos.getCosto_pasaje());
            ps.setDate(4, destinos.getFecha_partida());
            ps.setDate(5, destinos.getFecha_llegada());
            ps.setInt(6, destinos.getId_bus());
            ps.setInt(7, destinos.getId_encargado());
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

    }

    @Override
    public void upate(Destinos destinos) throws Exception {
        try {
            this.conectar();
            String sql;
            sql = "UPDATE destinos SET parada = ?, lugar_destino = ?, costo_pasaje = ?, fecha_partida = ?, fecha_llegada =?, id_bus = ?, id_encargado = ? WHERE id_des = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, destinos.getParada());
            ps.setString(2, destinos.getLugar_destino());
            ps.setInt(3, destinos.getCosto_pasaje());
            ps.setDate(4, destinos.getFecha_partida());
            ps.setDate(5, destinos.getFecha_llegada());
            ps.setInt(6, destinos.getId_bus());
            ps.setInt(7, destinos.getId_encargado());
            ps.setInt(8, destinos.getId_des());
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id_des) throws Exception {
        try {
            this.conectar();
            String sql;
            sql = "DELETE FROM destinos WHERE id_des = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id_des);
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

    }

    @Override
    public Destinos getById(int id_des) throws Exception {

        Destinos d = new Destinos();
        try {
            this.conectar();
            String sql;
            sql = "SELECT * FROM destinos WHERE id_des = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id_des);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                d.setId_des(rs.getInt("id_des"));
                d.setParada(rs.getString("parada"));
                d.setLugar_destino(rs.getString("lugar_destino"));
                d.setCosto_pasaje(rs.getInt("costo_pasaje"));
                d.setFecha_partida(rs.getDate("fecha_partida"));
                d.setFecha_llegada(rs.getDate("fecha_llegada"));
                d.setId_bus(rs.getInt("id_bus"));
                d.setId_encargado(rs.getInt("id_encargado"));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return d;

    }

    @Override
    public List<Destinos> getAll() throws Exception {
        List<Destinos> lista = null;
        try {
            this.conectar();
            String sql;
            sql = "SELECT d.*,t.modelo modelo,e.nombre encargado from destinos d LEFT JOIN bus b ON b.id_bus = d.id_bus LEFT JOIN encargado e ON e.id_en =d.id_encargado LEFT JOIN tipo_bus t on t.id_t =b.id_tbus";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Destinos>();

            while (rs.next()) {
                Destinos d = new Destinos();
                d.setId_des(rs.getInt("id_des"));
                d.setParada(rs.getString("parada"));
                d.setLugar_destino(rs.getString("lugar_destino"));
                d.setCosto_pasaje(rs.getInt("costo_pasaje"));
                d.setFecha_partida(rs.getDate("fecha_partida"));
                d.setFecha_llegada(rs.getDate("fecha_llegada"));
                d.setId_bus(rs.getInt("id_bus"));
                d.setId_encargado(rs.getInt("id_encargado"));
                d.setModelo(rs.getString("modelo"));
                d.setEncargado(rs.getString("encargado"));

                lista.add(d);
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
