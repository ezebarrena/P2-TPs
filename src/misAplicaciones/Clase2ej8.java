package misAplicaciones;

import misApi.ConjuntoTDA;
import misImplementacionesDinamicas.ConjuntoDinamico;

public class Clase2ej8 {
    
    public static void main (String [] args){


        ConjuntoTDA c1 = new ConjuntoDinamico();
        ConjuntoTDA c2 = new ConjuntoDinamico();

        ConjuntoTDA unido = metodoUnion(c1, c2);

        
        
    }

    public static ConjuntoTDA metodoUnion (ConjuntoTDA c1, ConjuntoTDA c2){
        ConjuntoTDA cRes = new ConjuntoDinamico();
        cRes.inicializarConjunto();

        while (!c1.conjuntoVacio()){
            int valor = c1.obtener();
            cRes.agregar(valor);
            c1.sacar(valor);
        }
        while (!c2.conjuntoVacio()){
            int valor = c2.obtener();
            cRes.agregar(valor);
            c2.sacar(valor);
        }
        
        return cRes;
    }

    public static ConjuntoTDA metodoInterseccion (ConjuntoTDA c1, ConjuntoTDA c2){
        ConjuntoTDA cRes = new ConjuntoDinamico();
        cRes.inicializarConjunto();

        while (!c1.conjuntoVacio()){
            int valor = c1.obtener();

            if (c2.pertenece(valor)){
                cRes.agregar(valor);
                c2.sacar(valor);
            }
            c1.sacar(valor);
        }
        return cRes;
    }

    public static ConjuntoTDA metodoDiferencia (ConjuntoTDA c1, ConjuntoTDA c2){
        ConjuntoTDA cRes = new ConjuntoDinamico();
        cRes.inicializarConjunto();

        while (!c1.conjuntoVacio()){
            int valor = c1.obtener();

            if (!c2.pertenece(valor)){
                cRes.agregar(valor);
            }

            c1.sacar(valor);
        }

        return cRes;
    }

    public static ConjuntoTDA metodoDiferenciaSimetrica (ConjuntoTDA c1, ConjuntoTDA c2){
        ConjuntoTDA cRes = new ConjuntoDinamico();
        cRes.inicializarConjunto();

        while (!c1.conjuntoVacio()){
            int valor = c1.obtener();

            if (!c2.pertenece(valor)){
                cRes.agregar(valor);
            }
            c1.sacar(valor);
        }
        return cRes;
    }
}
