package misMetodos;

import misApi.PilaTDA;
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
            while (!aux2.pilaVacia()){
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
            }
        }

        
        return pertenencia;
    }

    public int longPila(PilaTDA pila){
        int i = 0;
        while (!pila.pilaVacia()){
            pila.desapilar();
            i++;
        }
        return i;
    }

}