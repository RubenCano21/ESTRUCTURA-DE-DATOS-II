package arbolString;

public class Nodo {

    public String elem;
    public int frec;
    public Nodo izq;
    public Nodo der;

    public Nodo(String elem){
        this.elem = elem;
        this.frec = 1;
        this.izq = this.der = null;
    }

    public Nodo(String elem, int frec){
        this.elem = elem;
        this.frec = frec;
        this.izq = this.der = null;
    }
}
