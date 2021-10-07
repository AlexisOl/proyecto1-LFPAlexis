/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Tokens.Tipos;

/**
 *
 * @author alexis
 */
public class Movimiento {
    private int fila;
    private int columna;
    private int lugarError;
    private String lexema;
    private String token;
    private int espacio_Texto;
    private Tipos tipoToken;
    private int cantidad_Lexemas;
public static Movimiento moverse;

    public Movimiento(int fila, int columna, int lugarError, String lexema, String token, int espacio_Texto) {
        this.fila = fila;
        this.columna = columna;
        this.lugarError = lugarError;
        this.lexema = lexema;
        this.token = token;
        this.espacio_Texto = espacio_Texto;
    }

    public Movimiento(int fila, int columna, int lugarError, String lexema, String token, int espacio_Texto, Tipos tipoToken, int cantidad_Lexemas) {
        this.fila = fila;
        this.columna = columna;
        this.lugarError = lugarError;
        this.lexema = lexema;
        this.token = token;
        this.espacio_Texto = espacio_Texto;
        this.tipoToken = tipoToken;
        this.cantidad_Lexemas = cantidad_Lexemas;
    }

    public Movimiento() {
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

    public int getLugarError() {
        return lugarError;
    }

    public void setLugarError(int lugarError) {
        this.lugarError = lugarError;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getEspacio_Texto() {
        return espacio_Texto;
    }

    public void setEspacio_Texto(int espacio_Texto) {
        this.espacio_Texto = espacio_Texto;
    }

    public Tipos getTipoToken() {
        return tipoToken;
    }

    public void setTipoToken(Tipos tipoToken) {
        this.tipoToken = tipoToken;
    }

    public int getCantidad_Lexemas() {
        return cantidad_Lexemas;
    }

    public void setCantidad_Lexemas(int cantidad_Lexemas) {
        this.cantidad_Lexemas = cantidad_Lexemas;
    }
    
    
    
    
    
    
    
}
