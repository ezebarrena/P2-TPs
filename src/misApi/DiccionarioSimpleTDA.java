package misApi;

public interface DiccionarioSimpleTDA {
    void inicializarDiccionario();
    void agregar(int x, String clave);
    void eliminar (String clave);
    int obtener (String clave);
    ConjuntoTDA claves();
}
