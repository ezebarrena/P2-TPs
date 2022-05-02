package misAplicaciones;

import misApi.ABBTDA;

public class ej3FinalJunio {
    
    public static int menorElemento (ABBTDA arbol){
        if (!arbol.HijoIzq().arbolVacio()){
            return (menorElemento(arbol.HijoIzq()));
        }
        else{
            return (arbol.raiz());
        }
    }

    public static int mayorElemento (ABBTDA arbol){
        if (!arbol.HijoDer().arbolVacio()){
            return (mayorElemento(arbol.HijoDer()));
        }
        else {
            return (arbol.raiz());
        }
    }

    public static int calcularX (ABBTDA a1, ABBTDA a2){
        int x1 = mayorElemento(a1) - menorElemento(a1);
        int x2 = mayorElemento(a2) - menorElemento(a2);

        int x = x1 - x2;

        return x;
    }
}
