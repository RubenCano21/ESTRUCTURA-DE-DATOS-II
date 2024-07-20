package arbolString;

public class ListaArray {

    public int max;
    public int cantElem;
    public String[] elem;
    public int[] frec;

    public ListaArray(int max) {
        this.max = max;
        this.cantElem = 0;
        this.elem = new String[max];
        this.frec = new int[max];
    }
    public ListaArray() {
        this(100);
    }

    public boolean seEncuentra(String x) {
        for (int i = 0; i < cantElem; i++) {
            if (elem[i].compareTo(x) == 0) return true;
        }
        return false;
    }
    public int indexOf(String x) {
        for (int i = 0; i < cantElem; i++) {
            if (elem[i].equals(x)) return i;
        }
        return -1;
    }
    public void insertarSinOrden(String x) {
        if (!seEncuentra(x)) {
            elem[cantElem] = x;
            frec[cantElem] = 1;
            cantElem++;
        } else {
            frec[indexOf(x)]++;
        }
    }
    public void insertarOrdenado(String s1, int f) {
        int i = 0;
        while (i < cantElem && frec[i] < f) i++;
        insertarIesimo(s1, f, i);
    }

    private void insertarIesimo(String s1, int f, int i) {
        for (int j = cantElem; j > i; j--) {
            elem[j] = elem[j - 1];
            frec[j] = frec[j - 1];
        }
        elem[i] = s1;
        frec[i] = f;
        cantElem++;
    }

    public void frecuencias() {
        for (int i = 0; i < cantElem; i++) {
            System.out.println(elem[i] + " " + frec[i]);
        }
    }


}
