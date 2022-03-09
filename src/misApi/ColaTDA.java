package misApi;

public interface ColaTDA {
    //inicializa la estructura
    void inicializarCola();

    //agrega un elemento, debe estar iniciada
    void acolar(int x);

    //elimina elemento mas antiguo, no debe estar vacia
    void desacolar();

    //primer elemento a eliminar, no debe estar vacia
    int primero();

    //indica si tiene elementos o no, debe estar iniciada
    boolean colaVacia();

    void imprimir();

    int largo();
}
