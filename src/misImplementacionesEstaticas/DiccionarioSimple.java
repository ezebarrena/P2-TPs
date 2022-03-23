package misImplementacionesEstaticas;

import javax.swing.text.html.parser.ContentModel;

import misApi.ConjuntoTDA;
import misApi.DiccionarioSimpleTDA;

public class DiccionarioSimple implements DiccionarioSimpleTDA{


    public class Elem {
        int clave;
        int dato;
    }

    private Elem[] vector;
    private int cant;

    @Override
    public void inicializarDiccionario() {
        // TODO Auto-generated method stub
        vector = new Elem[100];
        cant = 0;
    }

    @Override
    public void agregar(int x, int clave) {
        // TODO Auto-generated method stub
        vector[cant] = new Elem();
        vector[cant].clave = clave;
        vector[cant].dato = x;
        cant++;
    }

    @Override
    public void eliminar(int clave) {
        // TODO Auto-generated method stub
        int i = cant-1;

        while (vector[i].clave != clave){
            i--;
        }
        vector[i] = vector[cant-1];
        cant--;
    }

    @Override
    public int obtener(int clave) {
        // TODO Auto-generated method stub

        int i = 0;

        while (vector[i].clave != clave){
            i++;
        }
        return vector[i].dato;
    }

    @Override
    public ConjuntoTDA claves() {
        // TODO Auto-generated method stub


        ConjuntoTDA conjuntoClaves = new Conjunto();
        conjuntoClaves.inicializarConjunto();

        for (int i = 0; i < cant; i++){
            conjuntoClaves.agregar(vector[i].clave);
        }


        return conjuntoClaves;
    }
    
}
