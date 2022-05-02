package misAplicaciones;

import misApi.ConjuntoTDA;
import misApi.GrafoTDA;
import misImplementacionesDinamicas.ConjuntoDinamico;
import misImplementacionesDinamicas.GrafoDinamico;

public class ej3FinalVerano {
    
    public static void main (String [] args){
        GrafoTDA grafo = new GrafoDinamico();
        ConjuntoTDA vertIniciales = new ConjuntoDinamico();
        ConjuntoTDA vertFinales = new ConjuntoDinamico();

        vertIniciales.inicializarConjunto();
        grafo.inicializarGrafo();

        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);

        grafo.agregarArista(1, 3, 1);
        grafo.agregarArista(1, 2, 1);
        grafo.agregarArista(3, 4, 1);
        grafo.agregarArista(2, 4, 1);
        grafo.agregarArista(5, 4, 1);

        vertIniciales = verticesIniciales(grafo);
        vertFinales = verticesFinales(grafo);
        System.out.println("VERTICES INICIALES");
        imprimirConjunto(vertIniciales);
        System.out.println("VERTICES FINALES");
        imprimirConjunto(vertFinales);
    }

    public static ConjuntoTDA verticesIniciales (GrafoTDA grafo){
        ConjuntoTDA vertIniciales = new ConjuntoDinamico();
        vertIniciales.inicializarConjunto();
        ConjuntoTDA vertices=grafo.vertices();

        while (!vertices.conjuntoVacio()){ // candidatos a iniciales
            boolean inicial=true;
            int v = vertices.obtener();
            ConjuntoTDA otros=grafo.vertices(); //los otros vertices que voy a comparar
            otros.sacar(v); //saco el vertice de referencia para no compararlo con el mismo
            while(!otros.conjuntoVacio() && inicial) { //mientras no haya comparado todos y siga siendo inicial
                int otro=otros.obtener(); //elijo un vertice a comparar
                if (grafo.existeArista(otro, v )) {// si existe arista que termina en vertice de referencia
                    inicial = false; // deja de ser inicial
                }
                otros.sacar(otro);
            }
            if (inicial){ //si luego de comparar con todos, es inicial
                vertIniciales.agregar(v); //que lo agregue al conjunto
                vertices.sacar(v); //que lo saque de vertices a chequear
            }
            else { //si no es inicial
                vertices.sacar(v); //que saque el vertice y siga comparando
            }
        }
        return vertIniciales; //devuelva el conjunto de vertices
    }

    public static ConjuntoTDA verticesFinales(GrafoTDA grafo) {
        ConjuntoTDA vertFinales = new ConjuntoDinamico();
        vertFinales.inicializarConjunto();
        ConjuntoTDA vertices = grafo.vertices();

        while (!vertices.conjuntoVacio()){
            boolean finale = true;
            int vertice = vertices.obtener();
            ConjuntoTDA otros = grafo.vertices();
            otros.sacar(vertice);
            while (!otros.conjuntoVacio() && finale){
                int otro = otros.obtener();
                if (grafo.existeArista(vertice, otro)){
                    finale = false;
                }
                otros.sacar(otro);
            }
            if (finale){
                vertFinales.agregar(vertice);
                vertices.sacar(vertice);
            }
            else {
                vertices.sacar(vertice);
            }
        }
        return vertFinales;
    }

    public static void imprimirConjunto ( ConjuntoTDA c){
        while (!c.conjuntoVacio()){
            int valor = c.obtener();
            System.out.println(valor);
            c.sacar(valor);
        }
    }
}