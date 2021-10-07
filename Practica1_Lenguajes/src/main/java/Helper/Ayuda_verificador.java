/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

/**
 *
 * @author alexis
 */
public class Ayuda_verificador {
    String linea;
     String Cantidad_linea;
   // nos serviara como auxiliar para ver el tamanio
     
     char verificadorLinea;
    int caracteresUsados;
    public static Ayuda_verificador instanciadores;
 
    public Ayuda_verificador(String linea, String reduccionLinea, char verificadorLinea, int caracteresUsados) {
        this.linea = linea;
        this.Cantidad_linea = reduccionLinea;
        this.verificadorLinea = verificadorLinea;
        this.caracteresUsados = caracteresUsados;
    }

    public Ayuda_verificador() {
    }
    
    
    
    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public char getVerificadorLinea() {
        return verificadorLinea;
    }

    public void setVerificadorLinea(char verificadorLinea) {
        this.verificadorLinea = verificadorLinea;
    }

    
    public String getReduccionLinea() {
        return Cantidad_linea;
    }

    public void setReduccionLinea(String reduccionLinea) {
        this.Cantidad_linea = reduccionLinea;
    }

    public int getCaracteresUsados() {
        return caracteresUsados;
    }

    public void setCaracteresUsados(int caracteresUsados) {
        this.caracteresUsados = caracteresUsados;
    }
    public static void INIcio_lexemas_analisis_manejador(){
         instanciadores= new Ayuda_verificador("","",' ',0);
    }
}
