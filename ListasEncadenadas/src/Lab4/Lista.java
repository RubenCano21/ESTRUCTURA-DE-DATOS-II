package Lab4;

/**
 *
 * @author Cano
 */
public class Lista {

    public Nodo prim;
    public int cantElem;
    public Nodo ult;

    public Lista() {
        prim = ult = null;
        cantElem = 0;
    }

    //1. L1.toString() : Método que devuelve una cadena, que representa la secuencia de elementos de la lista L1.
    @Override
    public String toString() {
        String s1 = "[";
        Nodo p = prim;
        while (p != null) {
            s1 += p.elem;
            if (p.prox != null) {
                s1 += ", ";
            }
            p = p.prox;
        }
        return s1 + "]";
    }

    //2. L1.insertarPrim(x) : Método que inserta el elemento x, al inicio de la lista L1.
    public void insertarPrim(int x) {
        if (vacia()) {
            prim = ult = new Nodo(x, null);
        } else {
            prim = ult = new Nodo(x, prim);
        }
        cantElem++;
    }

    public boolean vacia() {
        return (prim == null && ult == null);
    }

    //3. L1.insertarUlt(x) : Método que inserta el elemento x, al inicio de la lista L1.
    public void insertarUlt(int x) {
        if (vacia()) {
            prim = ult = new Nodo(x, null);
        } else {
            ult = ult.prox = new Nodo(x, null);
        }
        cantElem++;
    }

    public void insertarIesimo(int x, int i) {
        int k = 0;
        Nodo p = prim, ap = null;
        while (p != null && k < i) {
            ap = p;
            p = p.prox;
            k++;
        }
        insertarNodo(x, ap, p);
    }

    public void insertarNodo(int x, Nodo ap, Nodo p) {
        if (ap == null) {
            insertarPrim(x);
        } else if (p == null) {
            insertarUlt(x);
        } else {
            ap.prox = new Nodo(x, p);
            cantElem++;
        }
    }

    //4. L1.iguales() : Método Lógico que devuelve True, si todos los elementos de la lista L1 son iguales.
    public boolean iguales() {
        Nodo p = prim;
        int aux = prim.elem;

        if (cantElem <= 1) {
            return true;
        } else {
            while (p != null) {
                if (p.elem != aux) {
                    return false;
                }
                p = p.prox;
            }
        }
        return true;
    }

    /*5. L1.diferentes() : Método Lógico que devuelve True, 
    si todos los elementos de la lista L1 son diferentes.*/
    public boolean diferentes() {
        Nodo p = prim, ap = null;
        if (cantElem <= 1) {
            return true;
        } else {
            while (ap != null) {
                ap = p;
                p = p.prox;
                if (ap.elem == p.elem) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean diferente() {
        return !iguales();
    }

    //6. L1.mayorElem() : Método que devuelve el mayor elemento de la lista L1.
    public int mayorElem() {
        Nodo p = prim.prox;
        int may = p.elem;

        while (p != null) {
            if (p.elem > may) {
                may = p.elem;
            }
            p = p.prox;
        }
        return may;
    }

    //7. L1.menorElem() : Método que devuelve el menor elemento de la lista L1.
    public int menorElem() {
        Nodo p = prim.prox;
        int men = prim.elem;

        while (p != null) {
            if (p.elem < men) {
                men = p.elem;
            }
            p = p.prox;
        }
        return men;
    }

    /*8. L1.ordenado()  : Método Lógico que devuelve True, si todos los elementos 
    de la lista L1 están ordenados en forma ascendente o descendente.*/
    public boolean ordenadoAsc() {
        Nodo p = prim;
        if (prim == null || prim.prox == null) {
            return true;
        }

        while (p.prox != null) {

            if (p.elem > p.prox.elem) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }

    public boolean ordenadoDesc() {
        Nodo p = prim;
        if (prim == null || prim.prox == null) {
            return true;
        }

        while (p.prox != null) {

            if (p.elem < p.prox.elem) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }

    public boolean ordenado() {
        return ordenadoAsc() || ordenadoDesc();
    }

    /*9. L1.pares() : Método lógico que devuelve True, si todos los 
    elementos de la lista L1 son pares.*/
    public boolean pares() {
        if (cantElem <= 1) {
            if (prim.elem % 2 == 0) {
                return true;
            }
        } else {
            Nodo p = prim;
            while (p != null) {
                if (p.elem % 2 != 0) {
                    return false;
                }
                p = p.prox;
            }
        }
        return true;
    }

    /*10. L1.parImpar() : Método lógico que devuelve True, si la lista L1 
    contiene al menos un elemento par e impar.*/
    public boolean parImpar() {
        Nodo p = prim;
        int k = 0, j = 0;
        while (p != null) {
            if (esPar(p.elem)) {
                k++;
            }
            if (esImpar(p.elem)) {
                j++;
            }
            p = p.prox;
        }
        return k >= 1 && j >= 1;
    }

    private boolean esPar(int x) {
        return (x % 2 == 0);
    }

    private boolean esImpar(int x) {
        return (x % 2 == 1);
    }

    /*11. L1.reemplazar(x, y) : Método que reemplaza todas las ocurrencias del
    elemento x por el elemento y en la lista L1.*/
    public void reemplazar(int x, int y) {
        Nodo p = prim;
        while (p != null) {
            if (p.elem == x) {
                p.elem = y;
            }
            p = p.prox;
        }
    }

    /*12. L1.seEncuentra(x) : Método Lógico que devuelve True, 
    si el elemento x, se encuentra en la lista L1.*/
    public boolean seEncuentra(int x) {
        Nodo p = prim;
        while (p != null) {
            if (p.elem == x) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }

    /*13. L1.frecuencia(x) : Método que devuelve la cantidad de veces que
    aparece el elemento x en la lista L1.*/
    public int frecuencia(int x) {
        Nodo p = prim;
        int k = 0;
        while (p != null) {
            if (p.elem == x) {
                k++;
            }
            p = p.prox;
        }
        return k;
    }

    /*14.   L1.existeFrec(k) : Método Lógico que devuelve True, si existe algún 
    elemento que se repite exactamente k-veces en la lista L1.*/
    public boolean existeFrec(int k) {
        if (prim == null) {
            return false;
        }

        Nodo p = prim;
        while (p != null) {
            int i = 0;
            Nodo ap = p;
            while (ap != null) {
                if (ap.elem == p.elem) {
                    i++;
                }
                ap = ap.prox;
            }
            if (i == k) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }

    /*15.   L1.mismasFrec() : Método Lógico que devuelve True, si todos los 
    elementos de la lista L1 tienen la misma frecuencia.*/
    public boolean mismaFrec() {
        if (prim == null || prim.prox == null) {
            return true;
        }

        Nodo p = prim;
        while (p != null) {
            int k = 0;
            Nodo ap = p;
            while (ap != null) {
                if (ap.elem == p.elem) {
                    k++;
                }
                ap = ap.prox;
            }
            if (k != frecuencia(p.elem)) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }

    /*16. L1.poker() : Método Lógico que devuelve True, si los elementos de la 
    lista L1 forman poker. (Todos los elementos son iguales excepto uno)*/
    public boolean poker() {
        Nodo p = prim;
        while (p != null) {
            if (frecuencia(p.elem) == (cantElem - 1)) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }

    /*17.   L1.existePar() : Método lógico que devuelve True, si la lista L1 
    contiene al menos un elemento par.*/
    public boolean existePar() {

        Nodo p = prim;
        while (p != null) {
            if (esPar(p.elem)) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }

    /*18.   L1.existeImpar() : Método lógico que devuelve True, si la lista L1
    contiene al menos un elemento impar.*/
    public boolean existeImpar() {
        Nodo p = prim;
        while (p != null) {
            if (esImpar(p.elem)) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }

    //19.   L1.todoPares() : Método lógico que devuelve True, si todos los elementos de la lista L1 son pares.
    public boolean todosPares() {
        if (!vacia()) {
            Nodo p = prim;
            while (p != null) {
                if (p.elem % 2 != 0) {
                    return false;
                }
                p = p.prox;
            }
            return true;
        } else {
            System.out.print("ERROR:: Lista Vacia ");
            return false;
        }
    }

    /*20.   L1.todoImpares() : Método lógico que devuelve True, si todos los
    elementos de la lista L1 son impares.*/
    public boolean todosImpares() {
        if (!vacia()) {
            Nodo p = prim;
            while (p != null) {
                if (p.elem % 2 == 0) {
                    return false;
                }
                p = p.prox;
            }
            return true;
        } else {
            System.out.print("ERROR:: Lista Vacia ");
            return false;
        }
    }

    /*21.   L1.existeParImpar() : Método lógico que devuelve True, 
    si en la lista L1 al menos existe un elemento par y un elemento impar.*/
    public boolean existeParImpar() {
        return existePar() && existeImpar();
    }

    /*22.   L1.alternos() : Método lógico que devuelve true, si la lista L1 
    contiene elementos en la siguiente secuencia: par, impar, par, impar, . . 
    . or  impar, par, impar, par, . . . .*/
    public boolean alternos() {
        if (!vacia()) {
            Nodo p = prim;
            boolean pp = (esPar(p.elem));
            while (p.prox != null) {
                p = p.prox;
                if ((p.elem % 2 == 0) == pp) {
                    return false;
                }
                pp = !pp;
            }
        }
        return true;
    }

    //23.   L1.insertarUlt(L2) : Método que inserta los elementos de la Lista L2, al final de la Lista L1.
    public void insertarUlt(Lista L2) {
        Nodo p = L2.prim;
        while (p != null) {
            insertarUlt(p.elem);
            p = p.prox;
        }
    }

    /*24.   L1.insertarLugarAsc(x) : Método que inserta el elemento x, en su lugar
    correspondiente en la Lista L1, ordenada de menor a mayor.*/
    public void ordenarAsc() {
        Nodo p = prim;
        while (p != null) {
            Nodo q = prim;
            while (q != null) {
                if (p.elem <= q.elem) {
                    int z = p.elem;
                    int y = q.elem;
                    p.elem = y;
                    q.elem = z;
                }
                q = q.prox;
            }
            p = p.prox;
        }
    }

    public void insertarLugarAsc(int x) {
        ordenarAsc();
        Nodo p = prim;
        int i = 0;
        while (p != null && p.elem < x) {
            p = p.prox;
            i++;
        }
        insertarIesimo(x, i);
    }

    /*25.   L1.insertarLugarDesc(x) : Método que inserta el elemento x, 
    en su lugar correspondiente en la Lista L1, ordenada de mayor a menor.*/
    public void ordenarDesc() {
        Nodo p = prim;
        while (p != null) {
            Nodo q = prim;
            while (q != null) {
                if (p.elem >= q.elem) {
                    int z = p.elem;
                    int y = q.elem;
                    p.elem = y;
                    q.elem = z;
                }
                q = q.prox;
            }
            p = p.prox;
        }
    }

    public void insertarLugarDesc(int x) {
        ordenarDesc();
        Nodo p = prim;
        int i = 0;
        while (p != null && p.elem > x) {
            p = p.prox;
            i++;
        }
        insertarIesimo(x, i);
    }

    /*26. L1.intercalar(L2, L3) : Método que intercala los elementos de las 
    Listas L2 con L3 en L1.*/
    public void intercalar(Lista L2, Lista L3) {
        L2.insertarUlt(L3);
        insertarUlt(L2);
        ordenarAsc();
    }

    //1.- eliminarRango(int inicio, int fin): Este método elimina todos los elementos en el rango especificado de la lista.
    public void eliminarRango(int inicio, int fin) {
        if (inicio < 0 || fin >= cantElem || inicio > fin) {
            System.out.println("Rango inválido. No se realizó ninguna operación.");
            return;
        }

        if (inicio == 0) {
            for (int i = 0; i <= fin; i++) {
                eliminarElementosPrimos();
            }
        } else {
            Nodo anterior = prim;
            for (int i = 1; i < inicio; i++) {
                anterior = anterior.prox;
            }
            Nodo actual = anterior.prox;
            for (int i = inicio; i <= fin; i++) {
                anterior.prox = actual.prox;
                actual = null;
                actual = anterior.prox;
                cantElem--;
            }
        }
    }

    //2.- eliminarElementosPares(): Este método elimina todos los elementos pares de la lista.
    public void eliminarElementosPares() {
        Nodo actual = prim;
        Nodo anterior = null;
        while (actual != null) {
            if (actual.elem % 2 == 0) {
                if (actual == prim) {
                    prim = actual.prox;
                } else {
                    anterior.prox = actual.prox;
                }
                if (actual == ult) {
                    ult = anterior;
                }
                Nodo temp = actual;
                actual = actual.prox;
                temp.prox = null;
                cantElem--;
            } else {
                anterior = actual;
                actual = actual.prox;
            }
        }
    }

    //3.- eliminarElementosImpares(): Este método elimina todos los elementos impares de la lista.
    public void eliminarElementosImpares() {
        Nodo actual = prim;
        Nodo anterior = null;
        while (actual != null) {
            if (actual.elem % 2 == 1) {
                if (actual == prim) {
                    prim = actual.prox;
                } else {
                    anterior.prox = actual.prox;
                }
                if (actual == ult) {
                    ult = anterior;
                }
                Nodo temp = actual;
                actual = actual.prox;
                temp.prox = null;
                cantElem--;
            } else {
                anterior = actual;
                actual = actual.prox;
            }
        }
    }

    //4.-eliminarElementosPrimos():Este método elimina los elementos primos de una lista.
    public void eliminarElementosPrimos() {
        Nodo actual = prim;
        Nodo anterior = null;
        while (actual != null) {
            if (esPrimo(actual.elem)) {
                if (actual == prim) {
                    prim = actual.prox;
                } else {
                    anterior.prox = actual.prox;
                }
                if (actual == ult) {
                    ult = anterior;
                }
                Nodo temp = actual;
                actual = actual.prox;
                temp.prox = null;
                cantElem--;
            } else {
                anterior = actual;
                actual = actual.prox;
            }
        }
    }

    // Función para verificar si un número es primo
    private boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    //5.- EliminarMultiplosDeCinco():Este metodo elimina los elementos multiplos de cinco de la lista 
    public void eliminarMultiplosDeCinco() {
        Nodo actual = prim;
        Nodo anterior = null;
        while (actual != null) {
            if (esMultiploDeCinco(actual.elem)) {
                if (actual == prim) {
                    prim = actual.prox;
                } else {
                    anterior.prox = actual.prox;
                }
                if (actual == ult) {
                    ult = anterior;
                }
                Nodo temp = actual;
                actual = actual.prox;
                temp.prox = null;
                cantElem--;
            } else {
                anterior = actual;
                actual = actual.prox;
            }
        }
    }

    // Función para verificar si un número es múltiplo de 5
    private boolean esMultiploDeCinco(int num) {
        return num % 5 == 0;
    }

}
