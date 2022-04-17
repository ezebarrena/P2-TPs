package misAplicaciones;

import misApi.PilaTDA;
import misImplementacionesDinamicas.PilaDinamica;
import misMetodos.MetodosPilas;

public class Clase4ej2b {
    public static void main (String [] args) throws Exception{
        PilaTDA pila = new PilaDinamica();

        MetodosPilas metodosPilas = new MetodosPilas();

        pila.inicializarPila();

        pila.apilar(3);
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3);
        pila.apilar(2);
        pila.apilar(1);
        pila.apilar(4);

        metodosPilas.eliminarRepsPila(pila);
        
        impresionPila (pila);
        
    }

    public static void impresionPila(PilaTDA p) {
		while(!p.pilaVacia()) {
			System.out.println(p.tope());
			p.desapilar();
		}
	}
}
