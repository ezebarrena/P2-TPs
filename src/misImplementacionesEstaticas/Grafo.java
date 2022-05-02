package misImplementacionesEstaticas;

import misApi.ConjuntoTDA;
import misApi.GrafoTDA;

public class Grafo implements GrafoTDA {

    static int n = 100;
    private int [][] MAdy;
    private int [] etiquetas;
    private int cantNodos;

    @Override
    public void inicializarGrafo() {
        // TODO Auto-generated method stub
        MAdy = new int [n][n];
        etiquetas = new int [n];
        cantNodos = 0;
    }

    @Override
    public void agregarVertice(int vert) {
        // TODO Auto-generated method stub
        
        etiquetas[cantNodos] = vert;

        for (int i = 0; i < cantNodos; i++){
            MAdy[cantNodos][i] = 0;
            MAdy[i][cantNodos] = 0;
        }

        cantNodos ++;
    }

    @Override
    public void eliminarVertice(int vert) {
        // TODO Auto-generated method stub
        int ind = Vert2Indice(vert);

        

        for (int k = 0; k < cantNodos; k++){
            MAdy[k][ind] = MAdy[k][cantNodos-1];
            MAdy[ind][k] = MAdy[cantNodos-1][k];
        }

        etiquetas[ind] = etiquetas[cantNodos -1];
        cantNodos--;
    }

    private int Vert2Indice(int v){
        int i = cantNodos-1;
        while (i>= 0 && etiquetas[i] != v){
            i--;
        }
        return i;
    }

    @Override
    public void agregarArista(int origen, int destino, int peso) {
        // TODO Auto-generated method stub
        int o = Vert2Indice(origen);
        int d = Vert2Indice(destino);
        MAdy[o][d] = peso;
    }

    @Override
    public void eliminarArista(int origen, int destino) {
        // TODO Auto-generated method stub
        int o = Vert2Indice(origen);
        int d = Vert2Indice(destino);
        MAdy[o][d] = 0;
        
    }

    @Override
    public ConjuntoTDA vertices() {
        // TODO Auto-generated method stub
        ConjuntoTDA verts = new Conjunto();

        verts.inicializarConjunto();

        for (int i = 0; i< cantNodos; i ++){
            verts.agregar(etiquetas[i]);
        }

        return verts;
    }

    @Override
    public int peso(int origen, int destino) {
        // TODO Auto-generated method stub

        int o = Vert2Indice(origen);
        int d = Vert2Indice(destino);

        return MAdy[o][d];
    }

    @Override
    public boolean existeArista(int vert1, int vert2) {
        // TODO Auto-generated method stub
        int o = Vert2Indice(vert1);
        int d = Vert2Indice(vert2);

        return MAdy[o][d] != 0;
    }
}
