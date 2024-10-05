package proyectoalgoritmos;

/**
 *
 * @author Huawei
 * @version 0.9 Dijkstra y funcionalidaes Completados
 */
public class ListaEnlazadaAristas {

    private NodoListaArista primero;
    private NodoListaArista ultimo;

    public ListaEnlazadaAristas() {
        this.primero = null;
        this.ultimo = null;
    }

    public void insertarFinal(Arista arista) {
        if (primero == null) {
            primero = new NodoListaArista(arista);
            ultimo = primero;
        } else {

            NodoListaArista nuevo = new NodoListaArista(arista);
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
    }

    public String imprimir() {
        String salida = "";
        NodoListaArista temp = primero;
        while (temp != null) {
            salida += temp.getArista() + " ";
            temp = temp.getSiguiente();
        }
        return salida;
    }

    public boolean eliminarPrimero() {
        if (primero == null) {
            return false;
        }
        primero = primero.getSiguiente();
        return true;

    }

    public boolean eliminarUltimo() {
        if (ultimo == null) {
            //throw error
            return false;
        }

        NodoListaArista temp = primero;
        while (temp.getSiguiente().getSiguiente() != null) {
            temp = temp.getSiguiente();
        }
        temp.setSiguiente(null);
        ultimo = temp;
        return true;
    }

    public boolean eliminarArista(String origen, String destino) {
        if (primero == null) {
            //throw error
            return false;
        }
        if (primero.getArista().getOrigen().equals(origen) && primero.getArista().getDestino().equals(destino)) {
            return eliminarPrimero();
        }
        if (ultimo.getArista().getOrigen().equals(origen) && ultimo.getArista().getDestino().equals(destino)) {
            return eliminarUltimo();
        }
        NodoListaArista temp = primero;

        while (temp.getSiguiente() != null) {
            if (temp.getSiguiente().getArista().getOrigen().equals(origen) && temp.getArista().getDestino().equals(destino)) {
                temp.setSiguiente(temp.getSiguiente().getSiguiente());
                return true;
            }
            temp = temp.getSiguiente();
        }

        return false;
    }

    public Arista distanciaMenor() {
        NodoListaArista temp = primero;
        Arista menorDistancia = null;
        int menor = 0;
        if (temp.getSiguiente() == null) {
            menorDistancia = temp.getArista();
        }
        while (temp.getSiguiente() != null) {

            menor = temp.getArista().getDistancia();
            if (temp.getArista().getDistancia() < temp.getSiguiente().getArista().getDistancia() && temp.getArista().getDistancia() <= menor) {
                menorDistancia = temp.getArista();
            } else if (temp.getArista().getDistancia() > temp.getSiguiente().getArista().getDistancia() && temp.getSiguiente().getArista().getDistancia() <= menor) {
                menorDistancia = temp.getSiguiente().getArista();

            }
            temp = temp.getSiguiente();
        }

        return menorDistancia;
    }

    public NodoListaArista getPrimero() {
        return primero;
    }

    public void setPrimero(NodoListaArista primero) {
        this.primero = primero;
    }

    public NodoListaArista getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoListaArista ultimo) {
        this.ultimo = ultimo;
    }

}
