package misAplicaciones;

import misApi.MultiConjuntoTDA;
import misImplementacionesEstaticas.MultiConjuntoEstatico;

public class ej1FinalJunio {
    public static void main (String [] args){
        MultiConjuntoTDA multiC = new MultiConjuntoEstatico();
        multiC.inicializarMultiConjunto();

        multiC.agregar(5);
        multiC.agregar(5);
        multiC.agregar(3);
        multiC.agregar(5);
        multiC.agregar(3);
        multiC.sacar(5);

        System.out.println(multiC.multiplicidad(5));

    }
}
