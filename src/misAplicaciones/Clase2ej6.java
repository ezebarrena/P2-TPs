package misAplicaciones;

import misApi.ColaPrioridadTDA;
import misImplementacionesEstaticas.ColaPrioridad;

public class Clase2ej6 {

    public static void main (String[] args) throws Exception{
        ColaPrioridadTDA cola = new ColaPrioridad();
        ColaPrioridadTDA colaMod = new ColaPrioridad();

        //colaMod.inicializarCola();
        cola.inicializarCola();

        cola.acolarPrioridad(7, 1);
        cola.acolarPrioridad(4, 2);
        cola.acolarPrioridad(6, 2);
        cola.acolarPrioridad(3, 2);
        cola.acolarPrioridad(5, 4);
        cola.acolarPrioridad(8, 4);
        cola.acolarPrioridad(7, 2);

        colaMod = colaSinReps(cola);

        colaMod.imprimirCola();

    }

    public static ColaPrioridadTDA colaSinReps (ColaPrioridadTDA c1){
        ColaPrioridadTDA colaNueva = new ColaPrioridad();
        colaNueva.inicializarCola();

        int valor;
        int priori;
        int siguientePriori;
        int siguienteValor;
        
        
        while (!c1.colaVacia()){
            int i = 1;
            int suma = 0;
            int prom = 0;

            valor = c1.primero();
            priori = c1.prioridad();

            c1.desacolar();

            if (!c1.colaVacia()){
                siguienteValor = c1.primero();
                siguientePriori = c1.prioridad();


                while (priori == siguientePriori && !c1.colaVacia()){
                    c1.desacolar();
                    if (i == 1){
                        suma = suma + valor + siguienteValor;
                    }
                    else{
                        suma = suma + valor;
                    }
                    valor = c1.primero();
                    priori = c1.prioridad();

                    
                    i++;
                    
                
                }
                if (i > 1){
                    prom = suma / i;
                    valor = prom;
                    priori = siguientePriori;
                }
            }
            colaNueva.acolarPrioridad(valor, priori);

        }

        return colaNueva;
    }
}

