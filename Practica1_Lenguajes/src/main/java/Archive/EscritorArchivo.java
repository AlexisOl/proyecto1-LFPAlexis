/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archive;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
/**
 *
 * @author alexis
 */

public class EscritorArchivo {


    
    // metodo guardar
   public static void guardar(JTextArea textArea, File archivo) throws IOException{
        File file = archivo;

        if (file.createNewFile()) {
        } else {
            file.delete();
            file.createNewFile();
        }
        String source = textArea.getText();
        FileWriter fileWriter = new FileWriter(file, false);
        fileWriter.write(source);
        fileWriter.close();
    }
}
