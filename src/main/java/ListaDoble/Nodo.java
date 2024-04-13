package ListaDoble;

public class Nodo {
    public Nodo ant;
    public int elem;
    public Nodo prox;

    public Nodo(Nodo ant, int x, Nodo prox){
        this.ant = ant;
        this.elem = x;
        this.prox = prox;
    }
}
