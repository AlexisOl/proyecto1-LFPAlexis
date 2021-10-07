/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Construccion;
import static Helper.Helper_movimiento.movilizar;
import Reportes_Objetos.CrearLexema;
import Model.Lexemas_model;
import Reportes_Objetos.CrearError;
import static JFrame.frame_principal.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author alexis
 */
public class CargarLexema {
    public ArrayList<Lexemas_model> cargarLexema() throws FileNotFoundException,IOException,ClassNotFoundException{
        //estrucamos array list para recuento lexema
        int verificarExistencia=0;
        //definimos los espacios que ocupara en nuestro error al ser creado
        String lexema=movilizar.getCadenaUsada()+"";
        String token=movilizar.getTokenProviniente();
        //identificamos que si ya existe el lexema en lugar de ponerlo de nuevo se sume
        for (int i = 0; i < lexemaLista.size(); i++) {
            if (lexemaLista.get(i).getLexema().equals(lexema)) {
                lexemaLista.get(i).setCantidad(lexemaLista.get(i).getCantidad()+1);
                verificarExistencia=1;
            }  
        }
        //indicamos que si no existe entonces le asignamos valor 1
        if(verificarExistencia==0){
            String espacio[]={lexema,token,"1"};
            Lexemas_model lexemas = CrearLexema.crearLexema(espacio);
            lexemaLista.add(lexemas);//agreagamos un nuevo lexema
        }

        return lexemaLista;
    }
}
