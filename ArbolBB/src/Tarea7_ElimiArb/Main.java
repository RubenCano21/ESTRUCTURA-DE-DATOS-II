package Tarea7_ElimiArb;

public class Main {

    public static void main(String[] args) {

        Arbol A = new Arbol();

        A.insertar(1);
        A.insertar(4);
        A.insertar(3);
        A.insertar(5);
        A.insertar(7);
        A.insertar(9);
        A.insertar(2);

        A.inOrden();
        System.out.println();
        A.eliminarHojas();
        A.inOrden();
        System.out.println();
        A.eliminarPares();
        A.inOrden();
    }
}
