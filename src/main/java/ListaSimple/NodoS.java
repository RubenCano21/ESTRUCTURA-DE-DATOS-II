package ListaSimple;

public class NodoS {

    public int elem;
    public NodoS prox;

    public NodoS(int elem, NodoS prox){
        this.elem = elem;
        this.prox = prox;
    }

    public NodoS(int elem) {
        this.elem = elem;
        this.prox = null;
    }
}
