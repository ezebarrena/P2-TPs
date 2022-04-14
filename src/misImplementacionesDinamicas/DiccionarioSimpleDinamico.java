package misImplementacionesDinamicas;

import misApi.ConjuntoTDA;
import misApi.DiccionarioSimpleTDA;
import misImplementacionesEstaticas.Conjunto;

public class DiccionarioSimpleDinamico implements DiccionarioSimpleTDA{

    class NodoClave{
        int clave;
        int valor;
        NodoClave sigClave;
    }

    NodoClave origen;

    @Override
    public void inicializarDiccionario() {
        origen = null;
    }

    @Override
    public void agregar(int x, int clave) {
        NodoClave nc = Clave2NodoClave(clave);
        if (nc == null){
            nc = new NodoClave();
            nc.clave = clave;
            nc.sigClave = origen;
            origen = nc;
        }
        nc.valor = x;
    }

    private NodoClave Clave2NodoClave (int clave){
        NodoClave aux = origen;
        while (aux != null && aux.clave != clave){
            aux = aux.sigClave;
        }
        return aux;
    }

    @Override
    public void eliminar(int clave) {
        if (origen != null){
            origen = origen.sigClave;
        }
        else{
            NodoClave aux = origen;
            while (aux.sigClave != null && aux.sigClave.clave != clave){
                aux = aux.sigClave;
            }
            if (aux.sigClave != null){
                aux.sigClave = aux.sigClave.sigClave;
            }
        }
    }

    @Override
    public int obtener(int clave) {
        NodoClave n = Clave2NodoClave(clave);
        return n.valor;
    }

    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA c = new ConjuntoDinamico();
        c.inicializarConjunto();

        NodoClave aux = origen;

        while ( aux != null){
            c.agregar(aux.clave);
            aux = aux.sigClave;
        }
        return c;
    }
    
}
