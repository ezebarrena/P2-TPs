package misAplicaciones;

import misApi.ColaTDA;
import misImplementacionesDinamicas.ColaDinamica;
import misMetodos.MetodosColas;

public class Clase4ej2d {
    public static void main (String [] args) throws Exception{
        ColaTDA cola = new ColaDinamica();
        

        cola.inicializarCola();

        cola.acolar(1);
        cola.acolar(1);
        cola.acolar(1);
        cola.acolar(0);
        cola.acolar(1);
        cola.acolar(1);
        cola.acolar(1);
        cola.acolar(1);
        cola.acolar(1);
        cola.acolar(0);
        cola.acolar(1);
        cola.acolar(1);
        cola.acolar(1);
        cola.acolar(1);
        cola.acolar(0);
        

        MetodosColas metodosColas = new MetodosColas();

        int num = metodosColas.secuenciaMasLarga(cola);

        System.out.println("La secuencia mas larga es de " + num + " elementos");
    }
}
