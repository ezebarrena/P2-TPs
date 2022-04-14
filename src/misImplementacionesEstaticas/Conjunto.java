package misImplementacionesEstaticas;

import java.util.Random;

import misApi.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA{
    private int [] vector;
    private int cant;
    private Random random;

    @Override
    public void inicializarConjunto() {
        
        vector = new int [100];
        cant = 0;
        random = new Random();
    }

    @Override
    public void agregar(int x) {
        
        if (!pertenece(x)){
            vector[cant] = x;
            cant ++;
        }
    }

    @Override
    public void sacar(int x) {
        int i = cant-1;
        
        while (vector[i] != x){
            i--;
        }

        vector[i] = vector[cant-1];
        cant--;
        
        
    }

    @Override
    public int obtener() {
        int pos = random.nextInt(cant);

        return vector[pos];
    }

    @Override
    public boolean conjuntoVacio() {

        return cant == 0;
    }

    @Override
    public boolean pertenece(int x) {
        
        int i = 0;

        while (i<cant && vector[i] != x){
            i++;
        }

        return (i < cant);
    }

    @Override
    public void imprimirConjunto(){
        int i = 0;
        while (i<cant){
            System.out.println(vector[i]);
            i++;
        }
        
    }
    
}
