package misImplementacionesEstaticas;

import misApi.PilaTDA;

public class Pila implements PilaTDA{


    int [] vector;
    int cant;

    @Override
    public void inicializarPila() {
        vector = new int[100];
        cant = 0;
        
    }

    @Override
    public void apilar(int x) {
        vector[cant] = x;
        cant++;
        
    }

    @Override
    public void desapilar() {
        cant--;
        
    }

    @Override
    public int tope() {
        
        return vector[cant - 1];
    }

    @Override
    public boolean pilaVacia() {
        
        return (cant == 0);
    }
    
}
