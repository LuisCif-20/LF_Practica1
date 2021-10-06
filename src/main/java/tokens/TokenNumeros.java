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
public class TokenNumeros {

    private int[][] matrizTransicion = new int[4][2];

    //constructor
    public TokenNumeros() {
        //Estado S0-->0, Estado S1-->1, Estado S2-->2, Estado S3-->3
        //Digito -->[0], Punto -->[1]
        //No pertenece --> -1
        matrizTransicion[0][0] = 1;
        matrizTransicion[0][1] = -1;
        matrizTransicion[1][0] = 1;
        matrizTransicion[1][1] = 2;
        matrizTransicion[2][0] = 3;
        matrizTransicion[2][1] = -1;
        matrizTransicion[3][0] = 3;
        matrizTransicion[3][1] = -1;
    }

    //Verifica su alfabeto
    public int analizarAlfabeto(char caracter) {
        int respuesta = -1;
        if (Character.isDigit(caracter)) {
            respuesta = 0;
        } else {
            if (caracter == '.') {
                respuesta = 1;
            }
        }
        return respuesta;
    }

    //Controla las transicion de la palabra
    public int controlarTransiciones(int estadoActual, int caracterIngresado) {
        int estadoSiguiente = -1;
        if (caracterIngresado >= 0 && caracterIngresado <= 1) {
            estadoSiguiente = matrizTransicion[estadoActual][caracterIngresado];
        }
        return estadoSiguiente;
    }

    //Determina si es un tpken de tipo entero o decimal o no lo es
    public void determinarToken(String palabra, int linea, int columna) {
        int posicionPalabra = 0;
        String palabraError = "";
        int estadoActual = 0;
        while (posicionPalabra < palabra.length()) {
            char temporal = palabra.charAt(posicionPalabra);
            palabraError += temporal;
            int estadoTemporal = controlarTransiciones(estadoActual, analizarAlfabeto(temporal));
            estadoActual = estadoTemporal;
            if (estadoActual == -1) {
                break;
            }
            posicionPalabra++;
        }
        if (estadoActual == 1) {
            AlmacenadorInfo.agregarInformacion("Entero", palabra, linea, columna);
        } else if (estadoActual == 3) {
            AlmacenadorInfo.agregarInformacion("Decimal", palabra, linea, columna);

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
