package misAplicaciones;

import misApi.ConjuntoTDA;
import misApi.GrafoTDA;
import misImplementacionesDinamicas.ConjuntoDinamico;

public class ej2FinalJunio {
    public static ConjuntoTDA obtenerVecindario (GrafoTDA grafo, int x){
        ConjuntoTDA vecindario = new ConjuntoDinamico();
        vecindario.inicializarConjunto();

        ConjuntoTDA vertices = grafo.vertices();
        vertices.sacar(x);

        while (!vertices.conjuntoVacio()){
            int destino = vertices.obtener();
            if (grafo.existeArista(x, destino)){
                vecindario.agregar(destino);
            }
            vertices.sacar(destino);
        }
        return vecindario;

    }

    public static ConjuntoTDA interseccionEntreConjuntos (ConjuntoTDA c1, ConjuntoTDA c2){
        ConjuntoTDA interseccion = new ConjuntoDinamico();
        interseccion.inicializarConjunto();

        while (!c1.conjuntoVacio()){
            int x = c1.obtener();
            if (c2.pertenece(x)){
                interseccion.agregar(x);
            }

            c1.sacar(x);
        }
        return interseccion;
    }

    public static ConjuntoTDA verticesConVecindarioComun (GrafoTDA g, int v1, int v2){
        ConjuntoTDA vecindario1 = obtenerVecindario(g, v1);
        ConjuntoTDA vecindario2 = obtenerVecindario(g, v2);

        ConjuntoTDA interseccionVecindarios = interseccionEntreConjuntos(vecindario1, vecindario2);

        return interseccionVecindarios;
    }

}
