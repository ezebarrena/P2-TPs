package misApi;

public interface GrafoTDA {
    void inicializarGrafo();
    void agregarVertice();
    void eliminarVertice(int x);
    void agregarArista (int origen, int destino, int peso);
    void eliminarArista(int origen, int destino);
    ConjuntoTDA vertices();
    int peso (int origen, int destino);
    boolean existeArista(int origen, int destino);
}
