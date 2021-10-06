/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import Interfazes.Analizador;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

/**
 *
 * @author nroda
 */
public class LectorArchivo {
    
    private static String ruta = "";
    
    //Lee y proyecta el archivo en el text area
    public static void leerArchivo(String ruta, JTextArea area) throws FileNotFoundException, IOException{
        File archivo = new File(ruta);
        if (archivo.exists()) {
            BufferedReader leer = new BufferedReader( new FileReader(archivo));
            int caracter;
            String linea = "";
            caracter = leer.read();
            while(caracter != -1){
                linea += (char)caracter;
                caracter = leer.read();
            }
            area.setText(linea);
            leer.close();
        }
    }
    
    //Guarda en el archivo abierto lo que se edito en el text area
    public static void guardarCambios(JTextArea area){
        try {
            String contenido = area.getText();
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void buscarPalabra(String ruta, JTextArea area, String palabra) throws FileNotFoundException, IOException{
        int longitud = palabra.length();
        File archivo = new File(ruta);
        if (archivo.exists()) {
            BufferedReader leer = new BufferedReader( new FileReader(archivo));
            int caracter;
            String linea = "";
            caracter = leer.read();
            while(caracter != -1){
                for (int i = 0; i < longitud; i++) {
                    if (caracter == palabra.charAt(i)) {
                        
                    }
                }
                linea += (char)caracter;
                caracter = leer.read();
            }
            area.setText(linea);
        }
    }
    
    //Setter y Getter

    public static String getRuta() {
        return ruta;
    }

    public static void setRuta(String ruta) {
        LectorArchivo.ruta = ruta;
    }
    
}
