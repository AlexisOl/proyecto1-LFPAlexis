/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Automata_Analisis;

import static Helper.Helper_movimiento.movilizar;
import static JFrame.frame_principal.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author alexis
 */
public class Id {
   
    static int[][] matrizID=new int [2][2];
      boolean lectura=true;
    int caracter=0; 
    int Contador = 0;
    int estado_actual=0;
     int estado_siguiente=0;
     int resultado=0;
      int enviarReporte=0;
      boolean reporte = false;
    char [] textToChar;
    String LexemaEnsamble="";
    {
        matrizID[0][0]=1;
        matrizID[0][1]=-1;
        matrizID[1][0]=1;
        matrizID[1][1]=1;
    }
  
  

    public static void inicio_ID(String linea,JTextArea movimiento){
       
        Id id = new Id();
        id.Analisis_id(linea,movimiento);
        
    }
    public int Next(int estadoPasable,int caracter){
        resultado=3;
       
        if(caracter>=0&&caracter<=1){
            resultado = matrizID[estadoPasable][caracter];
        }   
        return resultado;
    }
    public int Tipo_Simbolo(char caracter){
        resultado=3;
        if(Character.isLetter(caracter)){
                resultado=0;
            }else if(Character.isDigit(caracter)){
                resultado=1;
            }
        return resultado;
    }
    public void Analisis_id(String linea,JTextArea movimiento){
        //reseteamos variables
        movilizar.setHayEspacio(0);
        reporte=false;
        LexemaEnsamble="";
        Contador=0;
        textToChar=linea.toCharArray();//formato matriz
        estado_actual=0;
        while((lectura)&&Contador<linea.length()&&resultado!=3){
       
            if(Character.isSpaceChar(textToChar[Contador])){
                
                if(Contador==0){
                }else{
                    lectura=false;
                    movilizar.setHayEspacio(1);
                }
            }else{
                estado_siguiente= Next(estado_actual,Tipo_Simbolo(textToChar[Contador]));
                movimiento.setText(movimiento.getText()+"se movio del primer estado:  "+estado_actual+" al estado: "+estado_siguiente+" con el lexema:"
                        + " "+textToChar[Contador]+"\n");
                estado_actual=estado_siguiente;
        }
        if(resultado==3){
            movimiento.setText(movimiento.getText()+"Error en el lexema \n");
            reporte=true;
        }  
  
        LexemaEnsamble=LexemaEnsamble+Character.toString(textToChar[Contador]);
        
        Contador++;
        }
        
       //valores a tabla
       
       
       
        movilizar.setColumna(Contador);
        movilizar.setCaracteresUsados(movilizar.getCaracteresUsados()+Contador);
        movilizar.setCadenaUsada(LexemaEnsamble.replaceAll(" ", ""));
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
            movilizar.setTokenProviniente("Identificador");
            try {
                
                
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
