package misImplementacionesEstaticas;

import misApi.ConjuntoTDA;
import misApi.GrafoTDA;

public class Grafo implements GrafoTDA {


    private int [][] matriz;
    private int [] etiquetas;
    private int cant;

    @Override
    public void inicializarGrafo() {
        // TODO Auto-generated method stub
        matriz = new int [100][100];
        etiquetas = new int [100];
        cant = 0;
    }

    @Override
    public void agregarVertice(int vert) {
        // TODO Auto-generated method stub
        
        etiquetas[cant] = vert;

        for (int i = 0; i < cant; i++){
            matriz[cant][i] = 0;
            matriz[i][cant] = 0;
        }

        cant ++;
    }

    @Override
    public void eliminarVertice(int vert) {
        // TODO Auto-generated method stub
        int pos = buscaPos(vert);
        etiquetas[pos] = etiquetas[cant - 1];

        for (int i = 0; i < cant; i++){
            matriz[pos][i] = matriz[cant - 1][i];
            matriz[i][pos] = matriz[i][cant - 1];
        }
        cant--;
    }

    @Override
    public void agregarArista(int origen, int destino, int peso) {
        // TODO Auto-generated method stub
        int pos1 = buscaPos(origen);
        int pos2 = buscaPos(destino);
        matriz[pos1][pos2] = peso;
    }

    @Override
    public void eliminarArista(int origen, int destino) {
        // TODO Auto-generated method stub
        int pos1 = buscaPos(origen);
        int pos2 = buscaPos(destino);
        matriz[pos1][pos2] = 0;
        
    }

    @Override
    public ConjuntoTDA vertices() {
        // TODO Auto-generated method stub
        ConjuntoTDA verts = new Conjunto();

        verts.inicializarConjunto();

        for (int i = 0; i< cant; i ++){
            verts.agregar(etiquetas[i]);

        }

        return verts;
    }

    @Override
    public int peso(int origen, int destino) {
        // TODO Auto-generated method stub

        int pos1 = buscaPos(origen);
        int pos2 = buscaPos(destino);

        return matriz[pos1][pos2];
    }

    @Override
    public boolean existeArista(int vert1, int vert2) {
        // TODO Auto-generated method stub
        return peso(vert1, vert2) != 0;
    }


    private int buscaPos(int vertice){
        int pos = 0;
        while (etiquetas[pos] != vertice){
            pos++;
        }
        return pos;
    }
    
}
