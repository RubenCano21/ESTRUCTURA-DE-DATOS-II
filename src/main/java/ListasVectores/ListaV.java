package ListasVectores;

public class ListaV {

    private static final int MAX = 50;
    private int v[];
    private int cantElem;

    public ListaV(){
        this.cantElem =0;
        v = new int[50];
    }

    public void insertarUlt(int x){
        this.cantElem++;
        this.v[cantElem] = x;
    }

    public String toString(){
        String s1 = "[";
        for (int i = 1; i <= this.cantElem; i++) {
            s1 += v[i] + ", ";
        }
        s1 = s1.substring(0, s1.length() -2);
        return s1 + "]";
    }

    /*  LAB-1. LISTAS EN ARREGLO
    L1.insertarIesimo(x, i) : Método que inserta el elemento x, en la posición i, de la lista L1.

2. L1.insertarPrim(x) : Método que insertar el elemento x, al inicio de la lista L1.

3. L1.insertarUlt(x) : Método que inserta el elemento x, al final de la lista L1.

4. L1.eliminarIesimo(i) : Método que elimina el elemento de la posición i.

5. L1.eliminarPrim() : Método que elimina el elemento de la primer posición.

6. L1.eliminarUlt() : Método que elimina el último elemento de la lista L1.

8. L1.eliminarTodo( x ) : Método que elimina todos los elementos x de la lista L1.

8. L1.eliminarPares() : Método que elimina los elementos pares de la lista L1. Verificar en listas dónde todos los elementos sean pares.

9. L1.eliminarUnicos() : Método que elimina los elementos que aparecen solo una vez en la lista L1.

10. L1.eliminarTodo(L2) : Método que elimina todos los elementos de la lista L1, que aparecen en la lista L2.*/



    /*. LAB-2. LISTAS EN ARREGLO, MÁS CONSULTAS . . .
     L1.insertarIesimo(x, i) : Método que inserta el elemento x, en la posición i, de la lista L1.

2. L1.insertarPrim(x) : Método que insertar el elemento x, al inicio de la lista L1.

3. L1.insertarUlt(x) : Método que inserta el elemento x, al final de la lista L1.*/

//4. L1.eliminarIesimo(i) : Método que elimina el elemento de la posición i.
    public void eliminarIesimo(int i){
        for (int j = i; j < this.cantElem; j++) {
            v[j] = v[j+1];
        }
        this.cantElem--;
    }

/*5. L1.eliminarPrim() : Método que elimina el elemento de la primer posición.

6. L1.eliminarUlt() : Método que elimina el último elemento de la lista L1.

7. L1.pasarDigitos( n ) : Método que pasa los dígitos del entero n, a la ListaDoble.Lista L1. Ejemplo: Si n = 546781, L1 = []. El resultado es L1 = [5, 4, 6, 7, 8, 1]

8. L1.rotarIzqDer( n ) : Método que hace rotar los elementos de la lista L1 n-veces de izquierda a derecha. Sugerencia, utilizar los métodos de insertar y eleminar por los extremos de la ListaDoble.Lista.

9. L1.rotarDerIzq( n ) : Método que hace rotar los elementos de la lista L1 n-veces de derecha a izquierda.

10. L1.eliminarPrim( n ) : Método que eliminar los primeros n-elementos de la lista L1.

11. L1.eliminarUlt( n ) : Método que elimina los n-últimos elementos de la lista L1.

12. L1.insertarIesimo(L2, i) : Método que inserta la ListaDoble.Lista L2 en la ListaDoble.Lista L1, en la posición i.*/


    /* LAB-3. MÁS SOBRE LISTAS EN ARREGLO
    L1.insertarIesimo(x, i) : Método que inserta el elemento x, en la posición i, de la lista L1.

2. L1.insertarPrim(x) : Método que insertar el elemento x, al inicio de la lista L1.

3. L1.insertarUlt(x) : Método que inserta el elemento x, al final de la lista L1.

4. L1.insertarLugasAsc(x) : Método que inserta el elemento x, en su lugar correspondiente en la ListaDoble.Lista L1, ordenada de menor a mayor.

5. L1.insertarLugasDesc(x) : Método que inserta el elemento x, en su lugar correspondiente en la ListaDoble.Lista L1, ordenada de mayor a menor.

6. L1.comunes(L2, L3) : Método que encuentra en L1, los elementos comunes en las Listas L2, L3.

7. L1.intercalar(L2, L3) : Método que encuentra en L1, los elementos intercalados de las Listas L2 y L3.

8. L1.ordenado() : Método lógico que devuelve True, si los elementos de la lista L1, están ordenados en forma ascendente o descendente.*/

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

//11. L1.menor() : Método que devuelve el menor elemento de la ListaDoble.Lista L1.
    public int menor(){
        int men = v[1];
        for (int i = 1; i <= this.cantElem; i++) {
            if (v[i] < men)
                men = v[i];
        }
        return men;
    }
/*12. L1.parImpar() : Método lógico que devuelve True, en la ListaDoble.Lista L1, existe al menos un elemento par y al menor un elemento impar.

13. L1.mismaFrec() : Método lógico que devuelve True, si todos los elementos tienen la misma frecuencia de aparición en la ListaDoble.Lista L1.

14. L1.palindrome() : Método lógico que devuelve True, si los elementos de la ListaDoble.Lista L1, forma un palíndrome.

15. L1.mismosElem(L2) : Método lógico que devuelve True, las ListaDoble.Lista L1 y L2 tienen los mismos elementos.*/
}
