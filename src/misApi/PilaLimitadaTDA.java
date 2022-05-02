package misApi;

public interface PilaLimitadaTDA {
    
    //genera la pila vacia y se le pasa como parametro el tamaño maximo que puede tener
    void inicializarPila(int size);

    //debe estar inicializada
    //agregar un entero
    //si ya esta llena, se elimina el mas antiguo y se agrega al tope
    void apilar (int x);

    //elimina el tope
    //debe estar inicializada y no vacia
    void desapilar();

    //debe estar inicializada
    boolean pilaVacia();

    //debe estar inicializada y no vacia
    int tope();
}
