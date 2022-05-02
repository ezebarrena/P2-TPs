package misAplicaciones;

import misApi.ABBTDA;
import misImplementacionesDinamicas.ABB;

public class ej2FinalVerano {

    public static void main (String [] args){
        ABBTDA arbol = new ABB();

        arbol.inicializarArbol();
        
        arbol.agregarElem(2);
        arbol.agregarElem(1);
        arbol.agregarElem(3);
        arbol.agregarElem(5);

        System.out.println (alturaMaxABB(arbol));

    }
    public static int alturaMaxABB (ABBTDA arbol){
        if (arbol.arbolVacio()){
            return (-1);
        }
        else {
            if (alturaMaxABB(arbol.HijoDer()) > alturaMaxABB(arbol.HijoIzq())){
                return 1 + alturaMaxABB(arbol.HijoDer());
            }
            else {
                return 1 + alturaMaxABB(arbol.HijoIzq());
            }
        }
    }
}
