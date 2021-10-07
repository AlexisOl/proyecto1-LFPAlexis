/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes_Objetos;

/**
 *
 * @author alexis
 */
public class CrearToken {
    public static TokenreporteController crearToken(String[] Array){
        TokenreporteController token=null;
      
        token= new TokenreporteController(Array[0],
                                                                    Array[1],
                                                                    Integer.valueOf(Array[2]),
                                                                    Integer.valueOf(Array[3]));
        return token;
    }
}
