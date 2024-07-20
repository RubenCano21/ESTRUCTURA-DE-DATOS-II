package ListasD;

public class Lista {

    public Nodo prim;
    public Nodo ult;
    public int cantElem;

    public Lista() {
        prim = ult = null;
        cantElem = 0;
    }

    @Override
    public String toString(){
        StringBuilder s1 = new StringBuilder("[");
        Nodo p = prim;
        while (p != null){
            s1.append(p.elem).append(", ");
            p = p.prox;
        }
        s1 = new StringBuilder(s1.substring(0, s1.length() - 2));
        return s1 + "]";
    }

    public void insertarPrim(int x){
        if (vacia()){
            prim = ult = new Nodo(null, x, null);
        }else{
            prim = prim.ant = new Nodo(null, x, prim);
        }
        cantElem++;
    }

    private boolean vacia() {
        return (prim == null && ult == null);
    }

    public void insertarUlt(int x){
        if (vacia()){
            prim = ult = new Nodo(null, x, null);
        }else {
            ult = ult.prox = new Nodo(ult, x, null);
        }
        cantElem++;
    }
    // 4. L1.insertarIesimo(x, i) : Método que inserta el elemento x, en la posición i, de la lista L1.
    public void insertarIesimo(int x, int i){
        int k =0 ;
        Nodo p = prim, ap = null;
        while (k < i && p != null){
            ap = p;
            p = p.prox;
            k++;
        }
        insertarNodo(ap, p, x);
    }

    private void insertarNodo(Nodo ap, Nodo p, int x) {
        if (ap == null)
            insertarPrim(x);
        else if (p == null)
            insertarUlt(x);
        else {
            ap .prox = p.ant = new Nodo(ap, x, p);
            cantElem++;
        }
    }
    // 5. L1.insertarIesimo(L2, i) : Método que insertar los elementos de la lista L2 en la lista L1, desde la posición i.
    public void insertarIesimo(Lista L2, int i){
        if (i == 0){
            L2.insertarUlt(prim.elem);
            prim = L2.prim;
        }
        Nodo p = prim;
        int k =0;
        while (k < i-1 && p != null){
            p = p.prox;
            k++;
        }
        Nodo q = p.prox;
        p.prox = L2.prim;
        L2.prim.ant = p;
        while (p.prox != null){
            p = p.prox;
        }
        p.prox = q;
        if (q != null){
            q.ant = p;
        }
    }

    public void generar(int n, int a, int b) {
        for (int i = 1; i <= n; i++) {
            int r = (int)(a + (b - a) * Math.random());
            insertarUlt(r);
        }
    }

    public void mostrarMayMen() {
        Nodo p = prim;
        while (p != null) {
            System.out.print(p.elem+", ");
            p = p.prox;
        }
    }

    public void mostrarMayMenDig() {
        Nodo p = obtenerUltimoNodo();
        while (p != null) {
            System.out.print(p.elem+ ", ");
            p = p.ant;
        }
    }

    public Nodo obtenerUltimoNodo() {
        if (prim == null) {
            return null;
        }
        Nodo p = prim;
        while (p.prox != null) {
            p = p.prox;
        }
        return p;
    }

    public void mostrarMayMenTodo() {
        Nodo p = obtenerUltimoNodo();
        while (p != null) {
            System.out.print(p.elem+", ");
            p = p.ant;
        }
    }

    public void mostrarImpares() {
        Nodo p = prim;
        while (p != null) {
            if (p.elem % 2 != 0) {
                System.out.print(p.elem+", ");
            }
            p = p.prox;
        }
    }

    public void mostrarPrimos() {
        Nodo p = prim;
        while (p != null) {
            if (esPrimo(p.elem)) {
                System.out.print(p.elem+", ");
            }
            p = p.prox;
        }
    }

    public boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }


}
