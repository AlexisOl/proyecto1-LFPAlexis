/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Construccion;
import static Helper.Helper_movimiento.movilizar;
import Reportes_Objetos.CrearToken;
import Reportes_Objetos.ReporteTokensObjeto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import static JFrame.frame_principal.Tokenlista;

/**
 *
 * @author alexis
 */
public class CargarToken {
    public ArrayList<ReporteTokensObjeto> cargarToken() throws FileNotFoundException,IOException,ClassNotFoundException{
        //definimos los espacios que ocupara en nuestro error al ser creado ycreamos array para reporte token
        int procesoReduccionColumna=movilizar.getCaracteresUsados()-movilizar.getCadenaUsada().length();//indicamos operacion para establecer posicion de columna
        //convertimos valores a strings
        String nombreToken=movilizar.getTokenProviniente();
        String lexema=movilizar.getCadenaUsada();
        String fila=movilizar.getFila()+"";
        String columna=procesoReduccionColumna+"";
        //si la columna fuera 0 significa que es columna 1
        if (columna.equals("0")) {
            columna="1";
        }
        String espacio[]={nombreToken,lexema,fila,columna};
        ReporteTokensObjeto tokens = CrearToken.crearToken(espacio);//lenamos espacios en reporte token
        Tokenlista.add(tokens);//agreagamos un nuevo token
        return Tokenlista;
    }
}
