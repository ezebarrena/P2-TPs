package misImplementacionesEstaticas;

import misApi.ColaPrioridadTDA;

public class ColaPrioridad2 implements ColaPrioridadTDA{

    private int [] vectorP;
    private int [] vectorV;
    private int cant;

    @Override
    public void inicializarCola() {
        vectorP = new int [100];
        vectorV = new int [100];
        cant = 0;
    }

    @Override
    public void acolarPrioridad(int x, int p) {
        int i = cant - 1;

        while (i>= 0 && p < vectorP[i]){
            vectorP[i+1] = vectorP[i];
            vectorV[i+1] = vectorV[i];
            i--;
        }

        vectorP[i+1] = p;
        vectorV[i+1] = x;
        cant++;
    }

    @Override
    public void desacolar() {
        cant--;
    }

    @Override
    public int primero() {
        return vectorV[cant-1];
    }

    @Override
    public int prioridad() {
        return vectorP[cant-1];
    }

    @Override
    public boolean colaVacia() {
        return cant==0;
    }

	@Override
	public void imprimirCola() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int longitud() {
		// TODO Auto-generated method stub
		return 0;
	}
    
}
