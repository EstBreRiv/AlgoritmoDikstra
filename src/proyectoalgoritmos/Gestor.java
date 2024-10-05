/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoalgoritmos;

import java.awt.color.ICC_Profile;
import javax.swing.JOptionPane;

/**
 *
 * @author Huawei
 * @version 0.9 Dijkstra y funcionalidaes Completados
 */
public class Gestor {

    public int botones() {
        int opcion = 0;
        String[] botones = {"Opcion-1", "Opcion-2", "Opcion-3", "Opcion-4", "Opcion-5", "Opcion-6", "Opcion-7", "Opcion-8",
            "Opcion-9", "Opcion-10", "Opcion-11", "Opcion-12", "Salir"};
        opcion = JOptionPane.showOptionDialog(null, "Opcion-1: Cargar archivo\nOpcion-2: Agregar "
                + "vertice\nOpcion-3: Eliminar vertice\nOpcion-4: Agregar arista\nOpcion-5: Eliminar arista"
                + "\nOpcion-6: Imprimir grafo\nOpcion-7: Ruta mas corta entre dos puntos"
                + "\nOpcion-8: Ruta mas rapida entre dos puntos\nOpcion-9: Ruta mas corta entre dos puntos pasando por un tercero"
                + "\nOpcion-10: Ruta mas rapida entre dos puntos pasando por un tercero\nOpcion-11: Ruta mas corta de un punto a los demas"
                + "\nOpcion-12: Ruta mas rapida de un punto a los demas", "Bienvenido al programa para calcular recorridos", opcion, JOptionPane.INFORMATION_MESSAGE, null, botones, botones);
        return opcion;
    }

    public int numero(String mensaje) {

        boolean salir = false;
        int dato = 0;
        while (salir != true) {
            try {
                dato = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
                salir = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Solo se permiten numeros");
            }
        }

        return dato;
    }

    public void escribir(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public String string(String mensaje) {
        String texto = JOptionPane.showInputDialog(mensaje);

        return texto;
    }

    public void isboolean(boolean valor) {
        JOptionPane.showMessageDialog(null, valor);
    }

    public void listado(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
