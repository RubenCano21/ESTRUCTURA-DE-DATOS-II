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
        StringBuilder s1 = new StringBuilder("[");
        Nodo p = prim;
        while (p != null){
            s1.append(p.elem).append(", ");
            p = p.prox;
        }
        s1 = new StringBuilder(s1.substring(0, s1.length() - 2));
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
    public void merge(ListaD L2, ListaD L3) {
        if (L2 == null || L2.prim == null) {
            prim = L3.prim;
            return;
        }
        if (L3 == null || L3.prim == null) {
            prim = L2.prim;
            return;
        }
        Nodo p = L2.prim;
        Nodo q = L3.prim;
        // Crear un nuevo nodo que represente la prim de la lista L1
        prim = new Nodo(0);
        Nodo temp = prim;
        while (p != null && q != null) {
            if (p.elem <= q.elem) {
                temp.prox = p;
                p = p.prox;
            } else {
                temp.prox = q;
                q = q.prox;
            }
            temp = temp.prox;
        }
        // Agregar los elementos restantes de L2 o L3 al final de L1
        if (p != null) {
            temp.prox = p;
        }
        if (q != null) {
            temp.prox = q;
        }
        prim = prim.prox; // Descartar el nodo ficticio al principio
    }
    // 13.   L1.iguales() : Método Lógico que devuelve True, si todos los elementos de la lista L1 son iguales.
    public boolean iguales(){
        Nodo p = prim;
        int aux = prim.elem;
        while (p != null){
            if (p.elem != aux)
                return false;
            p = p.prox;
        }
        return true;
    }
    // 14.   L1.diferentes() : Método Lógico que devuelve True, si todos los elementos de la lista L1 son diferentes.
    public boolean diferentes(){
        Nodo p = prim, ap = null;
        while (p != null && p.prox != null){
            ap = p;
            p = p.prox;
            if (ap.elem == p.elem)
                return false;
        }
        return true;
    }
    // 15.   L1.mayorElem() : Método que devuelve el mayor elemento de la lista L1.
    public int mayorElem(){
        Nodo p = prim;
        int may = prim.elem;
        while (p != null){
            if (p.elem >= may)
                may = p.elem;
            p = p.prox;
        }
        return may;
    }
    // 16.    L1.menorElem() : Método que devuelve el menor elemento de la lista L1.
    public int menorElem(){
        Nodo p = prim;
        int men = prim.elem;
        while (p != null){
            if (p.elem <= men)
                men = p.elem;
            p = p.prox;
        }
        return men;
    }
    // 17.    L1.ordenado()  : Método Lógico que devuelve True, si todos los elementos de la lista L1 están ordenados en forma ascendente o descendente.
    public boolean ordenado(){
        return ordenadoAsc() || ordenadoDesc();
    }

    private boolean ordenadoDesc() {
        Nodo p = prim;
        while (p != null && p.prox != null){
            if (p.elem <= p.prox.elem)
                return false;
            p = p.prox;
        }
        return true;
    }

    private boolean ordenadoAsc() {
        Nodo p = prim;
        while (p != null && p.prox != null){
            if (p.elem >= p.prox.elem)
                return false;
            p = p.prox;
        }
        return true;
    }
    // 18.   L1.indexOf(x) : Método que devuelve la posición de la primera ocurrencia del elemento x. Si x no se encuentra en
    // la lista L1, el método devuelve –1.
    public int indexOf(int x) {
        Nodo p = prim;
        int k = 0;
        while (p != null) {
            if (p.elem == x) {
                return k;
            }
            p = p.prox;
            k++;
        }
        return -1;
    }
    // 19.   L1.indexOf(x, i) : Método que devuelve la posición de la primera ocurrencia del elemento x,
    // la búsqueda se realiza desde la posición i.
    public int indexOf(int x, int i) {
        if (prim == null || i < 0) {
            // La lista está vacía o la posición inicial es negativa
            return -1;
        }
        Nodo p = prim;
        int k = -1;
        int kk = 0;
        // Avanzar hasta la posición i
        while (kk < k && p != null) {
            p = p.prox;
            kk++;
        }
        // Buscar la primera ocurrencia de x desde la posición i
        while (p != null) {
            if (p.elem == x) {
                k = kk; // Actualizar la posición de la primera ocurrencia de x
                break;
            }
            p = p.prox;
            kk++;
        }
        return k;
    }

    // 20.   L1.lastIndexOf(x) : Método que devuelve la posición de la última ocurrencia del elemento x.
    // Si x no se encuentra en la lista L1, el método devuelve –1.
    public int lastIndexOf(int x) {
        Nodo p = ult;
        int k = cantElem - 1;
        while (p != null) {
            if (p.elem == x) {
                return k;
            }
            p = p.ant;
            k--;
        }
        return -1;
    }
    // 21.   L1.lastIndexOf(x, i) : Método que devuelve la posición de la última ocurrencia del elemento x.
    // Si x no se encuentra en la lista L1, el método devuelve –1. La búsqueda se realiza desde la posición i.
    public int lastIndexOf(int x, int i) {
        if (prim == null || i < 0) {
            return -1;
        }
        Nodo p = prim;
        int k = -1;
        int kk = 0;
        // Avanzar hasta la posición i
        while (kk < i && p != null) {
            p = p.prox;
            kk++;
        }
        // Buscar la última ocurrencia de x desde la posición i
        while (p != null) {
            if (p.elem == x) {
                k = kk; // Actualizar la posición de la última ocurrencia de x
            }
            p = p.prox;
            kk++;
        }
        return k;
    }

    // 22.   L1.reemplazar(x, y) : Método que reemplaza todas las ocurrencias del elemento x por el elemento y en la lista L1.
    public void reemplazar (int x, int y){
        Nodo p = prim;
        int k =0;
        while (p != null){
            if (p.elem == x){
                p.elem = y;
            }
            p = p.prox;
        }
    }
    // 23.   L1.seEncuentra(x) : Método Lógico que devuelve True, si el elemento x, se encuentra en la lista L1.
    public boolean seEncuentra(int x){
        Nodo p = prim;
        while (p != null){
            if (p.elem != x)
                return false;
            p = p.prox;
        }
        return true;
    }
    // 24.   L1.frecuencia(x) : Método que devuelve la cantidad de veces que aparece el elemento x en la lista L1.
    public int frecuencia(int x){
        int k =0;
        Nodo p = prim;
        while ( p != null){
            if (p.elem == x)
                k++;
            p = p.prox;
        }
        return k;
    }
    // 25.   L1.existeFrec(k) : Método Lógico que devuelve True, si existe algún elemento que se repite exactamente
    // k-veces en la lista L1.
    public boolean existeFrec(int k){
        int c = 0;
        Nodo p = prim;
        while (p != null){
            if (frecuencia(p.elem) == k)
                return true;
            p = p.prox;
        }
        return false;
    }
    // 26.   L1.mismasFrec() : Método Lógico que devuelve True, si los elementos de la lista L1 tienen la misma frecuencia.
    public boolean mismaFrec(){
        Nodo p = prim;
        while (p != null){
            if (frecuencia(p.elem) == frecuencia(p.prox.elem))
                return true;
            p = p.prox;
        }
        return false;
    }
    // 27.   L1.poker() : Método Lógico que devuelve True, si los elementos de la lista L1 forman poker.
    // (Todos los elementos son iguales excepto uno)
    public  boolean poker(){
        Nodo p = prim;
        while (p != null){
            if (frecuencia(p.elem) == cantElem-1)
                return true;
            p =p.prox;
        }
        return false;
    }
    // 28.   L1.existePar() : Método lógico que devuelve True, si la lista L1 contiene al menos un elemento par.
    public boolean existePar(){
        Nodo p = prim;
        while (p != null){
            if (esPar(p.elem))
                return true;
            p =p.prox;
        }
        return false;
    }

    private boolean esPar(int x) {
        return (x % 2 == 0);
    }
    // 29.   L1.existeImpar() : Método lógico que devuelve True, si la lista L1 contiene al menos un elemento impar.
    public boolean existeImpar(){
        Nodo p =prim;
        while (p != null){
            if (esImpar(p.elem))
                return true;
            p = p.prox;
        }
        return false;
    }

    private boolean esImpar(int x) {
        return (x % 2 == 1);
    }
    // 30.   L1.todoPares() : Método lógico que devuelve True, si todos los elementos de la lista L1 son pares.
    public boolean todosPares(){
        Nodo p = prim;
        while (p != null){
            if (!esPar(p.elem))
                return false;
            p = p.prox;
        }
        return true;
    }
    // 31.   L1.todoImpares() : Método lógico que devuelve True, si todos los elementos de la lista L1 son impares.
    public boolean todosImpares(){
        Nodo p = prim;
        while (p != null){
            if (!esImpar(p.elem))
                return false;
            p = p.prox;
        }
        return true;
    }
    //32.   L1.existeParImpar() : Método lógico que devuelve True, si en la lista L1 al menos existe un elemento par y
    // un elemento impar.
    public boolean existeParImpar(){
        Nodo p = prim;
        while (p != null){
            if (existePar() && existeImpar())
                return true;
            p = p.prox;
        }
        return false;
    }
    // 33.   L1.alternos() : Método lógico que devuelve true, si la lista L1 contiene elementos en la prox secuencia:
    // par, impar, par, impar, . . . or  impar, par, impar, par, . . . .
    public boolean alternos (){
        Nodo p= prim;
        while (p != null && p.prox != null){
            if (esPar(p.elem) && esPar(p.prox.elem) ||
                    esImpar(p.elem) && esImpar(p.prox.elem))
                return false;
            p = p.prox;
        }
        return true;
    }
    // 34.   L1.palindrome() : Método lógico que devuelve True, si la lista L1 contiene elementos que forma un palíndrome.
    // Ejemplo, caso anterior.
    public boolean palindrome() {
        if (prim == null) {
            return false;
        }
        Nodo p = prim;
        Nodo q = prim;
        while (q.prox != null) {
            q = q.prox;
        }
        while (p != q && p.ant != q) {
            if (p.elem != q.elem) {
                return false;
            }
            p = p.prox;
            q = q.ant;
        }
        return true;
    }
    // 35. L1.invertir() : Método que invierte los elementos de la lista L1.
    public void invertir() {
        Nodo p = prim;
        Nodo ap = null;
        while (p != null) {
            ap = p.ant;
            p.ant = p.prox;
            p.prox = ap;
            p = p.ant;
        }
        if (ap != null) {
            prim = ap.ant;
        }
    }


    //          ELIMINAR LOS ELEMENTOS DE UNA LISTA

    // 1. L1.eliminarPrim() : Método que elimina el primer elemento de la lista L1.
    public  void eliminarPrim(){
        if (vacia())
            return;
        if (prim == ult)
            prim = ult = null;
        else {
            prim.prox.ant = null;
            prim = prim.prox;
        }
        cantElem--;
    }
    // 2. L1.eliminarUlt() : Método que elimina el último elemento de la lista L1.
    public void eliminarUlt(){
        if (vacia())
            return;
        if (prim == ult)
            prim = ult = null;
        else {
            ult.ant.prox = null;
            ult = ult.ant;
        }
        cantElem--;
    }
    // 3. L1.eliminarIesimo(i) : Método que elimina el i-ésimo elemento de la lista L1.
    public void eliminarIesimo(int i){
        int k = 0;
        Nodo p = prim, ap = null;
        while (k < i && p != null){
            ap = p;
            p = p.prox;
            k++;
        }
        eliminarNodo(ap,p);
    }

    private Nodo eliminarNodo(Nodo ap, Nodo p) {
        if (p == null)
            return null;

        if (ap == null){
            eliminarPrim();
            return prim;
        }
        if (p.prox == null){
            eliminarUlt();
            return null;
        }
        ap.prox = p.prox;
        p.prox.ant = ap;
        cantElem--;
        return ap.prox;
    }
    // 4. L1.eliminarPrim(x) : Método que elimina el primer elemento x de la lista L1.
    public void eliminarPrimX(int x){
        Nodo p = prim;
        while (p != null){
            if (p.elem == x) {
                eliminarNodo(p.ant, p);
                return;
            }
            p = p.prox;
        }
    }
    // 5. L1.eliminarUlt(x) : Método que elimina el último elemento x de la lista L1.
    public void eliminarUltX(int x) {
        if (prim == null) {
            return;
        }
        Nodo p = prim;
        Nodo ap = null;
        // Encontrar el último nodo y verificar si contiene el valor a eliminar
        while (p.prox != null) {
            if (p.prox.elem == x) {
                ap = p;
            }
            p = p.prox;
        }
        // Si no se encontró el valor a eliminar, no hay nada que hacer
        if (ap == null) {
            return;
        }
        // Si el último nodo es el primer nodo
        if (ap == prim) {
            prim = prim.prox;
            if (prim != null) {
                prim.ant = null; // Actualizar el puntero del nodo anterior
            }
            return;
        }
        // Eliminar el último nodo que contiene el valor a eliminar
        ap.prox = ap.prox.prox;
        if (ap.prox != null) {
            ap.prox.ant = ap; // Actualizar el puntero del nodo anterior al siguiente nodo
        }
    }

    // 6. L1.eliminarTodo( x ) : Método que elimina todos los elementos x de la lista L1.
    public void eliminarTodo(int x){
        Nodo p = prim, ap=null;
        while(p != null){
            if(p.elem == x){
                p.prox = eliminarNodo(ap, p);
                p = p.prox;
            }else {
                ap =p;
                p = p.prox;
            }
        }
    }

    // 7. L1.eliminarPrim( n ) : Método que eliminar los primeros n-elementos de la lista L1.
    public void eliminarPrim(int n){
        if(vacia())
            return;
        if (cantElem == 1) {
            eliminarUlt();
        }
        int k =1;
        Nodo p = prim;
        while (k <= n && p!= null) {
            eliminarPrim();
            p = p.prox;
            k++;
        }
    }
    // 8. L1.eliminarUlt( n ) : Método que elimina los n-últimos elementos de la lista L1.
    public void eliminarUlt(int n){
        if(vacia())
            return;
        if (cantElem == 1) {
            eliminarUlt();
        }
        int k =1;
        Nodo p = prim;
        while (k <= n && p!= null) {
            eliminarUlt();
            p = p.prox;
            k++;
        }
    }
    // 9. L1.eliminarIesimo(i, n) : Método que elimina los n-elementos de la lista L1, desde la posición i.
    public void eliminarIesimo(int i, int n){
        int k =0;
        Nodo p = prim, ap = null;
        while (i > k && p != null){
            ap = p;
            p = p.prox;
            k++;
        }
        for (int j = 1; j <= n ; j++) {
            ap.prox = eliminarNodo(ap, p);
            p = p.prox;
        }
    }
    // 10. L1.eliminarExtremos( n ) : Método que eliminar la n-elementos de los extremos de la lista L1.
    public void eliminarExtremos(int n){
        int k = 0;
        Nodo p = prim;
        while (k < n && p != null){
            eliminarPrim();
            eliminarUlt();
            p = p.prox;
            k++;
        }
    }
    // 11. L1.eliminarPares() : Método que elimina los elementos pares de la lista L1.
    public void eliminarPares(){
        Nodo p = prim, ap = null;
        while (p != null){
            if (esPar(p.elem)){
                ap.prox = eliminarNodo(ap,p);
                p = p.prox;
            }else {
                ap = p;
                p = p.prox;
            }
        }
    }
    // 12.L1.eliminarUnicos() : Método que elimina los elementos que aparecen solo una vez en la lista L1.
    public void eliminarUnicos() {
        Nodo p = prim;
        while (p != null) {
            if (!esRepetido(p.elem)) {
                eliminarNodo(p.ant,p);
                p = prim;
            } else {
                p = p.prox;
            }
        }
    }

    private boolean esRepetido(int elem) {
        Nodo p = prim;
        int k = 0;
        while (p != null) {
            if (p.elem == elem) {
                k++;
            }
            p = p.prox;
        }
        return k > 1;
    }
    // 13 L1.eliminarTodo(L2) : Método que elimina todos los elementos de la lista L1, que aparecen en la lista L2.
    public void eliminarTodo(ListaD L2) {
        Nodo q = L2.prim;
        while (q != null) {
            Nodo p = prim;
            while (p != null) {
                if (p.elem == q.elem) {
                    p = eliminarNodo(p.ant, p);
                    break;
                }
                p = p.prox;
            }
            q = q.prox;
        }
    }
    // 14. L1.eliminarVeces(k) : Método que elimina los elementos que se repiten k-veces en la lista L1.
    public void eliminarVeces(int k){
        Nodo p =prim;
        while (p != null && p.prox != null){
            if (frecuencia(p.elem) == k)
                eliminarTodo(p.elem);
            p = p.prox;
        }
    }
    // 15. L1.eliminarAlternos() : Método que elimina los elementos de las posiciones alternas.(permanece, se elimina, permanece, se elimina, etc.)
    public void eliminarAlternos() {
        Nodo p = prim;
        while (p != null && p.prox != null) {
            Nodo q = p.prox.prox;
            p.prox = q;
            p = q;
        }
    }
    // 16. L1.rotarIzqDer( n ) : Método que hace rotar los elementos de la lista L1 n-veces de izquierda a derecha.
    public void rotarIzqDer(int n) {
        if (prim == null || n <= 0) {
            return;
        }
        int k = 1;
        Nodo q = prim;
        while (q.prox != null) {
            q = q.prox;
            k++;
        }
        n = n % k;
        if (n == 0) {
            return;
        }
        Nodo p = prim;
        for (int i = 1; i < k - n; i++) {
            p = p.prox;
        }
        Nodo ap = p.prox;
        ap.ant = null;
        p.prox = null;
        q.prox = prim;
        prim.ant = q;
        prim = ap;
    }
    // 17. L1.rotarDerIzq( n ) : Método que hace rotar los elementos de la lista L1 n-veces de derecha a izquierda.
    public void rotarDerIzq(int n) {
        if (prim == null || n <= 0) {
            return;
        }
        int k = 1;
        Nodo q = prim;
        while (q.prox != null) {
            q = q.prox;
            k++;
        }
        n = n % k;
        if (n == 0) {
            return;
        }
        Nodo p = prim;
        for (int i = 1; i < k - n; i++) {
            p = p.prox;
        }
        Nodo ap = p.prox;
        ap.ant = null;
        p.prox = null;
        q.prox = prim;
        prim.ant = q;
        prim = ap;
    }

}
