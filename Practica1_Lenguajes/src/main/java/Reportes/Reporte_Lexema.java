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
public class Reporte_Lexema {
    private  String token;
    private String lexema;
    private int cantidad_de_veces;

    public Reporte_Lexema(String token, String lexema, int cantidad_de_veces) {
        this.token = token;
        this.lexema = lexema;
        this.cantidad_de_veces = cantidad_de_veces;
    }

    
    
    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getCantidad_de_veces() {
        return cantidad_de_veces;
    }

    public void setCantidad_de_veces(int cantidad_de_veces) {
        this.cantidad_de_veces = cantidad_de_veces;
    }
    
    
    
}
