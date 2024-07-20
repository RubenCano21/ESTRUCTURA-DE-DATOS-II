package Tarea7_ElimiArb;

public class Nodo {

    public Nodo izq;
    public Nodo der;
    public int elem;

    public Nodo(int elem){
        this.elem = elem;
        this.izq = null;
        this.der = null;
    }
}
