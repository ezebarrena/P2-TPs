package misApi;

public interface AbbTDA {
    void inicializarABB();
    int raiz ();
    AbbTDA hijoIzq();
    AbbTDA hijoDer();
    void agregar(int x);
    void eliminar (int x);
    boolean arbolVacio();
    boolean pertenece (int x);
}
