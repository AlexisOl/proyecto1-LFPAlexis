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
public class Helper_movimiento {
    //creamos variables
      private int fila;
    private int columna;
    private int caracteresUsados;
    private int condiconalError;
    private int hayEspacio;
    private String Lexema_completo;
    private String tokenProviniente;
    public static Helper_movimiento movilizar;

    public Helper_movimiento(int fila, int columna, int caracteresUsados, int condiconalError, int hayEspacio, String cadenaUsada, String tokenProviniente) {
        this.fila = fila;
        this.columna = columna;
        this.caracteresUsados = caracteresUsados;
        this.condiconalError = condiconalError;
        this.hayEspacio = hayEspacio;
        this.Lexema_completo = cadenaUsada;
        this.tokenProviniente = tokenProviniente;
    }

    public Helper_movimiento(int fila, int columna, int caracteresUsados) {
        this.fila = fila;
        this.columna = columna;
        this.caracteresUsados = caracteresUsados;
    }

    public Helper_movimiento() {
    }
   

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getCaracteresUsados() {
        return caracteresUsados;
    }

    public void setCaracteresUsados(int caracteresUsados) {
        this.caracteresUsados = caracteresUsados;
    }
    
    public String getCadenaUsada() {
        return Lexema_completo;
    }

    public void setCadenaUsada(String cadenaUsada) {
        this.Lexema_completo = cadenaUsada;
    }

    public String getTokenProviniente() {
        return tokenProviniente;
    }

    public void setTokenProviniente(String tokenProviniente) {
        this.tokenProviniente = tokenProviniente;
    }

    public int getCondiconalError() {
        return condiconalError;
    }

    public void setCondiconalError(int condiconalError) {
        this.condiconalError = condiconalError;
    }

    public int getHayEspacio() {
        return hayEspacio;
    }

    public void setHayEspacio(int hayEspacio) {
        this.hayEspacio = hayEspacio;
    }
    
    public static void Inicio_Movimiento_linea(){
         movilizar= new Helper_movimiento(0,0,0,0,0,"","");
    }
}
