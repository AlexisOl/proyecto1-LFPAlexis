/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archive;

import javax.swing.JTextArea;

/**
 *
 * @author alexis
 */
public class Contador_Lineas {
    
    /// Metodo para determinar cuantas lineas hay en el area
    public void Contar(JTextArea text, JTextArea actual) {
        actual.setText("");
        text.setCaretPosition(0);
        int cantidad_columnas = text.getLineCount();
        
        for (int i = 0; i <cantidad_columnas; i++) {
                actual.append(Integer.toString(i+1) + " \n");
             //   actual.append(" /n");
           //  actual.append("hola/n" + "simon");
            
        }
        actual.setCaretPosition(0);
        actual.setAutoscrolls(false);
    }
}

       
       