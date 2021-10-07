/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tokens;

/**
 *
 * @author alexis
 * objeto de Token, el cual esta compuesto del tipo de token, un mensaje, numero de linea y el lexema
 */
public class Token {
   
    private Tipos tipo;
    private String mensaje;
    private int No_Linea;
    private int No_Columna;
    private String lexema;
    private int cantidad;
    private String nombre;

    public Token(Tipos tipo, int No_Linea, int No_Columna, String lexema, String nombre) {
        this.tipo = tipo;
        this.No_Linea = No_Linea;
        this.No_Columna = No_Columna;
        this.lexema = lexema;
        this.nombre = nombre;
    }
    
    
    
    
    public Token(Tipos tipo, String mensaje, int No_Linea, String lexema) {
        this.tipo = tipo;
        this.mensaje = mensaje;
        this.No_Linea = No_Linea;
        this.lexema = lexema;
    }

    public Token(int No_Linea, int No_Columna, String lexema, String nombre) {
        this.No_Linea = No_Linea;
        this.No_Columna = No_Columna;
        this.lexema = lexema;
        this.nombre = nombre;
    }

    public Token(int No_Linea, int No_Columna, String lexema) {
        this.No_Linea = No_Linea;
        this.No_Columna = No_Columna;
        this.lexema = lexema;
    }
    
    

    public Token(String nombre, String lexema) {
        this.nombre = nombre;
        this.lexema = lexema;
    }

    
   

    
    public Tipos getTipo() {
        return tipo;
    }

    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setNo_Linea(int No_Linea) {
        this.No_Linea = No_Linea;
    }

    public int getNo_Linea() {
        return No_Linea;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getNo_Columna() {
        return No_Columna;
    }

    public void setNo_Columna(int No_Columna) {
        this.No_Columna = No_Columna;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

 
    
}
