package misAplicaciones;

import misApi.ColaPrioridadTDA;
import misImplementacionesDinamicas.ColaPrioridadDinamica;
import misMetodos.MetodosColasPrioridad;

public class Clase4ej3c {
    public static void main (String [] args){
        ColaPrioridadTDA cola1 = new ColaPrioridadDinamica();
        ColaPrioridadTDA cola2 = new ColaPrioridadDinamica();
        ColaPrioridadTDA colaRes = new ColaPrioridadDinamica();

        MetodosColasPrioridad metodosCp = new MetodosColasPrioridad();

        cola1.inicializarCola();
        cola2.inicializarCola();


        cola1.acolarPrioridad(1, 2);
        cola1.acolarPrioridad(3, 5);
        cola1.acolarPrioridad(6, 29);
        cola1.acolarPrioridad(4, 8);
        cola1.acolarPrioridad(10, 22);

        cola2.acolarPrioridad(5, 2);
        cola2.acolarPrioridad(223, 5);
        cola2.acolarPrioridad(6, 30);
        cola2.acolarPrioridad(9, 8);
        cola2.acolarPrioridad(10, 22);   

        colaRes = metodosCp.unionColas(cola1, cola2);

        metodosCp.imprimirCola(colaRes);
    }
}
