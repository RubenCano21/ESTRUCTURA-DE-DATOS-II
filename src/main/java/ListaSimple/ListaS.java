package ListaSimple;

public class ListaS {

    public NodoS prim;
    public int cantElem;
    public NodoS ult;


    public ListaS (){
        this.prim = null;
        this.ult = null;
        this.cantElem = 0;
    }





    //  LAB-4. CONSULTAS LISTAS ENCADENADAS SIMPLES
//1.      L1.toString() : Método que devuelve una cadena, que representa la secuencia de elementos de la lista L1.
    public String toString(){
        String s1 = "[ ";
        NodoS p = prim;
        while (p != null){
            s1 += p.elem + "-> ";
            p = p.prox;
        }
        s1 = s1.substring(0, s1.length() -3);
        return s1 + "]";
    }
    public boolean vacia(){
        return (this.prim == null && this.ult == null);
    }

    /**
     * 2.L1.insertarPrim(x) : Método que inserta el elemento x, al inicio de la lista L1.
     */
    public void insertarPrim(int x){
        if (vacia()){
            NodoS p = new NodoS(x, null);
            prim = p;
            ult = p;
        }else {
            prim = new NodoS(x, prim);
        }
        cantElem++;
    }
//3.      L1.insertarUlt(x) : Método que inserta el elemento x, al inicio de la lista L1.
    public void insertarUlt(int x){
        if (vacia()){
            prim = ult = new NodoS(x, null);
        }else {
            ult = ult.prox = new NodoS(x, null);
        }
        cantElem++;
    }
//.      L1.InsertarIesimo(x, i) : Método que inserta el elemento x, en la la iésima posición de la ListaDoble.Lista L1.

//4.      L1.iguales() : Método Lógico que devuelve True, si todos los elementos de la lista L1 son iguales.

//5.      L1.menorElem() : Método que devuelve el menor elemento de la lista L1.
    /**
     * 6.   L1.reemplazar(x, y) : Método que reemplaza todas las ocurrencias del elemento x por el elemento y en la lista L1.
     * @param x
     * @param y
     */
    public void reemplazar(int x, int y){
        NodoS p = prim;
        while (p != null){
            if (p.elem == x)
                p.elem = y;
            p = p.prox;
        }
    }
//7.   L1.seEncuentra(x) : Método Lógico que devuelve True, si el elemento x, se encuentra en la lista L1.

//8.   L1.frecuencia(x) : Método que devuelve la cantidad de veces que aparece el elemento x en la lista L1.
    public int frecuencia(int x){
        int k =0;
        NodoS p = prim;
        while (p != null){
            if (p.elem == x)
                k++;
            p = p.prox;
        }
        return k;
    }
/*9.   L1.insertarUlt(L2) : Método que inserta los elementos de la ListaDoble.Lista L2, al final de la ListaDoble.Lista L1.

10.   L1.insertarLugar(x) : Método que inserta el elemento x, en su lugar correspondiente en la ListaDoble.Lista L1, ordenada de menor a mayor.*/



    /*  TAREA-4. EJERCICIOS BÁSICOS SOBRE LISTAS ENCADENADAS SIMPLES
1.      L1.toString() : Método que devuelve una cadena, que representa la secuencia de elementos de la lista L1.

2.      L1.insertarPrim(x) : Método que inserta el elemento x, al inicio de la lista L1.

3.      L1.insertarUlt(x) : Método que inserta el elemento x, al inicio de la lista L1.

4.      L1.iguales() : Método Lógico que devuelve True, si todos los elementos de la lista L1 son iguales.

5.      L1.diferentes() : Método Lógico que devuelve True, si todos los elementos de la lista L1 son diferentes.

6.      L1.mayorElem() : Método que devuelve el mayor elemento de la lista L1.

7.      L1.menorElem() : Método que devuelve el menor elemento de la lista L1.

8.      L1.ordenado()  : Método Lógico que devuelve True, si todos los elementos de la lista L1 están ordenados en forma ascendente o descendente.

9.      L1.pares() : Método lógico que devuelve True, si todos los elementos de la lista L1 son pares.

10.      L1.parImpar() : Método lógico que devuelve True, si la lista L1 contiene al menos un elemento par e impar.

11.   L1.reemplazar(x, y) : Método que reemplaza todas las ocurrencias del elemento x por el elemento y en la lista L1.

12.   L1.seEncuentra(x) : Método Lógico que devuelve True, si el elemento x, se encuentra en la lista L1.

13.   L1.frecuencia(x) : Método que devuelve la cantidad de veces que aparece el elemento x en la lista L1.

14.   L1.existeFrec(k) : Método Lógico que devuelve True, si existe algún elemento que se repite exactamente k-veces en la lista L1.

15.   L1.mismasFrec() : Método Lógico que devuelve True, si todos los elementos de la lista L1 tienen la misma frecuencia.

16.   L1.poker() : Método Lógico que devuelve True, si los elementos de la lista L1 forman poker. (Todos los elementos son iguales excepto uno)

17.   L1.existePar() : Método lógico que devuelve True, si la lista L1 contiene al menos un elemento par.

18.   L1.existeImpar() : Método lógico que devuelve True, si la lista L1 contiene al menos un elemento impar.

19.   L1.todoPares() : Método lógico que devuelve True, si todos los elementos de la lista L1 son pares.

20.   L1.todoImpares() : Método lógico que devuelve True, si todos los elementos de la lista L1 son impares.

21.   L1.existeParImpar() : Método lógico que devuelve True, si en la lista L1 al menos existe un elemento par y un elemento impar.

22.   L1.alternos() : Método lógico que devuelve true, si la lista L1 contiene elementos en la siguiente secuencia: par, impar, par, impar, . . . or  impar, par, impar, par, . . . .

23.   L1.insertarUlt(L2) : Método que inserta los elementos de la ListaDoble.Lista L2, al final de la ListaDoble.Lista L1.

24.   L1.insertarLugarAsc(x) : Método que inserta el elemento x, en su lugar correspondiente en la ListaDoble.Lista L1, ordenada de menor a mayor.

25.   L1.insertarLugarDesc(x) : Método que inserta el elemento x, en su lugar correspondiente en la ListaDoble.Lista L1, ordenada de mayor a menor.

26. L1.intercalar(L2, L3) : Método que intercala los elementos de las Listas L2 con L3 en L1.

27.   Adicionar al menos 5 métodos cualesquiera de consulta interesantes.*/
}
