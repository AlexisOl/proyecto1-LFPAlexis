/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Construccion;
import static Helper.Helper_movimiento.movilizar;
import Reportes_Objetos.CrearToken;
import Reportes_Objetos.TokenreporteController;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import static JFrame.frame_principal.Tokenlista;

/**
 *
 * @author alexis
 */
public class CargarToken {
    public ArrayList<TokenreporteController> cargarToken() throws FileNotFoundException,IOException,ClassNotFoundException{
       int cantidadParcial = movilizar.getCantidad()-movilizar.getCadenaUsada().length();
        int procesoReduccionColumna=cantidadParcial;
        
        String nombreToken=movilizar.getTokenProviniente();
        String lexema=movilizar.getCadenaUsada();
        int fila=movilizar.getFila();
        int columna=procesoReduccionColumna;
        if (columna==0) {
            columna=1;
        }
        String espacio[]={nombreToken,lexema,
            String.valueOf(fila),String.valueOf(columna)};
        
        TokenreporteController tokens = CrearToken.crearToken(espacio);
        Tokenlista.add(tokens);//agreagamos un nuevo token
        return Tokenlista;
    }
}
