package misImplementacionesDinamicas;

import misApi.ConjuntoTDA;
import misApi.GrafoTDA;

public class GrafoDinamico implements GrafoTDA{


    class NodoGrafo{
        int nodo;
        NodoArista arista;
        NodoGrafo sigNodo;
    }

    class NodoArista {
        int etiqueta;
        NodoGrafo nodoDestino;
        NodoArista sigArista;
    }

    NodoGrafo origen;

    @Override
    public void inicializarGrafo() {
        // TODO Auto-generated method stub
        origen = null;
        
    }

    @Override
    public void agregarVertice(int vert) {
        // TODO Auto-generated method stub
        NodoGrafo aux = new NodoGrafo();
        aux.nodo = vert;
        aux.arista = null;
        aux.sigNodo = origen;
        origen = aux;
    }

    @Override
    public void eliminarVertice(int vert) {
        // TODO Auto-generated method stub
        if (origen.nodo == vert){
            origen = origen.sigNodo;
        }

        NodoGrafo aux = origen;
        while (aux != null){

            this.eliminarAristaNodo(aux, vert);

            if (aux.sigNodo != null && aux.sigNodo.nodo == vert){
                aux.sigNodo = aux.sigNodo.sigNodo;
            }
            aux = aux.sigNodo;
        }
    }

    @Override
    public void agregarArista(int origen, int destino, int peso) {
        // TODO Auto-generated method stub
        NodoGrafo n1 = Vert2Nodo(origen);
        NodoGrafo n2 = Vert2Nodo(destino);

        NodoArista aux = new NodoArista();
        aux.etiqueta = peso;
        aux.nodoDestino = n2;
        aux.sigArista = n1.arista;
        n1.arista = aux;
    }

    private void eliminarAristaNodo (NodoGrafo nodo, int v){
        NodoArista aux = nodo.arista;

        if (aux != null){
            if (aux.nodoDestino.nodo == v){
                nodo.arista = aux.sigArista;
            }
            else {
                while (aux.sigArista != null && aux.sigArista.nodoDestino.nodo != v){
                    aux = aux.sigArista;
                }
                if (aux.sigArista != null){
                    aux.sigArista = aux.sigArista.sigArista;
                }
            }
        }
    }
    private NodoGrafo Vert2Nodo (int v){
        NodoGrafo aux = origen;
        while (aux!=null && aux.nodo != v){
            aux = aux.sigNodo;
        }
        return aux;
    }

    @Override
    public void eliminarArista(int origen, int destino) {
        // TODO Auto-generated method stub
        NodoGrafo n1 = Vert2Nodo(origen);
        eliminarAristaNodo(n1, destino);
    }

    @Override
    public ConjuntoTDA vertices() {
        ConjuntoTDA c = new ConjuntoDinamico();
        c.inicializarConjunto();

        NodoGrafo aux = origen;
        while (aux != null){
            c.agregar(aux.nodo);
            aux = aux.sigNodo;
        }

        return c;
    }

    @Override
    public int peso(int v1, int v2) {
        NodoGrafo n1 = Vert2Nodo(v1);

        NodoArista aux = n1.arista;
        while (aux.nodoDestino.nodo != v2){
            aux = aux.sigArista;
        }
        return aux.etiqueta;
    }

    @Override
    public boolean existeArista(int vert1, int vert2) {
        NodoGrafo n1 = Vert2Nodo(vert1);
        NodoArista aux = n1.arista;
        while (aux != null && aux.nodoDestino.nodo != vert2){
            aux = aux.sigArista;
        }
        return aux != null;
    }
    
}
