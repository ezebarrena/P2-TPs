package misAplicaciones;

import misApi.ColaPrioridadTDA;
import misApi.ColaTDA;
import misImplementacionesEstaticas.ColaPrioridad;
import misImplementacionesEstaticas.ColaTopeIni;

public class Clase2ej4 {
    public static void main(String[] args) throws Exception{
        ColaTDA cola = new ColaTopeIni();
        cola.inicializarCola();

        cola.acolar(20);
        cola.acolar(3);
        cola.acolar(5);
        cola.acolar(1);
        cola.acolar(4);
        cola.acolar(2);

        System.out.println("---DESORDENADA---");
        cola.imprimir();
        System.out.println("-----------------");
        cola = ordenarCola(cola);
        System.out.println("-----ORDENADA----");
        cola.imprimir();

    }

    public static ColaTDA ordenarCola (ColaTDA cola){
        ColaPrioridadTDA colaPrio = new ColaPrioridad();
        colaPrio.inicializarCola();
        
        int prioridad;
        int i = 0;

        while (!cola.colaVacia()){
            prioridad = cola.primero();
            cola.desacolar();

            colaPrio.acolarPrioridad(i, prioridad);

            i++;
        }

        int valor;
        while (!colaPrio.colaVacia()){
            valor = colaPrio.prioridad();
            cola.acolar(valor);
            colaPrio.desacolar();

        }

        return cola;
    }
    public static void colaToCola(ColaTDA cola1, ColaTDA cola2) {
        
        int valor;

        while (!cola1.colaVacia()) {
            valor = cola1.primero();
            cola1.desacolar();

            cola2.acolar(valor);
        }
    }
}
