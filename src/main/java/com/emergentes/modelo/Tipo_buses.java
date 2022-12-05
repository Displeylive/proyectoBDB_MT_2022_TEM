package com.emergentes.modelo;

public class Tipo_buses {
    private int id_t;
    private String modelo;
    private String marca;

    public Tipo_buses() {
    }

    public int getId_t() {
        return id_t;
    }

    public void setId_t(int id_t) {
        this.id_t = id_t;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Tipo_buses{" + "id_t=" + id_t + ", modelo=" + modelo + ", marca=" + marca + '}';
    }  
}
