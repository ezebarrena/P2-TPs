package misMetodos;

import misApi.ColaPrioridadTDA;
import misImplementacionesDinamicas.ColaPrioridadDinamica;

public class MetodosColasPrioridad {

    public void unificarColasP (ColaPrioridadTDA c1, ColaPrioridadTDA c2, ColaPrioridadTDA cr){
        
        ColaPrioridadTDA aux1 = new ColaPrioridadDinamica();
        ColaPrioridadTDA aux2 = new ColaPrioridadDinamica();
        
        aux1.inicializarCola();
        aux2.inicializarCola();
        
        
        pasarColaPColaP(c1, aux1);
        pasarColaPColaP(c2, aux2);

        while (!aux1.colaVacia()){
            int valor = aux1.primero();
            
            while (!aux2.colaVacia()){
                if (aux2.primero() != valor){
                    cr.acolarPrioridad(aux1.primero(), aux1.prioridad());
                    cr.acolarPrioridad(aux2.primero(), aux2.prioridad());
                    
                }
                aux2.desacolar();

            }
            aux1.desacolar();
        }
    }

    public void pasarColaPColaP (ColaPrioridadTDA cola, ColaPrioridadTDA cola2){
        while (!cola.colaVacia()){
            cola2.acolarPrioridad(cola.primero(), cola.prioridad());
            cola.desacolar();
        }
    }

    public void clonarColaP (ColaPrioridadTDA cola, ColaPrioridadTDA cola2){
        ColaPrioridadTDA aux = new ColaPrioridadDinamica();
        aux.inicializarCola();

        while (!cola.colaVacia()){
            aux.acolarPrioridad(cola.primero(), cola.prioridad());
            cola.desacolar();
        }

        while (!aux.colaVacia()){
            cola.acolarPrioridad(aux.primero(), aux.prioridad());
            cola2.acolarPrioridad(aux.primero(), aux.prioridad());

            aux.desacolar();
        }
    }

    public void imprimirCola(ColaPrioridadTDA cola) {
        ColaPrioridadTDA aux = new ColaPrioridadDinamica();

        aux.inicializarCola();

        clonarColaP(cola, aux);

        while (!aux.colaVacia()){
            System.out.println("Valor: "+ aux.primero()+ ", Prioridad:"+ aux.prioridad());
            aux.desacolar();
        }
    }


    public ColaPrioridadTDA unionColas (ColaPrioridadTDA c1, ColaPrioridadTDA c2){
        ColaPrioridadTDA aux = new ColaPrioridadDinamica();
        ColaPrioridadTDA colaUnida = new ColaPrioridadDinamica();
        ColaPrioridadTDA colaRes = new ColaPrioridadDinamica();

        colaUnida.inicializarCola();
        aux.inicializarCola();
        colaRes.inicializarCola();

        pasarColaPColaP(c1, colaUnida);

        //aca ambas colas quedan unidas
        while (!c2.colaVacia()){
            colaUnida.acolarPrioridad(c2.primero(), c2.prioridad());
            c2.desacolar();
        }

        int valorTemporal;
        int prioTemporal;


        //aca me empiezo a fijar por sacar repetidos

        while (!colaUnida.colaVacia()){
            valorTemporal = colaUnida.primero();
            prioTemporal = colaUnida.prioridad();
            colaUnida.desacolar();

            while (!colaUnida.colaVacia()){

                if (valorTemporal == colaUnida.primero()){
                    
                    if (prioTemporal < colaUnida.prioridad()){
                        prioTemporal = colaUnida.prioridad();
                    }
                    
                    colaUnida.desacolar();
                }

                else{                
                    aux.acolarPrioridad(colaUnida.primero(), colaUnida.prioridad());
                    colaUnida.desacolar();
                }

            }
            
            pasarColaPColaP(aux, colaUnida);

            colaRes.acolarPrioridad(valorTemporal, prioTemporal);

        }

        return colaRes;
    
    }
}
