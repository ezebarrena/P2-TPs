package misAplicaciones;

import misApi.ABBTDA;
import misApi.ColaTDA;
import misApi.ConjuntoTDA;
import misApi.DiccionarioSimpleTDA;
import misImplementacionesDinamicas.ColaDinamica;
import misImplementacionesDinamicas.DiccionarioSimpleDinamico;
import misImplementacionesDinamicas.ABB;

public class ej2FinalT1 {

    public static void main (String [] args){
        ABBTDA arbol = new ABB();
        DiccionarioSimpleTDA diccio = new DiccionarioSimpleDinamico();
        arbol.inicializarArbol();

        arbol.agregarElem(41);
        arbol.agregarElem(33);
        arbol.agregarElem(80);
        arbol.agregarElem(60);
        arbol.agregarElem(90);
        arbol.agregarElem(65);

        diccio = obtenerDiccio(arbol);
        
        imprimirDiccionarioSimple(diccio);

    }
    public static DiccionarioSimpleTDA obtenerDiccio (ABBTDA arbol){
        DiccionarioSimpleTDA diccio = new DiccionarioSimpleDinamico();
        ColaTDA elementosABB = new ColaDinamica();
        diccio.inicializarDiccionario();

        elementosABB.inicializarCola();
        colaElementosABB(arbol, elementosABB);

        while (!elementosABB.colaVacia()){
            int valor = elementosABB.primero();

            int profundidad = profundidadElemento(arbol, valor);

            diccio.agregar(profundidad, valor);

            elementosABB.desacolar();
        }

        return diccio;

    }

    public static void colaElementosABB (ABBTDA arbol, ColaTDA elementos){
        if (!arbol.arbolVacio()){
            elementos.acolar(arbol.raiz());
            colaElementosABB(arbol.HijoIzq(), elementos);
            colaElementosABB(arbol.HijoDer(), elementos);
        }
    }

    public static int profundidadElemento (ABBTDA arbol, int x){
        if (arbol.arbolVacio()){
            return 0;
        }
        else if(arbol.raiz() == x){
            return 0;
        }
        else if (arbol.raiz() > x){
            return (1 + profundidadElemento(arbol.HijoIzq(), x));
        }
        else {
            return (1 + profundidadElemento(arbol.HijoDer(), x));
        }
    }

    public static int alturaABB (ABBTDA arbol){
        if (arbol.arbolVacio()){
            return 0;
        }
        else {
            if (alturaABB(arbol.HijoDer()) > alturaABB(arbol.HijoIzq())){
                return 1 + alturaABB(arbol.HijoDer());
            }
            else {
                return 1 + alturaABB(arbol.HijoIzq());
            }
        }
    }

    public static void imprimirDiccionarioSimple (DiccionarioSimpleTDA diccio){
        ConjuntoTDA claves = diccio.claves();

        while (!claves.conjuntoVacio()){
            int clave = claves.obtener();
            int valor = diccio.obtener(clave);

            System.out.println("Clave: " + clave + ", Valor: " + valor);
            claves.sacar(clave);
        }
    }
}
