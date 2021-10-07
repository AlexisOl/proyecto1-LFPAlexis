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
       
        int cantidad=0;
  
        String lexema=movilizar.getCadenaUsada()+"";
        String token=movilizar.getTokenProviniente();
        for (int i = 0; i < lexemaLista.size(); i++) {
            if (lexemaLista.get(i).getLexema().equals(lexema)) {
                lexemaLista.get(i).setCantidad(lexemaLista.get(i).getCantidad()+1);
                cantidad=1;
            }  
        }

        if(cantidad==0){
            String espacio[]={lexema,token,"1"};
            Lexemas_model lexemas = CrearLexema.crearLexema(espacio);
            lexemaLista.add(lexemas);//agreagamos a la lista
        }

        return lexemaLista;
    }
}
