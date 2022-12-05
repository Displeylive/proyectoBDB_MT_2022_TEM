package com.emergentes.modelo;

import java.sql.Date;

public class Destinos {
    
   private int id_des;
   private String parada;
   private String lugar_destino;
   private int costo_pasaje;
   private Date fecha_partida;
   private Date fecha_llegada;
   private int id_bus;
   private int id_encargado;
     private String modelo;
     private String encargado;

    public Destinos() {
    }

    public int getId_des() {
        return id_des;
    }

    public void setId_des(int id_des) {
        this.id_des = id_des;
    }

    public String getParada() {
        return parada;
    }

    public void setParada(String parada) {
        this.parada = parada;
    }

    public String getLugar_destino() {
        return lugar_destino;
    }

    public void setLugar_destino(String lugar_destino) {
        this.lugar_destino = lugar_destino;
    }

    public int getCosto_pasaje() {
        return costo_pasaje;
    }

    public void setCosto_pasaje(int costo_pasaje) {
        this.costo_pasaje = costo_pasaje;
    }

    public Date getFecha_partida() {
        return fecha_partida;
    }

    public void setFecha_partida(Date fecha_partida) {
        this.fecha_partida = fecha_partida;
    }

    public Date getFecha_llegada() {
        return fecha_llegada;
    }

    public void setFecha_llegada(Date fecha_llegada) {
        this.fecha_llegada = fecha_llegada;
    }

    public int getId_bus() {
        return id_bus;
    }

    public void setId_bus(int id_bus) {
        this.id_bus = id_bus;
    }

    public int getId_encargado() {
        return id_encargado;
    }

    public void setId_encargado(int id_encargado) {
        this.id_encargado = id_encargado;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    @Override
    public String toString() {
        return "Destinos{" + "id_des=" + id_des + ", parada=" + parada + ", lugar_destino=" + lugar_destino + ", costo_pasaje=" + costo_pasaje + ", fecha_partida=" + fecha_partida + ", fecha_llegada=" + fecha_llegada + ", id_bus=" + id_bus + ", id_encargado=" + id_encargado + ", modelo=" + modelo + ", encargado=" + encargado + '}';
    }
     
     
   
}
