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
import static Helper.Datos_manejadores.instanciadores;
import static Helper.Helper_movimiento.movilizar;
import static JFrame.frame_principal.cargarError;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import static JFrame.frame_principal.jTextArea2;

/**
 *
 * @author alexis
 */
public class CodigoCondicionalRepetidoAutomata {
    public static void codigoAutomataRepitencia(String linea, char verificadorLinea,String reduccionLinea,int caracteresUsados,JTextArea MovilizadorDatos){
        //creamos metodo para reutilizacion de codigo para identificador automatas, reduccion linea es para acortar nuestro dato
        verificadorLinea=reduccionLinea.charAt(0);
        //si contiene espacio avanzamos un caracter
        if (Character.isSpaceChar(verificadorLinea)) {
            if (movilizar.getHayEspacio()==1) {  //si anteriormente era espacio no tienen que haber dos espacios
                verificadorLinea=reduccionLinea.charAt(0);
            }else{
                verificadorLinea=reduccionLinea.charAt(1);
            }       
        }
        //establecemos que modificamos el char a string para validar datos
        String comprobarPunto=Character.toString(verificadorLinea);
        //si es letra ingresa a automata identificador
        if(Character.isLetter(verificadorLinea)){
            Id.inicio_ID(linea, jTextArea2);
            reduccionLinea=linea.substring(movilizar.getCaracteresUsados(), linea.length());
        }//Si es digito ingresamos a posibilidad de numero o digito
        else if(Character.isDigit(verificadorLinea)){
            Numero_o_Decimal.empezar_numero_lexema(linea, jTextArea2);
            reduccionLinea=linea.substring(movilizar.getCaracteresUsados(), linea.length());
        }//Si es +-*/ entre signos parecidos significa que entra a operacion
        else if(comprobarPunto.equals("+")|comprobarPunto.equals("-")|comprobarPunto.equals("*")|comprobarPunto.equals("/")|comprobarPunto.equals("%")){
            Operador_Aritmetico.operadorInicio(reduccionLinea, jTextArea2);
            reduccionLinea=linea.substring(movilizar.getCaracteresUsados(), linea.length());
        }//si es . , ; entre signos parecidos significa que entra a puntuacion 
        else if(comprobarPunto.equals(".")|comprobarPunto.equals(",")|comprobarPunto.equals(";")|comprobarPunto.equals(":")){
            Signo_Puntuacion.puntuacionInicio(linea, jTextArea2);
            reduccionLinea=linea.substring(movilizar.getCaracteresUsados(), linea.length());
        }//si es ( ) [ { entre signos parecidos significa que entramos a agrupacion
        else if(comprobarPunto.equals("(")|comprobarPunto.equals(")")|comprobarPunto.equals("[")|comprobarPunto.equals("]")|comprobarPunto.equals("{")|comprobarPunto.equals("}")){
            Signo_Agrupacion.agrupacionInicio(linea, jTextArea2);
            reduccionLinea=linea.substring(movilizar.getCaracteresUsados(), linea.length());
        }else{
            try {
                //estructuramos que si haya error y modificamos datos
                movilizar.setCadenaUsada(Character.toString(verificadorLinea));
                movilizar.setCaracteresUsados(movilizar.getCaracteresUsados()+1);
                cargarError.cargarReporte();
                movilizar.setCondiconalError(1);
                //señalizaos error
                jTextArea2.setText(jTextArea2.getText()+"------------Error------------ al usar "+movilizar.getCadenaUsada()+"\n");
                reduccionLinea=linea.substring(movilizar.getCaracteresUsados(), linea.length());
            } catch (IOException ex) {
                Logger.getLogger(CodigoCondicionalRepetidoAutomata.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CodigoCondicionalRepetidoAutomata.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //modificamos valores iniciales al recargar este método
        instanciadores.setLinea(linea);
        instanciadores.setReduccionLinea(reduccionLinea);
        instanciadores.setVerificadorLinea(verificadorLinea);
    }
}
