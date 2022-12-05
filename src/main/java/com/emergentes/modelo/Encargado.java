
package com.emergentes.modelo;

public class Encargado {
    
   private int id_en;
   private String nombre;
   private int id_carrera;
   private String celular;
   private String funcion;
    private String carrera;

    public Encargado() {
    }

    public int getId_en() {
        return id_en;
    }

    public void setId_en(int id_en) {
        this.id_en = id_en;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Encargado{" + "id_en=" + id_en + ", nombre=" + nombre + ", id_carrera=" + id_carrera + ", celular=" + celular + ", funcion=" + funcion + ", carrera=" + carrera + '}';
    }
   
}
