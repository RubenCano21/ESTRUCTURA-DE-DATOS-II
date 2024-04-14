package ListaDoble;

public class ListaD {

    public Nodo prim;
    public Nodo ult;
    public int cantElem;

    public ListaD() {
        prim = ult = null;
        cantElem = 0;
    }
    //INSERTAR / ELIMINAR Nodo DE UNA LISTA DOBLEMENTE ENCADENADA.
    // Implementar en JAVA, los siguientes ejercicios, para cada una de las siguientes estructuras de datos: Listas en Arreglo,
    // Listas Encadenadas Simples y Listas Doblemente Encadenadas.
    //
    // 1.   L1.toString() : Método que devuelve una cadena, que representa la secuencia de elementos de la lista L1.
    @Override
    public String toString(){
        String s1 = "[";
        Nodo p = prim;
        while (p != null){
            s1 += p.elem + ", ";
            p = p.prox;
        }
        s1 = s1.substring(0, s1.length() -2);
        return s1 + "]";
    }
    // 2.   L1.insertarPrim(x) : Método que inserta el elemento x, al final de la lista L1.
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
    // 3.   L1.insertarUlt(x) : Método que inserta el elemento x, al final de la lista L1.
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
    public void insertarIesimo(ListaD L2, int i){
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
    // 6. L1.insertarPrim(L2) : Método que insertar los elementos de la lista L2 al principio de la lista L1.
    public void insertarPrim(ListaD L2){
        if (L2.prim == null){
            return;
        }
        if (prim == null){
            prim = L2.prim;
        }else {
            Nodo p = L2.prim;
            while (p.prox != null){
                p = p.prox;
            }
            p.prox = prim;
            prim.ant = p;
            prim = L2.prim;
        }
    }
    // 7. L1.insertarUlt(L2) : Método que insertar los elementos de la lista L2 al final de la lista L1.
    public void insertarUlt(ListaD L2){
        if (L2.ult == null){
            return;
        }
        if (ult == null){
            ult = L2.prim;
        }else {
            Nodo p = L2.prim;
            while (p.prox != null){
                p = p.prox;
            }
            ult.prox = p;
            p.ant = ult;
            ult.prox = L2.prim;
        }
    }
    // 8. L1.insertarAsc(x) : Método que inserta el elemento x en su lugar correspondiente, en la lista L1, ordenada en forma ascendente.
    public  void insertarAsc(int x){
        Nodo aux = new Nodo(null,x, null);
        if (prim == null){
            prim = aux;
        } else if (x < prim.elem) {
            aux.prox = prim;
            prim.ant = aux;
            prim = aux;
        }else {
            Nodo p = prim;
            while (p.prox != null && p.prox.elem < x){
                p = p.prox;
            }
            aux.prox = p.prox;
            if (p.prox != null)
                p.prox.ant = aux;
            p.prox = aux;
            aux.ant = p;
        }
    }
    // 9. L1.insertarDes(x) : Método que inserta el elemento x en su lugar correspondiente, en la lista L1, ordenada en forma descendente.
    public void insertarDesc(int x){
        Nodo aux = new Nodo(null, x, null);
        if (prim == null){
            prim = aux;
        } else if (x > prim.elem) {
            aux.prox = prim;
            prim.ant = aux;
            prim = aux;
        }else {
            Nodo p = prim;
            while (p.prox != null && p.prox.elem > x){
                p = p.prox;
            }
            aux.prox = p.prox;
            if (p.prox != null)
                p.prox.ant = aux;
            p.prox = aux;
            aux.ant = p;
        }
    }
    // 10. L1.concatenar(L2, L3): Método que concatena las listas L2 con L3 en L1.
    public void concatenar(ListaD L2, ListaD L3){
        if (L2 == null && L3 == null){
            return;
        }
        if (L2 == null || L2.prim == null){
            prim = L3.prim;
        } else if (L3 == null || L3.prim == null) {
            prim = L2.prim;
        }else {
            Nodo p = L2.prim;
            while (p.prox != null){
                p = p.prox;
            }
            p.prox = L3.prim;
            prim = L2.prim;
        }
    }
    // 11. L1.intercalar(L2, L3): Método que intercala los elementos de las Listas L2 con L3 en L1.
    public  void intercalar(ListaD L2, ListaD L3){
        if (L2 == null || L3 == null) {
            return; // No hay nada que intercalar si alguna de las listas es nula
        }
        Nodo aux = prim;
        Nodo p = L2.prim;
        Nodo q = L3.prim;

        while (p != null && q != null) {
            // Insertar elemento de L2
            Nodo nuevoNodoL2 = new Nodo(p.elem);
            if (aux == null) {
                prim = nuevoNodoL2;
            } else {
                aux.prox = nuevoNodoL2;
                nuevoNodoL2.ant = aux;
            }
            aux = nuevoNodoL2;
            p = p.prox;
            // Insertar elemento de L3
            Nodo nuevoNodoL3 = new Nodo(p.elem);
            aux.prox = nuevoNodoL3;
            nuevoNodoL3.ant = aux;
            aux = nuevoNodoL3;
            q = q.prox;
        }
        // Si una lista es más larga que la otra, agregar los elementos restantes al final de L1
        while (p != null) {
            Nodo nuevoNodo = new Nodo(p.elem);
            aux.prox = nuevoNodo;
            nuevoNodo.ant = aux;
            aux = nuevoNodo;
            p = p.prox;
        }
        while (q != null) {
            Nodo nuevoNodo = new Nodo(p.elem);
            aux.prox = nuevoNodo;
            nuevoNodo.ant = aux;
            aux = nuevoNodo;
            q = q.prox;
        }
    }
    // 12. L1.merge(L2, L3): Método que realiza el merge en L1, de las listas ordenadas en forma ascedente L2 y L3.
    //
    // 13.   L1.iguales() : Método Lógico que devuelve True, si todos los elementos de la lista L1 son iguales.
    //
    // 14.   L1.diferentes() : Método Lógico que devuelve True, si todos los elementos de la lista L1 son diferentes.
    //
    // 15.   L1.mayorElem() : Método que devuelve el mayor elemento de la lista L1.
    //
    // 16.    L1.menorElem() : Método que devuelve el mayor elemento de la lista L1.
    //
    // 17.    L1.ordenado()  : Método Lógico que devuelve True, si todos los elementos de la lista L1 están ordenados en forma ascendente o descendente.
    //
    // 18.   L1.indexOf(x) : Método que devuelve la posición de la primera ocurrencia del elemento x. Si x no se encuentra en la lista L1, el método devuelve –1.
    //
    // 19.   L1.indexOf(x, i) : Método que devuelve la posición de la primera ocurrencia del elemento x, la búsqueda se realiza desde la posición i.
    //
    // 20.   L1.lastIndexOf(x) : Método que devuelve la posición de la última ocurrencia del elemento x. Si x no se encuentra en la lista L1, el método devuelve –1.
    //
    // 21.   L1.lastIndexOf(x, i) : Método que devuelve la posición de la última ocurrencia del elemento x. Si x no se encuentra en la lista L1, el método devuelve –1. La búsqueda se realiza desde la posición i.
    //
    // 22.   L1.reemplazar(x, y) : Método que reemplaza todas las ocurrencias del elemento x por el elemento y en la lista L1.
    //
    // 23.   L1.seEncuentra(x) : Método Lógico que devuelve True, si el elemento x, se encuentra en la lista L1.
    //
    // 24.   L1.frecuencia(x) : Método que devuelve la cantidad de veces que aparece el elemento x en la lista L1.
    //
    // 25.   L1.existeFrec(k) : Método Lógico que devuelve True, si existe algún elemento que se repite exactamente k-veces en la lista L1.
    //
    // 26.   L1.mismasFrec() : Método Lógico que devuelve True, si los elementos de la lista L1 tienen la misma frecuencia.
    //
    // 27.   L1.poker() : Método Lógico que devuelve True, si los elementos de la lista L1 forman poker. (Todos los elementos son iguales excepto uno)
    //
    // 28.   L1.existePar() : Método lógico que devuelve True, si la lista L1 contiene al menos un elemento par.
    //
    // 29.   L1.existeImpar() : Método lógico que devuelve True, si la lista L1 contiene al menos un elemento impar.
    //
    // 30.   L1.todoPares() : Método lógico que devuelve True, si todos los elementos de la lista L1 son pares.
    //
    // 31.   L1.todoImpares() : Método lógico que devuelve True, si todos los elementos de la lista L1 son impares.
    //
    // 32.   L1.existeParImpar() : Método lógico que devuelve True, si en la lista L1 al menos existe un elemento par y un elemento impar.
    //
    // 33.   L1.alternos() : Método lógico que devuelve true, si la lista L1 contiene elementos en la siguiente secuencia: par, impar, par, impar, . . . or  impar, par, impar, par, . . . .
    //
    // 34.   L1.palindrome() : Método lógico que devuelve True, si la lista L1 contiene elementos que forma un palíndrome. Ejemplo, caso anterior.
    //
    // 35. L1.invertir() : Método que invierte los elementos de la lista L1.
    //
    //
    //
    // ELIMINAR LOS ELEMENTOS DE UNA LISTA
    //
    // 1. L1.eliminarPrim() : Método que elimina el primer elemento de la lista L1.
    //
    // 2. L1.eliminarUlt() : Método que elimina el último elemento de la lista L1.
    //
    // 3. L1.eliminarIesimo(i) : Método que elimina el i-ésimo elemento de la lista L1.
    //
    // 4. L1.eliminarPrim(x) : Método que elimina el primer elemento x de la lista L1.
    //
    // 5. L1.eliminarUlt(x) : Método que elimina el último elemento x de la lista L1.
    //
    // 6. L1.eliminarTodo( x ) : Método que elimina todos los elementos x de la lista L1.
    //
    // 7. L1.eliminarPrim( n ) : Método que eliminar los primeros n-elementos de la lista L1.
    //
    // 8. L1.eliminarUlt( n ) : Método que elimina los n-últimos elementos de la lista L1.
    //
    // 9. L1.eliminarIesimo(i, n) : Método que elimina los n-elementos de la lista L1, desde la posición i.
    //
    // 10. L1.eliminarExtremos( n ) : Método que eliminar la n-elementos de los extremos de la lista L1.
    //
    // 11. L1.eliminarPares() : Método que elimina los elementos pares de la lista L1.
    //
    // 12.L1.eliminarUnicos() : Método que elimina los elementos que aparecen solo una vez en la lista L1.
    //
    // 13 L1.eliminarTodo(L2) : Método que elimina todos los elementos de la lista L1, que aparecen en la lista L2.
    //
    // 14. L1.eliminarVeces(k) : Método que elimina los elementos que se repiten k-veces en la lista L1.
    //
    // 15. L1.eliminarAlternos() : Método que elimina los elementos de las posiciones alternas. (permanece, se elimina, permanece, se elimina, etc.)
    //
    // 16. L1.rotarIzqDer( n ) : Método que hace rotar los elementos de la lista L1 n-veces de izquierda a derecha.
    //
    // 17. L1.rotarDerIzq( n ) : Método que hace rotar los elementos de la lista L1 n-veces de derecha a izquierda.
}
