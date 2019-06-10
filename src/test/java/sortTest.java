/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import GestionCelulares.Celular;
import GestionCelulares.Gestor;

/**
 *
 * @author JAVIER
 */
public class sortTest {

    @Test
    public void testLeer() {
        Gestor gest = new Gestor();
        assertEquals("modelo;pantalla\n"
                + "Iphone X;5.8\n"
                + "Galaxy S9+;6.2\n"
                + "Mate 10 Pro;6.0\n"
                + "Galaxy Note 9;6.4\n"
                + "Mate 20 Pro;6.4\n"
                + "P20 Pro;6.1\n"
                + "Redmi 6A;5.45\n"
                + "Galaxy J5;5.2\n"
                + "Moto G7;6.2\n"
                + "Pixel 2 XL;6.0", gest.leerArchivo("celulares.csv"));
    }
    
    

}
