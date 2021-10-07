/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import Model.Errores;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexis
 */
public class Error_Table {
  
    public static void Error_Table(ArrayList<Errores> Error_datos,JTable tabla) {
        
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tabla.setModel(modeloTabla);
        modeloTabla.addColumn("Cadena Error");
        modeloTabla.addColumn("Fila");
        modeloTabla.addColumn("Columna");
      
        
        for (Errores error : Error_datos) {
            modeloTabla.addRow(new Object[]{error.getCadenaError(),error.getFila(),error.getColumna()});
        }
    }
}
