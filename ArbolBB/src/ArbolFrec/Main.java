package ArbolFrec;

public class Main {

    public static void main(String[] args) {

        Arbol A1 = new Arbol();

        A1.insertar(60);
        A1.insertar(20);
        A1.insertar(80);
        A1.insertar(70);
        A1.insertar(90);
        A1.insertar(20);
        A1.insertar(40);
        A1.insertar(60);
        A1.insertar(55);
        A1.insertar(70);
        A1.insertar(90);
        A1.insertar(20);
        A1.insertar(80);

       // System.out.println(A1.toString());
        A1.frecuencia();
        A1.generar(10, 5,15);
        System.out.println("-----------------");
        System.out.println(A1.toString());

        A1.insertarAleatorio(10, 5,15);
        //A1.inOrden();
        System.out.println("----Arbol 2-----");
        Arbol A2 = A1.crearArbolBBPorFrec();

        A2.mostrarMayMen();
    }
}
