/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoalgoritmos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Huawei
 * @version 0.9 Dijkstra y funcionalidaes Completados
 */
public class Menu {

    private Gestor gs = new Gestor();
    private ListaEnlazadaVertices listaVertices = new ListaEnlazadaVertices();

    public void menu() {
        boolean salir = false;

        while (salir != true) {
            int opcion = gs.botones();
            System.out.println(opcion);

            switch (opcion) {
                case 0:
                    listaVertices.vaciarLista(); //Se vacia la lista para evitar duplicados
                    Lector lector = new Lector(listaVertices);
                    lector.leerLista();
                    listaVertices = lector.getLista();
                    break;
                    

                case 1:
                    String nombre = gs.string("Ingrese el nombre del vertice");
                    if (listaVertices.buscarNombre(nombre) != true) {
                        if (!nombre.equals("")) {
                            ListaEnlazadaAristas listaAristas = new ListaEnlazadaAristas();
                            Vertice vertice = new Vertice(nombre, listaAristas);
                            listaVertices.insertarFinal(vertice);
                        } else {
                            gs.escribir("El nombre del vertice no debe estar vacio");
                        }
                    } else {
                        gs.escribir("Este vertice ya existe");
                    }
                    break;

                case 2:
                    String nombreVertice = gs.string("Ingrese el nombre del vetice que desea eliminar\n" + listaVertices.nombresVertices());
                     {
                        try {
                            listaVertices.eliminarVertice(nombreVertice);
                        } catch (ListaVerticesException ex) {
                            gs.escribir(ex.getMessage());
                        }
                    }
                    break;

                case 3:
                    String origen = gs.string("Ingrese el nombre del vertice de origen\n" + listaVertices.nombresVertices());
                    String destino = gs.string("Ingrese el nombre del vertice de destino\n" + listaVertices.nombresVertices());
                    int distancia = gs.numero("Ingrese la distancia de la arista");
                    int tiempo = gs.numero("ingrese el tiempo de la arista");
                     {
                        try {
                            listaVertices.getLista(origen).insertarFinal(new Arista(origen, destino, distancia, tiempo));
                        } catch (ListaVerticesException ex) {
                            gs.escribir(ex.getMessage());
                        }
                    }
                    break;

                case 4:
                    String origenEliminar = gs.string("Ingrese el nombre del origen de la arista que desea eliminar");

                    String destinoEliminar = gs.string("Ingrese el nombre del destino de la arista que desea eliminar");
                     {
                        try {
                            listaVertices.getLista(origenEliminar).eliminarArista(origenEliminar, destinoEliminar);
                        } catch (ListaVerticesException ex) {
                            gs.escribir(ex.getMessage());
                        }
                    }
                    break;

                case 5:
                    gs.escribir(listaVertices.imprimir());
                    break;

                case 6:
                    String inicio = gs.string("Ingrese el nombre del inicio");
                    String verticeDestino = gs.string("Ingrese el nombre del verticede destino");
                    listaVertices.reiniciarVertices();
                     {
                        try {
//                            gs.string(listaVertices.dijskstra(inicio));
                            gs.escribir(listaVertices.calcularDosPuntos(inicio, verticeDestino));
                        } catch (ListaVerticesException ex) {
                            gs.escribir(ex.getMessage());
                        }
                    }
                    break;

                case 7:
                    String inicioT = gs.string("Ingrese el nombre del inicio");
                    String destinoTiempo = gs.string("Ingrese el nombre del destino");
                    listaVertices.reiniciarVertices();

                     {
                        try {
                            gs.escribir(listaVertices.tiempoDosPuntos(inicioT, destinoTiempo));
                        } catch (ListaVerticesException ex) {
                            gs.escribir(ex.getMessage());
                        }
                    }
                    break;

                case 8:
                    String inicioReccorrido = gs.string("Ingrese el vertice destino");
                    String puntoMedio = gs.string("Ingrese la ciudad que hay que visitar");
                    String verticeFinal = gs.string("Ingrese el destino");

                     {
                        try {
                            listaVertices.reiniciarVertices();
                            gs.escribir(listaVertices.calcularTresPuntos(inicioReccorrido, puntoMedio, verticeFinal));
                        } catch (ListaVerticesException ex) {
                            gs.escribir(ex.getMessage());
                        }
                    }
                    break;

                case 9:
                    String inicioTiem = gs.string("Ingrese el vertice de partida");
                    String puntoMedioTiempo = gs.string("Ingrese la ciudad que hay que visitar");
                    String destinoTiemp = gs.string("Ingrese el destino");

                    listaVertices.reiniciarVertices();

                     {
                        try {
                            gs.escribir(listaVertices.tiempoTresPuntos(inicioTiem, puntoMedioTiempo, destinoTiemp));
                        } catch (ListaVerticesException ex) {
                            gs.escribir(ex.getMessage());
                        }
                    }
                    break;

                case 10:
                    listaVertices.reiniciarVertices();
                    String verticeInicio = gs.string("Ingrese el vertice de partida");
                     {
                        try {
                            gs.escribir(listaVertices.dijskstra(verticeInicio));
                        } catch (ListaVerticesException ex) {
                            gs.escribir(ex.getMessage());
                        }
                    }
                    break;

                case 11:
                    listaVertices.reiniciarVertices();
                    String inicioTiempo = gs.string("Ingrese el vertice de partida");

                     {
                        try {
                            gs.escribir(listaVertices.dijskstraTiempo(inicioTiempo));
                        } catch (ListaVerticesException ex) {
                            gs.escribir(ex.getMessage());
                        }
                    }
                    break;

                case 12:
                    salir = true;
                    break;
                default:
                    throw new AssertionError();
            }

            System.out.println(listaVertices.imprimir());
        }
    }
}
