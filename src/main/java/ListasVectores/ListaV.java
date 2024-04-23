package ListasVectores;

import java.util.ArrayList;
import java.util.Arrays;

public class ListaV {

    private static final int MAX = 50;
    private final int[] v;
    private int cantElem;

    public ListaV(){
        this.cantElem =0;
        v = new int[50];
    }

    public String toString(){
        String s1 = "[";
        for (int i = 1; i <= this.cantElem; i++) {
            s1 += v[i] + ", ";
        }
        s1 = s1.substring(0, s1.length() -2);
        return s1 + "]";
    }

    //  LAB-1. LISTAS EN ARREGLO

    //     L1.insertarIesimo(x, i) : Método que inserta el elemento x, en la posición i, de la lista L1.
     public void insertarIesimo(int x, int i){
        int k = this.cantElem;
        while (k >= i){
            this.v[k+1] = this.v[k];
            k--;
        }
        v[i] = x;
        cantElem++;
     }

    // 2. L1.insertarPrim(x) : Método que insertar el elemento x, al inicio de la lista L1.
    public void insertarPrim(int x){
        insertarIesimo(x,0);
    }

    public void insertarPrim1(int x){
        if (cantElem == 0) {
            this.v[1] = x;
            cantElem++;
        } else {
            // Mover los elementos existentes una posición hacia adelante
            for (int i = cantElem; i >= 1; i--) {
                this.v[i + 1] = this.v[i];
            }
            // Insertar el nuevo elemento en la posición 1
            this.v[1] = x;
            cantElem++;
        }
    }

    // 3. L1.insertarUlt(x) : Método que inserta el elemento x, al final de la lista L1.
    public void insertarUlt(int x){
        this.cantElem++;
        this.v[cantElem] = x;
    }

    public void insertarUlt1(int x){
        insertarIesimo(x, cantElem +1);
    }
    // 4. L1.eliminarIesimo(i) : Método que elimina el elemento de la posición i.
    public void eliminarIesimo(int i){
        for (int j = i; j < this.cantElem; j++) {
            v[j] = v[j+1];
        }
        this.cantElem--;
    }
    // 5. L1.eliminarPrim() : Método que elimina el elemento de la primer posición.
    public void eliminarPrim(){
        eliminarIesimo(0);
    }

    public void eliminarPrim1() {
        if (cantElem > 0) {
            // Mover los elementos restantes una posición hacia atrás
            for (int i = 1; i < cantElem; i++) {
                this.v[i] = this.v[i + 1];
            }
            // Establecer el último elemento como null (o 0 si es un array primitivo)
            this.v[cantElem] = 0; // Si v es un array de objetos
            // Decrementar el contador de elementos
            cantElem--;
        }
    }

    // 6. L1.eliminarUlt() : Método que elimina el último elemento de la lista L1.
    public void eliminarUlt(){
        eliminarIesimo(cantElem);
    }

    public void eliminarUlt1(){
        if (cantElem > 0){
            this.v[cantElem] = 0;
            cantElem--;
        }
    }
    // 8. L1.eliminarTodo( x ) : Método que elimina todos los elementos x de la lista L1.
    public void eliminarTodo(int x) {
        int i = 1;
        while (i <= cantElem) {
            if (this.v[i] == x) {
                for (int j = i; j < cantElem; j++) {
                    this.v[j] = this.v[j + 1];
                }
                this.v[cantElem] = 0;
                cantElem--;
            } else {
                // Avanzar al siguiente elemento
                i++;
            }
        }
    }

    // 8. L1.eliminarPares() : Método que elimina los elementos pares de la lista L1. Verificar en listas dónde todos los elementos sean pares.
    public void eliminarPares(){
        int k =1;
        while (k <= cantElem){
            if (this.v[k] % 2 == 0){
                for (int i = k; i < cantElem; i++) {
                    this.v[i] = this.v[i+1];
                }
                this.v[cantElem] = 0;
                cantElem--;
            }else {
                k++;
            }
        }
    }

    // 9. L1.eliminarUnicos() : Método que elimina los elementos que aparecen solo una vez en la lista L1.
    public void eliminarUnicos() {
        int i = 1;
        while (i <= cantElem) {
            int elemento = this.v[i];
            if (frecuencia(elemento) == 1) {
                // Eliminar el elemento moviendo los elementos restantes una posición hacia atrás
                for (int j = i; j < cantElem; j++) {
                    this.v[j] = this.v[j + 1];
                }
                // Establecer el último elemento como null (o 0 si es un array primitivo)
                this.v[cantElem] = 0; // Si v es un array de objetos
                cantElem--;
            } else {
                // Avanzar al siguiente elemento
                i++;
            }
        }
    }

    public int frecuencia(int elemento) {
        // Contar la frecuencia del elemento en la lista
        int contador = 0;
        for (int i = 1; i <= cantElem; i++) {
            if (this.v[i] == elemento) {
                contador++;
            }
        }
        return contador;
    }

    // 10. L1.eliminarTodo(L2) : Método que elimina todos los elementos de la lista L1, que aparecen en la lista L2.
    public void eliminarTodo(ListaV L2) {
        for (int i = 1; i <= cantElem; i++) {
            int elemento = this.v[i];
            // Verificar si el elemento está presente en la lista L2
            if (estaEnLista(elemento, L2)) {
                // Eliminar el elemento moviendo los elementos restantes una posición hacia atrás
                for (int j = i; j < cantElem; j++) {
                    this.v[j] = this.v[j + 1];
                }
                this.v[cantElem] = 0;
                cantElem--;
                // Decrementar el índice para volver a comprobar el nuevo elemento en la posición i
                i--;
            }
        }
    }
    public boolean estaEnLista(int elemento, ListaV lista) {
        // Verificar si el elemento está presente en la lista
        for (int i = 1; i <= lista.cantElem; i++) {
            if (lista.v[i] == elemento) {
                return true;
            }
        }
        return false;
    }


    //. LAB-2. LISTAS EN ARREGLO, MÁS CONSULTAS . . .

    // 7. L1.pasarDigitos( n ) : Método que pasa los dígitos del entero n, a la ListaDoble.Lista L1.
    // Ejemplo: Si n = 546781, L1 = []. El resultado es L1 = [5, 4, 6, 7, 8, 1]
    public void pasarDigitos(int n) {
        // Convertir el entero n en una cadena
        String digitos = String.valueOf(n);
        // Agregar cada dígito de la cadena a la lista L1
        for (int i = 0; i < digitos.length(); i++) {
            int digito = Character.getNumericValue(digitos.charAt(i));
            insertarUlt(digito);
        }
    }


    // 8. L1.rotarIzqDer( n ) : Método que hace rotar los elementos de la lista L1 n-veces de izquierda a derecha.
    // Sugerencia, utilizar los métodos de insertar y eleminar por los extremos de la Lista.
    public void rotarIzqDer(int n) {
        if (n == 0) {
            // No hay rotación
            return;
        }
        // Calcular el número real de rotaciones (número positivo)
        n = n % cantElem;
        if (n < 0) {
            // Convertir el número negativo a rotaciones hacia la izquierda
            n = cantElem + n;
        }
        // Realizar rotaciones
        for (int i = 0; i < n; i++) {
            // Rotar a la derecha
            int ultimoElemento = this.v[cantElem];
            for (int j = cantElem; j > 1; j--) {
                this.v[j] = this.v[j - 1];
            }
            this.v[1] = ultimoElemento;
        }
    }

    // 9. L1.rotarDerIzq( n ) : Método que hace rotar los elementos de la lista L1 n-veces de derecha a izquierda.
    public void rotarDerIzq(int n) {
        if (n == 0) {
            // No hay rotación
            return;
        }
        // Calcular el número real de rotaciones (número positivo)
        n = n % cantElem;
        if (n < 0) {
            // Convertir el número negativo a rotaciones hacia la derecha
            n = cantElem + n;
        }
        // Realizar rotaciones
        for (int i = 0; i < n; i++) {
            // Rotar a la izquierda
            int primerElemento = this.v[1];
            for (int j = 1; j < cantElem; j++) {
                this.v[j] = this.v[j + 1];
            }
            this.v[cantElem] = primerElemento;
        }
    }

    // 10. L1.eliminarPrim( n ) : Método que eliminar los primeros n-elementos de la lista L1.
    public void eliminarPrim(int n) {
        if (n <= 0) {
            // No hay elementos para eliminar
            return;
        }
        if (n >= cantElem) {
            limpiarLista();
            return;
        }
        for (int i = 1; i <= cantElem - n; i++) {
            this.v[i] = this.v[i + n];
        }
        cantElem -= n;
        // Limpiar los elementos que quedaron al final
        for (int i = cantElem + 1; i <= cantElem + n; i++) {
            this.v[i] = 0; // Si v es un array de objetos
            // this.v[i] = 0; // Si v es un array de primitivos
        }
    }

    private void limpiarLista() {
        // Establecer el contador de elementos a cero
        int cantEleme = cantElem -1;

        // Limpiar el arreglo v
        for (int i = cantEleme ; i > 0; i--) {
            v[i] = 0; // Si v es un array de objetos
            cantElem--;
        }
    }

    // 11. L1.eliminarUlt( n ) : Método que elimina los n-últimos elementos de la lista L1.
    public void eliminarUlt(int n) {
        if (n <= 0) {
            return;
        }
        if (n >= cantElem) {
            limpiarLista();
            return;
        }
        cantElem -= n;
        for (int i = cantElem + 1; i <= cantElem + n; i++) {
            this.v[i] = 0; // Si v es un array de primitivos
        }
    }

    // 12. L1.insertarIesimo(L2, i) : Método que inserta la Lista L2 en la Lista L1, en la posición i.
    public void insertarIesimo(ListaV L2, int i) {
        // Verificar si i está dentro de los límites válidos de la lista L1
        if (i < 1 || i > cantElem + 1) {
            System.out.println("Posición de inserción inválida.");
            return;
        }
        // Calcular la nueva longitud de L1 después de la inserción de L2
        int nuevaLongitud = cantElem + L2.cantElem;
        // Verificar si hay suficiente espacio en L1 para acomodar los elementos de L2
        if (nuevaLongitud > v.length) {
            System.out.println("No hay suficiente espacio en la lista para insertar los elementos de la lista L2.");
            return;
        }
        // Dsplazar los elementos de L1 a la derecha para hacer espacio para los elementos de L2
        for (int j = cantElem; j >= i; j--) {
            v[j + L2.cantElem] = v[j];
        }
        // Insertar los elementos de L2 en L1 en la posición i
        int indexL2 = 1;
        for (int j = i; j < i + L2.cantElem; j++) {
            v[j] = L2.v[indexL2];
            indexL2++;
        }
        // Actualizar el contador de elementos de L1
        cantElem = nuevaLongitud;
    }

    // LAB-3. MÁS SOBRE LISTAS EN ARREGLO

    // 4. L1.insertarLugasAsc(x) : Método que inserta el elemento x, en su lugar correspondiente en la Lista L1, ordenada de menor a mayor.
    public void insertarLugasAsc(int x) {
        // Encontrar el índice donde se debe insertar x
        int k = 1;
        while (k <= cantElem && v[k] < x) {
            k++;
        }
        insertarEnIndice(x, k);
    }

    private void insertarEnIndice(int x, int indice) {
        // Verificar si hay suficiente espacio en la lista
        if (cantElem == v.length - 1) {
            System.out.println("No hay suficiente espacio en la lista para insertar el elemento.");
            return;
        }
        // Desplazar los elementos a la derecha para hacer espacio para x
        for (int i = cantElem; i >= indice; i--) {
            v[i + 1] = v[i];
        }
        // Insertar x en el lugar correspondiente
        v[indice] = x;
        // Incrementar el contador de elementos
        cantElem++;
    }

    // 5. L1.insertarLugasDesc(x) : Método que inserta el elemento x, en su lugar correspondiente en la Lista L1, ordenada de mayor a menor.
    public void insertarLugasDesc(int x) {
        // Encontrar el índice donde se debe insertar x
        int indice = 1;
        while (indice <= cantElem && v[indice] > x) {
            indice++;
        }

        // Insertar x en el lugar correspondiente
        insertarEnIndice(x, indice);
    }

    // 6. L1.comunes(L2, L3) : Método que encuentra en L1, los elementos comunes en las Listas L2, L3.
    public void comunes(ListaV L2, ListaV L3) {
        // Crear una lista para almacenar los elementos comunes
        ArrayList<Integer> comunes = new ArrayList<>();
        // Verificar cada elemento de L1
        for (int i = 1; i <= cantElem; i++) {
            int elemento = v[i];
            // Verificar si el elemento está presente en L2 y L3
            if (estaEnLista(elemento, L2) && estaEnLista(elemento, L3)) {
                // Agregar el elemento a la lista de elementos comunes
                comunes.add(elemento);
            }
        }
        // Imprimir los elementos comunes
        System.out.print("Elementos comunes en L1, L2 y L3 son: ");
        for (int num : comunes) {
            System.out.println(num);
        }
    }
    // 7. L1.intercalar(L2, L3) : Método que encuentra en L1, los elementos intercalados de las Listas L2 y L3.
    public void intercalar(ListaV L2, ListaV L3) {
        // Crear una lista para almacenar los elementos intercalados
        ArrayList<Integer> intercalados = new ArrayList<>();
        // Índices para recorrer L2 y L3
        int k = 0;
        int j = 0;
        // Verificar cada elemento de L1
        for (int i = 1; i <= cantElem; i++) {
            int elemento = v[i];
            // Verificar si el elemento está presente en L2 y L3
            if (estaEnLista(elemento, L2) && estaEnLista(elemento, L3)) {
                intercalados.add(elemento);
                k++;
                j++;
            }
        }
        // Imprimir los elementos intercalados
        System.out.println("Elementos intercalados en L1, L2 y L3:");
        for (int num : intercalados) {
            System.out.println(num);
        }
    }
    // 8. L1.ordenado() : Método lógico que devuelve True, si los elementos de la lista L1, están ordenados en forma ascendente o descendente.
    public boolean ordenado() {
        boolean ascendente = true;
        boolean descendente = true;

        // Verificar si la lista está ordenada de forma ascendente
        for (int i = 1; i < cantElem; i++) {
            if (v[i] > v[i + 1]) {
                ascendente = false;
                break;
            }
        }

        // Verificar si la lista está ordenada de forma descendente
        for (int i = 1; i < cantElem; i++) {
            if (v[i] < v[i + 1]) {
                descendente = false;
                break;
            }
        }

        // La lista está ordenada si es ascendente o descendente
        return ascendente || descendente;
    }
    //9. L1.iguales() : Método lógico que devuelve True, si todos los elementos de la lista L1, son iguales.
    public boolean iguales(){
        int aux = v[1];
        for (int i = 2; i <= this.cantElem; i++) {
            if (v[i] != aux)
                return false;
        }
        return true;
    }
//10. L1.diferentes() : Método lógico que devuelve True, si todos los elementos de la lista L1, son diferentes.
public boolean diferentes() {
    // Verificar si todos los elementos son diferentes
    for (int i = 1; i <= cantElem; i++) {
        int elementoActual = v[i];
        for (int j = i + 1; j <= cantElem; j++) {
            if (elementoActual == v[j]) {
                // Si se encuentra un elemento igual, significa que no son todos diferentes
                return false;
            }
        }
    }
    // Si se llega hasta aquí, significa que todos los elementos son diferentes
    return true;
}
    //11. L1.menor() : Método que devuelve el menor elemento de la ListaDoble.Lista L1.
    public int menor(){
        int men = v[1];
        for (int i = 1; i <= this.cantElem; i++) {
            if (v[i] < men)
                men = v[i];
        }
        return men;
    }
    //12. L1.parImpar() : Método lógico que devuelve True, en la ListaDoble.Lista L1, existe al menos un elemento par
    // y al menor un elemento impar.
    public boolean parImpar() {
        int cantPares = 0;
        int cantImpares = 0;
        // Contar la cantidad de pares e impares
        for (int i = 1; i <= cantElem; i++) {
            int elemento = v[i];
            if (elemento % 2 == 0) {
                cantPares++;
            } else {
                cantImpares++;
            }
            if (cantPares > 0 && cantImpares > 0) return true;
        }
        return false;
    }

    // 13. L1.mismaFrec() : Método lógico que devuelve True, si todos los elementos tienen la misma frecuencia de
    // aparición en la Lista L1.
    public boolean mismaFrec() {
        // Obtener la frecuencia del primer elemento en la lista
        int primeraFrecuencia = frecuencia(v[1]);
        // Verificar si todos los elementos tienen la misma frecuencia
        for (int i = 2; i <= cantElem; i++) {
            // Si la frecuencia del elemento actual es diferente a la frecuencia del primer elemento, retornar false
            if (frecuencia(v[i]) != primeraFrecuencia) {
                return false;
            }
        }
        // Si todas las frecuencias son iguales, retornar true
        return true;
    }
    // 14. L1.palindrome() : Método lógico que devuelve True, si los elementos de la ListaDoble.Lista L1, forma un palíndrome.
    public boolean palindrome() {
        int inicio = 1;
        int fin = cantElem;
        while (inicio < fin) {
            if (v[inicio] != v[fin]) { // Comparar los elementos en las posiciones inicio y fin
                return false;
            }
            inicio++;
            fin--;
        }
        return true;
    }
    // 15. L1.mismosElem(L2) : Método lógico que devuelve True, las Lista L1 y L2 tienen los mismos elementos.
    public boolean mismosElem(ListaV L2) {
        if (cantElem != L2.cantElem) {
            return false;
        }
        for (int i = 1; i <= cantElem; i++) {
            int elemento = v[i];
            int frecuenciaL1 = frecuencia(elemento);
            int frecuenciaL2 = L2.frecuencia(elemento);
            if (frecuenciaL1 != frecuenciaL2) {// Si las frecuencias no coinciden, las listas no tienen los mismos elementos
                return false;
            }
        }
        return true;
    }
    public void imprimir(ListaV L2) {
        for (int i = 1; i <= cantElem; i++) {
            int elemento = v[i];
            int frecuenciaL1 = frecuencia(elemento);
            int frecuenciaL2 = L2.frecuencia(elemento);
            if (frecuenciaL1 != frecuenciaL2) {

            }
        }
    }
}
