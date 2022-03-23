package misApi;

public interface DiccionarioSimpleTDA {
    //inicia el diccionario
    void inicializarDiccionario();

    //agrega elemento x a una clave, debe estar iniciado y x no debe existir
    void agregar(int x, int clave);

    //elimina una una clave, la vlave debe exitir
    void eliminar (int clave);

    //devuelve valor asociado a una clave, la clave debe existir
    int obtener (int clave);

    //devuelve conjunto de claves, el diccionario debe estar iniciado
    ConjuntoTDA claves();
}
