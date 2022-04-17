package misAplicaciones;

import misApi.PilaTDA;
import misImplementacionesDinamicas.PilaDinamica;
import misMetodos.*;

public class Clase4ej2a {
    public static void main (String [] args) throws Exception{
        PilaTDA pila1 = new PilaDinamica();
        PilaTDA pila2 = new PilaDinamica();

        MetodosPilas metodosPilas = new MetodosPilas();

        pila1.inicializarPila();
        pila2.inicializarPila();

        pila1.apilar(1);
        pila1.apilar(3);
        pila1.apilar(4);
        pila1.apilar(5);
        pila1.apilar(7);
        pila1.apilar(4);

        pila2.apilar(4);
        pila2.apilar(5);
        pila2.apilar(6);

        System.out.println(metodosPilas.longPila(pila1));
        System.out.println(metodosPilas.longPila(pila2));


        System.out.println(metodosPilas.longPila(pila1));
        System.out.println(metodosPilas.longPila(pila2));
        
        boolean pertenece = metodosPilas.ej2A(pila1, pila2);

        System.out.println(pertenece);
    }
}
