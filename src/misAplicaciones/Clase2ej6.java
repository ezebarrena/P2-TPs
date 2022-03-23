package misAplicaciones;

import misApi.ColaPrioridadTDA;
import misImplementacionesEstaticas.ColaPrioridad;

public class Clase2ej6 {

    public static void main (String[] args) throws Exception{

    }

    public static ColaPrioridadTDA colaSinReps (ColaPrioridadTDA c1){
        ColaPrioridadTDA colaNueva = new ColaPrioridad();
        colaNueva.inicializarCola();

        int valor;
        int priori;
        int siguientePriori;
        int siguienteValor;
        int suma = 0;
        int i = 1;

        while (!c1.colaVacia()){
            
            valor = c1.primero();
            priori = c1.prioridad();

            c1.desacolar();
            if (!c1.colaVacia()){
                siguienteValor = c1.primero();
                siguientePriori = c1.prioridad();


                while (priori == siguientePriori && !c1.colaVacia()){
                    c1.desacolar();

                    suma = suma + valor;

                    valor = c1.primero();
                    priori = c1.prioridad();

                    c1.desacolar();

                    siguienteValor = c1.primero();
                    siguientePriori = c1.prioridad();

                    i++;
                }
            }
            colaNueva.acolarPrioridad(valor, priori);

        }

        return colaNueva;
    }
}

