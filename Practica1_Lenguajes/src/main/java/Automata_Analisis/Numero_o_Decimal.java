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
public class Numero_o_Decimal {
    
    static int[][] matrizNumero=new int [4][2];
    boolean continuar=true;
    int caracter=0; 
     int Contador = 0;
     
     //variables de estados
     int estado_Actual=0;
     int estado_siguiente=0;
     
     int resultado=0;
     boolean reporte = false;
    char [] textToChar;
    String numeroDecimalTotal="";
    {
        matrizNumero[0][0]=1;
        matrizNumero[0][1]=4;
        matrizNumero[1][0]=1;
        matrizNumero[1][1]=2;
        matrizNumero[2][0]=3;
        matrizNumero[2][1]=4;
        matrizNumero[3][0]=3;
        matrizNumero[3][1]=4;
    }
  
    
    public static void empezar_numero_lexema(String linea,JTextArea movimiento){
        //incializamos  y creamos valores
        Numero_o_Decimal numeroDecimal = new Numero_o_Decimal();
        numeroDecimal.inicializacion(linea,movimiento);
        
    }
    public int next(int estadoPasable,int caracter){
        resultado=4;
       
        
        
        if(caracter>=0&&caracter<=1){
            resultado = matrizNumero[estadoPasable][caracter];
        }   
        return resultado;
    }
    
    public int Tipo_Simbolo(char caracter){
        resultado=4;
        if (validaciones.esNumero(caracter)) {
            resultado=0;
        } else if (validaciones.esPunto(caracter)) {
              if (numeroDecimalTotal.contains(".")) {
                resultado=4;
            }else{
                resultado=1;
            }
        }
      
        return resultado;
    }
    public void inicializacion(String linea,JTextArea movimiento){
        //reseteamos variables
        movilizar.setHayEspacio(0);
        reporte= false;
        numeroDecimalTotal="";
        Contador=0;
        textToChar=linea.toCharArray();//formato matriz
        estado_Actual=0;
        while((continuar)&&Contador<linea.length()&&resultado!=4){
            if(Character.isSpaceChar(textToChar[Contador])){
                //verificammos espacios
                
                if(Contador==0){
                }else{
                    continuar=false;
                    movilizar.setHayEspacio(1);
                }
            }else{
                estado_siguiente= next(estado_Actual,Tipo_Simbolo(textToChar[Contador]));
                //mensajes de Token
                movimiento.setText(movimiento.getText()+"se movio del primer estado:  "+estado_Actual+" al estado: "+estado_siguiente+" con el lexema:"
                        + " "+textToChar[Contador]+"\n");
                estado_Actual=estado_siguiente;
        }
        
        if(resultado==4){
            movimiento.setText(movimiento.getText()+"Error en el lexema \n");
            reporte = true;
        }
        //ensable de cadena
        numeroDecimalTotal=numeroDecimalTotal+Character.toString(textToChar[Contador]);
        
        Contador++;
        }
        String comprobarPunto=Character.toString(textToChar[Contador-1]);
        if(comprobarPunto.equals(".")){
            reporte = true;
        }
       
        //modificamos valores a enviar a tablas
        movilizar.setColumna(Contador);
        movilizar.setCaracteresUsados(movilizar.getCaracteresUsados()+Contador);
        movilizar.setCadenaUsada(numeroDecimalTotal.replaceAll(" ", ""));
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
            //se mira si es decimal o numero
            
            
            if (numeroDecimalTotal.contains(".")) {
                    movilizar.setTokenProviniente("Decimal");
            }else{
                    movilizar.setTokenProviniente("Numero");
            }  
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
