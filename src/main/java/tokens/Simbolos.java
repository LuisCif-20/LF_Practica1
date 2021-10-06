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
public class Simbolos {

    //Constructor
    public Simbolos() {
    }

    //Verifica si es un simbolo
    public boolean esSimbolo(char caracter, int fila, int columna) {
        boolean esSimbolo = false;
        if (this.esAgrupador(caracter, fila, columna) | this.esOperador(caracter, fila, columna)) {
            esSimbolo = true;
        } else if (this.esPuntuador(caracter, fila, columna)) {
            esSimbolo = true;
        }
        return esSimbolo;
    }

    //Verifica si es un operador
    public boolean esOperador(char caracter, int fila, int columna) {
        boolean esOperador = false;
        if (caracter == '+' | caracter == '-') {
            esOperador = true;
        } else if (caracter == '*' | caracter == '/') {
            esOperador = true;
        } else if (caracter == '%') {
            esOperador = true;
        }
        if (esOperador) {
            AlmacenadorInfo.agregarInformacion("Operador", caracter + "", fila, columna);
        }
        return esOperador;
    }

    //Verifica si es un signo de puntuacion
    public boolean esPuntuador(char caracter, int fila, int columna) {
        boolean esPuntuador = false;
        if (caracter == '.' | caracter == ',') {
            esPuntuador = true;
        } else if (caracter == ':' | caracter == ';') {
            esPuntuador = true;
        }
        if (esPuntuador) {
            AlmacenadorInfo.agregarInformacion("Signo de Puntuacion", caracter + "", fila, columna);
        }
        return esPuntuador;
    }

    //Verifica si es un signo de agrupacion
    public boolean esAgrupador(char caracter, int fila, int columna) {
        boolean esAgrupador = false;
        if (caracter == '{' | caracter == '}') {
            esAgrupador = true;
        } else if (caracter == '(' | caracter == ')') {
            esAgrupador = true;
        } else if (caracter == '[' | caracter == ']') {
            esAgrupador = true;
        }
        if (esAgrupador) {
            AlmacenadorInfo.agregarInformacion("Signo de Agrupacion", caracter + "", fila, columna);
        }
        return esAgrupador;
    }

}
