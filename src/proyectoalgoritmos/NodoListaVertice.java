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
public class NodoListaVertice {

    private Vertice vertice;
    private NodoListaVertice siguiente;

    public NodoListaVertice(Vertice vertice) {
        this.vertice = vertice;
        this.siguiente = null;
    }

    public Vertice getVertice() {
        return vertice;
    }

    public void setVetrice(Vertice vertice) {
        this.vertice = vertice;
    }

    public NodoListaVertice getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoListaVertice siguiente) {
        this.siguiente = siguiente;
    }
}
