package misImplementacionesDinamicas;

import misApi.ColaPrioridadTDA;

public class ColaPrioridadDinamica implements ColaPrioridadTDA{

    class NodoPrioridad{
        int info;
        int prioridad;
        NodoPrioridad sig;
    }

    NodoPrioridad mayorPrioridad;

    @Override
    public void inicializarCola() {
        mayorPrioridad = null;
        
    }

    @Override
    public void acolarPrioridad(int x, int p) {
        
        NodoPrioridad nuevo = new NodoPrioridad();
        nuevo.info = x;
        nuevo.prioridad = p;

        if (mayorPrioridad == null || p > mayorPrioridad.prioridad){
            nuevo.sig = mayorPrioridad;
            mayorPrioridad = nuevo;
        }
        else{
            NodoPrioridad aux = mayorPrioridad;
            
            while (aux.sig != null && aux.sig.prioridad >= p){
                aux = aux.sig;
            }
            nuevo.sig = aux.sig;
            aux.sig = nuevo;
        }
    }

    @Override
    public void desacolar() {
        mayorPrioridad = mayorPrioridad.sig;
        
    }

    @Override
    public int primero() {
        
        return mayorPrioridad.info;
    }

    @Override
    public int prioridad() {
        
        return mayorPrioridad.prioridad;
    }

    @Override
    public boolean colaVacia() {
        
        return (mayorPrioridad == null);
    }

    @Override
    public void imprimirCola() {
        
        
    }

    @Override
    public int longitud() {
        
        return 0;
    }
    
}
