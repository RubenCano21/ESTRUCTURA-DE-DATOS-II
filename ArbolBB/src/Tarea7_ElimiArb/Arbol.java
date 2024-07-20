package Tarea7_ElimiArb;

import java.util.List;

public class Arbol {

    public Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    public void insertar(int x){
        raiz = insertar(x, raiz);
    }

    private Nodo insertar(int x, Nodo p) {
        if (p == null) return new Nodo(x);
        if (x < p.elem)
            p.izq = insertar(x, p.izq);
        else
            p.der = insertar(x, p.der);
        return p;
    }

    public void inOrden(){
        inOrden(raiz);
    }

    private void inOrden(Nodo p) {
        if (p != null){
            inOrden(p.izq);
            System.out.print(p.elem + ", ");
            inOrden(p.der);
        }
    }

//    TRABAJO GRUPAL.

//    A. Eliminar elementos de un Árbol Binario de Búsqueda.
//
//A1.eliminar(x) : Método que elimina el elemento x, del árbol A1.
    public void eliminar(int x){
        raiz = eliminar(x, raiz);
    }

    private Nodo eliminar(int x, Nodo p) {
        if (p == null) return null;
        if (x == p.elem)
            return eliminarNodo(p);
        if(x<p.elem)
            p.izq = eliminar(x, p.izq);
        else
            p.der = eliminar(x, p.der);
        return p;
    }

    private Nodo eliminarNodo(Nodo p) {
        if (p.izq == null && p.der == null)
            return null;
        if (p.izq != null && p.der == null)
            return p.izq;
        if (p.izq == null && p.der != null)
            return p.der;
        Nodo q = p.izq;
        while (q.der != null){
            q = q.der;
        }
        int y = q.elem;
        eliminar(y);
        p.elem = y;
        return p;
    }

//  A1.eliminarHojas() : Método que elimina los nodos hoja de árbol A1.
    public void eliminarHojas(){
        raiz = eliminarHojas(raiz);
    }

    private Nodo eliminarHojas(Nodo p) {
        if (p == null)
            return null;
        if (p.izq == null && p.der == null)
            return null;
        p.izq = eliminarHojas(p.izq);
        p.der = eliminarHojas(p.der);
        return p;
    }
//  A1.eliminarPares() : Método que elimina los elementos pares del árbol A1.
    public void eliminarPares(){
        raiz = eliminarPares(raiz);
    }

    private Nodo eliminarPares(Nodo p) {
        if (p == null) return null;

        p.izq = eliminarPares(p.izq);
        p.der = eliminarPares(p.der);

        if (p.elem % 2 == 0){
            eliminarNodoSup(p);
        }
        return p;
    }

    public void eliminarSup(int x){
        raiz=eliminarSup(x,raiz);
    }

    private Nodo eliminarSup(int x, Nodo p){
        if(p == null)return null;
        if(x == p.elem)return eliminarNodoSup(p);
        if(x < p.elem)p.izq=eliminarSup(x,p.izq);
        else
            p.der = eliminarSup(x, p.der);
        return p;
    }

    private Nodo eliminarNodoSup(Nodo p){
        if(p.izq == null && p.der == null)return null;
        if(p.izq != null && p.der == null)return p.izq;
        if(p.izq == null && p.der != null)return p.der;
        Nodo q = p.der;
        while(q.izq != null)q=q.izq;
        int y = q.elem;
        eliminarSup (y);
        p.elem = y;
        return p;
    }

//  A1.eliminar(L1) : Método que elimina los elementos de la lista L1 que se encuentran en el árbol A1.
    public void eliminar(List<Integer> L1) {
        for (int x : L1) {
            raiz = eliminarElemento(x, raiz);
        }
    }
    private Nodo eliminarElemento(int x, Nodo p) {
        if (p == null) return null;
        if (x == p.elem) return eliminarNodoSup(p);
        if (x < p.elem) p.izq = eliminarElemento(x, p.izq);
        else p.der = eliminarElemento(x, p.der);
        return p;
    }

//  A1.eliminarMenor(): Método que elimina el elemento menor del árbol A1.
    public void eliminarMenor() {
        if (raiz != null) {
            raiz = eliminarMenor(raiz);
        }
    }
    private Nodo eliminarMenor(Nodo p) {
        if (p.izq == null) {
            return p.der;
        }
        p.izq = eliminarMenor(p.izq);
        return p;
    }

//  A1.eliminarMayor(): Método que elimina el elemento mayor del árbol A1.
    public void eliminarMayor() {
        if (raiz != null) {
            raiz = eliminarMayor(raiz);
        }
    }
    private Nodo eliminarMayor(Nodo p) {
        if (p.der == null) {
            return p.izq;
        }
        p.der = eliminarMayor(p.der);
        return p;
    }

//  A1.eliminarNivel( n ) : Método que elimina los nodos del árbol A1 del nivel n.
    public void eliminarNivel(int n) {
        raiz = eliminarNivel(raiz, n, 1);
    }

    private Nodo eliminarNivel(Nodo p, int nivelObj, int nivelAct) {
        if (p == null) {
            return null;
        }
        if (nivelAct == nivelObj) {
            return null; // Eliminar el nodo
        }
        p.izq = eliminarNivel(p.izq, nivelObj, nivelAct + 1);
        p.der = eliminarNivel(p.der, nivelObj, nivelAct + 1);

        return p;
    }

//  A1.eliminarRaices() : Método que elimina los nodos raíces del árbol A1.
    public void eliminarRaices() {
        raiz = eliminarRaices(raiz);
    }

    private Nodo eliminarRaices(Nodo p) {
        if (p == null) {
            return null;
        }
        if (p.izq != null || p.der != null) {
            eliminarNodo(p);
        }
        p.izq = eliminarRaices(p.izq);
        p.der = eliminarRaices(p.der);

        return p;
    }

//    Proponer e implementar al menos 5 ejercicios adicionales interesantes. En lo posible citar fuente.

//            CONSULTAS.
//
//            L1.arbolPequeño() : Método que devuelve el Árbol de menos cantidad de elementos.
//            L1.arbolGrande() : Método que devuelve el Árbol de mayor cantidad de elementos.
//            L1.igualTamaño() : Método lógico que devuelve True, si todos los Arboles tiene la misma cantidad de elementos.
//            L1.arbolAsc() : Método Lógico que devuelve True, si los árboles crecen secuencialmente por cantidad de elementos.
//            L1.arbolMayorAltura() : Método que devuelve el arbol de mayor altura.
//    Proponer e implementar al menos 5 ejercicios adicionales interesantes. En lo posible citar fuente.
}
