package misImplementacionesEstaticas;

import misApi.ColaTDA;

public class ColaTopeIni implements ColaTDA{
    private int [] contenedor;
    private int cant;

    @Override
    public void inicializarCola() {
        contenedor = new int [100];
        cant = 0;
        
    }

    @Override
    public void acolar(int x) {
        contenedor[cant] = x;
        cant ++;
        
    }

    @Override
    public void desacolar() {
        int i = 0;
        while (i<cant){
            contenedor[i] = contenedor[i+1];
            i++;
        }
        cant--;
    }

    @Override
    public int primero() {
        
        return contenedor[0];
    }

    @Override
    public boolean colaVacia() {
        
        return (cant == 0);
    }
    
}
