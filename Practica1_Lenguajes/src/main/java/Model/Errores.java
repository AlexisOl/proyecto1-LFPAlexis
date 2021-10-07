/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author alexis
 */
public class Errores {
    private String Error;
    private int fila;
    private int columna;
    
    
    public Errores(String cadenaError, int fila, int columna) {
        this.Error = cadenaError;
        this.fila = fila;
        this.columna = columna;
    }

    public String getCadenaError() {
        return Error;
    }

    public void setCadenaError(String cadenaError) {
        this.Error = cadenaError;
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
}
