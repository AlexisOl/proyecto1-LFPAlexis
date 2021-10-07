/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import Helper.Datos_manejadores;
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
                //inicializamos estructuradores de datos
                Helper_movimiento.crearMovilizador();//llamamos a movilizar datos
                Datos_manejadores.crearDatosInstanciadores();//llamamos instanciadores
                frame_principal ingreso = new frame_principal();
                ingreso.setVisible(true);
            }
        });
    }
    
}
