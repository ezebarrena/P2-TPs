import misApi.ColaPrioridadTDA;
import misImplementacionesEstaticas.ColaPrioridad;

public class Clase2ej2 {
    public static void main(String[] args) throws Exception{
        ColaPrioridadTDA cola1 = new ColaPrioridad();
        ColaPrioridadTDA cola2 = new ColaPrioridad();

        cola1.inicializarCola();
        cola2.inicializarCola();

        cola1.acolarPrioridad(5, 3);
        cola1.acolarPrioridad(10, 5);
        cola1.acolarPrioridad(7, 4);
        cola1.acolarPrioridad(3, 1);
        cola1.acolarPrioridad(8, 2);
        
        cola1.imprimirCola();

        cola2 = copiarCola(cola1, cola2);

        System.out.println("--------------");
        cola2.imprimirCola();
    }

    public static ColaPrioridadTDA copiarCola(ColaPrioridadTDA c1, ColaPrioridadTDA c2){
        int i = 0;
        
        while (i < c1.longitud()){
            c2.acolarPrioridad(c1, c1.prioridad());
            
            i++;
        }

        return c2;
    }
}
