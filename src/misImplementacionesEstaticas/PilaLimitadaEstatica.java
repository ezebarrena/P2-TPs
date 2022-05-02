package misImplementacionesEstaticas;

import misApi.PilaLimitadaTDA;

public class PilaLimitadaEstatica implements PilaLimitadaTDA{

    int [] vector;
    int indice;
    int maxSize;

    @Override
    public void inicializarPila(int size) {
        vector = new int [size + 1];
        maxSize = size;
        indice = 0;
    }

    @Override
    public void apilar(int x) {
        for (int i = indice -1; i >= 0; i--){
            vector[i+1] = vector[i];
        }
        vector[0] = x;
        indice++;
        if (indice > maxSize){
            indice--;
        }

    }

    @Override
    public void desapilar() {
        for (int i = 0; i<indice; i++){
            vector[i] = vector[i+1];
        }
        indice --;
    }

    @Override
    public boolean pilaVacia() {
        return indice == 0;
    }

    @Override
    public int tope() {
        return vector[0];
    }
    
}
