/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import Helper.Ayuda_verificador;
import Helper.Helper_movimiento;
import JFrame.*;

/**
 *
 * @author alexis
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
       public static void main(String[] args) {
        // Clase principal y llamamos el frame
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //inicio de movimiento:
                
                Helper_movimiento.Inicio_Movimiento_linea();
                Ayuda_verificador.INIcio_lexemas_analisis_manejador();
                
            //ir al frame
                
                frame_principal ingreso = new frame_principal();
                ingreso.setVisible(true);
            }
        });
    }
    
}
