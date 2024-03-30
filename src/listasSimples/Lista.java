package listasSimples;

public class Lista {

    public Nodo prim;
    public int cantElem;
    public Nodo ult;

    public Lista (){
        prim = ult = null;
        cantElem = 0;
    }

    public void insertarPrim(int x){
        Nodo p = prim;
        if (vacia()){
            prim = ult = new Nodo(x, prim);
        }else {
            ult = ult.prox = new Nodo(x, null);
        }
        cantElem++;
    }

    private boolean vacia() {
        return (prim == null && ult  == null);
    }

    @Override
    public String toString(){
        String s1 = "[";
        Nodo p = prim;
        while (p != null){
            s1 += p.elem;
            if (p.prox != null)
                s1 += ", ";
            p = p.prox;
        }
        return s1 + "]";
    }


}
