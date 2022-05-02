package misAplicaciones;

import misApi.ColaTDA;
import misApi.PilaTDA;
import misImplementacionesDinamicas.ColaDinamica;
import misImplementacionesDinamicas.PilaDinamica;

public class ej1FinalT1 {
    public static void main (String [] args){
        ColaTDA cola = new ColaDinamica();
        PilaTDA pila = new PilaDinamica();

        cola.inicializarCola();
        pila.inicializarPila();

        cola.acolar(5);
        cola.acolar(2);
        
       
        pila.apilar(5);
        pila.apilar(2);
                
        System.out.println(mismosElemsPilaCola(pila, cola));
    }

    public static boolean mismosElemsPilaCola (PilaTDA pila, ColaTDA cola){
        ColaTDA aux = new ColaDinamica();
        
        sacarRepsCola(cola);
        pilaSinReps(pila);

        boolean igualdad = false;

        if (cantidadElementosCola(cola) != cantidadElementosPila(pila)){
            return igualdad;
        }

        else {
            while (!pila.pilaVacia()){
                cola.acolar(pila.tope());
                pila.desapilar();
            }
            //quedo unificado y ahora vamos a mirar el arreglo

            
            while (!cola.colaVacia()){
                int valor = cola.primero();
                cola.desacolar();

                
                if (perteneceACola(valor, cola)){
                    igualdad = true;
                }
                else {
                    igualdad = false;
                }
                
            }
            
        }
        return igualdad;
    }

    public static int cantidadElementosCola (ColaTDA cola){
        ColaTDA aux = new ColaDinamica();
        aux.inicializarCola();
        int cant = 0;

        clonarCola(cola, aux);

        while (!aux.colaVacia()){
            cant++;
            aux.desacolar();
        }

        return cant;
    }
    public static boolean perteneceACola (int x, ColaTDA cola){
        ColaTDA aux = new ColaDinamica();
        aux.inicializarCola();

        clonarCola(cola, aux);

        while (!aux.colaVacia()){
            if (x == aux.primero()){
                return true;
            }
            aux.desacolar();
        }
        return false;
    }

    public static void clonarCola (ColaTDA llena, ColaTDA vacia){
        ColaTDA aux = new ColaDinamica();
        aux.inicializarCola();

        while (!llena.colaVacia()){
            aux.acolar(llena.primero());
            llena.desacolar();
        }

        while (!aux.colaVacia()){
            llena.acolar(aux.primero());
            vacia.acolar(aux.primero());
            aux.desacolar();
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

    public static void pasarColaCola(ColaTDA llena, ColaTDA vacia){
        while (!llena.colaVacia()){
            vacia.acolar(llena.primero());
            llena.desacolar();
        }
    }

    public static void pilaSinReps (PilaTDA pila){
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

    public static void clonarPila (PilaTDA llena, PilaTDA vacia){
        PilaTDA aux = new PilaDinamica();
        aux.inicializarPila();

        while (!llena.pilaVacia()){
            aux.apilar(llena.tope());
            llena.desapilar();
        }

        while (!aux.pilaVacia()){
            llena.apilar(aux.tope());
            vacia.apilar(aux.tope());

            aux.desapilar();
        }
    }
    
    public static int cantidadElementosPila (PilaTDA pila){
        PilaTDA aux = new PilaDinamica();

        aux.inicializarPila();

        int i = 0;
        clonarPila(pila, aux);
        
        while (!aux.pilaVacia()){
            i++;
            aux.desapilar();
        }
        return i;
    }

}
