/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoalgoritmos;

/**
 *
 * @author Huawei
 * @version 0.9 Dijkstra y funcionalidaes Completados
 */
public class NodoListaArista {

    private Arista arista;
    private NodoListaArista siguiente;

    public NodoListaArista(Arista arista) {
        this.arista = arista;
        this.siguiente = null;
    }

    public Arista getArista() {
        return arista;
    }

    public void setArista(Arista arista) {
        this.arista = arista;
    }

    public NodoListaArista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoListaArista siguiente) {
        this.siguiente = siguiente;
    }
}
