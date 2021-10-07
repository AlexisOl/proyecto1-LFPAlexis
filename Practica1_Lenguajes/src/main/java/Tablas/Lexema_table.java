/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import Model.Lexemas_model;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexis
 */
public class Lexema_table {
    
    public static void lexema_table(ArrayList<Lexemas_model> lexema_datos,JTable table) {
      
        DefaultTableModel modeloTabla = new DefaultTableModel();
        table.setModel(modeloTabla);

        modeloTabla.addColumn("Lexema");
        modeloTabla.addColumn("Token");
        modeloTabla.addColumn("Cantidad");
  
        for (Lexemas_model lexemas : lexema_datos) {
            modeloTabla.addRow(new Object[]{lexemas.getLexema(),lexemas.getToken(),lexemas.getCantidad()});
        }
    }
}
