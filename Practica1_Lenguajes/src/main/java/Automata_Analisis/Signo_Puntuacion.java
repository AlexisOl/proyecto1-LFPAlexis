/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Automata_Analisis;

import static Helper.Helper_movimiento.movilizar;
import static JFrame.frame_principal.cargarError;
import static JFrame.frame_principal.cargarLexema;
import static JFrame.frame_principal.cargarToken;
import Validacion.validaciones;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author alexis
 */
public class Signo_Puntuacion {
   
    static int[][] matrizPuntuacion=new int [2][4];
    String LexemaEnsamblado="";
    boolean lectura=true;
    boolean reporte = false;
    
    int contador = 0;
    int estado_Actual=0;
    int estado_siguiente=0; 
    int resultado=0;
    char [] textToChar;
    {
        matrizPuntuacion[0][0]=1;
        matrizPuntuacion[0][1]=1;
        matrizPuntuacion[0][2]=1;
        matrizPuntuacion[0][3]=1;
        matrizPuntuacion[1][0]=1;
        matrizPuntuacion[1][1]=1;
        matrizPuntuacion[1][2]=1;
        matrizPuntuacion[1][3]=1;
    }
 

    public static void puntuacionInicio(String linea,JTextArea movimiento){
        Signo_Puntuacion puntuacion = new Signo_Puntuacion();
        puntuacion.inicializacion(linea,movimiento);
        
    }
    public int Next(int estadoPasable,int caracter){
        resultado=-1;
        if(caracter>=0&&caracter<4){
            resultado = matrizPuntuacion[estadoPasable][caracter];
        }   
        return resultado;
    }
    public int comprobarExistencia(char caracter){
        resultado=-1;
       if (validaciones.esPuntuacion(caracter)) {
        if(caracter==('.')){
                resultado=0;
        }else if(caracter==','){
                resultado=1;
        }else if(caracter==';'){
                resultado=2;
        }else if(caracter==':'){
                resultado=3;
        } 
       }
       
        return resultado;
    }
    public void inicializacion(String linea,JTextArea movimiento){
        //reseteamos variables
        movilizar.setHayEspacio(0);
        reporte=false;
        LexemaEnsamblado="";
        contador=0;
        textToChar=linea.toCharArray();
        
        
        
        estado_Actual=0;
        while((lectura)&&contador<linea.length()&&resultado!=4){
            if(Character.isSpaceChar(textToChar[contador])){
                if(contador==0){
                }else{
                    lectura=false;
                    movilizar.setHayEspacio(1);
                }
            }else{
                estado_siguiente= Next(estado_Actual,comprobarExistencia(textToChar[contador]));
                movimiento.setText(movimiento.getText()+"Me movi de estado --> "+estado_Actual+" hacia --> "+estado_siguiente+" con caracter: "+textToChar[contador]+"\n");
                estado_Actual=estado_siguiente;
        }
        if(resultado==4){
            movimiento.setText(movimiento.getText()+"Error en el lexema \n");
            reporte=true;
        }  
        LexemaEnsamblado=LexemaEnsamblado+Character.toString(textToChar[contador]);
        
        contador++;
        }
        
        
        
        
        /*tablas ingreso  
        */
        movilizar.setColumna(contador);
        movilizar.setCaracteresUsados(movilizar.getCaracteresUsados()+contador);
        movilizar.setCadenaUsada(LexemaEnsamblado.replaceAll(" ", ""));
        if(reporte==true){
            try {
                //ingreso erro?
                cargarError.cargarReporte();
                movilizar.setCondiconalError(1);
            } catch (IOException ex) {
                Logger.getLogger(Id.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Id.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            movilizar.setTokenProviniente("Puntuacion");
            try {
            /*
                ingreso de lexemas normales
                */
                cargarLexema.cargarLexema();
                cargarToken.cargarToken();
            } catch (IOException ex) {
                Logger.getLogger(Id.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Id.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
