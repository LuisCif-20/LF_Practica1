/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lf_practica1;

import java.util.ArrayList;
import tokens.AlmacenadorInfo;
import tokens.DeterminadorToken;

/**
 *
 * @author nroda
 */
public class Principal {

    public static void main(String[] args) {
        String texto = "65..1531 . + ADSF15 .%ADGAD\nasdgaewg .498135 \n 56623505 \n3215.4931 ";
        DeterminadorToken token = new DeterminadorToken(texto);
        while(token.getPosicion()<texto.length()){
            token.separarTexto();
        }
        System.out.println(AlmacenadorInfo.getDatosTabla().size());
        for (int i = 0; i < AlmacenadorInfo.getDatosTabla().size(); i++) {
            ArrayList datos = AlmacenadorInfo.getDatosTabla().get(i);
            for (int j = 0; j < datos.size(); j++) {
                System.out.print(datos.get(j) + " ");
            }
            System.out.println("");
        }
    }

}
