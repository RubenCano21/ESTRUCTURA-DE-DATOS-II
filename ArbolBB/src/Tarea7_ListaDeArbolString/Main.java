package Tarea7_ListaDeArbolString;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ListaArbol ListArb = new ListaArbol();

        // Crear y agregar árboles a la lista
        Arbol A1 = new Arbol();
        A1.insertar("casa");
        A1.insertar("perro");
        A1.insertar("gato");

        Arbol A2 = new Arbol();
        A2.insertar("árbol");
        A2.insertar("flor");
        A2.insertar("hierba");

        ListArb.agregarArbol(A1);
        ListArb.agregarArbol(A2);

//        // Imprimir todos los árboles antes de eliminar palabras
//        System.out.println("Árboles antes de eliminar palabras:");
//        ListArb.imprimirTodos();
//
//        // Lista de palabras a eliminar
//        List<String> L2 = List.of("perro", "flor");
//
//        // Eliminar palabras de los árboles
//        ListArb.eliminar(L2);

        // Imprimir todos los árboles después de eliminar palabras
        System.out.println("Árboles después de eliminar palabras:");
        ListArb.imprimirTodos();

        ListArb.eliminarNodosRaices();
        ListArb.imprimirTodos();
        ListArb.eliminarNodosTerm();
        ListArb.imprimirTodos();

        System.out.println("Altura total: " + ListArb.alturaTotal());
        System.out.println("Número total de nodos: " + ListArb.contarNodosTotal());
        System.out.println("Todos son completos: " + ListArb.todosSonCompletos());
        System.out.println("Valor mínimo global: " + ListArb.encontrarMinGlobal());
        System.out.println("Valor máximo global: " + ListArb.encontrarMaxGlobal());
        System.out.println("Suma total de nodos: " + ListArb.sumaNodosTotal());

    }
}
