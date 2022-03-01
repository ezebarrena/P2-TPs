package misApi;

public interface PilaTDA {
    //inicializar estructura pila
    void inicializarPila();

    //agregar elemento, la pila tiene que estar inicializada
    void apilar(int x);

    //elimina ultimo elemento agregado, no debe estar vacia
    void desapilar();

    //primer elemento a eliminar, no debe estar vacia
    int tope();

    //indica si tiene elementos o no, debe estar inicializada
    boolean pilaVacia();
}
