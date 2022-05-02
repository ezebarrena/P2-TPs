package misImplementacionesDinamicas;

import misApi.ABBTDA;

public class ABB implements ABBTDA {

    class NodoABB {
        int info;
        ABBTDA hijoIzq;
        ABBTDA hijoDer;
    }

    NodoABB raiz;

    @Override
    public int raiz() {
        // TODO Auto-generated method stub
        return raiz.info;
    }

    @Override
    public ABBTDA HijoIzq() {
        // TODO Auto-generated method stub
        return raiz.hijoIzq;
    }

    @Override
    public ABBTDA HijoDer() {
        // TODO Auto-generated method stub
        return raiz.hijoDer;
    }

    @Override
    public boolean arbolVacio() {
        // TODO Auto-generated method stub
        return raiz == null;
    }

    @Override
    public void inicializarArbol() {
        // TODO Auto-generated method stub
        raiz = null;
    }

    @Override
    public void agregarElem(int x) {
        // TODO Auto-generated method stub
        if (raiz == null){
            raiz = new NodoABB();
            raiz.info = x;
            raiz.hijoIzq = new ABB();
            raiz.hijoIzq.inicializarArbol();
            raiz.hijoDer = new ABB();
            raiz.hijoDer.inicializarArbol();
        }
        else if (raiz.info > x){
            raiz.hijoIzq.agregarElem(x);
        }
        else if (raiz.info < x){
            raiz.hijoDer.agregarElem(x);
        }
    }

    @Override
    public void eliminarElem(int x) {
        // TODO Auto-generated method stub
        if (raiz != null){
            if (raiz.info == x && raiz.hijoIzq.arbolVacio() && raiz.hijoDer.arbolVacio()){
                raiz = null;
            }
            else if (raiz.info == x && !raiz.hijoIzq.arbolVacio()){
                raiz.info = this.mayor(raiz.hijoIzq);
                raiz.hijoIzq.eliminarElem(raiz.info);
            }
            else if (raiz.info == x && raiz.hijoIzq.arbolVacio()){
                raiz.info = this.menor (raiz.hijoDer);
                raiz.hijoDer.eliminarElem(raiz.info);
            }
            else if (raiz.info < x){
                raiz.hijoDer.eliminarElem(x);
            }
            else {
                raiz.hijoIzq.eliminarElem(x);
            }
        }
    }

    private int mayor (ABBTDA a){
        if (a.HijoDer().arbolVacio())
            return a.raiz();
        else
            return mayor(a.HijoDer());
    }

    private int menor (ABBTDA a){
        if (a.HijoIzq().arbolVacio())
            return a.raiz();
        
        else
            return menor (a.HijoIzq());
    }
    
}
