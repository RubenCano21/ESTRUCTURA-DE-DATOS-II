package arbolString;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Arbol {

    public Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    public Arbol(Arbol A1){
        raiz = copiar(A1.raiz);
    }

    private Nodo copiar(Nodo p) {
        if (p == null) {return null;}
        Nodo q = new Nodo(p.elem, p.frec);
        p.izq = copiar(p.izq);
        p.der = copiar(p.der);
        return q;
    }


    public void insertar(String s1) {
        raiz = insertar(raiz, s1.trim());
    }

    private Nodo insertar(Nodo p, String s1) {
        if (p == null){
            return new Nodo(s1);
        } else if (p.elem.equals(s1)) {
            p.frec++;
        } else if (s1.compareTo(p.elem) < 0) {
            p.izq = insertar(p.izq, s1);
        }else {
            p.der = insertar(p.der, s1);
        }
        return p;
    }


    public void frecuencia(){
        frecuencia(raiz);
    }

    private void frecuencia(Nodo p) {
        if (p == null) {return;}
        System.out.println(p.elem +" \t| "+ p.frec);
        frecuencia(p.izq);
        frecuencia(p.der);
    }

    @Override
    public String toString(){
        Nodo p = raiz;
        List<String> list = new ArrayList<>();
        while (p != null) {
            if (p.izq != null) {
                list.add(p.elem + "|" + p.frec);
                p = p.izq;
            }else {
                list.add(p.elem + "|" + p.frec);
                p = p.der;
            }
        }
        return list.toString();
    }

    public void inOrden1() {
        inOrden1(raiz);
    }

    private void inOrden1(Nodo nodo) {
        if (nodo != null) {
            inOrden1(nodo.izq);
            System.out.print(nodo.elem + " ");
            inOrden1(nodo.der);
        }
    }

    public void mostrarMenMay(){
        mostrarMenMay(raiz);
    }

    private void mostrarMenMay(Nodo p) {
        if (p == null) {return;}
        mostrarMenMay(p.izq);
        System.out.println(p.elem + " \t|  " + p.frec);
        mostrarMenMay(p.der);
    }

    public void mostrarMayMen(){
        mostrarMayMen(raiz);
    }

    private void mostrarMayMen(Nodo p) {
        if (p == null) {return;}
        mostrarMayMen(p.der);
        System.out.println(p.elem + " \t| " + p.frec);
        mostrarMayMen(p.izq);
    }

    public Arbol crearArbolBBPorFrec(){
        ListaArray lista = new ListaArray();
        llenarLista(raiz, lista);

        Arbol arbol = new Arbol();
        for (int i = 0; i < lista.cantElem; i++) {
            for (int j = 0; j < lista.frec[i]; j++) {
                arbol.insertar(lista.elem[i]);
            }
        }
        return arbol;
    }

    private void llenarLista(Nodo p, ListaArray lista) {
        if (p == null) {return;}
        llenarLista(p.izq, lista);
        lista.insertarOrdenado(p.elem, p.frec);
        llenarLista(p.der, lista);
    }

    public void iguales(String s1, String s2) {
        iguales(raiz, s1.trim(), s2.trim());
    }

    private void iguales(Nodo p, String s1, String s2) {
        if (p != null){
            StringTokenizer st1 = new StringTokenizer(s1, " ,.");
            StringTokenizer st2 = new StringTokenizer(s2, " ,.");
            while (st1.hasMoreTokens() && st2.hasMoreTokens()) {
                String p1 = st1.nextToken();
                String p2 = st2.nextToken();
                if (p1.compareTo(p2) ==0) {
                    System.out.println(p1 + " \t| " + p.frec);
                }
            }
        }
    }


}
