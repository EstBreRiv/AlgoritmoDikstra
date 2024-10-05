/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoalgoritmos;

import java.util.ArrayList;

/**
 *
 * @author Huawei
 * @version 0.9 Dijkstra y funcionalidaes Completados
 */
public class ListaEnlazadaVertices {

    private NodoListaVertice primero;
    private NodoListaVertice ultimo;
    String salida = "";
    int suma = 0;
    int minimo = 9999;

    public ListaEnlazadaVertices() {
        this.primero = null;
        this.ultimo = null;
    }

    public void insertarFinal(Vertice vertice) {
        if (primero == null) {
            primero = new NodoListaVertice(vertice);
            ultimo = primero;
        } else {

            NodoListaVertice nuevo = new NodoListaVertice(vertice);
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
    }

    public boolean eliminarPrimero() throws ListaVerticesException {
        if (primero == null) {
            throw new ListaVerticesException("La lista esta vacia");

        }
        primero = primero.getSiguiente();
        return true;
    }

    public boolean eliminarUltimo() throws ListaVerticesException {
        if (ultimo == null) {
            throw new ListaVerticesException("La lista esta vacia");
        }

        NodoListaVertice temp = primero;
        while (temp.getSiguiente().getSiguiente() != null) {
            temp = temp.getSiguiente();
        }
        temp.setSiguiente(null);
        ultimo = temp;
        return true;
    }

    public boolean eliminarVertice(String nombre) throws ListaVerticesException {
        if (primero == null) {
            throw new ListaVerticesException("La lista esta vacia");
        }
        if (primero.getVertice().getNombre().equals(nombre)) {
            return eliminarPrimero();
        }
        if (ultimo.getVertice().getNombre().equals(nombre)) {
            return eliminarUltimo();
        }

        for (NodoListaVertice tempV = primero; tempV != null; tempV = tempV.getSiguiente()) {
            ListaEnlazadaAristas listaTemp = tempV.getVertice().getListaAristas();

            System.err.println("Vertice a eliminar: " + tempV.getVertice().getNombre());
            for (NodoListaArista aristaTemp = listaTemp.getPrimero(); aristaTemp != null; aristaTemp = aristaTemp.getSiguiente()) {
                if (aristaTemp.getArista().getDestino().equals(nombre)) {
                    listaTemp.eliminarArista(tempV.getVertice().getNombre(), nombre);
                }
            }
        }

        NodoListaVertice temp = primero;
        while (temp.getSiguiente() != null) {
            if (temp.getSiguiente().getVertice().getNombre().equals(nombre)) {
                temp.setSiguiente(temp.getSiguiente().getSiguiente());
                return true;
            }
            temp = temp.getSiguiente();
        }

        throw new ListaVerticesException("No se encontro el vertice a eliminar");
    }

    public boolean buscarNombre(String nombre) {
        NodoListaVertice temp = primero;
        while (temp != null) {
            if (temp.getVertice().getNombre().equals(nombre)) {
                return true;
            }
            temp = temp.getSiguiente();
        }
        return false;
    }

    //Metodo utilizado para ignorar problemas de mayusculas y minusculas, retorna el nombre respetando mayus y minus
    public String buscarNombreMinuscula(String nombre) {
        String minuscula;
        NodoListaVertice temp = primero;
        while (temp != null) {
            minuscula = temp.getVertice().getNombre().toLowerCase();
            if (minuscula.equals(nombre)) {
                return temp.getVertice().getNombre();
            }
            temp = temp.getSiguiente();
        }
        return null;
    }

    public Vertice buscarVertice(String nombre) throws ListaVerticesException {
        NodoListaVertice temp = primero;
        while (temp != null) {
            if (temp.getVertice().getNombre().equals(nombre)) {
                return temp.getVertice();
            }
            temp = temp.getSiguiente();
        }
        throw new ListaVerticesException("No se encontro el vertice");
    }

    public String imprimir() {
        String salida = "";
        NodoListaVertice temp = primero;
        while (temp != null) {
            salida += "Vertice " + temp.getVertice().getNombre() + "\n";
            salida += temp.getVertice().imprimir() + " ";
            temp = temp.getSiguiente();
            salida += "\n\n";
        }
        return salida;
    }

    public String nombresVertices() {
        String salida = "";
        NodoListaVertice temp = primero;
        while (temp != null) {
            salida += "Vertice => " + temp.getVertice().getNombre() + "\n";
            temp = temp.getSiguiente();
        }
        return salida;
    }

    public ListaEnlazadaAristas getLista(String nombre) throws ListaVerticesException {
        NodoListaVertice temp = primero;
        while (temp != null) {
            if (temp.getVertice().getNombre().equals(nombre)) {
                return temp.getVertice().getListaAristas();
            }
            temp = temp.getSiguiente();
        }
        throw new ListaVerticesException("Este vertice no existe");
    }

    public void vaciarLista() {
        this.primero = null;
        this.ultimo = null;
    }

    public String dijskstra(String verticeSalida) throws ListaVerticesException {

        int acumulado = 0;
        String mensaje = "";
        boolean salir = false;
        int iteracion = 0;
        String listaFinal = "";
        if (verticeSalida == null) {
            throw new ListaVerticesException("El vertice de salida no debe estar vacio");
        }
        String verticesiguiente = verticeSalida.toLowerCase();
        buscarVertice(verticeSalida).setVisitado(true);

        while (salir != true) {
            System.err.println("vertice a recorrer: " + verticesiguiente);
            Vertice temp = buscarVertice(verticesiguiente);
            listaFinal += " " + temp.getNombre();
            acumulado = temp.getAcumulado();

            mensaje += listaFinal + " Distancia total: " + acumulado + "\n";
            ListaEnlazadaAristas listaTemp = temp.getListaAristas();

            for (NodoListaArista aristaTemp = listaTemp.getPrimero(); aristaTemp != null; aristaTemp = aristaTemp.getSiguiente()) {
                Vertice marca = buscarVertice(aristaTemp.getArista().getDestino());

                if (marca.isVisitado() == false) {
                    if (marca.getAcumulado() < 1 || marca.getAcumulado() > (temp.getAcumulado() + aristaTemp.getArista().getDistancia())) {
                        marca.setAcumulado(temp.getAcumulado() + aristaTemp.getArista().getDistancia());
                        marca.setPredecesor(temp.getNombre());
                        marca.setIteracion(temp.getIteracion() + 1);
                        System.out.println(marca.getNombre() + marca.getAcumulado() + marca.getPredecesor());
                    }
                }
            }

            verticesiguiente = etiquetaMinima();
            if (verticesiguiente == null || verticesiguiente.equals("")) {
                salir = true;
            } else {
                buscarVertice(verticesiguiente).setVisitado(true);
            }

        }

//        for (NodoListaVertice lista = primero; lista != null; lista = lista.getSiguiente()) {
//            listaFinal += "Ciudad: " + lista.getVertice().getNombre()
//                    + " acumulado: " + lista.getVertice().getAcumulado();
//        }
        return mensaje;

    }

    public void reiniciarVertices() {
        for (NodoListaVertice temp = primero; temp != null; temp = temp.getSiguiente()) {
            temp.getVertice().setAcumulado(0);
            temp.getVertice().setVisitado(false);
            temp.getVertice().setIteracion(0);
            temp.getVertice().setPredecesor("");
        }
    }

    public String etiquetaMinima() {
        int minimo = 0;
        String vertice = "";
        for (NodoListaVertice temp = primero; temp != null; temp = temp.getSiguiente()) {
            if (temp.getVertice().isVisitado() == false && temp.getVertice().getAcumulado() != 0) {

                if (minimo == 0 || temp.getVertice().getAcumulado() < minimo && temp.getVertice().getAcumulado() != 0) {

                    minimo = temp.getVertice().getAcumulado();
                    vertice = temp.getVertice().getNombre();

                    System.out.println("Minimo: " + minimo + vertice);
                }
            }

            System.out.println("Informacion geeneral: " + temp.getVertice().toString());
        }
        return vertice;
    }

    public String calcularDosPuntos(String origen, String destino) throws ListaVerticesException {
        dijskstra(origen);

        Vertice busqueda = buscarVertice(destino);
        int distanciaTotal = busqueda.getAcumulado();
        String listaFinal = busqueda.getNombre();

        while (!busqueda.getPredecesor().equals("")) {
            listaFinal = busqueda.getPredecesor() + " -> " + listaFinal;
            busqueda = buscarVertice(busqueda.getPredecesor());
        }

        return "Ciudades a recorrer\n" + listaFinal + "\nDistancia total: " + distanciaTotal + "  Km";
    }

    public String calcularTresPuntos(String inicio, String puntoMedio, String destino) throws ListaVerticesException {
        dijskstra(inicio);

        Vertice busqueda = buscarVertice(puntoMedio);
        int distanciaTotal = busqueda.getAcumulado();
        String listaFinal = busqueda.getNombre();

        while (!busqueda.getPredecesor().equals("")) {
            listaFinal = busqueda.getPredecesor() + " -> " + listaFinal;
            busqueda = buscarVertice(busqueda.getPredecesor());
        }

        reiniciarVertices();

        dijskstra(puntoMedio);

        busqueda = buscarVertice(destino);
        distanciaTotal += busqueda.getAcumulado();

        String lista2 = "";

        while (!busqueda.getPredecesor().equals("")) {
            lista2 = busqueda.getNombre() + " -> " + lista2;
            busqueda = buscarVertice(busqueda.getPredecesor());
            System.out.println(listaFinal);
        }

        return "Ciudades a recorrer\n" + listaFinal + " -> " + lista2 + "\nDistancia total: " + distanciaTotal + "  Km";

    }

    public String dijskstraTiempo(String verticeSalida) throws ListaVerticesException {

        int acumulado = 0;
        String mensaje = "";
        boolean salir = false;
        int iteracion = 0;
        String listaFinal = "";
        if (verticeSalida == null) {
            throw new ListaVerticesException("El vertice de salida no debe estar vacio");
        }
        String verticesiguiente = verticeSalida.toLowerCase();
        buscarVertice(verticeSalida).setVisitado(true);

        while (salir != true) {
            System.err.println("vertice a recorrer: " + verticesiguiente);
            Vertice temp = buscarVertice(verticesiguiente);
            listaFinal += " " + temp.getNombre();
            acumulado = temp.getAcumulado();

            mensaje += listaFinal + " Tiempo total: " + acumulado + " minutos\n";
            ListaEnlazadaAristas listaTemp = temp.getListaAristas();

            for (NodoListaArista aristaTemp = listaTemp.getPrimero(); aristaTemp != null; aristaTemp = aristaTemp.getSiguiente()) {
                Vertice marca = buscarVertice(aristaTemp.getArista().getDestino());

                if (marca.isVisitado() == false) {
                    if (marca.getAcumulado() < 1 || marca.getAcumulado() > (temp.getAcumulado() + aristaTemp.getArista().getTiempo())) {
                        marca.setAcumulado(temp.getAcumulado() + aristaTemp.getArista().getTiempo());
                        marca.setPredecesor(temp.getNombre());
                        marca.setIteracion(temp.getIteracion() + 1);
                        System.out.println(marca.getNombre() + marca.getAcumulado() + marca.getPredecesor());
                    }
                }
            }

            verticesiguiente = etiquetaMinima();
            if (verticesiguiente == null || verticesiguiente.equals("")) {
                salir = true;
            } else {
                buscarVertice(verticesiguiente).setVisitado(true);
            }

        }

        return mensaje;
    }

    public String tiempoDosPuntos(String origen, String destino) throws ListaVerticesException {
        dijskstraTiempo(origen);

        Vertice busqueda = buscarVertice(destino);
        int tiempoTotal = busqueda.getAcumulado();
        String listaFinal = busqueda.getNombre();

        while (!busqueda.getPredecesor().equals("")) {
            listaFinal = busqueda.getPredecesor() + " -> " + listaFinal;
            busqueda = buscarVertice(busqueda.getPredecesor());
        }

        return "Ciudades a recorrer\n" + listaFinal + "\nTiempo total: " + tiempoTotal + "  minutos";
    }

    public String tiempoTresPuntos(String inicio, String puntoMedio, String destino) throws ListaVerticesException {
        dijskstraTiempo(inicio);

        Vertice busqueda = buscarVertice(puntoMedio);
        int tiempoTotal = busqueda.getAcumulado();
        String listaFinal = busqueda.getNombre();

        while (!busqueda.getPredecesor().equals("")) {
            listaFinal = busqueda.getPredecesor() + " -> " + listaFinal;
            busqueda = buscarVertice(busqueda.getPredecesor());
        }

        reiniciarVertices();

        dijskstraTiempo(puntoMedio);

        busqueda = buscarVertice(destino);
        tiempoTotal += busqueda.getAcumulado();
        String listaFinal2 = "";

        while (!busqueda.getPredecesor().equals("")) {
            listaFinal2 = busqueda.getNombre() + " -> " + listaFinal2;
            busqueda = buscarVertice(busqueda.getPredecesor());
            System.out.println(listaFinal);
        }

        return "Ciudades a recorrer\n" + listaFinal + " -> " + listaFinal2 + "\nTiempo total: " + tiempoTotal + "  minutos";

    }

}
