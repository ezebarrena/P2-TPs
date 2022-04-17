package misAplicaciones;

import misApi.ColaTDA;
import misImplementacionesDinamicas.ColaDinamica;
import misMetodos.MetodosColas;

public class Clase4ej2c {
    public static void main (String [] args) throws Exception{
        ColaTDA cola = new ColaDinamica();
        ColaTDA m1 = new ColaDinamica();
        ColaTDA m2 = new ColaDinamica();

        cola.inicializarCola();
        m1.inicializarCola();
        m2.inicializarCola();

        cola.acolar(1);
        cola.acolar(2);
        cola.acolar(3);
        cola.acolar(4);
        cola.acolar(5);
        cola.acolar(6);
        cola.acolar(7);
        cola.acolar(8);


        MetodosColas metodosColas = new MetodosColas();

        metodosColas.dividirCola(cola, m1, m2);


        System.out.println("--Mitad 1--");
        metodosColas.imprimirCola(m1);
        
        System.out.println("--Mitad 2--");
        metodosColas.imprimirCola(m2);
    }
}
