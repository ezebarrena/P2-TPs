package misApi;

public interface ConjuntoTDA {
    //inicia el conjunto
    void inicializarConjunto();

    //agrega un elemento x, debe estar iniciado y x no debe existir
    void agregar(int x);

    //elimina un elemento x, elemento debe pertencer
    void sacar(int x);

    int obtener();

    boolean conjuntoVacio();

    boolean pertenece(int x);
}
