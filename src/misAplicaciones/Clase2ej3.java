package misAplicaciones;

import misApi.ColaTDA;
import misImplementacionesEstaticas.ColaTopeIni;

public class Clase2ej3 {
    public static void main(String[] args) throws Exception {
        ColaTDA cola = new ColaTopeIni();

        cola.inicializarCola();

        for (int i = 1; i<6; i++){
            cola.acolar(i);
        }
        System.out.println("--COLA ORIGINAL--");
        cola.imprimir();
        System.out.println("-----------------");
        cola = invertirCola(cola);
        System.out.println("--COLA INVERTIDA--");
        cola.imprimir();
    }

    public static void colaToCola(ColaTDA cola1, ColaTDA cola2) {
        
        int valor;

        while (!cola1.colaVacia()) {
            valor = cola1.primero();
            cola1.desacolar();

            cola2.acolar(valor);
        }
    }

    public static ColaTDA invertirCola (ColaTDA c1){
        ColaTDA colaAux = new ColaTopeIni();
        ColaTDA colaInv = new ColaTopeIni();

        colaInv.inicializarCola();
        colaAux.inicializarCola();

        int valor;

        while (!c1.colaVacia() || !colaAux.colaVacia()){

            valor = c1.primero();
            c1.desacolar();
            

            if (c1.colaVacia()){
                colaInv.acolar(valor);
                colaToCola(colaAux, c1);
            }
            else{
                colaAux.acolar(valor);

            }
        }

        return colaInv;
    }
}
