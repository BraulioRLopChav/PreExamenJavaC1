package com.example.preexamencorte1;

public class ReciboNomina {
    // Atributos
    private int numRecibo;
    private String nombre;
    private float horasTrabNormal;
    private float horasTrabExtras;
    private int puesto;
    private float impuestoPorc;

    // Constructor
    public ReciboNomina() {
        this.numRecibo = 0;
        this.nombre = "";
        this.horasTrabNormal = 0.0f;
        this.horasTrabExtras = 0.0f;
        this.puesto = 0;
        this.impuestoPorc = 0.0f;
    }

    // Encapsulamiento
    public void setNumRecibo(int numRecibo) {
        this.numRecibo = numRecibo;
    }

    public int getNumRecibo() {
        return this.numRecibo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setHorasTrabNormal(float horasTrabNormal) {
        this.horasTrabNormal = horasTrabNormal;
    }

    public float getHorasTrabNormal() {
        return this.horasTrabNormal;
    }

    public void setHorasTrabExtras(float horasTrabExtras) {
        this.horasTrabExtras = horasTrabExtras;
    }

    public float getHorasTrabExtras(){
        return this.horasTrabExtras;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    public int getPuesto() {
        return this.puesto;
    }

    public void setImpuestoPorc(float impuestoPorc) {
        this.impuestoPorc = impuestoPorc;
    }

    public float getImpuestoPorc() {
        return this.impuestoPorc;
    }

    // Métodos
    public float calcularSubtotal() {
        float subtotal = 0.0f, pagoBase = 200;

        if(getPuesto() == 1) {
            pagoBase = (pagoBase * 1.20f);
            subtotal = (pagoBase * (getHorasTrabNormal() - getHorasTrabExtras())) + (getHorasTrabExtras() * (pagoBase * 2));
        } else if(getPuesto() == 2) {
            pagoBase = (pagoBase * 1.50f);
            subtotal = (pagoBase * getHorasTrabNormal()) + (getHorasTrabExtras() * (pagoBase * 2));
        }
        else if(getPuesto() == 3) {
            pagoBase = (pagoBase * 2f);
            subtotal = (pagoBase * getHorasTrabNormal()) + (getHorasTrabExtras() * (pagoBase * 2));
        }

        return subtotal;
    }

    public float calcularImpuesto() {
        return (calcularSubtotal() * .16f);
    }

    public float calcularTotal() {
        return calcularSubtotal() - calcularImpuesto();
    }
}

