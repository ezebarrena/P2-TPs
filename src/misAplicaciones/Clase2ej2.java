package misAplicaciones;
import misApi.ColaPrioridadTDA;
import misImplementacionesEstaticas.ColaPrioridad;

public class Clase2ej2 {
    public static void main(String[] args) throws Exception{
        ColaPrioridadTDA cola1 = new ColaPrioridad();
        ColaPrioridadTDA cola2 = new ColaPrioridad();
        ColaPrioridadTDA colaAux = new ColaPrioridad();

        colaAux.inicializarCola();
        cola1.inicializarCola();
        cola2.inicializarCola();

        cola1.acolarPrioridad(5, 3);
        cola1.acolarPrioridad(10, 5);
        cola1.acolarPrioridad(7, 4);
        cola1.acolarPrioridad(3, 1);
        cola1.acolarPrioridad(8, 2);
        

        copiarCola(cola1, cola2, colaAux);

        System.out.println("-------Cola 2-------");
        cola2.imprimirCola();
        System.out.println("-------Cola 1-------");
        cola1.imprimirCola();


    }

    public static void copiarCola(ColaPrioridadTDA c1, ColaPrioridadTDA c2, ColaPrioridadTDA cAux){
        
        colaToCola(c1, cAux);
        
        while (!cAux.colaVacia()){
            
            c2.acolarPrioridad(cAux.primero(), cAux.prioridad());
            c1.acolarPrioridad(cAux.primero(), cAux.prioridad());
            cAux.desacolar();
        }

        
    }

    public static void colaToCola(ColaPrioridadTDA cola1, ColaPrioridadTDA cola2) {
        
        int valor;
        int prioridad;

        while (! cola1.colaVacia()) {
            valor = cola1.primero();
            prioridad = cola1.prioridad();
            cola1.desacolar();

            cola2.acolarPrioridad(valor, prioridad);
        }
    }
}
