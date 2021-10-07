/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Tokens.Tipos;

/**
 *
 * @author alexis
 */
public class Lexemas_model {
   private String lexema;
     private  String      token;
    private int cantidad;
    private Tipos tipo;
    
    public Lexemas_model(String lexema, String token, int cantidad) {
        this.lexema = lexema;
        this.token = token;
        this.cantidad = cantidad;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
