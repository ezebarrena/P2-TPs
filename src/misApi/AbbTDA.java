package misApi;

public interface ABBTDA {
    int raiz ();
    ABBTDA HijoIzq();
    ABBTDA HijoDer();
    boolean arbolVacio();
    void inicializarArbol();
    void agregarElem(int x);
    void eliminarElem(int x);
}
