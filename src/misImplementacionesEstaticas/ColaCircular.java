package misImplementacionesEstaticas;

import misApi.ColaTDA;

public class ColaCircular implements ColaTDA{
    private int [] contenedor;
    private int primero;
    private int ultimo;
    @Override
    public void inicializarCola() {
        contenedor = new int [100];
        primero = ultimo = 0;
    }

    @Override
    public void acolar(int x) {
        contenedor[ultimo] = x;
        ultimo++;
        if (ultimo == 100){
            ultimo = 0;
        }
    }

    @Override
    public void desacolar() {
        primero++;
        if (primero == 100) {
            primero = 0;
        }
    }

    @Override
    public int primero() {
        return contenedor[primero];
    }

    @Override
    public boolean colaVacia() {
        return (primero == ultimo);
    }
    
}
