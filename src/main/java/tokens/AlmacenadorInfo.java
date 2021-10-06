/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokens;

import java.util.ArrayList;

/**
 *
 * @author nroda
 */
public class AlmacenadorInfo {
    
    private static ArrayList<ArrayList> datosTabla = new ArrayList<ArrayList>();
    
    //Metodo que agrega la informacion al array
    public static void agregarInformacion(String tipo, String lexema, int fila, int columna){
        ArrayList datos = new ArrayList();
        datos.add(tipo);
        datos.add(lexema);
        datos.add(fila);
        datos.add(columna);
        datosTabla.add(datos);
    }
    
    //Getter y Setter

    public static ArrayList<ArrayList> getDatosTabla() {
        return datosTabla;
    }

    public static void setDatosTabla(ArrayList<ArrayList> datosTabla) {
        AlmacenadorInfo.datosTabla = datosTabla;
    }

    
    
}
