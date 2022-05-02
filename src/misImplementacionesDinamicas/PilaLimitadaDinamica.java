package misImplementacionesDinamicas;

import misApi.PilaLimitadaTDA;

public class PilaLimitadaDinamica implements PilaLimitadaTDA{

    class Nodo {
        int info;
        int indice;
        Nodo sig;
    }

    Nodo primero;
    int maxSize;
    int cant;
    

    @Override
    public void inicializarPila(int size) {
        // TODO Auto-generated method stub
        primero = null; 

        maxSize = size;
        cant = 0;
    }

    @Override
    public void apilar(int x) {
        // TODO Auto-generated method stub
        Nodo aux = new Nodo();
        Nodo aux2 = new Nodo();

        cant++;
        aux.info = x;
        aux.sig = primero;
        aux.indice = cant;

        primero = aux;
        


        if (cant > maxSize){

            while (aux.indice < cant){
                aux2.sig = aux;
                aux = aux.sig;

                if (aux.indice == cant){
                    aux = null;
                }

            }
        }
    }

    @Override
    public void desapilar() {
        // TODO Auto-generated method stub
        primero = primero.sig;
    }

    @Override
    public boolean pilaVacia() {
        // TODO Auto-generated method stub
        return primero == null;
    }

    @Override
    public int tope() {
        // TODO Auto-generated method stub
        return primero.info;
    }
    
}
