package misApi;

public interface DiccionarioMultipleTDA {
    void inicializarDiccionarioMultiple ();
    void agregar(int x, String clave);
    void eliminarClave(String clave);
    void eliminarValor(int x, String clave);
    ConjuntoTDA obtenerValores(String clave);
    ConjuntoTDA claves();
}
