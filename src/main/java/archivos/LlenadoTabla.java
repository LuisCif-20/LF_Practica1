/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import tokens.AlmacenadorInfo;

/**
 *
 * @author nroda
 */
public class LlenadoTabla {

    //Metodo que se encarga de llenar la table
    public static void llenarTablaError(JTable tabladatos, JButton boton) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Token");
        model.addColumn("Lexema");
        model.addColumn("Linea");
        model.addColumn("Columna");

        //Se llena la tabla
        int tamanio = AlmacenadorInfo.getDatosTabla().size();
        for (int i = 0; i < tamanio; i++) {
            ArrayList array = AlmacenadorInfo.getDatosTabla().get(i);
            if (array.get(0).equals("Error")) {
                model.addRow(new Object[]{array.get(0), array.get(1), array.get(2), array.get(3)});
            }
        }
        if (model.getRowCount() == 0) {
            for (int i = 0; i < tamanio; i++) {
                ArrayList array = AlmacenadorInfo.getDatosTabla().get(i);
                model.addRow(new Object[]{array.get(0), array.get(1), array.get(2), array.get(3)});
                boton.setEnabled(true);
            }
        }
        tabladatos.setModel(model);
    }

    //Metodo que recuenta los token
    public static void recontarToken(JTable tabladatos, JButton boton) {
        ArrayList<ArrayList> lista = new ArrayList<ArrayList>();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Token");
        model.addColumn("Lexema");
        model.addColumn("Cantidad");
        int tamanio = AlmacenadorInfo.getDatosTabla().size();
        //Bucle que recorre el arraylist
        for (int i = 0; i < tamanio; i++) {
            int contador =0;
            ArrayList array = AlmacenadorInfo.getDatosTabla().get(i);
            for (int j = 0; j < tamanio; j++) {
                ArrayList array1 = AlmacenadorInfo.getDatosTabla().get(j);
                if (array.get(1).equals(array1.get(1))) {
                    contador++;
                }
            }
            ArrayList cantidad = new ArrayList();
            cantidad.add(array.get(0));
            cantidad.add(array.get(1));
            cantidad.add(contador);
            //Valida si en el array de lista ya existe ese arrayList
            if (!lista.contains(cantidad)) {
                lista.add(cantidad);
                    model.addRow(new Object[]{cantidad.get(0), cantidad.get(1), cantidad.get(2)});
            }
        }
        tabladatos.setModel(model);
    }
}
