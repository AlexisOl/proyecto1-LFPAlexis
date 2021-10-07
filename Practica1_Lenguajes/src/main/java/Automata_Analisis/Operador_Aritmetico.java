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
public class Operador_Aritmetico {
  
    static int[][] matrizAritmetica=new int [2][5];
     //inicializamos variables
    boolean lectura=true;
    int caracter=0; 
    int Contador = 0;
    int estado_actual=0;
    int estado_siguiente=0;
    int resultado=0;
    boolean reporte = false;
    
    char [] textToChar;
    String operadorTotal="";
    {
        matrizAritmetica[0][0]=1;
        matrizAritmetica[0][1]=1;
        matrizAritmetica[0][2]=1;
        matrizAritmetica[0][3]=1;
        matrizAritmetica[0][4]=1;
        matrizAritmetica[1][0]=1;
        matrizAritmetica[1][1]=1;
        matrizAritmetica[1][2]=1;
        matrizAritmetica[1][3]=1;
        matrizAritmetica[1][4]=1;
    }
   

    public static void operadorInicio(String linea,JTextArea movimiento){
        //incializamos  y creamos valores
        Operador_Aritmetico operador = new Operador_Aritmetico();
        operador.inicializacion(linea,movimiento);
        
    }
    public int nextEstado(int estadoPasable,int caracter){
        resultado=5;
        //verificamos caracter menor igual a 4
        if(caracter>=0&&caracter<=4){
            resultado = matrizAritmetica[estadoPasable][caracter];
        }   
        return resultado;
    }
       public int Tipo_Simbolo(char text) {
        int number_Result=-1;
        if (validaciones.esAritmetico(text)) {
        if (text == '+') {
            return number_Result = 0;
        } else if( text == '-') {
            return number_Result = 1;
        }else if (text == '*') {
            return number_Result = 2;
        } else if (text == '%') {
            return number_Result = 3;
        }else if  (text == '/'){
        return number_Result = 4;
        } else {
            return number_Result = -1;
        } 
        } else {
            return number_Result =-1;
        }
        
    }
 
    public void inicializacion(String linea,JTextArea movimiento){
        movilizar.setHayEspacio(0);
        reporte=false;
        operadorTotal="";
        Contador=0;
        textToChar=linea.toCharArray();
       //ingreso y reinicio del proceo de analisis 
       
        estado_actual=0;
        while((lectura)&&Contador<linea.length()&&resultado!=5){
            //ver si esta en el alfabeto
            if(Character.isWhitespace(textToChar[Contador])){
             
                if(Contador==0){
                }else{
                    lectura=false;
                    movilizar.setHayEspacio(1);
                    
                }
            }else{
               
                estado_siguiente= nextEstado(estado_actual,Tipo_Simbolo(textToChar[Contador]));
                //mensajes de tokennn
                
                     movimiento.setText(movimiento.getText()+"se movio del primer estado:  "+estado_actual+" al estado: "+estado_siguiente+" con el lexema:"
                        + " "+textToChar[Contador]+"\n");
                     estado_actual=estado_siguiente;
        }
        if(resultado==5){
         
            movimiento.setText(movimiento.getText()+"Error en el lexema \n");
            reporte=true;
        }  
      
        operadorTotal=operadorTotal+Character.toString(textToChar[Contador]);
        
        Contador++;
        }
        movimiento.setText(movimiento.getText()+"------------ Al usar "+operadorTotal+" ----------\n");
        ///ingreso tables
        movilizar.setColumna(Contador);
        movilizar.setCaracteresUsados(movilizar.getCaracteresUsados()+Contador);
        movilizar.setCadenaUsada(operadorTotal.replaceAll(" ", ""));
        if(reporte==true){
            try {
             
                cargarError.cargarReporte();
                movilizar.setCondiconalError(1);
            } catch (IOException ex) {
                Logger.getLogger(Id.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Id.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            movilizar.setTokenProviniente("Operador");
            try {
              /* ingresa el lexema
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
