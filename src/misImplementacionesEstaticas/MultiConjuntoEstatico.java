package misImplementacionesEstaticas;

import misApi.MultiConjuntoTDA;

public class MultiConjuntoEstatico implements MultiConjuntoTDA{


    class elemento {
        int info;
        int multi;
    }

    private elemento [] vector;
    private int cant;


    @Override
    public void inicializarMultiConjunto() {
        vector = new elemento [100];
        cant = 0;
        
    }

    @Override
    public void agregar(int x) {

        

        vector[cant] = new elemento();
        vector[cant].info = x;
        vector[cant].multi = multiplicidad(x);

        cant++;

    }

    @Override
    public void sacar(int x) {
        int i = cant-1;

        while (vector[i].info != x){
            i--;
        }

        vector[i] = vector[cant-1];
        cant--;
    }

    @Override
    public int multiplicidad(int x) {
        int multi = 0;
        for (int i = 0; i<= cant-1; i++){
            if (vector[i].info == x){
                multi++;
            }

        }
        return multi; 
    }

    @Override
    public boolean multiConjuntoVacio() {
        
        return cant == 0;
    }

    @Override
    public int elegir() {
        
        return vector[cant].info;
    }
    
}
