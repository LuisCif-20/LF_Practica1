/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokens;

/**
 *
 * @author nroda
 */
public class DeterminadorToken {

    private int posicion = 0;
    private int conteoLinea = 1;
    int contadorColumna = 0;
    private int posicionEspacio = 0;
    private String textoParaAnalizar;
    Simbolos simbolos = new Simbolos();
    TokenIdentificador id;
    TokenNumeros digito;

    public DeterminadorToken(String textoParaAnalizar) {
        this.textoParaAnalizar = textoParaAnalizar;
        id = new TokenIdentificador();
        digito = new TokenNumeros();
    }

    //Recorre el texto y lo separa con cada espacio
    public void separarTexto() {
        int LineaTemporal = conteoLinea;
        boolean seguirLeyendo = true;
        boolean reiniciarContador = false;
        String palabraTemporal = "";
        while (seguirLeyendo & posicion < this.textoParaAnalizar.length()) {
            contadorColumna++;
            char temporal = this.textoParaAnalizar.charAt(posicion);
            if (Character.isWhitespace(temporal)) {
                if (temporal == '\n') {
                    conteoLinea++;
                    reiniciarContador = true;
                }
                posicionEspacio = posicion + 1;
                seguirLeyendo = false;
            } else {
                if (posicionEspacio == this.posicion && simbolos.esSimbolo(temporal, LineaTemporal, contadorColumna)) {
                    posicionEspacio = posicion + 1;
                    seguirLeyendo = false;
                } else {
                    palabraTemporal += temporal;
                }
            }
            posicion++;
        }
        if (posicion == this.textoParaAnalizar.length()) {
            contadorColumna++;
        }
        id.esId(palabraTemporal, LineaTemporal, contadorColumna - palabraTemporal.length());
        digito.determinarToken(palabraTemporal, LineaTemporal, contadorColumna - palabraTemporal.length());
        if (reiniciarContador) {
            contadorColumna = 0;
        }

    }

    //Getters y Setters
    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getTextoParaAnalizar() {
        return textoParaAnalizar;
    }

    public void setTextoParaAnalizar(String textoParaAnalizar) {
        this.textoParaAnalizar = textoParaAnalizar;
    }

    public int getPosicionEspacio() {
        return posicionEspacio;
    }

    public void setPosicionEspacio(int posicionEspacio) {
        this.posicionEspacio = posicionEspacio;
    }

}
