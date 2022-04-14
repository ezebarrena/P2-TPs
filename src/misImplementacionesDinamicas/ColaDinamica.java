package misImplementacionesDinamicas;

import misApi.ColaTDA;

public class ColaDinamica implements ColaTDA{

    class Nodo{
        int info;
        Nodo sig;
    }

    Nodo primero;

    Nodo ultimo;

    @Override
    public void inicializarCola() {
        primero = null;
        ultimo = null;
        
    }

    @Override
    public void acolar(int x) {
        Nodo aux = new Nodo();
        aux.info = x;

        if (ultimo != null){
            ultimo.sig = aux;
        }
        ultimo = aux;

        if (primero == null){
            primero = ultimo;
        }
        
    }

    @Override
    public void desacolar() {
        primero = primero.sig;

        if (primero == null){
            ultimo = null;
        }
        
    }

    @Override
    public int primero() {
        
        return primero.info;
    }

    @Override
    public boolean colaVacia() {
        
        return (ultimo == null);
    }

    @Override
    public void imprimir() {
        
        
    }

    @Override
    public int largo() {
        
        return 0;
    }
    
}
