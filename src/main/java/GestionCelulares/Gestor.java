/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionCelulares;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import GestionCelulares.Celular;

public class Gestor {

    /**
     *
     * @param nombre
     */
    public String leerArchivo(String nombre) {

        Path archivo = Paths.get(nombre);
        String Contenido = "";
        try {
            Contenido = new String(Files.readAllBytes(archivo));
        } catch (Exception e) {
            System.out.println("No se pudo leer el archivo.");
        }
        return Contenido;
    }

    /**
     *
     * @param nombre
     * @param texto
     */
    public void escribirArchivo(String nombre, String texto) {
        Path file = Paths.get(nombre);
        try {
            Files.write(file, texto.getBytes());
        } catch (Exception e) {
            System.out.println("El archivo no puede ser reescrito");
        }
    }

    /**
     *
     * @param texto
     */
    public String[] separarTelefonos(String texto) {// ingresa un texto y lo separa en un array de string segun saltos y comas.
        String[] separacion = texto.split("[\n;]+");
        return separacion;
    }

    /**
     *
     * @param celulares
     */
    public void agregarArray(ArrayList<Celular> celulares) {
        String[] infoCel = separarTelefonos(leerArchivo("celulares.csv"));
        int cantidad = (infoCel.length - 2) / 2;// obtenemos la cantidad de telefonos a subir
        for (int i = 0; i < cantidad; i++) {
            int pos = (i + 1) * 2;
            String nombreCel = infoCel[pos];
            double tamañoCel = Double.parseDouble(infoCel[pos + 1]);
            Celular celTemp = new Celular(nombreCel, tamañoCel);
            celulares.add(celTemp);

        }

    }

    /**
     *
     *
     */
    public void mostrar(ArrayList<Celular> celulares) {
        for (int i = 0; i < celulares.size(); i++) {
            System.out.println(celulares.get(i).toString());
        }

    }

    /**
     *
     * @param celulares
     */
    public void selectionSortTamaño(ArrayList<Celular> celulares) {
        System.out.println("Su listado actual es:");
        for (int i = 0; i < celulares.size(); i++) {
            System.out.println(celulares.get(i).toString());
        }

        for (int i = 0; i < celulares.size(); i++) {
            double valorMin = celulares.get(i).getModel();
            int posMin = i;
            for (int j = i; j < celulares.size(); j++) {
                if (celulares.get(j).getModel() < valorMin) {
                    valorMin = celulares.get(j).getModel();
                    posMin = j;
                }
            }
            if (valorMin < celulares.get(i).getModel()) {
                Celular celTemp = celulares.get(i);
                celulares.set(i, celulares.get(posMin));
                celulares.set(posMin, celTemp);

            }

        }
        System.out.println("Su modificado actual es:");
        for (int i = 0; i < celulares.size(); i++) {
            System.out.println(celulares.get(i).toString());
        }
        String texto = textoCSV(celulares);
        escribirArchivo("celulares.csv", texto);

    }

    public void selectionSortModelo(ArrayList<Celular> celulares) {
        System.out.println("Su listado actual es:");
        for (int i = 0; i < celulares.size(); i++) {
            System.out.println(celulares.get(i).toString());
        }

        for (int i = 0; i < celulares.size(); i++) {
            double valorMin = celulares.get(i).getModelo().charAt(0);
            int posMin = i;
            for (int j = i; j < celulares.size(); j++) {
                if (celulares.get(j).getModelo().charAt(0) < valorMin) {
                    valorMin = celulares.get(j).getModelo().charAt(0);
                    posMin = j;
                }
            }
            if (valorMin < celulares.get(i).getModelo().charAt(0)) {
                Celular celTemp = celulares.get(i);
                celulares.set(i, celulares.get(posMin));
                celulares.set(posMin, celTemp);

            }

        }
        System.out.println("Su modificado actual es:");
        for (int i = 0; i < celulares.size(); i++) {
            System.out.println(celulares.get(i).toString());
        }
        String texto = textoCSV(celulares);
        escribirArchivo("celulares.csv", texto);

    }

    /**
     *
     * @param celulares
     */
    public void insertionSortTamaño(ArrayList<Celular> celulares) {
        System.out.println("Su listado actual es:");
        for (int i = 0; i < celulares.size(); i++) {
            System.out.println(celulares.get(i).toString());
        }

        for (int i = 1; i < celulares.size(); i++) {
            double criterio = celulares.get(i).getModel();
            int j = i - 1;
            while (j >= 0 && criterio < celulares.get(j).getModel()) {
                Celular celTemp = celulares.get(j);
                celulares.set(j, celulares.get((j + 1)));
                celulares.set((j + 1), celTemp);
                j--;

            }

        }
        System.out.println("Su listado modificado es:");

    }

    public void insertionSortModelo(ArrayList<Celular> celulares) {
        System.out.println("Su listado actual es:");
        for (int i = 0; i < celulares.size(); i++) {
            System.out.println(celulares.get(i).toString());
        }

        for (int i = 1; i < celulares.size(); i++) {
            double criterio = celulares.get(i).getModelo().charAt(0);
            int j = i - 1;
            while (j >= 0 && criterio <= celulares.get(j).getModelo().charAt(0)) {
                Celular celTemp = celulares.get(j);
                celulares.set(j, celulares.get((j + 1)));
                celulares.set((j + 1), celTemp);
                j--;

            }

        }

        System.out.println("Su modificado actual es:");
        for (int i = 0; i < celulares.size(); i++) {
            System.out.println(celulares.get(i).toString());
        }
        String texto = textoCSV(celulares);
        escribirArchivo("celulares.csv", texto);

    }

    public String textoCSV(ArrayList<Celular> celulares) {
        String texto = "modelo;tamaño";
        for (int i = 0; i < celulares.size(); i++) {

            texto = texto + "\n";
            texto = texto + celulares.get(i).getModelo() + ";" + celulares.get(i).getModel();
        }
        return texto;
    }

}
