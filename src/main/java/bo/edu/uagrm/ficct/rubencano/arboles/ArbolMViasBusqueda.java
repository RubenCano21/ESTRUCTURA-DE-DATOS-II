package bo.edu.uagrm.ficct.rubencano.arboles;

import bo.edu.uagrm.ficct.rubencano.Excepciones.ClaveNoExisteExcepcion;
import bo.edu.uagrm.ficct.rubencano.Excepciones.OrdenInvalidoExcepcion;

import java.util.*;

public class ArbolMViasBusqueda<K extends Comparable<K>,V> implements IArbolBusqueda<K,V> {

    protected NodoMVias<K,V> raiz;
    protected final int orden;
    private static final int ORDEN_MINIMO = 3;
    private static final int POSICION_INVALIDA = -1;

    public ArbolMViasBusqueda(){
        this.orden = ArbolMViasBusqueda.ORDEN_MINIMO;
    }

    public ArbolMViasBusqueda(int orden) throws OrdenInvalidoExcepcion {

       if (orden < ArbolMViasBusqueda.ORDEN_MINIMO){
           throw new OrdenInvalidoExcepcion();
       }
       this.orden = orden;
    }

    @Override
    public void vaciar() {
        this.raiz = NodoMVias.nodoVacio();
    }

    @Override
    public boolean esArbolVacio() {
        return NodoMVias.esNodoVacio(this.raiz);
    }

    @Override
    public int size() {
        int cantidadDeNodos = 0;
        if (!this.esArbolVacio()){

            Queue<NodoMVias<K,V>> colaDeNodos = new LinkedList<>();
            colaDeNodos.offer(this.raiz);

            while (!colaDeNodos.isEmpty()){
                NodoMVias<K,V> nodoActual = colaDeNodos.poll();
                cantidadDeNodos++;
                for (int i = 0; i < this.orden; i++) {
                    if (!nodoActual.esHijoVacio(i)){
                        colaDeNodos.offer(nodoActual.getHijo(i));
                    }
                }
            }
        }
        return cantidadDeNodos;
    }

    @Override
    public int altura() {
        return altura(this.raiz);
    }

    // metodo recursivo
    protected int altura(NodoMVias<K, V> nodoActual) {
        if (NodoMVias.esNodoVacio(nodoActual)){ // n =0
            return 0;
        }
        int alturaMayor = 0;
        for (int i = 0; i < this.orden; i++) {
            int alturaDelHijoActual = altura(nodoActual.getHijo(i));
            if (alturaDelHijoActual > alturaMayor){
                alturaMayor = alturaDelHijoActual;
            }
        }
        return alturaMayor + 1;
    }


    @Override
    public int nivel() {
        return nivel(this.raiz);
    }

    private int nivel(NodoMVias<K, V> nodoActual) {
        int nivelMayor = 0;
        int supuestoNivelMayor = 0;
        for (int i = 0; i <= nodoActual.nroDeClavesNoVacias(); i++) {
            if (!nodoActual.esHijoVacio(i)){
                supuestoNivelMayor = nivel(nodoActual.getHijo(i)) +1;
            }
            if (supuestoNivelMayor > nivelMayor){
                nivelMayor = supuestoNivelMayor;
            }
        }
        return nivelMayor;
    }

    @Override
    public K minimo() {
        return null;
    }

    @Override
    public K maximo() {
        return null;
    }

    @Override
    public void insertar(K claveAInsertar, V valorAsociado) {
        if (claveAInsertar == null){
            throw new IllegalArgumentException("Clave no puede ser nula");
        }
        if (valorAsociado == null){
            throw new IllegalArgumentException("Valor no puede ser nula");
        }

        if (this.esArbolVacio()){
            this.raiz = new NodoMVias<>(this.orden, claveAInsertar, valorAsociado);
            return;
        }
        NodoMVias<K,V> nodoActual = this.raiz;
        do {
            int posicionDeClaveAInsertar = this.buscarPosicionDeClave(claveAInsertar, nodoActual);
            if (posicionDeClaveAInsertar != ArbolMViasBusqueda.POSICION_INVALIDA){
                nodoActual.setValor(posicionDeClaveAInsertar, valorAsociado);
                nodoActual = NodoMVias.nodoVacio();
            }else if (nodoActual.esHoja()){
                if (nodoActual.estanClavesLlenas()){
                    int posicionPorDondeBajar = this.buscarPosicionPorDondeBajar(nodoActual, claveAInsertar);
                    NodoMVias<K,V> nuevoNodo = new NodoMVias<>(this.orden, claveAInsertar, valorAsociado);
                    nodoActual.setHijo(posicionPorDondeBajar, nuevoNodo);
                }else {
                    insertarClaveYValorOrdenado(nodoActual, claveAInsertar, valorAsociado);
                }
                nodoActual = NodoMVias.nodoVacio();
            }else {
                // el nodoActual no es hoja
                int posicionPorDondeBajar = this.buscarPosicionPorDondeBajar(nodoActual, claveAInsertar);
                if (nodoActual.esHijoVacio(posicionPorDondeBajar)){
                    NodoMVias<K,V> nuevoNodo = new NodoMVias<>(this.orden, claveAInsertar, valorAsociado);
                    nodoActual.setHijo(posicionPorDondeBajar, nuevoNodo);
                    nodoActual = NodoMVias.nodoVacio();
                } else {
                    nodoActual = nodoActual.getHijo(posicionPorDondeBajar);
                }
            }
        }while (!NodoMVias.esNodoVacio(nodoActual));
    }

    public void insertarRec(K claveAInsertar, V valorAsociado){
        this.raiz = insertarRec(this.raiz, claveAInsertar, valorAsociado);
    }

    private NodoMVias<K, V> insertarRec(NodoMVias<K, V> nodoActual, K claveAInsertar, V valorAInsertar) {
        if (NodoMVias.esNodoVacio(nodoActual)){
            return new NodoMVias<>(this.orden, claveAInsertar, valorAInsertar);
        }
        if (!nodoActual.estanClavesLlenas()){
            nodoActual = colocarDatosOrdenadamente(nodoActual, claveAInsertar, valorAInsertar);
            return nodoActual;
        }
        int posBajar = buscarPosicionPorDondeBajar(nodoActual, claveAInsertar);
        nodoActual.setHijo(posBajar, insertarRec(nodoActual.getHijo(posBajar),
                                    claveAInsertar, valorAInsertar));
        return  nodoActual;
    }

    protected NodoMVias<K, V> colocarDatosOrdenadamente(NodoMVias<K, V> nodoActual, K clave, V valor) {
        int i;
        int pos;
        i = 0;
        while (i < nodoActual.nroDeClavesNoVacias() && clave.compareTo(nodoActual.getClave(i)) > 0){
            i++;
        }
        if (nodoActual.getClave(i) == NodoMVias.datoVacio()){
            nodoActual.setClave(i, clave);
            nodoActual.setValor(i, valor);
            return nodoActual;
        } else if (clave.compareTo(nodoActual.getClave(i)) == 0) {
            nodoActual.setValor(i, valor);
            return nodoActual;
        }else {
            pos = i;
            i = nodoActual.nroDeClavesNoVacias();
            while (i > pos) {
                nodoActual.setClave(i, nodoActual.getClave(i -1));
                nodoActual.setValor(i, nodoActual.getValor(i -1));
                i--;
            }
            nodoActual.setClave(pos, clave);
            nodoActual.setValor(pos, valor);
            return nodoActual;
        }
    }

    protected void insertarClaveYValorOrdenado(NodoMVias<K, V> nodoActual, K claveAInsertar, V valorAsociado) {
        
    }

    protected int buscarPosicionPorDondeBajar(NodoMVias<K, V> nodoActual, K claveAInsertar) {
        int lim = nodoActual.nroDeClavesNoVacias();
        int i = 0;
        while (i < lim && claveAInsertar.compareTo(nodoActual.getClave(i)) > 0){
            i++;
        }
        return i;
    }

    private int buscarPosicionDeClave(K claveAInsertar, NodoMVias<K, V> nodoActual) {
        return 0;
    }

    @Override
    public V eliminar(K claveAEliminar) throws ClaveNoExisteExcepcion {
        if (claveAEliminar == null){
            throw new ClaveNoExisteExcepcion("Clave a nula no puede ser nula");
        }
        
        V valorAEliminar = this.buscar(claveAEliminar);
        if (valorAEliminar == null){
            throw new ClaveNoExisteExcepcion();
        }
        this.raiz = eliminar(this.raiz, claveAEliminar);
        return valorAEliminar;
    }

    private NodoMVias<K,V> eliminar(NodoMVias<K,V> nodoActual, K claveAEliminar){
        for (int i = 0; i < nodoActual.nroDeClavesNoVacias(); i++) {
            K claveEnTurno = nodoActual.getClave(i);
            if (claveAEliminar.compareTo(claveEnTurno) == 0){
                if (nodoActual.esHoja()){
                    this.eliminarClaveDeNodoDePosicion(nodoActual, i);
                    if (!nodoActual.hayClavesNoVacias()){
                        return NodoMVias.nodoVacio();
                    }
                    return nodoActual;
                }
                // caso 2 o 3
                K claveDeReemplazo;
                if (this.hayHijosMasEdelanteDeLaPosicion(nodoActual, i)){
                    claveDeReemplazo = this.obtenerSucesorInOrden(nodoActual, claveAEliminar);
                } else {
                    claveDeReemplazo = this.obtenerPredecesorInOrden(nodoActual, claveAEliminar);
                }
                V valorDeReemplazo = this.buscar(claveDeReemplazo);
                
                nodoActual = eliminar(nodoActual, claveDeReemplazo);
                nodoActual.setClave(i, claveDeReemplazo);
                nodoActual.setValor(i, valorDeReemplazo);
                return nodoActual;
            }
            if (claveAEliminar.compareTo(claveEnTurno) < 0){
                NodoMVias<K,V> supuestoNuevoHijo = this.eliminar(nodoActual.getHijo(i), claveAEliminar);
                nodoActual.setHijo(i, supuestoNuevoHijo);
                return nodoActual;
            }
        }
        NodoMVias<K,V> supuestoNuevoHijo = this.eliminar(nodoActual.getHijo(nodoActual.nroDeClavesNoVacias()), claveAEliminar);
        nodoActual.setHijo(nodoActual.nroDeClavesNoVacias(), supuestoNuevoHijo);
        return nodoActual;
    }

    private K obtenerPredecesorInOrden(NodoMVias<K, V> nodoActual, K claveAEliminar) {
        return null;
    }

    private K obtenerSucesorInOrden(NodoMVias<K, V> nodoActual, K claveAEliminar) {
        return null;
    }

    private boolean hayHijosMasEdelanteDeLaPosicion(NodoMVias<K, V> nodoActual, int i) {
        return false;
    }

    protected void eliminarClaveDeNodoDePosicion(NodoMVias<K, V> nodoActual, int posicion) {
        
    }

    @Override
    public boolean contiene(K clave) {
        return this.buscar(clave) != null;
    }

    @Override
    public V buscar(K claveABuscar) {
        if (claveABuscar == null){
            throw new IllegalArgumentException("En el arbol no hay claves nulas");
        }

        if (!this.esArbolVacio()){

            NodoMVias<K,V> nodoAux = this.raiz;
            do {
                boolean cambiarNodoAux = false;
                for (int i = 0; i < nodoAux.nroDeClavesNoVacias() && !cambiarNodoAux; i++) {
                    K claveAux = nodoAux.getClave(i);
                    if (claveABuscar.compareTo(claveAux) == 0){
                        return nodoAux.getValor(i);
                    } else if (claveABuscar.compareTo(claveAux) < 0) {
                        nodoAux = nodoAux.getHijo(i);
                        cambiarNodoAux = true;
                    }

                }// fin del for
                if (!cambiarNodoAux){
                    nodoAux = nodoAux.getHijo(nodoAux.nroDeClavesNoVacias());
                }
            }while (!NodoMVias.esNodoVacio(nodoAux));
        }
        return null;
    }

    @Override
    public List<K> recorridoEnInOrden() {
        List<K> recorrido = new ArrayList<>();
        recorridoEnInOrden(this.raiz, recorrido);
        return recorrido;
    }

    private void recorridoEnInOrden(NodoMVias<K, V> nodoActual, List<K> recorrido) {
        if (NodoMVias.esNodoVacio(nodoActual)){
            return;
        }
        for (int i = 0; i < nodoActual.nroDeClavesNoVacias(); i++) {
            recorridoEnInOrden(nodoActual.getHijo(i), recorrido);
            recorrido.add(nodoActual.getClave(i));
        }
        recorridoEnInOrden(nodoActual.getHijo(nodoActual.nroDeClavesNoVacias()), recorrido);
    }

    @Override
    public List<K> recorridoEnPreOrden() {
        List<K> recorrido = new ArrayList<>();
        recorridoEnPreOrden(this.raiz, recorrido);
        return recorrido;
    }

    private void recorridoEnPreOrden(NodoMVias<K, V> nodoActual, List<K> recorrido) {
        if (NodoMVias.esNodoVacio(nodoActual)){
            return;
        }
        for (int i = 0; i < nodoActual.nroDeClavesNoVacias(); i++) {
            recorrido.add(nodoActual.getClave(i));
            recorridoEnPreOrden(nodoActual.getHijo(i), recorrido);
        }
        recorridoEnPreOrden(nodoActual.getHijo(nodoActual.nroDeClavesNoVacias()), recorrido);
    }

    @Override
    public List<K> recorridoEnPostOrden() {
        List<K> recorrido = new ArrayList<>();
        recorridoEnPostOrden(this.raiz, recorrido);
        return recorrido;
    }

    private void recorridoEnPostOrden(NodoMVias<K, V> nodoActual, List<K> recorrido) {
        if (NodoMVias.esNodoVacio(nodoActual)){
            return;
        }
        recorridoEnPostOrden(nodoActual.getHijo(0), recorrido);
        for (int i = 0; i < nodoActual.nroDeClavesNoVacias(); i++) {
            recorridoEnPostOrden(nodoActual.getHijo(i + 1), recorrido);
            recorrido.add(nodoActual.getClave(i));
        }
    }

    public void recorridoPorProfundidadRec(){
        recorridoPorProfundidadRec(this.raiz);
    }

    private void recorridoPorProfundidadRec(NodoMVias<K, V> nodoActual) {
        if (!NodoMVias.esNodoVacio(nodoActual)){
            visitarNodo(nodoActual);
            for (int i = 0; i < orden; i++) {
                if (!NodoMVias.esNodoVacio(nodoActual.getHijo(i))){
                    recorridoPorProfundidadRec(nodoActual.getHijo(i));
                }
            }
        }
    }

    private void visitarNodo(NodoMVias<K, V> nodoActual) {
        if (!NodoMVias.esNodoVacio(nodoActual)){
            for (int i = 0; i < orden - 1 && !nodoActual.esHijoVacio(i); i++) {
                System.out.println("[" + nodoActual.getClave(i) + "]");
            }
        }
    }

    @Override
    public List<K> recorridoPorNiveles() {
        List<K> recorrido = new ArrayList<>();
        if (!this.esArbolVacio()){
            Queue<NodoMVias<K,V>> colaDeNodos = new LinkedList<>();
            colaDeNodos.offer(this.raiz);

            do {
                NodoMVias<K,V> nodoActual = colaDeNodos.poll();
                for (int i = 0; i < nodoActual.nroDeClavesNoVacias(); i++){
                    recorrido.add(nodoActual.getClave(i));
                    if (!nodoActual.esHijoVacio(i)){
                        colaDeNodos.offer(nodoActual.getHijo(i));
                    }
                }// fin del for
                if (!nodoActual.esHijoVacio(nodoActual.nroDeClavesNoVacias())){
                    colaDeNodos.offer(nodoActual.getHijo(nodoActual.nroDeClavesNoVacias()));
                }
            } while (!colaDeNodos.isEmpty());
        }
        return recorrido;
    }

    @Override
    public String mostrarArbol() {
        return null;
    }

    // metodo que devuelva cuantos nodos de un ArbolMVias tienen un numero de hijos no vacios par Ej.=> 2,4,6,....
    public int cantidadDeNodosConHijosNoVaciosYPar(){
        return cantidadDeNodosConHijosNoVaciosYPar(this.raiz);
    }

    private int cantidadDeNodosConHijosNoVaciosYPar(NodoMVias<K, V> nodoActual) {
        if (NodoMVias.esNodoVacio(nodoActual)){
            return 0;
        }
        int cantNodosConHijosPares = 0;
        int cantHijos = 0;
        for (int i = 0; i <= nodoActual.nroDeClavesNoVacias(); i++) {
            if (!NodoMVias.esNodoVacio(nodoActual.getHijo(i))){
                cantNodosConHijosPares += cantidadDeNodosConHijosNoVaciosYPar(nodoActual.getHijo(i));
                cantHijos++;
            }
        }
        if ((cantHijos % 2 == 0) && (cantHijos != 0)){
            cantNodosConHijosPares++;
        }
        return cantNodosConHijosPares;
    }
// PREGUNTAS DE MODELOS DE EXAMENES
    /* 1. Para un arbol-Mvias de busqueda, implementar un metodo que recida la clave, la busque en el arbol
    en caso de encontrar la llave que retorne en que nivel esta. que retorne -1 en caso de no estar la clave
    en el arbol. La Implementacion debe ser recursiva.
     */


}
