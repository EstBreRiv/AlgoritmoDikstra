/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoalgoritmos;

/**
 *
 * @author Esteban Brenes Rivera C21366
 * @version 0.9 Dijkstra y funcionalidaes Completados
 */
public class Arista {

    private String origen;
    private String destino;
    private int distancia;
    private int tiempo;

    public Arista(String origen, String destino, int distancia, int tiempo) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        this.tiempo = tiempo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "Arista{" + "origen=" + origen + ", destino=" + destino + ", distancia=" + distancia + ", tiempo=" + tiempo + '}';
    }

}
