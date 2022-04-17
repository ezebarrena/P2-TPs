package misImplementacionesDinamicas;

import misApi.PilaTDA;

public class PilaDinamica implements PilaTDA{

    class Nodo{
        int info;
        Nodo sig;
    }
    Nodo primero;


    @Override
    public void inicializarPila() {
        primero = null;        
    }

    @Override
    public void apilar(int x) {
        Nodo aux = new Nodo();
        aux.info = x;
        aux.sig = primero;
        primero = aux;
        
    }

    @Override
    public void desapilar() {
        primero = primero.sig;
        
    }

    @Override
    public int tope() {
        
        return primero.info;
    }

    @Override
    public boolean pilaVacia() {
        
        return (primero == null);
    }
    
}
