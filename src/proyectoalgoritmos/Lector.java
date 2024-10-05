package proyectoalgoritmos;

/**
 *
 * @author Salazar
 * @version 0.9 Dijkstra y funcionalidaes Completados
 */
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lector {

    private ListaEnlazadaVertices lista;
    
    public Lector(ListaEnlazadaVertices lista){
        this.lista = lista;
    }
    
    public void leerLista() {

        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            leerArchivo(selectedFile);
        } else {
            System.out.println("No se seleccionó ningún archivo.");
        }
    }

    private void leerArchivo(File file) {
        //caracter usado para identificar la division de los datos
        String DIVISOR = ",";
        //vector que va a guardar cada dato
        String[] datosVertice;

        try {
            //Se crea el lector de archivos
            FileReader lectorArchivo = new FileReader(file);
            BufferedReader lector = new BufferedReader(lectorArchivo);

            //Lee una nueva linea
            String linea = lector.readLine();

            //Va a leer todos las lineas posibles que hayan en el archivo
            while (linea != null && !linea.equals("")) {

                datosVertice = linea.split(DIVISOR);
                //se comienzan a establecer todos los datos
                String origen = datosVertice[0].toLowerCase();
                String destino = datosVertice[1].toLowerCase();
                int distancia = Integer.parseInt(datosVertice[2]);
                int tiempo = Integer.parseInt(datosVertice[3]);
                //Se crea el arista
                Arista arista = new Arista(origen, destino, distancia, tiempo);
                crearVertices(origen, arista);
                linea = lector.readLine();
            }
            //Cierra el flujo de lectura
            lector.close();

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void crearVertices(String origen, Arista arista) {
        String origenMinus = origen.toLowerCase();
        String nombreEncontrado = lista.buscarNombreMinuscula(origenMinus); //Retorna null si no encuentra el vertice
        if (nombreEncontrado == null) { //Si el vertice no existe
            ListaEnlazadaAristas listaAristas = new ListaEnlazadaAristas();
            Vertice vertice = new Vertice(origen, listaAristas); //Crea el vertice respetando mayusculas y minusculas
            lista.insertarFinal(vertice);
        }   
        
        try {
        nombreEncontrado = lista.buscarNombreMinuscula(origenMinus); //Vuelve a buscar el nombre ya que pudo haber sido creado uno nuevo
        arista.setOrigen(nombreEncontrado); //Se setea el origen al nombre encontrado
        lista.getLista(nombreEncontrado).insertarFinal(arista);
        } catch (ListaVerticesException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ListaEnlazadaVertices getLista() {
        return lista;
    }
    
}
