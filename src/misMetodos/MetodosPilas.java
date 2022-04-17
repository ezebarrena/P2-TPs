package misMetodos;


import misApi.PilaTDA;
import misImplementacionesDinamicas.PilaDinamica;
import misImplementacionesEstaticas.Pila;

public class MetodosPilas {
    
    public boolean ej2A (PilaTDA pila1, PilaTDA pila2){
        PilaTDA aux1 = new Pila();
        PilaTDA aux2 = new Pila();
        aux1.inicializarPila();
        aux2.inicializarPila();

        aux1 = pila1;
        aux2 = pila2;
        int lp1 = longPila(pila1);
        int lp2 = longPila(pila2);

        boolean pertenencia = false;

        //si la pila 1 es mas larga que la 2 voy a verificar si la 2 pertenece a la 1
        if (lp1 >= lp2 ){
            int i = 0;
            while ( i < lp2){
                int valor1 = aux1.tope();
                int valor2 = aux2.tope();

                if (valor1 == valor2){
                    pertenencia = true;
                    aux1.desapilar();
                    aux2.desapilar();
                }
                else if (valor1 != valor2 && pertenencia == true){
                    return false;
                }
                else if (valor1 != valor2 && pertenencia == false){
                    aux1.desapilar();
                }
                i++;
            }
        }

        
        return pertenencia;
    }

    public int longPila(PilaTDA pila){
        PilaTDA aux = new PilaDinamica();
        aux.inicializarPila();

        copiarPila(pila, aux);



        int i = 0;
        while (!aux.pilaVacia()){
            aux.desapilar();
            i++;
        }
        return i;
    }

    public void copiarPila (PilaTDA pila1, PilaTDA pila2){
        PilaTDA pilaAux = new PilaDinamica();
        pilaAux.inicializarPila();

        while (!pila1.pilaVacia()){
            pilaAux.apilar(pila1.tope());
            pila1.desapilar();
        }

        int temporal;

        while (!pilaAux.pilaVacia()){
            temporal = pilaAux.tope();
            pilaAux.desapilar();
            pila1.apilar(temporal);
            pila2.apilar(temporal);
        }
    }


    public void eliminarRepsPila (PilaTDA pila){
        PilaTDA aux1 = new PilaDinamica();
        PilaTDA aux2 = new PilaDinamica();


        aux1.inicializarPila();
        aux2.inicializarPila();

        pasarPilaPila(aux1, pila);

        while (!aux1.pilaVacia()){
            int valorABuscar = aux1.tope();
            aux1.desapilar();
            while (!aux1.pilaVacia()){
                if (aux1.tope() != valorABuscar){
                    aux2.apilar(aux1.tope());
                }
                aux1.desapilar();
            }
            pasarPilaPila(aux1, aux2);
            pila.apilar(valorABuscar);
        }
        
    }

    public void pasarPilaPila(PilaTDA dest, PilaTDA origen) {
		while(!origen.pilaVacia()) {
			dest.apilar(origen.tope());
			origen.desapilar();
		}		
	}



}