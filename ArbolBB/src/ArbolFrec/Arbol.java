package ArbolFrec;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arbol {

    public Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    public Arbol (Arbol A1){
        raiz = copiar(A1.raiz);
    }

    private Nodo copiar(Nodo p) {
        if (p == null) {return null;}
        Nodo q = new Nodo(p.elem, p.frec);
        p.izq = copiar(p.izq);
        p.der = copiar(p.der);
        return q;
    }


    public void insertar(int x) {
        raiz = insertar(raiz, x);
    }

    private Nodo insertar(Nodo p, int x) {
        if (p == null){
            return new Nodo(x);
        } else if (p.elem == x) {
            p.frec++;
        } else if (x < p.elem) {
            p.izq = insertar(p.izq, x);
        }else {
            p.der = insertar(p.der, x);
        }
        return p;
    }

    public void frecuencia(){
        frecuencia(raiz);
    }

    private void frecuencia(Nodo p) {
        if (p == null) {return;}
        System.out.println(p.elem +"|"+ p.frec);
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

    public void generar(int n, int a, int b) {
        for (int i = 1; i <= n; i++) {
            int r = (int)(a + (b - a) * Math.random());
            insertar(r);
        }
    }

    public void insertarAleatorio(int n, int a, int b) {
        Random r = new Random();
        for (int i = 1; i <= n; i++) {
            int num = r.nextInt((b - a) + 1) + a;
            insertar(num);
        }
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
        System.out.println(p.elem + "|" + p.frec);
        mostrarMenMay(p.der);
    }

    public void mostrarMayMen(){
        mostrarMayMen(raiz);
    }

    private void mostrarMayMen(Nodo p) {
        if (p == null) {return;}
        mostrarMayMen(p.der);
        System.out.println(p.elem + "|" + p.frec);
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


}
