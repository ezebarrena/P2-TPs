package misAplicaciones;
import misApi.ConjuntoTDA;
import misImplementacionesEstaticas.Conjunto;

public class Clase2ej1 {
    public static void main(String[] args) throws Exception {
        ConjuntoTDA C1 = new Conjunto();
        ConjuntoTDA C2 = new Conjunto();


        C1.inicializarConjunto();
        C2.inicializarConjunto();

        C1.agregar(5);
        C1.agregar(2);
        C1.agregar(4);
        C1.agregar(52);
        C1.agregar(51);
        C1.agregar(523);
        
        System.out.println("Este es el C1 lleno");
        C1.imprimirConjunto();

        System.out.println("-------------------");

        C2 = copiarConjunto(C1, C2);

        System.out.println("Este es el C1 vacio");
        C1.imprimirConjunto();

        System.out.println("Este es el C2 lleno");
        C2.imprimirConjunto();
        
    }

    public static ConjuntoTDA copiarConjunto (ConjuntoTDA C1, ConjuntoTDA C2){
        
        while (!C1.conjuntoVacio()){
            int num = C1.obtener();
            C1.sacar(num);
            C2.agregar(num);
        }
        return C2;
    }

    
}
