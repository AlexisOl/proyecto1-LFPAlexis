/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import Reportes_Objetos.ReporteTokensObjeto;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexis
 */
public class tokens_Table {

    public static void Token_Table(ArrayList<ReporteTokensObjeto> token_datos,JTable table) {
      
        DefaultTableModel modeloTabla = new DefaultTableModel();
        table.setModel(modeloTabla);
     
        modeloTabla.addColumn("Token");
        modeloTabla.addColumn("Lexema");
        modeloTabla.addColumn("Fila");
        modeloTabla.addColumn("Columna");
    
        
        // ingreso de la tabla
        for (ReporteTokensObjeto token : token_datos) {
            modeloTabla.addRow(new Object[]{token.getNombreToken(),token.getLexema(),token.getFila(),
                token.getColumna()});
        }
    }
}
