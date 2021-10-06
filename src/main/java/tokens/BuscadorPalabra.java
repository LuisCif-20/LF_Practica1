/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokens;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

/**
 *
 * @author nroda
 */
public class BuscadorPalabra {

    private String palabraBuscada;

    //Constructor
    public BuscadorPalabra(String palabraBuscada) {
        this.palabraBuscada = palabraBuscada;
    }

    public void buscarPalabra(String texto, JTextArea area) throws BadLocationException {
        DefaultHighlighter.DefaultHighlightPainter subrayar = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
        Highlighter color = area.getHighlighter();
        color.removeAllHighlights();
        int posicion = 0;
//        int i = 0;
//        while (i < texto.length()) {
//            String temporal = "";
//            if (Character.compare(texto.charAt(i), this.palabraBuscada.charAt(0)) == 0) {
//                for (int j = 0; j < this.palabraBuscada.length(); j++) {
//                    if (Character.compare(texto.charAt(i), this.palabraBuscada.charAt(j)) == 0) {
//                        temporal += texto.charAt(i);
//                        if (temporal.equals(this.palabraBuscada)) {
//                            color.addHighlight(i-1, i + this.palabraBuscada.length()-1, subrayar);
//                            break;
//                        }
//                        i++;
//
//                    } else {
//                        j = this.palabraBuscada.length();
//                    }
//                }
//            }
//            i++;
//        }

        for (int i = 0; i < texto.length(); i++) {
            String temporal = "";
            int contTemporal = i;//Guarda el valor de i con el que entra al bucle para comparar valores
            for (int j = 0; j < this.palabraBuscada.length(); j++) {
                //Si sus valores son iguales entra a las verificadiones
                if (Character.compare(texto.charAt(i), this.palabraBuscada.charAt(j)) == 0) {
                    //Forma una palabra con los caracteres coincididos
                    temporal += texto.charAt(i);
                    //compara si la palabra formada de caracteres es igual a la ingresada
                    if (temporal.equals(this.palabraBuscada)) {
                        //Pinta desde el valor con el que i entro al bucle hasta el tamaño de la palabra
                        color.addHighlight(contTemporal, contTemporal + this.palabraBuscada.length(), subrayar);
                        break;
                    }
                    i++;
                   
                } else {
                    //Si no son iguales sale del bucle interior
                    j = this.palabraBuscada.length();
                }
            }
        }
    }
}
