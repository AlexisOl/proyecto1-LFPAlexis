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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
/**
 *
 * @author alexis
 */
public class Signo_Agrupacion {
 
    static int[][] matrizAgrupacion=new int [2][6];
    int Actual_result=0;
    String lexemaEnsamblado="";
 
    boolean lectura=true;
    int caracter=0;
    int contador = 0;
    int estado_Actual=0;
    int estado_siguiente=0;
    
    char [] textToChar;
    boolean reporte = false;
    {
        matrizAgrupacion[0][0]=1;
        matrizAgrupacion[0][1]=1;
        matrizAgrupacion[0][2]=1;
        matrizAgrupacion[0][3]=1;
        matrizAgrupacion[0][4]=1;
        matrizAgrupacion[0][5]=1;
        matrizAgrupacion[1][0]=1;
        matrizAgrupacion[1][1]=1;
        matrizAgrupacion[1][2]=1;
        matrizAgrupacion[1][3]=1;
        matrizAgrupacion[1][4]=1;
        matrizAgrupacion[1][5]=1;
    }
  

    public static void agrupacionInicio(String linea,JTextArea movimiento){
        //incializamos  y creamos valores
        Signo_Agrupacion agrupacion = new Signo_Agrupacion();
        agrupacion.inicio(linea,movimiento);
        
    }

    public int Next(int character, int lexem_Matrix){
         Actual_result=-1;
        if(lexem_Matrix>-1&&lexem_Matrix<6){
            Actual_result = matrizAgrupacion[character][lexem_Matrix];
        }   
        return Actual_result;
    }
    
    public int Tipo_Simbolo(char text) {
        int number_Result=-1;
        if (text == '(') {
            return number_Result = 0;
        } else if( text == ')') {
            return number_Result = 1;
        }else if (text == '[') {
            return number_Result = 2;
        } else if (text == ']') {
            return number_Result = 3;
        }else if  (text == '{'){
        return number_Result = 4;
        } else  if (text == '}'){
        return number_Result =5;
        } else {
            return number_Result = -1;
        } 
    }
    
    
    public void inicio(String linea,JTextArea movimiento){
        //reseteamos variables
        movilizar.setHayEspacio(0);
        reporte=false;
        lexemaEnsamblado="";
        contador=0;
        textToChar=linea.toCharArray();//formato matriz
        estado_Actual=0;
        while((lectura)&&contador<linea.length()&&Actual_result!=6){
            //puede acceder únicamente si cumple con tener letras y estar en el abecedario
            if(Character.isSpaceChar(textToChar[contador])){
                //si tiene espacio finalizamos proceso
                if(contador==0){
                }else{
                    lectura=false;
                    movilizar.setHayEspacio(1);
                }
            }else{
                estado_siguiente= Next(estado_Actual,Tipo_Simbolo(textToChar[contador]));
                // mensaje
                
                movimiento.setText(movimiento.getText()+"se movio del primer estado:  "+estado_Actual+" al estado: "+estado_siguiente+" con el lexema:"
                        + " "+textToChar[contador]+"\n");
                estado_Actual=estado_siguiente;
        }
        if(Actual_result==6){
            //si obtenemos error notificamos y modificamos que acceda a tabla error
            movimiento.setText(movimiento.getText()+"error en el lexema- \n");
            reporte=true;
        }  
        //estructuramos cadena usada
        lexemaEnsamblado=lexemaEnsamblado+Character.toString(textToChar[contador]);
        
        contador++;
        }


        //modificamos valores a enviar a tablas
        movilizar.setColumna(contador);
        movilizar.setCantidad(movilizar.getCantidad()+contador);
        movilizar.setCadenaUsada(lexemaEnsamblado.replaceAll(" ", ""));
        if(reporte==true){
            try {
                //cargamos reporte de error
                cargarError.cargarReporte();
                movilizar.setCondiconalError(1);
            } catch (IOException ex) {
                Logger.getLogger(Id.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Id.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            movilizar.setTokenProviniente("Agrupación");
            try {
                //cargamos reporte tabla lexema y token
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
