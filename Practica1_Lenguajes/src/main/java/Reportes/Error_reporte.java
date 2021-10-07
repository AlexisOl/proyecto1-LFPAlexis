/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

/**
 *
 * @author alexis
 */
public class Error_reporte {
    private String error;
    private int fila;
    private int columna;

    public Error_reporte(String error, int fila, int columna) {
        this.error = error;
        this.fila = fila;
        this.columna = columna;
    }

    
    
    
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
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
