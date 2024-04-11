public class Lista {

    public Nodo prim;
    public Nodo ult;
    public int cantElem;

    public Lista() {
        prim = ult = null;
        cantElem = 0;
    }

    @Override
    public String toString() {
        String s1 = "[";
        Nodo p = prim;
        while (p != null) {
            s1 = s1 + p.elem;
            if (p.prox != null) {
                s1 = s1 + ", ";
            }
            p = p.prox;
        }
        return s1 + "]";
    }

    public void insertarPrim(int x) {
        if (vacia()) {
            prim = ult = new Nodo(null, x, null);
        } else {
            prim = prim.ant = new Nodo(null, x, prim);
        }
        cantElem++;
    }

    private boolean vacia() {
        return (prim == null && ult == null);
    }

    public void insertarUlt(int x) {
        if (vacia()) {
            prim = ult = new Nodo(null, x, null);
        } else {
            ult = ult.prox = new Nodo(ult, x, null);
        }
        cantElem++;
    }

    public void insertarLugar(int x) {
        Nodo p = prim, ap = null;
        while (p != null && x > p.elem) {
            ap = p;
            p = p.prox;
        }
        insertarNodo(ap, p, x);
    }

    private void insertarNodo(Nodo ap, Nodo p, int x) {
        if (ap == null) {
            insertarPrim(x);
        } else if (p == null) {
            insertarUlt(x);
        } else {
            ap.prox = p.ant = new Nodo(ap, x, p);
            cantElem++;
        }
    }

    public void insertarIesimo(int x, int i) {
        int k = 0;
        Nodo p = prim, ap = null;
        while (k < i && p != null) {
            ap = p;
            p = p.prox;
            k++;
        }
        insertarNodo(ap, p, x);
    }
    /*1. L1.insertarIesimo(x, i) : Método que inserta el elemento x, en la posición i, de la lista L1

2. L1.insertarPrim(x) : Método que insertar el elemento x, al inicio de la lista L1.

3. L1.insertarUlt(x) : Método que inserta el elemento x, al final de la lista L1.*/

//4. L1.insertarLugarAsc(x) : Método que inserta el elemento x, en su lugar correspondiente en la Lista ordenadas de menor a mayor.

/*5. L1.insertarLugarDes(x) : Método que inserta el elemento x, en su lugar correspondiente en la Lista ordenadas de mayor a menor.

6. L1.insertarIesimo(L2, i) : Método que insertar los elementos de la lista L2 en la lista L1, desde la posición i.

7. L1.insertarPrim(L2) : Método que insertar los elementos de la lista L2 al principio de la lista L1.

8. L1.insertarUlt(L2) : Método que insertar los elementos de la lista L2 al final de la lista L1.

9. L1.iguales() : Método Lógico que devuelve True, si todos los elementos de la lista L1 son iguales.@

10. L1.diferentes() : Método Lógico que devuelve True, si todos los elementos de la lista L1 son diferentes.

11. L1.mayorElem() : Método que devuelve el mayor elemento de la lista L1.

12. L1.ordenado()  : Método Lógico que devuelve True, si todos los elementos de la lista L1 están ordenados en forma ascendente o descendente.

13. L1.indexOf(x) : Método que devuelve la posición (lugar) de la primera ocurrencia del elemento x. Si x no se encuentra en la lista L1, el método devuelve –

14. L1.lastIndexOf(x) : Método que devuelve la posición (lugar) de la última ocurrencia del elemento x. Si x no se encuentra en la lista L1, el método devuelve –

15. L1.palindrome() : Método lógico que devuelve True, si la lista L1 contiene elementos que forma un palíndrome.

16.  Incluir al menos 10 ejercicios cualesquiera, interesantes. (No utilizar métodos de eliminar . . . )*/

}
