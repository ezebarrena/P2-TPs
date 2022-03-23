package misApi;

public interface DiccionarioMultipleTDA {
    void inicializarDiccionarioMultiple ();
    void agregar(int x, int clave);
    void eliminarClave(String clave);
    void eliminarValor(int x, int clave);
    ConjuntoTDA obtenerValores(int clave);
    ConjuntoTDA claves();
}
