package ArbolFrec;

public class Nodo {

    public int elem;
    public int frec;
    public Nodo izq;
    public Nodo der;

    public Nodo (int elem){
        this.elem = elem;
        this.frec = 1;
        this.izq = this.der = null;
    }

    public Nodo (int elem, int frec){
        this.elem = elem;
        this.frec = frec;
        this.izq = this.der = null;
    }
}
