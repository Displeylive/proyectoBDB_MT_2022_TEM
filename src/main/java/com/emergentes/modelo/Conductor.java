package com.emergentes.modelo;

public class Conductor {
   private int id_con;
   private String ci_chofer;
   private String nombre;
   private String apellido;
   private int edad;
   private String celular;

    public Conductor() {
    }
   
    public int getId_con() {
        return id_con;
    }

    public void setId_con(int id_con) {
        this.id_con = id_con;
    }

    public String getCi_chofer() {
        return ci_chofer;
    }

    public void setCi_chofer(String ci_chofer) {
        this.ci_chofer = ci_chofer;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Conductor{" + "id_con=" + id_con + ", ci_chofer=" + ci_chofer + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", celular=" + celular + '}';
    }
   
}
