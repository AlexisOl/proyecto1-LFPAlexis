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
    public static Lexemas_model crearLexema(String[] espacio){
        //Creamos un retorno de tipo recuento lexema con parametros tipo arreglo
        Lexemas_model lexema=null;
        //creamos reporte lexema con datos y convertimos string a int        
        lexema= new Lexemas_model(espacio[0],espacio[1],Integer.parseInt(espacio[2]));
        return lexema;
    }
}
