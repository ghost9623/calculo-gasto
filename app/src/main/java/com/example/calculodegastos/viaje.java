package com.example.calculodegastos;

public class viaje implements operaciones {
    private String nombre;
    private String salida;
    private String llegada;
    private  String horasalida;
    private double costogaso;
    private double diskm;

    public viaje()
    {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getLlegada() {
        return llegada;
    }

    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    public String getHorasalida() {
        return horasalida;
    }

    public void setHorasalida(String horasalida) {
        this.horasalida = horasalida;
    }

    public double getCostogaso() {
        return costogaso;
    }

    public void setCostogaso(double costogaso) {
        this.costogaso = costogaso;
    }

    public double getDiskm() {
        return diskm;
    }

    public void setDiskm(double diskm) {
        this.diskm = diskm;
    }

    @Override
    public String tiempollegada() {

        int hora;
        int min;
        int  seg;

        double segtot;

        segtot=(diskm/92.2);

        segtot=(int)(segtot*3600);

        seg=(int)segtot%60;
        min=(int)(segtot/60)%60;
        hora=(int)((segtot/60)/60);




        return hora+":"+min+":"+seg ;
    }

    @Override
    public double costoviaje() {
      double gasto= 10.5;
               gasto=diskm/10.5;
        return gasto*costogaso;
    }
}
