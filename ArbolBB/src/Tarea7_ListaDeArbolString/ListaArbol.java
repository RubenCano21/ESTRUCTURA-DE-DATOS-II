package Tarea7_ListaDeArbolString;

import java.util.ArrayList;
import java.util.List;

public class ListaArbol {

    List<Arbol> listaDeArboles;

    ListaArbol() {
        listaDeArboles = new ArrayList<>();
    }

    public void agregarArbol(Arbol arbol) {
        listaDeArboles.add(arbol);
    }

    public void eliminar(List<String> L2) {
        for (String palabra : L2) {
            for (Arbol arbol : listaDeArboles) {
                arbol.eliminar(palabra);
            }
        }
    }

    // Método para imprimir todos los árboles en orden (para pruebas)
    public void imprimirTodos() {
        for (Arbol arbol : listaDeArboles) {
            arbol.inOrder();
        }
    }

    public void eliminarNodosRaices() {
        for (Arbol arbol : listaDeArboles) {
            arbol.eliminarRaiz();
        }
    }

    public void eliminarNodosTerm() {
        for (Arbol arbol : listaDeArboles) {
            arbol.eliminarNodosTerm();
        }
    }

    // Métodos adicionales para aplicar a todos los árboles en la lista
    public int alturaTotal() {
        int total = 0;
        for (Arbol arbol : listaDeArboles) {
            total += arbol.altura();
        }
        return total;
    }

    public int contarNodosTotal() {
        int total = 0;
        for (Arbol arbol : listaDeArboles) {
            total += arbol.contarNodos();
        }
        return total;
    }

    public boolean todosSonCompletos() {
        for (Arbol arbol : listaDeArboles) {
            if (!arbol.esCompleto()) {
                return false;
            }
        }
        return true;
    }

    public String encontrarMinGlobal() {
        String minGlobal = null;
        for (Arbol arbol : listaDeArboles) {
            String min = arbol.encontrarMin();
            if (minGlobal == null || (min != null && min.compareTo(minGlobal) < 0)) {
                minGlobal = min;
            }
        }
        return minGlobal;
    }

    public String encontrarMaxGlobal() {
        String maxGlobal = null;
        for (Arbol arbol : listaDeArboles) {
            String max = arbol.encontrarMax();
            if (maxGlobal == null || (max != null && max.compareTo(maxGlobal) > 0)) {
                maxGlobal = max;
            }
        }
        return maxGlobal;
    }

    public int sumaNodosTotal() {
        int total = 0;
        for (Arbol arbol : listaDeArboles) {
            total += arbol.sumaNodos();
        }
        return total;
    }

}
