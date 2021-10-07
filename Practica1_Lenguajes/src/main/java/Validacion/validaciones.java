/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validacion;

/**
 *
 * @author alexis
 */
public class validaciones {
    
    
    public static boolean esEspacio(char caracter){
    try {
            char text = caracter;
            if (Character.isWhitespace(text)){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean esNumero(char caracter ){
        try {
            char text = caracter;
            if (Character.isDigit(text)){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean esLetra(char caracter){
        try {
            char text = caracter;
            if (Character.isLetter(text)) {
                 return true;
            } else {
                return false;
            }    
             
        } catch (Exception e) {
            return false;
        }
    }
      public static boolean esPunto(char caracter){
        try {
            char text = caracter;
            if (text =='.') {
                 return true;
            } else {
                return false;
            }    
             
        } catch (Exception e) {
            return false;
        }
    }
       public static boolean esAritmetico(char caracter){
        try {
            char text = caracter;
            if (text == '+' || text == '-'|| text == '*'||
                text == '/' || text == '%') {
                 return true;
            } else {
                return false;
            }    
             
        } catch (Exception e) {
            return false;
        }
    }
         public static boolean esAgrupacion(char caracter){
        try {
            char text = caracter;
            if  (text == '(' || text == ')' ||
         text == '[' || text == ']' ||
         text == '{'|| text == '}')  {
                 return true;
            } else {
                return false;
            }    
             
        } catch (Exception e) {
            return false;
        }
    }
         
    public static boolean esPuntuacion(char caracter){
        try {
            char text = caracter;
            if  (text == '.' || text == ',' || text == ';'|| text == ':')  {
                 return true;
            } else {
                return false;
            }    
             
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean esPuntuacion_sinPunto(char caracter){
        try {
            char text = caracter;
            if  (text == ',' || text == ';'|| text == ':')  {
                 return true;
            } else {
                return false;
            }    
             
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean esSalto_de_Linea(char caracter) {
         try {
            char text = caracter;
            if  (text == '\n')  {
                 return true;
            } else {
                return false;
            }    
             
        } catch (Exception e) {
            return false;
        }
    }
   public static boolean esEspacio_de_Linea(char caracter) {
         try {
            char text = caracter;
            if  (text == ' ')  {
                 return true;
            } else {
                return false;
            }    
             
        } catch (Exception e) {
            return false;
        }
    }
      
}
