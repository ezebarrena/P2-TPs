package misImplementacionesDinamicas;

import misApi.ConjuntoTDA;
import misApi.DiccionarioMultipleTDA;

public class DiccionarioMultipleDinamico implements DiccionarioMultipleTDA{

    class NodoClave {
        int clave;
        NodoValor valores;
        NodoClave sigClave;
    }

    class NodoValor {
        int valor;
        NodoValor sigValor;
    }

    NodoClave origen;

    @Override
    public void inicializarDiccionarioMultiple() {
        origen = null;
        
    }

    @Override
    public void agregar(int x, int clave) {
        NodoClave nc = Clave2NodoClave (clave);
        if (nc == null){
            nc = new NodoClave();
            nc.clave = clave;
            nc.sigClave = origen;
            origen = nc;
        }
        
        NodoValor aux = nc.valores;
        while (aux != null && aux.valor != x){
            aux = aux.sigValor;
        }
        if (aux == null){
            NodoValor nv = new NodoValor();
            nv.valor = x;
            nv.sigValor = nc.valores;
        }
    }

    private NodoClave Clave2NodoClave (int clave){
        NodoClave aux = origen;
        while (aux!= null && aux.clave != clave){
            aux = aux.sigClave;
        }
        return aux;
    }

    @Override
    public void eliminarClave(int clave) {
        if (origen != null) {
            if (origen.clave == clave){
                origen = origen.sigClave;
            }
            else{
                NodoClave aux = origen;
                while (aux.sigClave != null && aux.sigClave.clave != clave){
                    aux = aux.sigClave;
                }
                if (aux.sigClave != null) {
                    aux.sigClave = aux.sigClave.sigClave;
                }
            }
        }
    }

    @Override
    public void eliminarValor(int x, int clave) {
        
        if (origen != null) {
            if (origen.clave == clave){
                EliminarValorEnNodo(origen, x);
                if(origen.valores == null){
                    origen = origen.sigClave;
                }
            }
        }
        else{
            NodoClave aux = origen;
            while (aux.sigClave != null && aux.sigClave.clave != clave){
                aux = aux.sigClave;
            }
            if (aux.sigClave != null){
                EliminarValorEnNodo (aux.sigClave, x);
                if (aux.sigClave.valores == null){
                    aux.sigClave = aux.sigClave.sigClave;
                }
            }
        }
    }

    private void EliminarValorEnNodo (NodoClave nodo, int x) {


        if (nodo.valores != null){
            if (nodo.valores.valor == x){
                nodo.valores = nodo.valores.sigValor;
            }
            else{
                NodoValor aux = nodo.valores;
                while (aux.sigValor != null && aux.sigValor.valor != x){
                    aux = aux.sigValor;
                }
                if (aux.sigValor != null){
                    aux.sigValor = aux.sigValor.sigValor;
                }
            }
        }
    }

    @Override
    public ConjuntoTDA obtenerValores(int clave) {
        NodoClave n = Clave2NodoClave(clave);

        ConjuntoTDA c = new ConjuntoDinamico();
        c.inicializarConjunto();

        if (n != null){
            NodoValor aux = n.valores;
            while (aux != null){
                c.agregar(aux.valor);
                aux = aux.sigValor;
            }
        }
        return c;
    }

    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA c = new ConjuntoDinamico();
        c.inicializarConjunto();

        NodoClave aux = origen;
        while (aux != null){
            c.agregar(aux.clave);
            aux = aux.sigClave;
        }
        return c;
    }

    
}
