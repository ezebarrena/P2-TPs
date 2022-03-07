package misImplementacionesEstaticas;

import misApi.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA{

    class Elemento{
        int valor;
        int prioridad;
    }

    private Elemento [] vector;
    private int cant;

    @Override
    public void inicializarCola() {
        vector = new Elemento[100];
        cant = 0;
    }

    @Override
    public void acolarPrioridad(int x, int p) {
        int i = cant-1;

        while (i >= 0 && p < vector[i].prioridad){
            vector[i+1] = vector[i];
            i--;
        }

        vector[i+1]= new Elemento();
        vector[i+1].valor = x;
        vector[i+1].prioridad = p;
        cant++;
        
    }

    @Override
    public void desacolar() {
        cant --;
        
    }

    @Override
    public int primero() {
        
        return vector[cant-1].valor;
    }

    @Override
    public int prioridad() {
        
        return vector[cant-1].prioridad;
    }

    @Override
    public boolean colaVacia() {
        
        return cant==0;
    }

    @Override
    public void imprimirCola() {
        int i = 0;

        while(i<cant){
            System.out.println("Valor: "+ vector[i].valor + " Priodidad: " + vector[i].prioridad);
            i++;
        }
    }

    @Override
    public int longitud() {
        return cant-1;
    }
    
}
