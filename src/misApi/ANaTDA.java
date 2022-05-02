package misApi;

public interface ANaTDA {
    int valor();
    ANaTDA HijoMayor();
    ANaTDA HermanoSig();
    boolean arbolVacio();
    void inicializarArbol();
    void elimHijoMConDesc (int x);
    void elimHermSConDesc (int x);
    void crearArbol (int r);
    void agregarHijoM (int p, int h);
}
