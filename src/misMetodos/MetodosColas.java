package misMetodos;

import misApi.ColaTDA;
import misImplementacionesDinamicas.ColaDinamica;

public class MetodosColas {
    
    public void dividirCola (ColaTDA cola, ColaTDA mitad1, ColaTDA mitad2){
        int largo = longitudCola(cola);
        int i = 1;
        
        while (i <= largo/2){

            mitad1.acolar(cola.primero());
            cola.desacolar();
            i++;
        }
        while (i <= largo){
            mitad2.acolar(cola.primero());
            cola.desacolar();
            i++;
        }
    }

    public int longitudCola(ColaTDA cola){
        ColaTDA aux = new ColaDinamica();
        aux.inicializarCola();
        
        clonarCola(cola, aux);
        int i = 0;

        while (!aux.colaVacia()){
            aux.desacolar();
            i++;
        }
        return i;
    }

    public void clonarCola(ColaTDA cola, ColaTDA cola2){
        ColaTDA aux = new ColaDinamica();
        aux.inicializarCola();

        while (!cola.colaVacia()){
            aux.acolar(cola.primero());
            cola.desacolar();
        }

        int temporal;

        while (!aux.colaVacia()){
            temporal = aux.primero();
            cola.acolar(temporal);
            cola2.acolar(temporal);
            aux.desacolar();
        }
    }

    public void imprimirCola(ColaTDA cola){
        ColaTDA aux = new ColaDinamica();
        aux.inicializarCola();

        clonarCola(cola, aux);

        while (!aux.colaVacia()){
            System.out.println(aux.primero());
            aux.desacolar();
        }

    }

    public int secuenciaMasLarga (ColaTDA cola){
        int i = 0;
        int max = 0;
        while (!cola.colaVacia()){
            int valor = cola.primero();

            if (valor != 0){
                i++;
            }
            else {
                
                if (i >= max){
                    max = i;
                }
                i = 0;
            }

            cola.desacolar();
        }

        return max;
    }

    public boolean sonIguales (ColaTDA c1, ColaTDA c2){
        ColaTDA aux1 = new ColaDinamica();
        ColaTDA aux2 = new ColaDinamica();

        int v1;
        int v2;
        boolean cond;
        while (!c1.colaVacia()){
            v1 = c1.primero();
            v2 = c2.primero();
            if (v1 == v2){
                cond = true;
            }
            else {
                return false;
            }

        }
        
        return true;
    }
    
}
