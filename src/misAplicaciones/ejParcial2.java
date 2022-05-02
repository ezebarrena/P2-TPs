package misAplicaciones;

import misApi.ColaTDA;
import misApi.PilaTDA;
import misImplementacionesDinamicas.ColaDinamica;
import misImplementacionesDinamicas.PilaDinamica;

public class ejParcial2 {

    public static void main (String [] args){
        ColaTDA cola = new ColaDinamica();
        PilaTDA pila = new PilaDinamica();
        ColaTDA res = new ColaDinamica();

        cola.inicializarCola();
        pila.inicializarPila();

        cola.acolar(7);
        cola.acolar(1);
        cola.acolar(1);
        cola.acolar(7);
        cola.acolar(3);
        cola.acolar(2);
        cola.acolar(3);
        cola.acolar(20);

        pila.apilar(4);
        pila.apilar(20);
        pila.apilar(2);
        pila.apilar(30);
        pila.apilar(21);
        pila.apilar(1);
        pila.apilar(15);

        res = mismosElementos(cola, pila);

        impresora(res);
        
    }

    public static ColaTDA mismosElementos (ColaTDA cola, PilaTDA pila){
        ColaTDA colaSinReps = new ColaDinamica();
        PilaTDA pilaSinReps = new PilaDinamica();
        ColaTDA elemReps = new ColaDinamica();
        ColaTDA cAux = new ColaDinamica();

        pilaSinReps.inicializarPila();
        colaSinReps.inicializarCola();
        elemReps.inicializarCola();
        cAux.inicializarCola();

        pasarPilaPila(pilaSinReps, pila);
        sacarRepsPila(pilaSinReps);

        pasarColaCola(cola, colaSinReps);
        sacarRepsCola(colaSinReps);

        //voy a unificar ambos arreglos que ya no tienen repetidos
        while (!pilaSinReps.pilaVacia()){
            colaSinReps.acolar(pilaSinReps.tope());
            pilaSinReps.desapilar();
        }
        //quedan unificadas en cola sin repetidos
        /*
        ahora voy a comparar todo el arreglo y guardar los elementos repetidos
        que serian los que comparten
        */

        while (!colaSinReps.colaVacia()){
            int valor = colaSinReps.primero();
            boolean agregar = false;
            colaSinReps.desacolar();

            while (!colaSinReps.colaVacia()){
                if (valor != colaSinReps.primero()){
                    cAux.acolar(colaSinReps.primero());
                    
                }
                else {
                    agregar = true;
                }
                colaSinReps.desacolar();
            }

            if (agregar){
                elemReps.acolar(valor);
            }

            pasarColaCola(cAux, colaSinReps);
        }

        return elemReps;
    }

    public static void pasarColaCola(ColaTDA llena, ColaTDA vacia){
        while (!llena.colaVacia()){
            vacia.acolar(llena.primero());
            llena.desacolar();
        }
    }

    public static void impresora (ColaTDA c){
        while (!c.colaVacia()){
            System.out.println(c.primero());
            c.desacolar();
        }
    }

    public static void pasarDeColaAPila (ColaTDA colaLlena, PilaTDA pilaVacia){
        

        while (!colaLlena.colaVacia()){
            pilaVacia.apilar(colaLlena.primero());
            colaLlena.desacolar();
        }

    }

    public static void sacarRepsPila (PilaTDA pila){
        PilaTDA aux1 = new PilaDinamica();
        PilaTDA aux2 = new PilaDinamica();

        aux1.inicializarPila();
        aux2.inicializarPila();

        pasarPilaPila (aux1, pila);

        while (!aux1.pilaVacia()){
            int valorABuscar = aux1.tope();
            aux1.desapilar();

            while (!aux1.pilaVacia()){
                if (aux1.tope() != valorABuscar){
                    aux2.apilar(aux1.tope());
                }
                aux1.desapilar();
            }
            pasarPilaPila(aux1, aux2);
            pila.apilar(valorABuscar);
        }
    }

    public static void pasarPilaPila (PilaTDA vacia, PilaTDA llena){
        while (!llena.pilaVacia()){
            vacia.apilar(llena.tope());
            llena.desapilar();
        }
    }

    public static void sacarRepsCola (ColaTDA cola){
        ColaTDA aux1 = new ColaDinamica();
        ColaTDA aux2 = new ColaDinamica();

        aux1.inicializarCola();
        aux2.inicializarCola();

        pasarColaCola(cola, aux1);

        while (!aux1.colaVacia()){
            int valorABuscar = aux1.primero();
            aux1.desacolar();

            while (!aux1.colaVacia()){
                if (aux1.primero() != valorABuscar){
                    aux2.acolar(aux1.primero());
                }
                aux1.desacolar();
            }
            pasarColaCola(aux2, aux1);
            cola.acolar(valorABuscar);
        }
    }
}
