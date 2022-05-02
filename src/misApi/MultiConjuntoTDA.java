package misApi;

public interface MultiConjuntoTDA {
    void inicializarMultiConjunto();
    void agregar(int x);
    void sacar (int x);
    int multiplicidad (int x);
    boolean multiConjuntoVacio();
    int elegir ();
}
