/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes_Objetos;

import Model.Errores;

/**
 *
 * @author alexis
 */
public class CrearError {
    public static Errores crearError(String[] espacio){
        //Creamos un retorno de tipo reporte error con parametros tipo arreglo
        Errores error=null;
        //creamos reporte error con datos y convertimos string a int        
        error= new Errores(espacio[0],Integer.parseInt(espacio[1]),Integer.parseInt(espacio[2]));
        return error;
    }
    
}
