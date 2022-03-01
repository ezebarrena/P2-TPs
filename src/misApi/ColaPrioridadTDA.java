package misApi;

public interface ColaPrioridadTDA {
    //inicia la estructura
    void inicializarCola();

    //agrega un elemento x con prioridad p, debe estar iniciada
    void acolarPrioridad(int x, int p);

    //elimina elemento con mayor prioridad, no debe estar vacia
    void desacolar(int x);

    //valor del dato de mayor prioridad, no debe estar vacia
    int primero(int p);

    //prioridad del valor... , no debe estar vacia
    int prioridad(int x);

    //indica si tiene elementos o no, debe estar iniciada
    boolean colaVacia();
}
