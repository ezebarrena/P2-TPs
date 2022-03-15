package misApi;

public interface GrafoTDA {
    void inicializarGrafo();
    void agregarVertice(int vert);
    void eliminarVertice(int vert);
    void agregarArista (int origen, int destino, int peso);
    void eliminarArista(int origen, int destino);
    ConjuntoTDA vertices();
    int peso (int origen, int destino);
    boolean existeArista(int vert1, int vert2);
}
