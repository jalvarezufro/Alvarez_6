/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionCelulares;

public class Celular {

    private String modelo;
    private double tamaño;

    public Celular(String modelo, double tamaño) {
        this.modelo = modelo;
        this.tamaño = tamaño;
    }

    public String getModelo() {
        return this.modelo;
    }

    public double getModel() {
        return this.tamaño;
    }

    /**
     *
     * @param modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     *
     * @param tamaño
     */
    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public String toString() {
        return "Celular{" + "modelo=" + modelo + ", tama\u00f1o=" + tamaño + '}';
    }

}
