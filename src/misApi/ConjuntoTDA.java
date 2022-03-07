package misApi;

public interface ConjuntoTDA {
    //inicia el conjunto
    void inicializarConjunto();

    //agrega un elemento x, debe estar iniciado y x no debe existir
    void agregar(int x);

    //elimina un elemento x, elemento debe pertencer
    void sacar(int x);

    //valor cualquiera del conjunto, no debe estar vacio
    int obtener();

    //dice si esta vacio o no, debe estar iniciado
    boolean conjuntoVacio();

    //verdadero si x pertenece al conjunto, debe esta iniciado
    boolean pertenece(int x);

    void imprimirConjunto();
    
}
