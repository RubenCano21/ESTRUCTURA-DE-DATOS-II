package bo.edu.uagrm.ficct.rubencano.arboles;

import bo.edu.uagrm.ficct.rubencano.Excepciones.ClaveNoExisteExcepcion;

import java.util.*;

public class ArbolBinarioBusqueda<K extends Comparable<K>,V> implements IArbolBusqueda<K,V> {

    protected NodoBinario<K,V> raiz;


    public ArbolBinarioBusqueda(){

    }

    /**
     * Instancia un arbol reconstruyendo en base a su recorrido inOrden y (PreOrden o PostOrden). Si el parametro
     * usandoPreOrden es verdadero, los parametros clavesNoInOrden y valoresNoInOrden tendran el recorrido en preOrden
     * del arbol, caso contrario seran el postOrden
     */
    public ArbolBinarioBusqueda(List<K> clavesInOrden, List<V> valoresInOrden,
                                List<K> clavesNoInOrden, List<V> valoresNoInOrden, boolean usandoPreOrden){

        if (clavesInOrden == null || clavesNoInOrden== null ||
                valoresInOrden == null || valoresNoInOrden == null){
            throw new IllegalArgumentException("Los parametros no pueden ser nulos");
        }

        if (clavesInOrden.isEmpty() || clavesNoInOrden.isEmpty() || valoresInOrden.isEmpty() ||
                valoresNoInOrden.isEmpty()){
            throw new IllegalArgumentException("Los parametros no pueden ser vacios");
        }

        if (clavesInOrden.size() != clavesNoInOrden.size() || clavesInOrden.size() != valoresInOrden.size() ||
                clavesInOrden.size() != valoresNoInOrden.size()){
            throw new IllegalArgumentException("Los parametros no pueden ser listas con diferentes tamaños");
        }

        if (usandoPreOrden){
            this.raiz = reconstruirConPreOrden(clavesInOrden,valoresInOrden, clavesNoInOrden, valoresNoInOrden);
        }else {
            this.raiz = reconstruirConPostOrden(clavesInOrden, valoresInOrden, clavesNoInOrden, valoresNoInOrden);
        }
    }

    private NodoBinario<K,V> reconstruirConPreOrden(List<K> clavesInOrden, List<V> valoresInOrden,
                                       List<K> clavesEnPreOrden, List<V> valoresEnPreOrden) {

        if (clavesInOrden.isEmpty()){
            return (NodoBinario<K, V>) NodoBinario.nodoVacio();
        }
        int posicionDeClavePadreEnPreOrden = 0;
        K clavePadre = clavesEnPreOrden.get(posicionDeClavePadreEnPreOrden);
        V valorPadre = valoresEnPreOrden.get(posicionDeClavePadreEnPreOrden);
        int posicionDeClavePadreEnInOrden = this.posicionDeClave(clavePadre, clavesInOrden);

        //para armar la rama izquierda
        List<K> clavesInOrdenPorIzquierda = clavesInOrden.subList(0,posicionDeClavePadreEnInOrden);
        List<V> valoresInOrdenPorIzquierda = valoresInOrden.subList(0, posicionDeClavePadreEnInOrden);
        List<K> clavesPreOrdenPorIzquierda = clavesEnPreOrden.subList(0,posicionDeClavePadreEnInOrden);
        List<V> valoresPreOrdenPorIzquierda = valoresEnPreOrden.subList(0, posicionDeClavePadreEnInOrden);
        NodoBinario<K,V> hijoIzquierdo = reconstruirConPreOrden(clavesInOrdenPorIzquierda, valoresInOrdenPorIzquierda,
                                                                    clavesPreOrdenPorIzquierda, valoresPreOrdenPorIzquierda);
        //para armar la rama derecha
        List<K> clavesInOrdenPorDerecha = clavesInOrden.subList(posicionDeClavePadreEnInOrden, clavesInOrden.size());
        List<V> valoresInOrdenPorDerecha = valoresInOrden.subList(posicionDeClavePadreEnInOrden, clavesInOrden.size());
        List<K> clavesPreOrdenPorDerecha = clavesEnPreOrden.subList(posicionDeClavePadreEnInOrden, clavesEnPreOrden.size());
        List<V> valoresPreOrdenPorDerecha = valoresEnPreOrden.subList(posicionDeClavePadreEnInOrden, clavesEnPreOrden.size());
        NodoBinario<K,V> hijoDerecho = reconstruirConPreOrden(clavesInOrdenPorDerecha, valoresInOrdenPorDerecha,
                                                                clavesPreOrdenPorDerecha, valoresPreOrdenPorDerecha);
        // armando el nodoActual
        NodoBinario<K,V> nodoActual = new NodoBinario<>(clavePadre, valorPadre);
        nodoActual.setHijoIzquierdo(hijoIzquierdo);
        nodoActual.setHijoDerecho(hijoDerecho);
        return nodoActual;
    }

    private NodoBinario<K,V> reconstruirConPostOrden(List<K> clavesInOrden, List<V> valoresInOrden,
                                         List<K> clavesEnPostOrden, List<V> valoresEnPostOrden) {
        if (clavesInOrden.isEmpty()){
            return (NodoBinario<K, V>) NodoBinario.nodoVacio();
        }

        int posicionDeClavePadreEnPostOrden = clavesEnPostOrden.size();
        K clavePadre;
        clavePadre = clavesEnPostOrden.get(posicionDeClavePadreEnPostOrden);
        V valorPadre = valoresEnPostOrden.get(posicionDeClavePadreEnPostOrden);
        int posicionDeClavePadreEnInOrden = this.posicionDeClave(clavePadre, clavesInOrden);

        // armar por la rama izquierda
        List<K> clavesInOrdenPorIzquierda = clavesInOrden.subList(0,posicionDeClavePadreEnInOrden);
        List<V> valoresInOrdenPorIzquierda = valoresInOrden.subList(0, posicionDeClavePadreEnInOrden);
        List<K> clavesPostOrdenPorIzquierda = clavesEnPostOrden.subList(0,posicionDeClavePadreEnInOrden);
        List<V> valoresPostOrdenPorIzquierda = valoresEnPostOrden.subList(0, posicionDeClavePadreEnInOrden);
        NodoBinario<K,V> hijoIzquierdo = reconstruirConPostOrden(clavesInOrdenPorIzquierda, valoresInOrdenPorIzquierda,
                                                                clavesPostOrdenPorIzquierda, valoresPostOrdenPorIzquierda);

        // armar por la rama derecha
        List<K> clavesInOrdenPorDerecha = clavesInOrden.subList(posicionDeClavePadreEnInOrden+1, clavesInOrden.size());
        List<V> valoresInOrdenPorDerecha = valoresInOrden.subList(posicionDeClavePadreEnInOrden+1, clavesInOrden.size());
        List<K> clavesPreOrdenPorDerecha = clavesEnPostOrden.subList(posicionDeClavePadreEnInOrden+1, clavesEnPostOrden.size());
        List<V> valoresPreOrdenPorDerecha = valoresEnPostOrden.subList(posicionDeClavePadreEnInOrden+1, clavesEnPostOrden.size());
        NodoBinario<K,V> hijoDerecho = reconstruirConPostOrden(clavesInOrdenPorDerecha, valoresInOrdenPorDerecha,
                clavesPreOrdenPorDerecha, valoresPreOrdenPorDerecha);

        // armando el nodoActual
        NodoBinario<K,V> nodoActual = new NodoBinario<>(clavePadre, valorPadre);
        nodoActual.setHijoIzquierdo(hijoIzquierdo);
        nodoActual.setHijoDerecho(hijoDerecho);
        return nodoActual;
    }

    private int posicionDeClave(K claveABuscar, List<K> listaDeClaves){
        for (int i= 0; i < listaDeClaves.size(); i++){
            K claveActual = listaDeClaves.get(i);
            if (claveActual.compareTo(claveABuscar) == 0){
                return i;
            }
        }
        return  -1;
    }


    @Override
    public void vaciar() {
        this.raiz = (NodoBinario<K, V>) NodoBinario.nodoVacio();
    }

    @Override
    public boolean esArbolVacio() {
        return NodoBinario.esNodoVacio(this.raiz);
    }

    @Override
    public int size() {
        int cantidadDeNodos = 0;
        if (!this.esArbolVacio()){

            Queue<NodoBinario<K,V>> colaDeNodos = new LinkedList<>();
            colaDeNodos.offer(this.raiz);
            while (!colaDeNodos.isEmpty()){
                NodoBinario<K,V> nodoActual = colaDeNodos.poll();
                cantidadDeNodos++;

                if (!nodoActual.esVacioHijoDerecho()){
                    colaDeNodos.offer(nodoActual.getHijoDerecho());
                }
                if (!nodoActual.esVacioHijoIzquierdo()){
                    colaDeNodos.offer(nodoActual.getHijoIzquierdo());
                }
            }
        }
        return cantidadDeNodos;
    }

    // metodo que devuelve todos los hijos derechos de un arbol
    public int cantidadDeHijosDerechos(){
        return cantidadDeHijosDerechos(this.raiz);
    }

    private int cantidadDeHijosDerechos(NodoBinario<K, V> nodoActual) {
        if (NodoBinario.esNodoVacio(nodoActual)){
            return 0;
        }
        int hdPorRamaIzquierda = cantidadDeHijosDerechos(nodoActual.getHijoIzquierdo());
        int hdPorRamaDerecha = cantidadDeHijosDerechos(nodoActual.getHijoDerecho());
        if (!nodoActual.esVacioHijoDerecho()){
            return hdPorRamaIzquierda + hdPorRamaDerecha +1;
        }
        return hdPorRamaIzquierda + hdPorRamaDerecha;
    }

    @Override
    public int altura() {
        return altura(this.raiz);
    }

    public int altura(NodoBinario<K, V> nodoActual) {
        if (NodoBinario.esNodoVacio(nodoActual)){
            return 0;
        }
        int alturaPorIzquierda = altura(nodoActual.getHijoIzquierdo());
        int alturaPorDerecha = altura(nodoActual.getHijoDerecho());

        return alturaPorIzquierda > alturaPorDerecha ? alturaPorIzquierda+1 : alturaPorDerecha+1;
    }

    public  int alturaIt(){
        if (this.esArbolVacio()){
            return 0;
        }
        int alturaDelArbol = 0;
        Queue<NodoBinario<K,V>> colaDeNodos = new LinkedList<>();
        colaDeNodos.offer(this.raiz);
        while (!colaDeNodos.isEmpty()){
            int cantidadDeNodosEnLaCola = colaDeNodos.size();
            int i =0;
            while (i < cantidadDeNodosEnLaCola){
                NodoBinario<K,V> nodoActual = colaDeNodos.poll();
                if (!nodoActual.esVacioHijoIzquierdo()){
                    colaDeNodos.offer(nodoActual.getHijoIzquierdo());
                }
                if (!nodoActual.esVacioHijoDerecho()){
                    colaDeNodos.offer(nodoActual.getHijoDerecho());
                }
                i++;
            }
            alturaDelArbol++;
        }
        return alturaDelArbol;
    }

    @Override
    public int nivel() {
        return altura()-1;
    }

    @Override
    public K minimo() {
        if (this.esArbolVacio()){
            return null;
        }
        NodoBinario<K,V> nodoActual = this.raiz;
        NodoBinario<K,V> nodoAnterior = (NodoBinario<K, V>) NodoBinario.nodoVacio();
        while (!NodoBinario.esNodoVacio(nodoActual)){
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.getHijoIzquierdo();
        }
        return nodoAnterior.getClave();
    }

    @Override
    public K maximo() {
        if (esArbolVacio()){
            return null;
        }
        NodoBinario<K,V> nodoAnterior = (NodoBinario<K, V>) NodoBinario.nodoVacio();
        NodoBinario<K,V> nodoActual = this.raiz;
        while (!NodoBinario.esNodoVacio(nodoActual)){
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.getHijoDerecho();
        }
        return nodoActual.getClave();
    }

    @Override
    public void insertar(K claveAInsertar, V valorAInsertar) {
        if (claveAInsertar == null){
            throw new IllegalArgumentException("Clave no puede ser nula");
        }
        if (valorAInsertar == null){
            throw new IllegalArgumentException("Valor no puede ser nulo");
        }
        if (this.esArbolVacio()){
            this.raiz = new NodoBinario<>(claveAInsertar, valorAInsertar);
            return;
        }
        NodoBinario<K,V> nodoActual = this.raiz;
        NodoBinario<K,V> nodoAnterior = (NodoBinario<K, V>) NodoBinario.nodoVacio();

        while (!NodoBinario.esNodoVacio(nodoActual)){
            K claveActual = nodoActual.getClave();
            nodoAnterior = nodoActual;
            if (claveAInsertar.compareTo(claveActual) < 0){
                nodoActual = nodoActual.getHijoIzquierdo();
            } else if (claveAInsertar.compareTo(claveActual) > 0) {
                nodoActual = nodoActual.getHijoDerecho();
            }else {
                nodoActual.setValor(valorAInsertar);
                return;
            }
        }
        NodoBinario<K,V> nuevoNodo = new NodoBinario<>(claveAInsertar, valorAInsertar);
        K claveDelPadre = nodoAnterior.getClave();
        if (claveAInsertar.compareTo(claveDelPadre) < 0){
            nodoAnterior.setHijoIzquierdo(nuevoNodo);
        }else {
            nodoAnterior.setHijoDerecho(nuevoNodo);
        }
    }

    @Override
    public V eliminar(K claveAEliminar)throws ClaveNoExisteExcepcion {
        if (claveAEliminar == null){
            throw new ClaveNoExisteExcepcion("No se aceptan claves nulas");
        }

        V valorARetornar = this.buscar(claveAEliminar);
        if (valorARetornar == null){
            throw new ClaveNoExisteExcepcion("");
        }
        this.raiz = this.eliminar(this.raiz, claveAEliminar);
        return valorARetornar;
    }

    private NodoBinario<K, V> eliminar(NodoBinario<K, V> nodoActual, K claveAEliminar) {

        K claveActual = nodoActual.getClave();
        if (claveAEliminar.compareTo(claveActual) < 0){
            NodoBinario<K,V> supuestoHijoIzq = this.eliminar(nodoActual.getHijoIzquierdo(), claveAEliminar);
            nodoActual.setHijoIzquierdo(supuestoHijoIzq);
            return nodoActual;
        }

        if (claveAEliminar.compareTo(claveActual) > 0){
            NodoBinario<K,V> supuestoHijoDer = this.eliminar(nodoActual.getHijoDerecho(), claveAEliminar);
            nodoActual.setHijoDerecho(supuestoHijoDer);
            return nodoActual;
        }

        // caso: 1
        if (nodoActual.esHoja()){
            return (NodoBinario<K, V>) NodoBinario.nodoVacio();
        }

        // caso: 2
        if (!nodoActual.esVacioHijoIzquierdo() && nodoActual.esVacioHijoDerecho()){
            return nodoActual.getHijoIzquierdo();
        }
        // caso: 2b
        if (nodoActual.esVacioHijoIzquierdo() && !nodoActual.esVacioHijoDerecho()){
            return nodoActual.getHijoDerecho();
        }

        // caso: 3
        NodoBinario<K,V> nodoDelSucesor = this.getSucesor(nodoActual.getHijoDerecho());
        NodoBinario<K,V> supuestoNuevoHijoDer = this.eliminar(nodoActual.getHijoDerecho(),nodoDelSucesor.getClave());
        nodoActual.setClave(nodoDelSucesor.getClave());
        nodoActual.setValor(nodoDelSucesor.getValor());
        return nodoActual;
    }

    protected NodoBinario<K, V> getSucesor(NodoBinario<K, V> nodoAux) {
        while (!nodoAux.esVacioHijoIzquierdo()){
            nodoAux = nodoAux.getHijoIzquierdo();
        }
        return nodoAux;
    }

    @Override
    public boolean contiene(K clave) {
        return this.buscar(clave) != null;
    }

    @Override
    public V buscar(K claveABuscar) {
        if (claveABuscar == null){
            throw new IllegalArgumentException("Clave no puede ser nula");
        }

        if (this.esArbolVacio()){
            return null;
        }

        NodoBinario<K,V> nodoActual = this.raiz;
        while (!NodoBinario.esNodoVacio(nodoActual)){
            K claveActual = nodoActual.getClave();
            if (claveABuscar.compareTo(claveActual) == 0){
                return nodoActual.getValor();
            } else if (claveABuscar.compareTo(claveActual) < 0) {
                nodoActual = nodoActual.getHijoIzquierdo();
            }else {
                nodoActual = nodoActual.getHijoDerecho();
            }
        }
        //si llego a este punto quiere decir que no encontro la clave en el arbol
        return null;
    }

    @Override
    public List<K> recorridoEnInOrden() {
        List<K> recorrido = new ArrayList<>();
        if (this.esArbolVacio()){
            return recorrido;
        }
        Stack<NodoBinario<K,V>> pilaDeNodos = new Stack<>();
        NodoBinario<K,V> nodoActual = this.raiz;
        meterPilaEnInOrden(nodoActual, pilaDeNodos);

        while (!pilaDeNodos.isEmpty()){
            nodoActual = pilaDeNodos.pop();
            recorrido.add(nodoActual.getClave());

            if (!nodoActual.esVacioHijoDerecho()){
                nodoActual = nodoActual.getHijoDerecho();
                meterPilaEnInOrden(nodoActual, pilaDeNodos);
            }
        }
        return recorrido;
    }

    private void meterPilaEnInOrden(NodoBinario<K, V> nodoActual, Stack<NodoBinario<K, V>> pilaDeNodos) {
        while (!NodoBinario.esNodoVacio(nodoActual)){
            pilaDeNodos.push(nodoActual);
            nodoActual = nodoActual.getHijoIzquierdo();
        }
    }


    public List<K> recorridoEnInOrdenRecursivo() {
        List<K> recorrido = new ArrayList<>();
        // para una implementacion recursiva, se necesita un metodo amigo que haga el grueso del trabajo
        recorridoEnInOrden(this.raiz, recorrido);
        return recorrido;
    }

    private void recorridoEnInOrden(NodoBinario<K, V> nodoActual, List<K> recorrido) {
        //simulamos el n para un caso base
        if (NodoBinario.esNodoVacio(nodoActual)){
            return;
        }
        recorridoEnInOrden(nodoActual.getHijoIzquierdo(), recorrido);
        recorrido.add(nodoActual.getClave());
        recorridoEnInOrden(nodoActual.getHijoDerecho(), recorrido);

    }


    @Override
    public List<K> recorridoEnPreOrden() {  //en este caso me conviene utilizar una pila
        List<K> recorrido = new ArrayList<>();
        if (this.esArbolVacio()){
            return recorrido;
        }
        Stack<NodoBinario<K,V>> pilaDeNodos = new Stack<>();
        pilaDeNodos.push(this.raiz);
        while (!pilaDeNodos.isEmpty()){
            NodoBinario<K,V> nodoActual = pilaDeNodos.pop();
            recorrido.add(nodoActual.getClave());

            if (!nodoActual.esVacioHijoDerecho()){
                pilaDeNodos.push(nodoActual.getHijoDerecho());
            }
            if (!nodoActual.esVacioHijoIzquierdo()){
                pilaDeNodos.push(nodoActual.getHijoIzquierdo());
            }
        }
        return recorrido;
    }

    // Recorrido en preOrden recursivo
    public List<K> recorridoEnPreOrdenRecursivo() {
        List<K> recorrido = new ArrayList<>();
        // para una implementacion recursiva, se necesita un metodo amigo que haga el grueso del trabajo
        recorridoEnPreOrdenRecursivo(this.raiz, recorrido);
        return recorrido;
    }

    private void recorridoEnPreOrdenRecursivo(NodoBinario<K, V> nodoActual, List<K> recorrido) {
        //simulamos el n para un caso base
        if (NodoBinario.esNodoVacio(nodoActual)){
            return;
        }
        recorrido.add(nodoActual.getClave());
        recorridoEnPreOrdenRecursivo(nodoActual.getHijoIzquierdo(), recorrido);
        recorridoEnPreOrdenRecursivo(nodoActual.getHijoDerecho(), recorrido);

    }

    @Override
    public List<K> recorridoEnPostOrden() {
        List<K> recorrido = new ArrayList<>();
        if (this.esArbolVacio()){
            return recorrido;
        }
        Stack<NodoBinario<K,V>> pilaDeNodos = new Stack<>();
        NodoBinario<K,V> nodoActual = this.raiz;
        //proceso inicial antes de entrar en la pila
        meterPilaParaPostOrden(pilaDeNodos, nodoActual);
        // empezamos a iterar sobre la pila
        while (!pilaDeNodos.isEmpty()){
            nodoActual = pilaDeNodos.pop();
            recorrido.add(nodoActual.getClave());
            if (!pilaDeNodos.isEmpty()){
                NodoBinario<K,V> nodoTope = pilaDeNodos.peek();
                if (!nodoTope.esVacioHijoDerecho() && nodoTope.getHijoDerecho() != nodoActual){
                    // volver a hacer el mismo bucle inicial
                    meterPilaParaPostOrden(pilaDeNodos, nodoTope.getHijoDerecho());
                }
            }
        }
        return recorrido;
    }

    private void meterPilaParaPostOrden(Stack<NodoBinario<K, V>> pilaDeNodos, NodoBinario<K, V> nodoActual) {
        while (!NodoBinario.esNodoVacio(nodoActual)){
            pilaDeNodos.push(nodoActual);
            if (!nodoActual.esVacioHijoIzquierdo()){
                nodoActual = nodoActual.getHijoIzquierdo();
            }else {
                nodoActual = nodoActual.getHijoDerecho();
            }
        }
    }

    //
    public List<K> recorridoEnPostOrdenRecursivo() {
        List<K> recorrido = new ArrayList<>();
        // para una implementacion recursiva, se necesita un metodo amigo que haga el grueso del trabajo
        recorridoEnPostOrdenRecursivo(this.raiz, recorrido);
        return recorrido;
    }

    private void recorridoEnPostOrdenRecursivo(NodoBinario<K, V> nodoActual, List<K> recorrido) {
        //simulamos el n para un caso base
        if (NodoBinario.esNodoVacio(nodoActual)){
            return;
        }
        recorridoEnPostOrdenRecursivo(nodoActual.getHijoIzquierdo(), recorrido);
        recorridoEnPostOrdenRecursivo(nodoActual.getHijoDerecho(), recorrido);
        recorrido.add(nodoActual.getClave());

    }

    @Override
    public List<K> recorridoPorNiveles() {  // para este recorrido si o si se necesita una Cola
        List<K> recorrido = new ArrayList<>();
        if (this.esArbolVacio()){
            return recorrido;
        }
        Queue<NodoBinario<K,V>> colaDeNodos = new LinkedList<>();
        colaDeNodos.offer(this.raiz);
        while (!colaDeNodos.isEmpty()){
            NodoBinario<K,V> nodoActual = colaDeNodos.poll();
            recorrido.add(nodoActual.getClave());
            if (!nodoActual.esVacioHijoIzquierdo()){
                colaDeNodos.offer(nodoActual.getHijoIzquierdo());
            }
            if (!nodoActual.esVacioHijoDerecho()){
                colaDeNodos.offer(nodoActual.getHijoDerecho());
            }
        }
        return recorrido;
    }

    @Override
    public String mostrarArbol() {
        return this.generarCadenaDeArbol(this.raiz,"", true);
    }

    private String generarCadenaDeArbol(NodoBinario<K, V> nodoActual, String prefijo, boolean ponerCodo) {

        StringBuilder cadena = new StringBuilder();
        cadena.append(prefijo);

        if (prefijo.length() == 0){
            cadena.append(ponerCodo ? "|---(R)" : "|---(R)"); // arbol vacio o no
        }else {
            cadena.append(ponerCodo ? "|---(D)" : "|---(I)"); // derecha o izquierda
        }
        if (NodoBinario.esNodoVacio(nodoActual)){
            cadena.append("-|\n");
            return cadena.toString();
        }
        cadena.append(nodoActual.getClave().toString());
        cadena.append("\n");

        NodoBinario<K,V> nodoIzq = nodoActual.getHijoIzquierdo();
        String prefijoAux = prefijo + (ponerCodo ? " " : "| ");
        cadena.append(generarCadenaDeArbol(nodoIzq, prefijoAux,false));

        NodoBinario<K,V> nodoDer = nodoActual.getHijoDerecho();
        cadena.append(generarCadenaDeArbol(nodoDer, prefijoAux, true));
        return cadena.toString();
    }

    /* 1. implementar un metodo recursivo que retorne la cantidad de nodos que tienen solo hijo izquierdo no vacio en un
    arbol binario
     */
    public int cantidadNodosSoloHijoIzqRec(){
        return cantidadNodosSoloHijoIzqRec(this.raiz);
    }

    private int cantidadNodosSoloHijoIzqRec(NodoBinario<K, V> nodoActual) {
        if (NodoBinario.esNodoVacio(nodoActual)){
            return 0;
        }
        int cantPorIzq = cantidadNodosSoloHijoIzqRec(nodoActual.getHijoIzquierdo());
        int cantPorDer = cantidadNodosSoloHijoIzqRec(nodoActual.getHijoDerecho());

        if (!nodoActual.esVacioHijoIzquierdo()){
            return  cantPorIzq + cantPorDer +1;
        }
        return cantPorIzq + cantPorDer;
    }

    /* 2. implemente un metodo iterativo que retorne la cantidad de nodos que tienen solo hijo izquierdo no vacio en un
    arbol binario
     */

    public int cantidadDeNodosSoloHijoIzquierdo(){
        if (this.esArbolVacio()){
            return 0;
        }
        Queue<NodoBinario<K,V>> colaDeNodos = new LinkedList<>();
        NodoBinario<K,V> nodoActual = this.raiz;
        colaDeNodos.offer(nodoActual);
        int cantHijosIzq = 0;

        while (!colaDeNodos.isEmpty()){
            nodoActual = colaDeNodos.poll();
            if (!nodoActual.esVacioHijoIzquierdo()){
                colaDeNodos.offer(nodoActual.getHijoIzquierdo());
                cantHijosIzq++;
            }
            if (!nodoActual.esVacioHijoDerecho()){
                colaDeNodos.offer(nodoActual.getHijoDerecho());
            }
        }
        return cantHijosIzq;
    }

    /* 3. implemente un metodo recursivo que retorne la cantidad de nodos que tienen solo hijo izquierdo no vacio en un
    arbol binario, pero solo en el nivel N
     */
    public int cantidadDeHijosIzquierdoEnNivel(int nivelABuscar){
        return cantidadDeHijosIzquierdoEnNivel(this.raiz, nivelABuscar,0);
    }

    private int cantidadDeHijosIzquierdoEnNivel(NodoBinario<K, V> nodoActual, int nivelABuscar, int nivelActual) {

        if (!NodoBinario.esNodoVacio(nodoActual)){
            if (nivelABuscar == nivelActual && !nodoActual.esVacioHijoIzquierdo()){
                return cantidadDeHijosIzquierdoEnNivel(nodoActual.getHijoIzquierdo(), nivelABuscar, nivelActual +1) +
                        cantidadDeHijosIzquierdoEnNivel(nodoActual.getHijoDerecho(), nivelABuscar, nivelActual+1) +1;
            }
            return cantidadDeHijosIzquierdoEnNivel(nodoActual.getHijoIzquierdo(), nivelABuscar, nivelActual +1) +
                    cantidadDeHijosIzquierdoEnNivel(nodoActual.getHijoDerecho(), nivelABuscar, nivelActual+1);
        }
        return 0;
    }

    /* 4.Implemente in metodo iterativo que retorne la cantidad de nodos que tienen solo hijo izquierdo no vacio en un
    arbol binario, pero solo "DESPUES" del nivel N
     */
    public  int cantidadDeHijosIzquierdoDespuesDeNivel(int nivel){
        if (this.esArbolVacio()){
            return 0;
        }

        Queue<NodoBinario<K,V>> colaDeNodos = new LinkedList<>();
        NodoBinario<K,V> nodoActual = this.raiz;
        colaDeNodos.offer(nodoActual);
        int cantidadHijosIzq = 0;

        while (!colaDeNodos.isEmpty()){
            int cantidadDeNodos = colaDeNodos.size();
            int i=0;
            while (i < cantidadDeNodos){
                nodoActual = colaDeNodos.poll();
                if (nivel < 0){
                    if (!nodoActual.esVacioHijoIzquierdo()){
                        cantidadHijosIzq++;
                    }
                }
                if (!nodoActual.esVacioHijoDerecho()){
                    colaDeNodos.offer(nodoActual.getHijoIzquierdo());
                }
                if (!nodoActual.esVacioHijoDerecho()){
                    colaDeNodos.offer(nodoActual.getHijoDerecho());
                }
                i++;
            }
            nivel--;
        }
        return cantidadHijosIzq;
    }


    /* 5.Implemente in metodo iterativo que retorne la cantidad de nodos que tienen solo hijo izquierdo no vacio en un
    arbol binario, pero solo "ANTES" del nivel N
     */
    public  int cantidadDeHijosIzquierdoAntesDeNivel(int nivel){
        if (this.esArbolVacio()){
            return 0;
        }
        Queue<NodoBinario<K,V>> colaDeNodos = new LinkedList<>();
        NodoBinario<K,V> nodoActual = this.raiz;
        colaDeNodos.offer(nodoActual);
        int cantidadHijosIzq = 0;

        while (!colaDeNodos.isEmpty()){
            int cantidadDeNodos = colaDeNodos.size();
            int i=0;
            while (i < cantidadDeNodos){
                nodoActual = colaDeNodos.poll();
                if (nivel > 0){
                    if (!nodoActual.esVacioHijoIzquierdo()){
                        cantidadHijosIzq++;
                    }
                }
                if (!nodoActual.esVacioHijoDerecho()){
                    colaDeNodos.offer(nodoActual.getHijoIzquierdo());
                }
                if (!nodoActual.esVacioHijoDerecho()){
                    colaDeNodos.offer(nodoActual.getHijoDerecho());
                }
                i++;
            }
            nivel--;
        }
        return cantidadHijosIzq;
    }

    /* 6. Implemente un metodo recursivo que reciba como parametro otro arbol binario de busqueda que retorne
    verdadero, si el arbol binario es similar al arlbol recibido como parametro, falso en caso contrario
     */
    public boolean arbolSimilar(ArbolBinarioBusqueda nuevoArbol){
        if (this.altura() != nuevoArbol.altura()){
            return false;
        }
        return arbolSimilar(this.raiz, nuevoArbol.raiz);
    }

    private boolean arbolSimilar(NodoBinario<K, V> nodoActual, NodoBinario<K, V> nodoNuevoArbol) {
        if (NodoBinario.esNodoVacio(nodoActual) && !NodoBinario.esNodoVacio(nodoNuevoArbol)){
            return false;
        }
        return (!nodoActual.esVacioHijoIzquierdo() && !nodoNuevoArbol.esVacioHijoIzquierdo());
    }

    /* 7. Para un arbol binario implemente un metodo que retorne la cantidad de nodos que tienen ambos hijos desde el
    nivel N. */
    public int cantidadNodosAmbosHijos(int nivel){
        return cantidadNodosAmbosHijos(this.raiz, nivel, 0);
    }

    private int cantidadNodosAmbosHijos(NodoBinario<K, V> nodoActual, int nivelABuscar, int nivel) {
        if (NodoBinario.esNodoVacio(nodoActual)){
            return 0;
        }
        int cantPorIzq = cantidadNodosAmbosHijos(nodoActual.getHijoIzquierdo(), nivelABuscar, nivel +1);
        int cantPorDer = cantidadNodosAmbosHijos(nodoActual.getHijoDerecho(), nivelABuscar, nivel +1);

        if (nivel > nivelABuscar){
            if (!nodoActual.esVacioHijoDerecho() && !nodoActual.esVacioHijoIzquierdo()){
                return cantPorDer + cantPorIzq +1;
            }
        }
        return cantPorDer + cantPorIzq;
    }

    /* 8. Implementar un metodo que retorne verdadero si un arbol binario esta lleno. */
    public boolean arbolEstaLleno(){
        if (this.esArbolVacio()){
            return false;
        }
        Queue<NodoBinario<K,V>> colaDeNodos = new LinkedList<>();
        NodoBinario<K,V> nodoActual = this.raiz;
        colaDeNodos.offer(nodoActual);
        int altura = altura();
        boolean esCompleto = true;

        while (!colaDeNodos.isEmpty() && esCompleto){
            int cantidadNodos = colaDeNodos.size();
            int i = 0;
            while (i < cantidadNodos){
                nodoActual = colaDeNodos.poll();

                if (altura == 1){
                    if (!nodoActual.esHoja()){
                        esCompleto = false;
                    }
                } else if (nodoActual.esVacioHijoIzquierdo() || nodoActual.esVacioHijoDerecho()) {
                    esCompleto = false;
                }
                if (!nodoActual.esVacioHijoIzquierdo()){
                    colaDeNodos.offer(nodoActual.getHijoIzquierdo());
                }
                if (!nodoActual.esVacioHijoDerecho()){
                    colaDeNodos.offer(nodoActual.getHijoDerecho());
                }
                i++;
            }
            altura--;
        }
        return esCompleto;
    }

    /* 9. Implementar un metodo que retorne un nuevo arbolBinario de busqueda invertido. */
    public NodoBinario<K,V> arbolInvertido(){
        return arbolInvertido(this.raiz);
    }

    private NodoBinario<K, V> arbolInvertido(NodoBinario<K, V> nodoActual) {
        if (NodoBinario.esNodoVacio(nodoActual)){
            return null;
        }
        NodoBinario<K,V> nodoIzq = arbolInvertido(nodoActual.getHijoIzquierdo());
        NodoBinario<K,V> nodoDer = arbolInvertido(nodoActual.getHijoDerecho());

        nodoActual.setHijoDerecho(nodoIzq);
        nodoActual.setHijoIzquierdo(nodoDer);

        return nodoActual;
    }

    /* 10. Implemnetar un metodo que retorne true si un arbolBInario, tiene nodos completos
    es decir que tenga sus dos hijos diferentes de cero en el nivel*/
    public boolean tieneNodosCompletosEnNivel(int nivel) {
        return tieneNodosCompletosEnNivel(this.raiz, nivel);
    }

    private boolean tieneNodosCompletosEnNivel(NodoBinario<K, V> nodoActual, int nivel) {
        if (NodoBinario.esNodoVacio(nodoActual)){
            return false;
        }
        if (nivel == 0){
            return !nodoActual.esNodoCompleto();
        }
        boolean parIzq = tieneNodosCompletosEnNivel(nodoActual.getHijoIzquierdo(), nivel -1);
        boolean parDer = tieneNodosCompletosEnNivel(nodoActual.getHijoDerecho(), nivel -1);
        return parIzq && parDer;
    }

    /* Implementar un metodo que cuente las hojas del arbol */
    public int contarHojas(){
        return contarHojas(this.raiz);
    }

    private int contarHojas(NodoBinario<K, V> nodoActual) {
        if (NodoBinario.esNodoVacio(nodoActual)){
            return 0;
        }
        if (nodoActual.esHoja()){
            return 1;
        }
        return contarHojas(nodoActual.getHijoIzquierdo()) +
                contarHojas(nodoActual.getHijoDerecho());
    }

    /* Implementar metodo que cuente las hojas del arbol en un determinado nivel */
    public int contarHojasEnNivel(int nivel){
        return contarHojasEnNivel(this.raiz, nivel);
    }

    private int contarHojasEnNivel(NodoBinario<K, V> nodoActual, int nivel) {
        if (NodoBinario.esNodoVacio(nodoActual)){
            return 0;
        }
        if (nivel <= 0) {
            if (nodoActual.esHoja()){
                return 1;
            }
            return 0;
        }
        int parIzq = contarHojas(nodoActual.getHijoIzquierdo());
        int parDer = contarHojas(nodoActual.getHijoDerecho());
        return parIzq + parDer;
    }

    /*
       Funcion que retorne el reflejo del arbol.
           Arbol normal

                           8
                   3              10
               1       6      __      14
            __  __  04  07  __  __  13  __

           Arbol reflejo

                           8
                  10               3
              14      __       6       1
            __  13  __  __   7   4  __  __
        */
    public ArbolBinarioBusqueda<K, V> reflejo() {
        ArbolBinarioBusqueda<K, V> reflejo = new ArbolBinarioBusqueda<>();
        reflejo.raiz = reflejo(this.raiz, reflejo.raiz);
        return reflejo;
    }

    private NodoBinario<K, V> reflejo(NodoBinario<K, V> nodoActual,
                                      NodoBinario<K, V> nodoActualRef) {
        if(NodoBinario.esNodoVacio(nodoActual)){
            return (NodoBinario<K, V>) NodoBinario.nodoVacio();
        }
        nodoActualRef = new NodoBinario<>(nodoActual.getClave(),
                nodoActual.getValor());
        nodoActualRef.setHijoDerecho(reflejo(
                nodoActual.getHijoIzquierdo(),
                nodoActualRef.getHijoDerecho()));
        nodoActualRef.setHijoIzquierdo(reflejo(
                nodoActual.getHijoDerecho(),
                nodoActualRef.getHijoIzquierdo()));
        return nodoActualRef;
    }





}
