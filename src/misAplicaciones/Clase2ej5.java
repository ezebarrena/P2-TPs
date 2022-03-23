package misAplicaciones;

import misApi.ColaPrioridadTDA;
import misApi.ConjuntoTDA;
import misImplementacionesEstaticas.ColaPrioridad;
import misImplementacionesEstaticas.Conjunto;

public class Clase2ej5 {
    public static void main (String[] args) throws Exception{
        ConjuntoTDA c1 = new Conjunto();
        ConjuntoTDA c2 = new Conjunto();

        c1.inicializarConjunto();
        c2.inicializarConjunto();

        c1.agregar(5);
        c1.agregar(4);
        c1.agregar(8);
        c1.agregar(7);

        c2.agregar(8);
        c2.agregar(4);
        c2.agregar(9);
        c2.agregar(7);
        boolean resultado;
        resultado = compararConjuntos(c1, c2);

        System.out.println(resultado);
    }

    public static boolean compararConjuntos (ConjuntoTDA conj1, ConjuntoTDA conj2){
        
        ColaPrioridadTDA colaAux1 = new ColaPrioridad();
        ColaPrioridadTDA colaAux2 = new ColaPrioridad();

        colaAux1.inicializarCola();
        colaAux2.inicializarCola();

        int valor1;
        int valor2;

        while (!conj1.conjuntoVacio() && !conj2.conjuntoVacio()){
            int i = 0;

            valor1 = conj1.obtener();
            valor2 = conj2.obtener();

            conj1.sacar(valor1);
            conj2.sacar(valor2);

            colaAux1.acolarPrioridad(i, valor1);
            colaAux2.acolarPrioridad(i, valor2);

            i++;
        }

        

        while (!colaAux1.colaVacia() && !colaAux2.colaVacia()){
            valor1 = colaAux1.prioridad();
            valor2 = colaAux2.prioridad();
            if (valor1 != valor2){
                return false;
            }
            colaAux1.desacolar();
            colaAux2.desacolar();
        }

        return true;
    }
}
