package ArbolBB;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arbol {

    public Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    //1. A1.insertar(x) : Método que inserta el elemento x, en el árbol A1 en su lugar correspondiente.
    public void insertar(int x){
        raiz = insertar(x, raiz);
    }

    private Nodo insertar(int x, Nodo p){
        if(p == null) return new Nodo(x);
        if(x < p.elem){
            p.izq = insertar(x, p.izq);
        }else {
            p.der = insertar(x, p.der);
        }
        return p;
    }
    //2. A1.preOrden() : Método que muestra los elementos del árbol A1 en preOrden.
    public void preOrden(){
        preOrden(raiz);
    }

    private void preOrden(Nodo p){
        if(p == null)
            return;
        System.out.print( p.elem+",\t");
        preOrden(p.izq);
        preOrden(p.der);
    }
    //3. A1.inOrden() : Método que muestra los elementos del árbol A1 en inOrden.
    public void inOrden(){
        inOrden(raiz);
    }

    private void inOrden(Nodo p){
        if(p == null)
            return;
        inOrden(p.izq);
        System.out.print(p.elem+",\t");
        inOrden(p.der);
    }
    //4. A1.postOrden() : Método que muestra los elementos del árbol A1 en postOrden.
    public void postOrden(){
        postOrden(raiz);
    }

    private void postOrden(Nodo p){
        if (p == null)
            return;
        postOrden(p.izq);
        postOrden(p.der);
        System.out.print(p.elem+",\t");
    }

    //5. A1.seEncuentra(x) : Métodos lógico que devuelve True, si el elemento x, se encuentra en el árbol A1.
    public boolean seEncuentra(int x){
        return seEncuentra(x,raiz);
    }

    private boolean seEncuentra(int x, Nodo p) {
        if(p == null)
            return false;
        if (x == p.elem)
            return true;
        if(x < p.elem)
            return seEncuentra(x, p.izq);
        else
            return seEncuentra(x, p.der);
    }
    //6. A1.cantidad() : Método que devuelve la cantidad de nodos del árbol A1.
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
    //7. A1.suma() : Método que devuelve la suma de los elementos del árbol A1.
    public int suma(){
        return suma(raiz);
    }

    private int suma(Nodo p){
        if (p == null)
            return 0;
        else
            return suma(p.izq) + suma(p.der) + p.elem;
    }
    //8. A1.menor() : Método que devuelve el elemento menor del árbol A1.
    public int  menor(){
        return menor(raiz);
    }

    private int menor(Nodo p){
        if (p.izq == null)
            return p.elem;
        else
            return menor(p.izq);
    }
    //9. A1.mayor() : Método que devuelve el elemento mayor del árbol A1.
    public int mayor(){
        return mayor(raiz);
    }

    private int mayor(Nodo p){
        if(p.der == null)
            return p.elem;
        else {
            return mayor(p.der);
        }
    }
    //10. A1.cantidadTerm() : Método que devuelve la cantidad de nodos terminales del árbol A1.
    public int cantidadTerm(){
        return cantidadTerm(raiz);
    }

    private int cantidadTerm(Nodo p){
        if (p == null)
            return 0;
        if (p.izq == null && p.der == null)
            return 1;
        return cantidadTerm(p.izq) + cantidadTerm(p.der);
    }
    //11. A1.sumaPares() : Método que devuelve la suma de los elementos pares  del árbol A1.
    public int sumaPares(){
        return sumaPares(raiz);
    }

    private int sumaPares(Nodo p){
        if (p == null)
            return 0;
        int suma = 0;
        if (p.elem % 2 == 0){
            suma += p.elem;
        }
        suma += sumaPares(p.izq);
        suma += sumaPares(p.der);
        return suma;
    }

    //******************************************************************************
    //***************TAREA-1. ARBOLES BINARIOS DE BÚSQUEDA**************************
    //******************************************************************************

//1.  A1.generarElem(n, a, b) : Método que genera n elementos aleatorios enteros diferentes entre a y b inclusive.
    public List<Integer> generarElem(int n, int a, int b) {
        if (n <= 0 || a > b) {
            throw new IllegalArgumentException("Parámetros inválidos");
        }
        Random rand = new Random();
        ArrayList<Integer> elementosGenerados = new ArrayList<>();

        while (elementosGenerados.size() <= n) {
            int numeroAleatorio = rand.nextInt(b - a + 1) + a;
            if (!elementosGenerados.contains(numeroAleatorio)) {
                elementosGenerados.add(numeroAleatorio);
            }
        }
        return elementosGenerados;
    }

//2.  A1.insertar(x) : Método que inserta el elemento x, en el árbol A1 en su lugar correspondiente.
    public void insertarX(int x){
        Nodo q = new Nodo(x);
        if (raiz == null){
            raiz = q;
            return;
        }
        Nodo p = raiz;
        Nodo ap = null;
        while (p != null){
            ap = p;
            if (x < p.elem){
                p = p.izq;
            }else {
                if (x > p.elem){
                    p = p.der;
                }else {
                    return;
                }
            }
        }
        if (x < ap.elem){
            ap.izq = q;
        }else {
            ap.der = q;
        }
    }
//3.  A1.preOrden() : Método que muestra los elementos del árbol A1 en preOrden.
    public void PreOrden(){
        PreOrden(raiz);
    }
    public void PreOrden(Nodo p){
        if (p != null){
            System.out.print(p.elem+",\t");
            PreOrden(p.izq);
            PreOrden(p.der);
        }
    }

//4.  A1.inOrden() : Método que muestra los elementos del árbol A1 en inOrden.
    public void InOrden(){
        InOrden(raiz);
    }

    public void InOrden(Nodo p){
        if (p != null){
            InOrden(p.izq);
            System.out.print(p.elem+",\t");
            InOrden(p.der);
        }
    }

//5.  A1.postOrden() : Método que muestra los elementos del árbol A1 en postOrden.
    public void PostOrden(){
        PostOrden(raiz);
    }

    public void PostOrden(Nodo p){
        if (p != null){
            PostOrden(p.izq);
            PostOrden(p.der);
            System.out.print(p.elem+",\t");
        }
    }

//6.  A1.desc(): Método que muestra los elementos del árbol A1 de mayor a menor.
    public void desc(){
        desc(raiz);
    }

    public void desc(Nodo p){
        if (p != null){
            desc(p.der);
            System.out.print(p.elem+",\t");
            desc(p.izq);
        }
    }
//7.  A1.seEncuentra(x) : Métodos lógico que devuelve True, si el elemento x, se encuentra en el árbol A1.
    public boolean SeEncuentra(int x){
        return SeEncuentra(raiz,x);
    }

    private boolean SeEncuentra(Nodo p, int x){
        if (p == null){
            return false;
        }else {
            if (p.elem == x){
                return true;
            }else {
                boolean ai= SeEncuentra(p.izq,x);
                boolean ad= SeEncuentra(p.der,x);
                return ai || ad || x == p.elem;
            }
        }
    }
//8.  A1.cantidad() : Método que devuelve la cantidad de nodos del árbol A1.
    public int Cantidad(){
        return Cantidad(raiz);
    }

    private int Cantidad(Nodo p){
        if (p == null){
            return 0;
        } else {
            if(esHoja(p))
                return 1;
            else {
                int ai = Cantidad(p.izq);
                int ad = Cantidad(p.der);
                return ai + ad +1;
            }
        }
    }
//9.  A1.suma() : Método que devuelve la suma de los elementos del árbol A1.
    public int Suma(){
        return Suma(raiz);
    }

    private int Suma(Nodo p){
        if (p == null){
            return 0;
        }else {
            int suma = 0;
            suma += Suma(p.izq);
            suma += Suma(p.der);
            return suma + p.elem;
        }
    }
//10.  A1.menor() : Método que devuelve el elemento menor del árbol A1.
    public int Menor(){
        return Menor(raiz);
    }

    private int Menor(Nodo p){
            if (p.izq == null)
                return p.elem;
            else {
                return Menor(p.izq);
            }

    }
//11.  A1.mayor() : Método que devuelve el elemento mayor del árbol A1.
    public int Mayor(){
        return Mayor(raiz);
    }

    private int Mayor(Nodo p){
        if (p.der == null){
            return p.elem;
        }else{
            return Mayor(p.der);
        }
    }

//12.  A1.mostrarTerm(): Método que muestra los elementos de los nodos terminales del árbol A1. Mostrar los elementos de menor a mayor.
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
//13.  A1.cantidadTerm(): Método que devuelve la cantidad de nodos terminales del árbol A1.
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
//14.  A1.lineal() : Método lógico que devuelve True, si el árbol A1 es un árbol degenerado o lIneal.
//     (Se puede dar cuando se genera el árbol con una secuencia ordenada de elementos)
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
        if(p.izq != null){
            return lineal(p.izq);
        }else {
            return lineal(p.der);
        }
    }
//15. A1.inmediatoSup(x) : Método que devuelve el elemento inmediato superior a x, si x se encuentra en A1, caso contrario devuelve el mismo elemento.
    public int inmediatoSup(int x){
        return inmediatoSup(raiz, x, Integer.MAX_VALUE);
    }

    private int inmediatoSup(Nodo p, int x, int sucesor){
        if (p == null){
            return sucesor;
        }
        if(x == p.elem){
            if(p.der != null){
                Nodo q = p.der;
                while (q.izq != null){
                    q = q.izq;
                }
                return q.elem;
            }
        }
        if(p.elem > x){
            return inmediatoSup(p.izq, x, p.elem);
        }else {
            return inmediatoSup(p.der, x, sucesor);
        }
    }
//16. A1.inmediatoInf(x) : Método que devuelve el elemento inmediato inferior a x, si x se encuentra en A1, caso contrario devuelve el mismo elemento.
    public int inmediatoInf(int x){
        return inmediatoInf(raiz, x, Integer.MIN_VALUE);
    }

    private int inmediatoInf(Nodo p, int x, int predecesor){
        if (p == null){
            return predecesor;
        }
        if(x == p.elem){
            if(p.izq != null){
                Nodo q = p.izq;
                while (q.der != null){
                    q = q.der;
                }
                return q.elem;
            }
        }
        if(p.elem < x){
            return inmediatoInf(p.der, x, p.elem);
        }else {
            return inmediatoInf(p.izq, x, predecesor);
        }
    }
//17.  Implementar al menos 5 Ejercicios adicionales cualesquiera, de consultas sobre uno o más árboles binarios de búsqueda. Citar fuentes.
    private boolean esHoja(Nodo p){
        return (p.izq == null && p.der == null);
    }
// Ejercicio 1: A1.altura() : Metodo que muestra la altura de un arbol
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

// Ejercicio 2: A1.iguales(A2): Metodo que devulve true si los arboles son iguales
    public boolean iguales(Arbol A1){
        return iguales(raiz, A1.raiz);
    }

    private boolean iguales(Nodo p1, Nodo p2){
        if (p1 == null && p2 == null)
            return true;
        if (p1 == null || p2 == null)
            return false;
        return p1.elem == p2.elem
                && iguales(p1.izq, p2.izq)
                && iguales(p1.der, p2.der);
    }

// Ejercicio 3: A1.mostrarNivel(n): metodo que muestra todos los elementos del nivel n
    public void mostrarNivel(int n){
        if (n >= 1 && n <= altura(raiz))
            mostrarNivel(raiz, n);
        else
            System.out.println("El nivel no es valido");
    }
    private void mostrarNivel(Nodo p, int n){
        if (p == null){
            return;
        }else {
            if(n == 1)
                System.out.print(p.elem+ ", ");
            else {
                mostrarNivel(p.der, n-1);
                mostrarNivel(p.izq, n-1);
            }
        }
    }

//Ejercicio 4: A1.mostrarDesdeNivel(n): metodo que muestra los elem desde el nivel n
    public void mostrarDesdeNivel(int n){
        if (n >= 1 && n <= altura(raiz))
            mostrarDesdeNivel(raiz, n, 1);
        else
            System.out.println("El nivel no es valido");
    }

    private void mostrarDesdeNivel(Nodo p, int n, int na){
        if (p == null){
            return;
        } else {
            if (na >= n){
                System.out.print(p.elem + ", ");
            }else {
                mostrarDesdeNivel(p.izq, n, na+1);
                mostrarDesdeNivel(p.der, n, na+1);
            }
        }
    }

// Ejercicio 5: A1.buscarNodo(p,x)
    public Nodo buscarNodo(Nodo p, int x){
        if (p == null || x == p.elem){
            return p;
        }
        if (x < p.elem){
            return buscarNodo(p.izq, x);
        }
        return buscarNodo(p.der, x);
    }

    public void insertarOrdenado(int valor) {
        raiz = insertarOrdenadoRec(raiz, valor);
    }

    private Nodo insertarOrdenadoRec(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }

        if (valor < nodo.elem) {
            nodo.izq = insertarOrdenadoRec(nodo.izq, valor);
        } else if (valor > nodo.elem) {
            nodo.der = insertarOrdenadoRec(nodo.der, valor);
        }

        return nodo;
    }

    public void inOrden1() {
        inOrdenRec(raiz);
    }

    private void inOrdenRec(Nodo nodo) {
        if (nodo != null) {
            inOrdenRec(nodo.izq);
            System.out.print(nodo.elem + " ");
            inOrdenRec(nodo.der);
        }
    }

    public void inOrdenImpares() {
        inOrdenImpares(raiz);
    }

    private void inOrdenImpares(Nodo p) {
        if (p == null) return;
        inOrdenImpares(p.izq);
        if (p.elem % 2 != 0) {
            System.out.println(p.elem);
        }
        inOrdenImpares(p.der);
    }
    public void inOrdenPrimos() {
        inOrdenPrimos(raiz);
    }

    private void inOrdenPrimos(Nodo p) {
        if (p == null) return;
        inOrdenImpares(p.izq);
        if (esPrimo(p.elem)) {
            System.out.println(p.elem);
        }
        inOrdenPrimos(p.der);
    }

    private boolean esPrimo(int x) {
        if (x <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

//A1.generarElem(n, a, b) : Método que genera n elementos aleatorios enteros diferentes entre a y b inclusive.

//2.A1.insertar(x) : Método que inserta el elemento x, en el árbol A1 en su lugar correspondiente.

//3.A1.preOrden() : Método que muestra los elementos del árbol A1 en preOrden.

//4. A1.inOrden() : Método que muestra los elementos del árbol A1 en inOrden.

// 5. A1.postOrden() : Método que muestra los elementos del árbol A1 en postOrden.

//6.A1.niveles(): Método que muestra los elementos del árbol A1, por niveles.

//7.A1.desc(): Método que muestra los elementos del árbol A1 de mayor a menor.

// 8.A1.seEncuentra(x) : Métodos lógico que devuelve True, si el elemento x, se encuentra en el árbol A1.

//9.A1.cantidad() : Método que devuelve la cantidad de nodos del árbol A1.

//10.   A1.suma() : Método que devuelve la suma de los elementos del árbol A1.

//11.   A1.menor() : Método que devuelve el elemento menor del árbol A1.

//12.   A1.mayor() : Método que devuelve el elemento mayor del árbol A1.
}




