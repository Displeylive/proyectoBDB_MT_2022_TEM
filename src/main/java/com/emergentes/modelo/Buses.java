package com.emergentes.modelo;

public class Buses {
   private int id_bus;
   private String nro_placa;
   private int id_tbus;
   private String descripcion;
   private int id_cond;
    private String modelo;
    private String nombreCon;

    public Buses() {
    }

    public int getId_bus() {
        return id_bus;
    }

    public void setId_bus(int id_bus) {
        this.id_bus = id_bus;
    }

    public String getNro_placa() {
        return nro_placa;
    }

    public void setNro_placa(String nro_placa) {
        this.nro_placa = nro_placa;
    }

    public int getId_tbus() {
        return id_tbus;
    }

    public void setId_tbus(int id_tbus) {
        this.id_tbus = id_tbus;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_cond() {
        return id_cond;
    }

    public void setId_cond(int id_cond) {
        this.id_cond = id_cond;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNombreCon() {
        return nombreCon;
    }

    public void setNombreCon(String nombreCon) {
        this.nombreCon = nombreCon;
    }

    @Override
    public String toString() {
        return "Buses{" + "id_bus=" + id_bus + ", nro_placa=" + nro_placa + ", id_tbus=" + id_tbus + ", descripcion=" + descripcion + ", id_cond=" + id_cond + ", modelo=" + modelo + ", nombreCon=" + nombreCon + '}';
    }
   
}
