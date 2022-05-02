package misAplicaciones;

import misApi.PilaLimitadaTDA;
import misImplementacionesDinamicas.PilaLimitadaDinamica;

public class ej4FinalVerano {
    public static void main (String [] args){
        PilaLimitadaTDA PilaL = new PilaLimitadaDinamica();

        PilaL.inicializarPila(3);

        PilaL.apilar(1);
        PilaL.apilar(2);
        PilaL.apilar(3);
        PilaL.apilar(4);
        imprirPila(PilaL);

    }

    public static void imprirPila (PilaLimitadaTDA pila){
        while (!pila.pilaVacia()){
            System.out.println(pila.tope());
            pila.desapilar();
        }
    }
}

 