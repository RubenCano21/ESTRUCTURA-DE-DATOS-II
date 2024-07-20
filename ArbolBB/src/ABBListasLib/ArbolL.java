package ABBListasLib;

import ArbolBB.Nodo;

import java.util.*;

public class ArbolL {

    public int cantElem;
    public Nodo raiz;

    public ArbolL (){
        cantElem = 0;
    }

    private boolean esHoja(Nodo p){
        return (p.izq == null && p.der == null);
    }

    public void elemNivel(){
        elemNivel(raiz, 1);
    }

    private void elemNivel(Nodo p, int nivel) {
        if (p == null) {
            return;
        }
        elemNivel(p.izq, nivel + 1);
        System.out.println(p.elem + "\t" + nivel);
        elemNivel(p.der, nivel + 1);
    }



    public void sumarNivel(){
        int max = cantidad();
        ArrayList<Integer> L1 = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            L1.add(0);
        }
        sumarNivel(raiz,0,L1);
        int i =0;
        while (L1.get(i) != 0){
            System.out.println(i+1 + "\t" + L1.get(i));
            i++;
        }
    }



    private void sumarNivel(Nodo p, int nivel, ArrayList<Integer> L1) {
        if (p == null) {return;}
        L1.set(L1.get(nivel), p.elem);
        sumarNivel(p.izq,nivel+1,L1);
        sumarNivel(p.der,nivel+1,L1);
    }

//    1.A1.generarElem(n, a, b) : Método que genera n elementos aleatorios enteros diferentes entre a y b inclusive.
    public void generarElem(int n , int a, int b){
        Set<Integer> element = new HashSet<>();
        Random rand = new Random();

        while (element.size() < n) {
            int num = rand.nextInt(b-a+1) + a;
            if (!element.contains(num)){
                insertar(num);
                element.add(num);
            }
        }
    }

//2. A1.insertar(x) : Método que inserta el elemento x, en el árbol A1 en su lugar correspondiente.
    public void insertar(int x){
        raiz = insertar(raiz,x);
    }

    private Nodo insertar(Nodo p, int x) {
        if (p == null) {
            p = new Nodo(x);
        }
        if (x < p.elem) {
            p.izq = insertar(p.izq,x);
        } else if (x > p.elem) {
            p.der = insertar(p.der,x);
        }
        return p;
    }

//3.       A1.preOrden() : Método que muestra los elementos del árbol A1 en preOrden.
    public void preOrden(){
        preOrden(raiz);
        System.out.println();
    }

    private void preOrden(Nodo p) {
        if (p == null) {return;}
        System.out.print(p.elem + ", ");
        preOrden(p.izq);
        preOrden(p.der);
    }
//4. A1.inOrden() : Método que muestra los elementos del árbol A1 en inOrden.
    public void inOrden(){
        inOrden(raiz);
        System.out.println();
    }

    private void inOrden(Nodo p) {
        if (p == null) {return;}
        inOrden(p.izq);
        System.out.print(p.elem + ", ");
        inOrden(p.der);
    }

//5. A1.postOrden() : Método que muestra los elementos del árbol A1 en postOrden.
    public void postOrden(){
        postOrden(raiz);
        System.out.println();
    }

    private void postOrden(Nodo p) {
        if (p == null) {return;}
        postOrden(p.izq);
        postOrden(p.der);
        System.out.print(p.elem + ", ");
    }

// 6. A1.niveles(): Método que muestra los elementos del árbol A1, por niveles.
    public void niveles(){
        if (raiz == null){
            return;
        }
        Queue<Nodo> q = new LinkedList<>();
        q.add(raiz);
        while (!q.isEmpty()){
            Nodo p = q.poll();
            System.out.print(p.elem + ", ");

            if (p.izq != null){
                q.add(p.izq);
            }
            if (p.der != null){
                q.add(p.der);
            }
        }
        System.out.println();
    }

//7. A1.desc(): Método que muestra los elementos del árbol A1 de mayor a menor.
    public void desc(){
        desc(raiz);
        System.out.println();
    }

    private void desc(Nodo p){
        if (p == null){
            return;
        }
        desc(p.der);
        System.out.print(p.elem + " ");
        desc(p.izq);
    }

// 8. A1.seEncuentra(x) : Métodos lógico que devuelve True, si el elemento x, se encuentra en el árbol A1.
    public boolean seEncuentra(int x){
        return seEncuentra(raiz, x);
    }

    private boolean seEncuentra(Nodo p, int x) {
        if (p == null){
            return false;
        }
        if(p.elem == x){
            return true;
        }
        if (x < p.elem){
            return seEncuentra(p.izq, x);
        }else {
            return seEncuentra(p.der, x);
        }
    }

//9. A1.cantidad() : Método que devuelve la cantidad de nodos del árbol A1.
    public int cantidad(){
        return cantidad(raiz);
    }

    private int cantidad(Nodo p){
        if (p == null)
            return 0;
        else {
            return cantidad(p.izq) + cantidad(p.der) + 1;
        }
    }

//10.   A1.suma() : Método que devuelve la suma de los elementos del árbol A1.
    public int suma(){
        return suma(raiz);
    }

    private int suma(Nodo p) {
        if (p == null){
            return 0;
        }else {
            int sum = 0;
            sum += suma(p.izq) + suma(p.der) + p.elem;
            return sum;
        }
    }
//11.   A1.menor() : Método que devuelve el elemento menor del árbol A1.
    public int menor(){
        return menor(raiz);
    }

    private int menor(Nodo p) {
        if (p.izq == null){
            return p.elem;
        }else {
            return menor(p.izq);
        }
    }
//12.   A1.mayor() : Método que devuelve el elemento mayor del árbol A1.
    public int mayor(){
        return mayor(raiz);
    }
    private int mayor(Nodo p) {
        if(p.der == null){
            return p.elem;
        }else {
            return mayor(p.der);
        }
    }

//13.   A1.preoOrden(L1) : Método que encuentra en la lista L1, el recorrido de preOrden de los elementos del árbol A1.
    public void preOrden(ArrayList<Integer> L1){
        preOrden(raiz, L1);
    }

    private void preOrden(Nodo p, ArrayList<Integer> L1) {
        if (p == null){return;}
        L1.add(p.elem);
        preOrden(p.izq, L1);
        preOrden(p.der, L1);
    }

//14.   A1.inOrden(L1) : Método que encuentra en la lista L1, el recorrido de inOrden de los elementos del árbol A1.
    public void inOrden(ArrayList<Integer> L1){
        inOrden(raiz, L1);
    }
    private void inOrden(Nodo p, ArrayList<Integer> L1) {
        if (p == null){return;}
        inOrden(p.izq, L1);
        L1.add(p.elem);
        inOrden(p.der, L1);
    }

//15.   A1.postOrden(L1) : Método que encuentra en la lista L1, el recorrido de postOrden de los elementos del árbol A1.
    public void postOrden(ArrayList<Integer> L1){
        postOrden(raiz, L1);
    }
    private void postOrden(Nodo p, ArrayList<Integer> L1) {
        if (p == null){return;}
        postOrden(p.izq, L1);
        postOrden(p.der, L1);
        L1.add(p.elem);
    }

//16.   A1.niveles(L1) : Método que encuentra en la lista L1, el recorrido por niveles de los elementos del árbol A1.
    public void niveles(ArrayList<Integer> L1){
        LinkedList<Nodo> q = new LinkedList<>();
        if (raiz != null){
            q.add(raiz);
        }
        while (!q.isEmpty()){
            Nodo p = q.poll();
            L1.add(p.elem);
            if (p.izq != null){
                q.add(p.izq);
            }
            if (p.der != null){
                q.add(p.der);
            }
        }
    }

//17.   A1.mostrarNivel(): Método que muestra los elementos del árbol y el nivel en el que se encuentran.
// (Recorrer el árbol en cualquier orden)
    public void mostrarNivel(){
        LinkedList<Nodo> L1 = new LinkedList<>();
        if (raiz == null)
            return;
        L1.add(raiz);
        while (!L1.isEmpty()) {
            Nodo p = L1.peekFirst();
            System.out.println(p.elem);
            if (p.izq != null)
                L1.add(p.izq);
            if (p.der != null)
                L1.add(p.der);
            L1.removeFirst();
        }
    }
//18. A1.sumarNivel(L1) : Método que encuentra en la Lista de acumuladores por nivel L1, la suma de los elementos de cada nivel.
    public void sumarNivel(ArrayList<Integer> L1){
        int sum = 0;
        if (raiz == null){
            return;
        }
        Queue<Nodo> q = new LinkedList<>();
        q.add(raiz);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Nodo p = q.poll();
                sum += p.elem;
                if (p.izq != null)
                    q.add(p.izq);
                if (p.der != null)
                    q.add(p.der);
            }
            L1.add(sum);
        }
    }
//19.   A1.alturaMayor(): Método que devuelve la altura del árbol A1. (Altura es la máxima longitud de la raíz a un nodo hoja en el árbol)
    public int alturaMayor(){
        return alturaMayor(raiz);
    }
    private int alturaMayor(Nodo p) {
        if (p == null){
            return 0;
        }else {
            if (esHoja(p))
                return 1;
            else {
                int ai = alturaMayor(p.izq);
                int ad = alturaMayor(p.der);
                return Math.max(ai, ad);
            }
        }
    }
//20.   A1.alturaMenor(): Método que devuelve la menor altura del árbol A1.
    public int alturaMenor(){
        return alturaMenor(raiz);
    }
    private int alturaMenor(Nodo p) {
        if(p == null){
            return 0;
        }else {
            if (esHoja(p))
                return 1;
            else {
                int ai = alturaMenor(p.izq);
                int ad = alturaMenor(p.der);
                return Math.min(ai, ad);
            }
        }
    }
//21.   A1.mostrarTerm(): Método que muestra los elementos de los nodos terminales del árbol A1. Mostrar los elementos de menor a mayor.
    public void mostrarTerm(){
        mostrarTerm(raiz);
    }

    private void mostrarTerm(Nodo p){
        if (p != null){
            if(esHoja(p))
                System.out.print("\t"+p.elem);
            else {
                mostrarTerm(p.izq);
                mostrarTerm(p.der);
            }
        }
    }
//22.  A1.cantidadTerm(): Método que devuelve la cantidad de nodos terminales del árbol A1.
    public int CantidadTerm(){
        return CantidadTerm(raiz);
    }

    private int CantidadTerm(Nodo p){
        if (p == null)
            return 0;
        if (p.izq == null && p.der == null)
            return 1;
        return CantidadTerm(p.izq) + CantidadTerm(p.der);
    }

//23.   A1.lineal() : Método lógico que devuelve True, si el árbol A1 es un árbol degenerado o lIneal.
// (Se puede dar cuando se genera el árbol con una secuencia ordenada de elementos)
public boolean lineal(){
    return lineal(raiz);
}

    private boolean lineal(Nodo p){
        if (p == null || (p.izq == null && p.der == null)){
            return true;
        }
        if(p.izq != null && p.der != null){
            return false;
        }
        return (p.izq != null) ? lineal(p.izq) : lineal(p.der);
    }
// 24. A1.inmediatoSup(x) : Método que devuelve el elemento inmediato superior a x, si x se encuentra en A1, caso contrario devuelve el mismo elemento.
    public int inmediatoSup(int x){
        Nodo p = inmediatoSup(raiz, x);
        return p != null ? p.elem : x;
    }

    private Nodo inmediatoSup(Nodo p, int x){
        if (p == null){
            return null;
        }
        if(x == p.elem){
            if(p.der != null){
                Nodo q = p.der;
                while (p.izq != null){
                    q = p.izq;
                }
                return q;
            }
        } else if (x < p.elem) {
            Nodo q = inmediatoSup(p.izq, x);
            if (q == null || q.elem <=x)
                return p;
            return q;
        }else {
            return inmediatoSup(p.der, x);
        }
        return null;
    }
//25. A1.inmediatoInf(x) : Método que devuelve el elemento inmediato inferior a x, si x se encuentra en A1, caso contrario devuelve el mismo elemento.
    public int inmediatoInf(int x){
        Nodo p = inmediatoSup(raiz, x);
        return p != null ? p.elem : x;
    }
    private Nodo inmediatoInf(Nodo p, int x){
        if (p == null){
            return null;
        }
        if(x == p.elem){
            if(p.der != null){
                Nodo q = inmediatoInf(p.izq, x);
                while (p.izq != null)
                    q = p.izq;
                return q;
            }
        }else if (x < p.elem) {
            return inmediatoInf(p.izq, x);
        }else {
            Nodo q = inmediatoInf(p.der, x);
            if (q == null || q.elem <=x)
                return p;
            return q;
        }
        return null;
    }

//26.   Implementar al menos 5 Ejercicios adicionales cualesquiera, de consultas sobre uno o más árboles binarios de búsqueda. Citar fuentes.
    //Ejercicio 1
    public boolean hermanos(int x, int y){
        return hermanos(raiz, x, y);
    }

    private boolean hermanos(Nodo p, int x, int y) {
        if (p == null){
            return false;
        }else {
            if (esHoja(p)){
                return false;
            }else {
                boolean ai = hermanos(p.izq, x, y);
                boolean ad = hermanos(p.der, x, y);
                if(ai || ad){
                    return true;
                }else {
                    return (x == p.izq.elem && y == p.der.elem ||
                            x == p.der.elem && y == p.izq.elem);
                }
            }
        }
    }

    //Ejercicio 2
    public int devolverPadre(int x){
        return devolverPadre(raiz, x);
    }
    private int devolverPadre(Nodo p, int x){
        if (p == null){
            System.out.println("No se puede devolver padre");
        }
        if (p.izq != null && p.izq.elem == x ||
            p.der != null && p.der.elem == x){
            return p.elem;
        }
        int ai = devolverPadre(p.izq, x);
        int ad = devolverPadre(p.der, x);
        return (ai != -1) ? ai : ad;
    }

    //Ejercicio 3
    public int altura(){
        return altura(raiz);
    }

    private int altura(Nodo p){
        if (p == null){
            return 0;
        }else {
            if(esHoja(p))
                return 1;
            else {
                int ai = altura(p.izq);
                int ad = altura(p.der);
                if (ai > ad)
                    return ai +1;
                else
                    return ad +1;
            }
        }
    }

    //Ejercicio 4
    public void encontrarAbuelo(int x){
        Nodo p = encontrarAbuelo(raiz,x);
        if(p == null)
            System.out.println("No se puede encontrar abuelo");
        else
            System.out.println(p.elem);
    }

    private Nodo encontrarAbuelo(Nodo p, int x){
        if (p == null){
            return null;
        }else {
            if (altura(p) >= 3){
                if (p.izq != null && esHijo(p.izq, x)){
                    return p;
                }
                if (p.der != null && esHijo(p.der,x)){
                    return p;
                }
            }
            Nodo ai = encontrarAbuelo(p.izq, x);
            Nodo ad = encontrarAbuelo(p.der, x);
            return (ai != null) ? ai : ad;
        }
    }

    //Ejercicio 5
    public boolean esHijo(Nodo p, int x) {
        if (p == null){
            return false;
        }else {
            if (esHoja(p)){
                if (p.izq != null && p.izq.elem == x){
                    return true;
                } else if (p.der != null && p.der.elem == x) {
                    return true;
                }
            }
        }
        return false;
    }

}
