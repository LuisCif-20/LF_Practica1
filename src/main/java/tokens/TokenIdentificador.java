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
public class TokenIdentificador {

    private int[][] matrizTransicion = new int[2][2];

    //Constructor
    public TokenIdentificador() {
        //Estado S0 --> 0, Estado S1 --> 1
        //Letra --> [0], Digito -->[1]
        //No pertenece --> 2
        matrizTransicion[0][0] = 1;
        matrizTransicion[0][1] = 2;
        matrizTransicion[1][0] = 1;
        matrizTransicion[1][1] = 1;
    }

    //Verifica el alfabeto
    public int analizarAlfabeto(char caracterIngresado) {
        int respuesta = 2;
        if (Character.isLetter(caracterIngresado)) {
            respuesta = 0;
        } else if (Character.isDigit(caracterIngresado)) {
            respuesta = 1;
        }
        return respuesta;
    }

    //Controla las transiciones en la matriz
    public int controlarTransiciones(int estadoActual, int caracterIngresado) {
        int siguienteEstado = 2;
        if (caracterIngresado >= 0 && caracterIngresado <= 1) {
            siguienteEstado = matrizTransicion[estadoActual][caracterIngresado];
        }
        return siguienteEstado;
    }

    //Determina si es un identificador o no
    public void esId(String palabra, int linea, int columna) {
        int estadoActual = 0;
        int posicionPalabra = 0;
        while (posicionPalabra < palabra.length()) {
            char temporal = palabra.charAt(posicionPalabra);
            int estadoTemporal = controlarTransiciones(estadoActual, analizarAlfabeto(temporal));
            estadoActual = estadoTemporal;
            if (estadoActual == 2) {
                break;
            }
            posicionPalabra++;
        }
        if (estadoActual == 1) {
            AlmacenadorInfo.agregarInformacion("Identificador", palabra, linea, columna);
        } else {
            if (posicionPalabra > 0) {
                AlmacenadorInfo.agregarInformacion("Error", palabra, linea, columna+posicionPalabra);
            }
        }
    }

    //Separa la palabra del error y reinicia
    public String separarPalabraError(String palabra, int posicion) {
        String error = "";
        for (int i = 0; i < posicion + 1; i++) {
            error += palabra.charAt(i);
        }
        return error;
    }

    //Separar palabra a evaluar
    public String separarPalabra(String palabra, int posicion) {
        String texto = "";
        for (int i = posicion + 1; i < palabra.length(); i++) {
            texto += palabra.charAt(i);
        }
        return texto;
    }

}
