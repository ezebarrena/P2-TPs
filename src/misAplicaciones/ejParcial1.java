package misAplicaciones;

import misApi.ColaTDA;
import misImplementacionesDinamicas.ColaDinamica;

public class ejParcial1 {
    
    public static void main (String [] args) {
        ColaTDA cola = new ColaDinamica();
        ColaTDA colaDeR = new ColaDinamica();

        cola.inicializarCola();
        cola.acolar(5);
        cola.acolar(3);
        cola.acolar(4);
        cola.acolar(4);
        cola.acolar(5);
        cola.acolar(2);
        cola.acolar(4);
        cola.acolar(2);

        colaDeR = repsDeUnaCola(cola);

        impresora(colaDeR);

    }

    public static ColaTDA repsDeUnaCola (ColaTDA c1){
        ColaTDA colaReps = new ColaDinamica();
        ColaTDA aux1 = new ColaDinamica();
        
        
        while (!c1.colaVacia()){
            boolean agrego = false;
            int valor = c1.primero();
            c1.desacolar();

            while (!c1.colaVacia()){
                if (valor != c1.primero()){

                    aux1.acolar(c1.primero());

                    c1.desacolar();
                }
                else {
                    agrego = true;
                    c1.desacolar();
                }

            }
            if (agrego)
                colaReps.acolar(valor);

            pasarColaCola(aux1, c1);

        }




        return colaReps;
    }


    public static void pasarColaCola(ColaTDA llena, ColaTDA vacia){
        while (!llena.colaVacia()){
            vacia.acolar(llena.primero());
            llena.desacolar();
        }
    }

    public static void impresora (ColaTDA c){
        while (!c.colaVacia()){
            System.out.println(c.primero());
            c.desacolar();
        }
    }
}
