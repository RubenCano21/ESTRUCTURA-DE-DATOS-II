package ListaSimple;

import ListaDoble.Nodo;

public class ListaS {

    public NodoS prim;
    public int cantElem;
    public NodoS ult;


    public ListaS (){
        this.prim = null;
        this.ult = null;
        this.cantElem = 0;
    }
    //  LAB-4. CONSULTAS LISTAS ENCADENADAS SIMPLES

//1.      L1.toString() : Método que devuelve una cadena, que representa la secuencia de elementos de la lista L1.
    public String toString(){
        String s1 = "[ ";
        NodoS p = prim;
        while (p != null){
            s1 += p.elem + "-> ";
            p = p.prox;
        }
        s1 = s1.substring(0, s1.length() -3);
        return s1 + "]";
    }
    public boolean vacia(){
        return (this.prim == null && this.ult == null);
    }

    /**
     * 2.L1.insertarPrim(x) : Método que inserta el elemento x, al inicio de la lista L1.
     */
    public void insertarPrim(int x){
        if (vacia()){
            NodoS p = new NodoS(x, null);
            prim = p;
            ult = p;
        }else {
            prim = new NodoS(x, prim);
        }
        cantElem++;
    }
    /**
     * 3.      L1.insertarUlt(x) : Método que inserta el elemento x, al inicio de la lista L1.
     * @param x
     */
    public void insertarUlt(int x){
        if (vacia()){
            prim = ult = new NodoS(x, null);
        }else {
            ult = ult.prox = new NodoS(x, null);
        }
        cantElem++;
    }
//.      L1.InsertarIesimo(x, i) : Método que inserta el elemento x, en la la iésima posición de la Lista.Lista L1.
    public void insertarIesimo(int x, int i){
        NodoS p = prim, ap = null;
        int k = 0;
        while (k < i && p != null){
            ap = p;
            p = p.prox;
            k++;
        }
        insertarNodo(x, ap, p);
    }

    private void insertarNodo(int x, NodoS ap, NodoS p) {
        if (ap == null)
            insertarPrim(x);
        else {
            if (p == null)
                insertarUlt(x);
            else {
                ap.prox = new NodoS(x,p);
                cantElem++;
            }
        }
    }
//4.      L1.iguales() : Método Lógico que devuelve True, si todos los elementos de la lista L1 son iguales.
    public boolean iguales(){
        NodoS p = prim;
        int aux = prim.elem;
        while (p != null){
            if (p.elem != aux)
                return false;
            p = p.prox;
        }
        return true;
    }
//5.      L1.menorElem() : Método que devuelve el menor elemento de la lista L1.
    public int menor(){
        NodoS p = prim;
        int men = prim.elem;
        while (p != null){
            if (p.elem < men)
                men = p.elem;
            p = p.prox;
        }
        return men;
    }
    /**
     * 6.   L1.reemplazar(x, y) : Método que reemplaza todas las ocurrencias del elemento x por el elemento y en la lista L1.
     * @param x
     * @param y
     */
    public void reemplazar(int x, int y){
        NodoS p = prim;
        while (p != null){
            if (p.elem == x)
                p.elem = y;
            p = p.prox;
        }
    }
//7.   L1.seEncuentra(x) : Método Lógico que devuelve True, si el elemento x, se encuentra en la lista L1.
    public boolean seEncuentra(int x){
        NodoS p = prim;
        while (p != null){
            if (p.elem == x)
                return true;
            p = p.prox;
        }
        return false;
    }
//8.   L1.frecuencia(x) : Método que devuelve la cantidad de veces que aparece el elemento x en la lista L1.
    public int frecuencia(int x){
        int k =0;
        NodoS p = prim;
        while (p != null){
            if (p.elem == x)
                k++;
            p = p.prox;
        }
        return k;
    }
//9.   L1.insertarUlt(L2) : Método que inserta los elementos de la Lista L2, al final de la Lista L1.
    public void insertarUlt(ListaS L2){
        ListaS nuevaLista = new ListaS();
        NodoS p = L2.prim;
        while (p != null){
            insertarUlt(p.elem);
            p = p.prox;
        }
    }
//10.   L1.insertarLugar(x) : Método que inserta el elemento x, en su lugar correspondiente en la Lista L1, ordenada de menor a mayor.*/
    public void insertarLugar(int x){
        NodoS p = prim, ap = null;
        while (p != null && x > p.elem){
            ap = p;
            p = p.prox;
        }
        insertarNodo(x, ap ,ap.prox);
    }

    //  TAREA-4. EJERCICIOS BÁSICOS SOBRE LISTAS ENCADENADAS SIMPLES

// 5.      L1.diferentes() : Método Lógico que devuelve True, si todos los elementos de la lista L1 son diferentes.
    public boolean diferentes(){
        NodoS p = prim, ap = null;

        while (p.prox != null){
            ap = p;
            p =p.prox;
            if (ap.elem == p.elem) {
                return false;
            }
        }
        return true;
    }
// 6.      L1.mayorElem() : Método que devuelve el mayor elemento de la lista L1.
    public int mayorElem(){
        NodoS p = prim;
        int may = p.elem;
        while (p != null){
            if (p.elem >= may) {
                may = p.elem;
            }
            p = p.prox;
        }
        return may;
    }

// 8.      L1.ordenado()  : Método Lógico que devuelve True, si todos los elementos de la lista L1 están ordenados en forma ascendente o descendente.
    public boolean ordenadoAsc(){
        NodoS p = prim;
        while (p != null && p.prox != null){
            if (p.elem >= p.prox.elem)
                return false;
            p = p.prox;
        }
        return true;
    }
    public boolean ordenadoDesc(){
        NodoS p = prim;
        while (p != null && p.prox != null){
            if (p.elem <= p.prox.elem)
                return false;
            p = p.prox;
        }
        return true;
    }

    public boolean ordenado(){
        return ordenadoAsc() || ordenadoDesc();
    }
// 9.      L1.pares() : Método lógico que devuelve True, si todos los elementos de la lista L1 son pares.
    public boolean pares(){
        NodoS p = prim;
        while (p != null){
            if(!esPar(p.elem))
                return false;
            p = p.prox;
        }
        return true;
    }

    private boolean esPar(int x) {
        return (x % 2 == 0);
    }
// 10.      L1.parImpar() : Método lógico que devuelve True, si la lista L1 contiene al menos un elemento par e impar.
    public boolean parImpar(){
        NodoS p = prim;
        int k =0, j =0;
        while (p != null){
            if (esPar(p.elem)){
                k++;
            }
            if (esImpar(p.elem)){
                j++;
            }
            p = p.prox;
        }
        return k >= 1 && j >= 1;
    }

    private boolean esImpar(int x) {
        return (x % 2 == 1);
    }

// 14.   L1.existeFrec(k) : Método Lógico que devuelve True, si existe algún elemento que se repite exactamente k-veces en la lista L1.
    public boolean existeFrec(int k){
        NodoS p = prim;
        int i = 0;
        while (i < k && p != null){
            if (frecuencia(p.elem) == k)
                return true;
            p = p.prox;
            i++;
        }
        return false;
    }
// 15.   L1.mismasFrec() : Método Lógico que devuelve True, si todos los elementos de la lista L1 tienen la misma frecuencia.
    public boolean mismaFrec(){
        NodoS p = prim;
        while (p != null && p.prox != null){
            if (frecuencia(p.elem) != frecuencia(p.prox.elem))
                return false;
            p = p.prox;
        }
        return true;
    }
// 16.   L1.poker() : Método Lógico que devuelve True, si los elementos de la lista L1 forman poker. (Todos los elementos son iguales excepto uno)
    public boolean poker(){
        NodoS p = prim;
        while (p != null){
            if (frecuencia(p.elem) == cantElem-1)
                return true;
            p =p.prox;
        }
        return  false;
    }
// 17.   L1.existePar() : Método lógico que devuelve True, si la lista L1 contiene al menos un elemento par.
    public boolean existePar(){
        NodoS p = prim;
        int k = 0;
        while (p != null){
            if (esPar(p.elem))
                k++;
            p = p.prox;
        }
        return k >=1;
    }
// 18.   L1.existeImpar() : Método lógico que devuelve True, si la lista L1 contiene al menos un elemento impar.
    public boolean existeImpar(){
        NodoS p = prim;
        int k =0;
        while (p != null){
            if (esImpar(p.elem))
                k++;
            p = p.prox;
        }
        return k>=1;
    }
// 19.   L1.todoPares() : Método lógico que devuelve True, si todos los elementos de la lista L1 son pares.
    public  boolean todoPares(){
        NodoS p = prim;
        while (p != null){
            if (!esPar(p.elem))
                return false;
            p =p.prox;
        }
        return true;
    }
// 20.   L1.todoImpares() : Método lógico que devuelve True, si todos los elementos de la lista L1 son impares.
    public boolean todoImpares(){
        NodoS p = prim;
        while (p != null){
            if (!esImpar(p.elem))
                return false;
            p = p.prox;
        }
        return true;
    }

// 22.   L1.alternos() : Método lógico que devuelve true, si la lista L1 contiene elementos en la siguiente secuencia:
// par, impar, par, impar, . . . or  impar, par, impar, par, . . . .
    public boolean alternos() {
        NodoS p = prim;
        boolean esPar = esPar(prim.elem); // Verificar si el primer elemento es par
        while (p != null && p.prox != null) {
            if ((p.elem % 2 == 0 && !esPar) || (p.elem % 2 != 0 && esPar)) {
                return false; // Los elementos no están alternados correctamente
            }
            esPar = !esPar; // Alternar entre par e impar
            p = p.prox;
        }
        return true; // La lista contiene elementos en la secuencia deseada
    }

// 26. L1.intercalar(L2, L3) : Método que intercala los elementos de las Listas L2 con L3 en L1.
    public void intercalar(ListaS L2, ListaS L3) {
        if (L2 == null || L3 == null) {
            return; // No hay nada que intercalar si alguna de las listas es nula
        }
        NodoS aux = prim;
        NodoS p = L2.prim;
        NodoS q = L3.prim;

        while (p != null && q != null) {
            // Insertar elemento de L2
            NodoS nuevoNodoL2 = new NodoS(p.elem);
            if (aux == null) {
                prim = nuevoNodoL2;
            } else {
                aux.prox = nuevoNodoL2;
                //nuevoNodoL2.anterior = aux;
            }
            aux = nuevoNodoL2;
            p = p.prox;
            // Insertar elemento de L3
            NodoS nuevoNodoL3 = new NodoS(q.elem);
            aux.prox = nuevoNodoL3;
            //nuevoNodoL3.anterior = aux;
            aux = nuevoNodoL3;
            q = q.prox;
        }
        // Si una lista es más larga que la otra, agregar los elementos restantes al final de L1
        while (p != null) {
            NodoS nuevoNodo = new NodoS(p.elem);
            aux.prox = nuevoNodo;
            //nuevoNodo.anterior = aux;
            aux = nuevoNodo;
            p = p.prox;
        }
        while (q != null) {
            NodoS nuevoNodo = new NodoS(q.elem);
            aux.prox = nuevoNodo;
            //nuevoNodo.anterior = aux;
            aux = nuevoNodo;
            q = q.prox;
        }
    }

}
