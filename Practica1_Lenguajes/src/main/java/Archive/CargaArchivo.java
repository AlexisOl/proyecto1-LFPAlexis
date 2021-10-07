/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JTextArea;

/**
 *
 * @author alexis
 */
public class CargaArchivo {
    public void leer(File archivo, JTextArea text, JTextArea numLineas) throws FileNotFoundException, IOException, ClassNotFoundException {
     
        FileReader leerA = new FileReader(archivo);
        BufferedReader leerTA = new BufferedReader(leerA);
        String linea;
        //ciclo para ver todo el texto
        
        while ((linea = leerTA.readLine()) != null) {
            text.append(linea+"\n");
        }
        Contador_Lineas lineas = new Contador_Lineas();
        //lineas del texto
        lineas.Contar(text, numLineas);
    }
}
