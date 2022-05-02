package misAplicaciones;

import misApi.ColaTDA;
import misApi.ConjuntoTDA;
import misImplementacionesDinamicas.ColaDinamica;
import misImplementacionesDinamicas.ConjuntoDinamico;

public class ej4FinalJunio {

    public static void main (String [] args){
        ConjuntoTDA c1 = new ConjuntoDinamico();
        ConjuntoTDA c2 = new ConjuntoDinamico();
        ColaTDA pc = new ColaDinamica();

        c1.agregar(1);
        c1.agregar(2);
        c1.agregar(3);

        c2.agregar(5);
        c2.agregar(6);

        pc = calcularProductoCartesiano(c1, c2);

        while(!pc.colaVacia()){
            System.out.println(pc.primero());
            pc.desacolar();
        }
    }
    public static ColaTDA calcularProductoCartesiano (ConjuntoTDA c1, ConjuntoTDA c2){
        ColaTDA productoCartesiano = new ColaDinamica();
        ConjuntoTDA c2Aux = new ConjuntoDinamico();

        productoCartesiano.inicializarCola();
        c2Aux.inicializarConjunto();

        while (!c1.conjuntoVacio()){
            int elemC1 = c1.obtener();
            
            clonarConjunto(c2, c2Aux);
            while (!c2Aux.conjuntoVacio()){
                int elemC2 = c2Aux.obtener();
                productoCartesiano.acolar(elemC1);
                productoCartesiano.acolar(elemC2);
                c2Aux.sacar(elemC2);
            }
            c1.sacar(elemC1);
        }
        return productoCartesiano;
    }

    public static void clonarConjunto(ConjuntoTDA lleno, ConjuntoTDA vacio) {
        ConjuntoTDA aux = new ConjuntoDinamico();

        aux.inicializarConjunto();

        while (!lleno.conjuntoVacio()){
            int x = lleno.obtener();
            aux.agregar(x);
            lleno.sacar(x);
        }

        while (!aux.conjuntoVacio()){
            int x = aux.obtener();
            lleno.agregar(x);
            vacio.agregar(x);
            aux.sacar(x);
        }
    }

    
}
