package ArbolFrec;

public class ListaArray {

    public int max;
    public int cantElem;
    public int[] elem;
    public int[] frec;

    public ListaArray(int max) {
        this.max = max;
        this.cantElem = 0;
        this.elem = new int[max];
        this.frec = new int[max];
    }
    public ListaArray() {
        this(100);
    }
    public boolean seEncuentra(int x) {
        for (int i = 0; i < cantElem; i++) {
            if (elem[i] == x) return true;
        }
        return false;
    }
    public int indexOf(int x) {
        for (int i = 0; i < cantElem; i++) {
            if (elem[i] == x) return i;
        }
        return -1;
    }
    public void insertarSinOrden(int x) {
        if (!seEncuentra(x)) {
            elem[cantElem] = x;
            frec[cantElem] = 1;
            cantElem++;
        } else {
            frec[indexOf(x)]++;
        }
    }
    public void insertarOrdenado(int x, int f) {
        int i = 0;
        while (i < cantElem && (frec[i] < f || (frec[i] == f && elem[i] < x))) i++;
        insertarIesimo(x, f, i);
    }
    private void insertarIesimo(int x, int f, int i) {
        for (int j = cantElem; j > i; j--) {
            elem[j] = elem[j - 1];
            frec[j] = frec[j - 1];
        }
        elem[i] = x;
        frec[i] = f;
        cantElem++;
    }
    public void frecuencias() {
        for (int i = 0; i < cantElem; i++) {
            System.out.println(elem[i] + " " + frec[i]);
        }
    }

}
