package Tarea7_ListaDeArbolString;

public class Arbol {

    public Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    public void insertar(String valor) {
        raiz = insertarRec(raiz, valor);
    }

    private Nodo insertarRec(Nodo p, String valor) {
        if (p == null) {
            p = new Nodo(valor);
            return p;
        }

        if (valor.compareTo(p.valor) < 0) {
            p.izq = insertarRec(p.izq, valor);
        } else if (valor.compareTo(p.valor) > 0) {
            p.der = insertarRec(p.der, valor);
        }

        return p;
    }

    // Método para eliminar nodos con un valor específico
    void eliminar(String valor) {
        raiz = eliminarRec(raiz, valor);
    }

    private Nodo eliminarRec(Nodo raiz, String valor) {
        if (raiz == null) {
            return raiz;
        }

        if (valor.compareTo(raiz.valor) < 0) {
            raiz.izq = eliminarRec(raiz.izq, valor);
        } else if (valor.compareTo(raiz.valor) > 0) {
            raiz.der = eliminarRec(raiz.der, valor);
        } else {
            if (raiz.izq == null) {
                return raiz.der;
            } else if (raiz.der == null) {
                return raiz.izq;
            }

            raiz.valor = encontrarMin(raiz.der).valor;
            raiz.der = eliminarRec(raiz.der, raiz.valor);
        }

        return raiz;
    }

    private Nodo encontrarMin(Nodo raiz) {
        Nodo min = raiz;
        while (min.izq != null) {
            min = min.izq;
        }
        return min;
    }

    // Método para imprimir el árbol en orden (para pruebas)
    public void inOrder() {
        inOrderRec(raiz);
        System.out.println();
    }

    private void inOrderRec(Nodo raiz) {
        if (raiz != null) {
            inOrderRec(raiz.izq);
            System.out.print(raiz.valor + " ");
            inOrderRec(raiz.der);
        }
    }

    public void eliminarRaiz() {
        if (raiz != null) {
            raiz = eliminarRec(raiz, raiz.valor);
        }
    }

    // Método para eliminar nodos terminales
    public void eliminarNodosTerm() {
        raiz = eliminarNodosTermRec(raiz);
    }

    private Nodo eliminarNodosTermRec(Nodo root) {
        if (root == null) {
            return null;
        }
        // Si es un nodo terminal, lo eliminamos
        if (root.izq == null && root.der == null) {
            return null;
        }
        // Continuar la búsqueda en los subárboles
        root.izq = eliminarNodosTermRec(root.izq);
        root.der = eliminarNodosTermRec(root.der);
        return root;
    }


    //    B. Sobre una Lista de ABB de Strings de misma longitud.
//
//            L1.eliminar(L2): Método que elimina las palabras que aparecen en la Lista de palabras L2, de los árboles
//            de Lista de árboles L1. L2, puede contener por ejemplo artículos or preposiciones or conectivos, etc.

//            L1.eliminarNodosRaices() : Método que elimina los nodos principales raíz, de cada Arbol.

//            L1.eliminarNodosTerm() : Método que elimina los nodos terminales de cada Arbol de L1.
//    Proponer e implementar al menos 5 ejercicios adicionales interesantes. En lo posible citar fuente.
//
    //Ejercicio 1: Encontrar la altura del árbol binario de búsqueda
    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(Nodo p) {
        if (p == null) {
            return 0;
        }
        int izquierdaAltura = alturaRec(p.izq);
        int derechaAltura = alturaRec(p.der);

        return Math.max(izquierdaAltura, derechaAltura) + 1;
    }

    //Ejercicio 2: Contar el número de nodos en el árbol
    public int contarNodos() {
        return contarNodosRec(raiz);
    }

    private int contarNodosRec(Nodo p) {
        if (p == null) {
            return 0;
        }
        return 1 + contarNodosRec(p.izq) + contarNodosRec(p.der);
    }

    //Ejercicio 3: Determinar si el árbol es un árbol completo
    public boolean esCompleto() {
        int numNodos = contarNodos();
        return esCompletoRec(raiz, 0, numNodos);
    }

    private boolean esCompletoRec(Nodo p, int indice, int numNodos) {
        if (p == null) {
            return true;
        }
        if (indice >= numNodos) {
            return false;
        }
        return esCompletoRec(p.izq, 2 * indice + 1, numNodos) &&
                esCompletoRec(p.der, 2 * indice + 2, numNodos);
    }

    //Ejercicio 4: Encontrar el valor máximo y mínimo en el árbol
    public String encontrarMin() {
        if (raiz == null) {
            return null;
        }
        return encontrarMinRec(raiz).valor;
    }

    private Nodo encontrarMinRec(Nodo root) {
        if (root.izq == null) {
            return root;
        }
        return encontrarMinRec(root.izq);
    }

    public String encontrarMax() {
        if (raiz == null) {
            return null;
        }
        return encontrarMaxRec(raiz).valor;
    }

    private Nodo encontrarMaxRec(Nodo raiz) {
        if (raiz.der == null) {
            return raiz;
        }
        return encontrarMaxRec(raiz.der);
    }

    //Ejercicio 5: Calcular la suma de todos los nodos en el árbol
    public int sumaNodos() {
        return sumaNodosRec(raiz);
    }

    private int sumaNodosRec(Nodo p) {
        if (p == null) {
            return 0;
        }
        try {
            int valorNodo = Integer.parseInt(p.valor);
            return valorNodo + sumaNodosRec(p.izq) + sumaNodosRec(p.der);
        } catch (NumberFormatException e) {
            // Si el valor no es un número, no lo sumamos
            return sumaNodosRec(p.izq) + sumaNodosRec(p.der);
        }
    }


}
