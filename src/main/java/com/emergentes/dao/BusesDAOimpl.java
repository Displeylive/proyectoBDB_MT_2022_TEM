package com.emergentes.dao;

import com.emergentes.modelo.Buses;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BusesDAOimpl extends ConexionDB implements BusesDAO {

    @Override
    public void insert(Buses buses) throws Exception {
        try {
            this.conectar();
            String sql;
            sql = "INSERT INTO bus (nro_placa,id_tbus,descripcion,id_cond) VALUES (?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, buses.getNro_placa());
            ps.setInt(2, buses.getId_tbus());
            ps.setString(3, buses.getDescripcion());
            ps.setInt(4, buses.getId_cond());

            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void upate(Buses buses) throws Exception {
        try {
            this.conectar();
            String sql;
            sql = "UPDATE bus SET nro_placa = ?, id_tbus = ?, descripcion = ?, id_cond = ? WHERE id_bus = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, buses.getNro_placa());
            ps.setInt(2, buses.getId_tbus());
            ps.setString(3, buses.getDescripcion());
            ps.setInt(4, buses.getId_cond());
            ps.setInt(5, buses.getId_bus());
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id_bus) throws Exception {
        try {
            this.conectar();
            String sql;
            sql = "DELETE FROM bus WHERE id_bus = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id_bus);
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Buses getById(int id_bus) throws Exception {

        Buses b = new Buses();
        try {
            this.conectar();
            String sql;
            sql = "SELECT * FROM bus WHERE id_bus = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id_bus);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                b.setId_bus(rs.getInt("id_bus"));
                b.setNro_placa(rs.getString("nro_placa"));
                b.setId_tbus(rs.getInt("id_tbus"));
                b.setDescripcion(rs.getString("descripcion"));
                b.setId_cond(rs.getInt("id_cond"));

            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return b;
    }

    @Override
    public List<Buses> getAll() throws Exception {

        List<Buses> lista = null;
        try {
            this.conectar();
            String sql;
            sql = "SELECT b.*,t.modelo as modelo,concat(c.nombre,' ',c.apellido) encargado FROM bus b LEFT JOIN tipo_bus t on b.id_tbus = t.id_t LEFT JOIN conductor c on b.id_cond = c.id_con";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Buses>();

            while (rs.next()) {
                Buses b = new Buses();
                b.setId_bus(rs.getInt("id_bus"));
                b.setNro_placa(rs.getString("nro_placa"));
                b.setId_tbus(rs.getInt("id_tbus"));
                b.setDescripcion(rs.getString("descripcion"));
                b.setId_cond(rs.getInt("id_cond"));
                b.setModelo(rs.getString("modelo"));
                b.setNombreCon(rs.getString("encargado"));

                lista.add(b);
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