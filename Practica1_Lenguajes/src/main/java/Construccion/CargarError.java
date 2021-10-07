/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Construccion;
import static Helper.Helper_movimiento.movilizar;
import Model.Errores;
import Reportes_Objetos.CrearError;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import static JFrame.frame_principal.ErrorLista;
/**
 *
 * @author alexis
 */
public class CargarError {
    public ArrayList<Errores> cargarReporte() throws FileNotFoundException,IOException,ClassNotFoundException{
        String fila=movilizar.getFila()+"";
        String columna=movilizar.getCantidad()+"";
        String espacio[]={movilizar.getCadenaUsada(),fila,columna};
        Errores error = CrearError.crearError(espacio);
        
        
        ErrorLista.add(error);// se agrega al arraylist
        return ErrorLista;
    }
}
