/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Automata_Analisis.Id;
import Automata_Analisis.Numero_o_Decimal;
import Automata_Analisis.Operador_Aritmetico;
import Automata_Analisis.Signo_Agrupacion;
import Automata_Analisis.Signo_Puntuacion;
import static Helper.Helper_movimiento.movilizar;
import static JFrame.frame_principal.cargarError;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import static JFrame.frame_principal.jTextArea2;
import Validacion.validaciones;
import static Helper.Ayuda_verificador.inciovariables;

/**
 *
 * @author alexis
 */
public class repeticiones {
    public static void codigoAutomataRepitencia(String linea, char verificadorLinea,String reduccionLinea,int caracteresUsados,JTextArea MovilizadorDatos){
        verificadorLinea=reduccionLinea.charAt(0);
        //si contiene espacio avanzamos un caracter
        if (Character.isSpaceChar(verificadorLinea)) {
            if (movilizar.getHayEspacio()==1) {  
                verificadorLinea=reduccionLinea.charAt(0);
            }else{
                verificadorLinea=reduccionLinea.charAt(1);
            }       
        }
        //mira si es letra
        if(validaciones.esLetra(verificadorLinea)){
            Id.inicio_ID(linea, jTextArea2);
            reduccionLinea=linea.substring(movilizar.getCantidad(), linea.length());
            
        }
        //mira si es numero
        else if(validaciones.esNumero(verificadorLinea)){
            Numero_o_Decimal.empezar_numero_lexema(linea, jTextArea2);
            reduccionLinea=linea.substring(movilizar.getCantidad(), linea.length());
        }
        //mira si es operador
        else if(validaciones.esAritmetico(verificadorLinea)){
            Operador_Aritmetico.operadorInicio(reduccionLinea, jTextArea2);
            reduccionLinea=linea.substring(movilizar.getCantidad(), linea.length());
        }
        //mira si es puntuacion
        else if(validaciones.esPuntuacion(verificadorLinea)){
            Signo_Puntuacion.puntuacionInicio(linea, jTextArea2);
            reduccionLinea=linea.substring(movilizar.getCantidad(), linea.length());
        }
        //mira si es agrupacion
        else if(validaciones.esAgrupacion(verificadorLinea)){
            Signo_Agrupacion.agrupacionInicio(linea, jTextArea2);
            reduccionLinea=linea.substring(movilizar.getCantidad(), linea.length());
            
            
        }else{
            try {
                //estructuramos que si haya error y modificamos datos
                movilizar.setCadenaUsada(Character.toString(verificadorLinea));
                movilizar.setCantidad(movilizar.getCantidad()+1);
                cargarError.cargarReporte();
                movilizar.setCondiconalError(1);


//mensaje en pantalla
                jTextArea2.setText(jTextArea2.getText()+" error en el lexema "+movilizar.getCadenaUsada()+"\n");
                reduccionLinea=linea.substring(movilizar.getCantidad(), linea.length());
            } catch (IOException ex) {
                Logger.getLogger(repeticiones.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(repeticiones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //modificamos valores iniciales al recargar este método
        inciovariables.setLinea(linea);
        inciovariables.setReduccionLinea(reduccionLinea);
        inciovariables.setVerificadorLinea(verificadorLinea);
    }
}
