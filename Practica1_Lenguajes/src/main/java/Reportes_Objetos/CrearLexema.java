/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes_Objetos;

import Model.Lexemas_model;

/**
 *
 * @author alexis
 */
public class CrearLexema {
    public static Lexemas_model crearLexema(String[] Array){
   
        Lexemas_model lexema=null;

        lexema= new Lexemas_model(Array[0],
                                                            Array[1],
                                                            Integer.parseInt(Array[2]));
        return lexema;
    }
}
