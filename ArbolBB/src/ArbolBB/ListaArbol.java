package ArbolBB;

public class ListaArbol {
    public int cantElem;
    public int max;
    public Arbol arbol[];

    private Nodo raiz;

    public ListaArbol() {
        this.max = this.cantElem = 10;
        arbol = new Arbol[10];
        for (int i = 0; i < 10; i++) {
            arbol[i] = new Arbol();
        }
    }

    public void generar(int n, int a, int b){
        for (int i = 1; i <= n; i++) {
            int r = (int)(a+ (b-a)*Math.random());
            arbol[r % 10].insertar(r);
        }
    }

    public void mostrar(){
        for (int i = 0; i < 10; i++) {
            arbol[i].inOrden1();
            System.out.println();
        }
    }

    private class Nodo {
        int valor;
        Nodo izq;
        Nodo der;

        Nodo(int valor) {
            this.valor = valor;
            izq = null;
            der = null;
        }
    }


    public void mostrar1() {
        for (int i = 0; i < 10; i++) {
            arbol[i].inOrden();
            System.out.println();
        }
    }

    // aqui mas ejercicios
    public void mostrarMayMen(){
        for (int i = 0; i < 10; i++) {
            arbol[i].desc();
            System.out.println();
        }
    }
    public void mostrarMayMenDig(){
        for (int i = 9; i >= 0; i--) {
            arbol[i].inOrden();
            System.out.println();
        }
    }

    public void mostrarMayMenTodo(){
        for (int i = 9; i >= 0; i--) {
            arbol[i].desc();
            System.out.println();
        }
    }
    public void mostrarImpares(){
        for(int i = 0; i < 10; i++){
            arbol[i].inOrdenImpares();
            System.out.println();
        }
    }

    public void mostrarPrimos(){
        for(int i = 0; i < 10; i++){
            arbol[i].inOrdenPrimos();
            System.out.println();
        }
    }





}
