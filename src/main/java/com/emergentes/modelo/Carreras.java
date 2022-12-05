package com.emergentes.modelo;

public class Carreras {
   private int id_c;
   private String area;

    public Carreras() {
    }

    public int getId_c() {
        return id_c;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Carreras{" + "id_c=" + id_c + ", area=" + area + '}';
    }
   
   
}
