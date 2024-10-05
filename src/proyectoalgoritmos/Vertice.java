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
public class Vertice {

    private String nombre;
    private boolean visitado;
    private ListaEnlazadaAristas listaAristas;
    private String predecesor;
    private int acumulado;
    private int iteracion;

    public Vertice(String nombre, ListaEnlazadaAristas listaAristas) {
        this.nombre = nombre;
        this.listaAristas = listaAristas;
        this.visitado = false;
        this.predecesor = "";
        this.acumulado = 0;
        this.iteracion = 0;

    }

    public String getPredecesor() {
        return predecesor;
    }

    public void setPredecesor(String predecesor) {
        this.predecesor = predecesor;
    }

    public int getAcumulado() {
        return acumulado;
    }

    public void setAcumulado(int acumulado) {
        this.acumulado = acumulado;
    }

    public int getIteracion() {
        return iteracion;
    }

    public void setIteracion(int iteracion) {
        this.iteracion = iteracion;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaEnlazadaAristas getListaAristas() {
        return listaAristas;
    }

    public void setListaAristas(ListaEnlazadaAristas listaAristas) {
        this.listaAristas = listaAristas;
    }

    public String imprimir() {
        String salida = listaAristas.imprimir();
        return salida;
    }

    @Override
    public String toString() {
        return "Vertice{" + "nombre=" + nombre + ", visitado=" + visitado + ", listaAristas=" + listaAristas + ", predecesor=" + predecesor + ", acumulado=" + acumulado + ", iteracion=" + iteracion + '}';
    }

}
