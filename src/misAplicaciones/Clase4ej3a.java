package misAplicaciones;

import misApi.ColaPrioridadTDA;
import misImplementacionesDinamicas.ColaPrioridadDinamica;
import misImplementacionesEstaticas.ColaPrioridad;
import misMetodos.MetodosColasPrioridad;

public class Clase4ej3a {
    public static void main (String [] args) throws Exception{
        ColaPrioridadTDA cola1 = new ColaPrioridadDinamica();
        ColaPrioridadTDA cola2 = new ColaPrioridadDinamica();
        ColaPrioridadTDA colaRes = new ColaPrioridadDinamica();

        cola1.inicializarCola();
        cola2.inicializarCola();
        colaRes.inicializarCola();

        MetodosColasPrioridad metodosColasP = new MetodosColasPrioridad();

        cola1.acolarPrioridad(1, 3);
        cola1.acolarPrioridad(2, 21);
        cola1.acolarPrioridad(3, 54);
        cola1.acolarPrioridad(4, 2);
        cola1.acolarPrioridad(5,7);
        cola1.acolarPrioridad(6, 8);
       
        cola1.acolarPrioridad(1, 3);
        cola1.acolarPrioridad(9, 21);
        cola1.acolarPrioridad(7, 54);
        cola1.acolarPrioridad(4, 2);
        cola1.acolarPrioridad(5,7);
        cola1.acolarPrioridad(8, 8);

        
        metodosColasP.unificarColasP(cola1, cola2, colaRes);

        metodosColasP.imprimirCola(colaRes);

    }
}
