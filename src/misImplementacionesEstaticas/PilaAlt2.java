package misImplementacionesEstaticas;

import misApi.PilaAlt2TDA;

public class PilaAlt2 implements PilaAlt2TDA {
    //CON TOPE AL INICIO
    private int [] contenedor;
    private int cant;

    @Override
    public void inicializarPila() {
        contenedor = new int [100];
        cant = 0;
    }

    @Override
    public void apilar(int x) {
        if (cant != 0){

            int i = cant;
            while (i>0){
                contenedor[i]=contenedor[i-1];
                i--;
            }
        }
        contenedor[0] = x;
        cant ++;
    }

    @Override
    public int topeSacar() {
        int tope;
        if (cant != 0){
            tope = contenedor[0];
            int i = 0;
            while (i<cant){
                contenedor[i] = contenedor[i+1];
                i++;
            }
            cant--;
        }
        else {
            tope = 0;
        }

        return tope;
    }

    @Override
    public boolean pilaVacia() {
        return cant == 0;
    }
    
}
