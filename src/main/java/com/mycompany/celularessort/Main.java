/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.celularessort;

import GestionCelulares.Celular;
import GestionCelulares.Gestor;
import java.util.ArrayList;

/**
 *
 * @author JAVIER
 *
 *
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Gestor gest = new Gestor();

        System.out.println(gest.leerArchivo("celulares.csv"));
    }
}
