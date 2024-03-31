package ArbolBinario;

import java.util.List;

public class ArbolBusquedaBinario <K extends Comparable<K>,V> implements IArbolBusquedaBinario<K,V>{

    protected NodoBinario<K,V> raiz;

    public ArbolBusquedaBinario(){
    }

    public ArbolBusquedaBinario (List<K> claveInOrden, List<V> valorInOrden,
                                 List<K> clavesNoInOrden, List<V> valoresNoInOrden, boolean usandoPreOrden){
        if (claveInOrden == null || clavesNoInOrden == null ||
            valorInOrden == null || valoresNoInOrden == null){
            throw new IllegalArgumentException("los parametros no pueden ser nulos");
        }
        if (claveInOrden.isEmpty() || clavesNoInOrden.isEmpty() || valorInOrden.isEmpty() || valoresNoInOrden.isEmpty()){
            throw new IllegalArgumentException("los parametros no pueden ser vacios");
        }
        if (claveInOrden.size() != clavesNoInOrden.size() || claveInOrden.size() != valorInOrden.size() ||
            claveInOrden.size() != valoresNoInOrden.size()){
            throw new IllegalArgumentException("Las listas no pueden ser de diferentes tamaños");
        }

        if (usandoPreOrden){
            this.raiz = reconstruirConPreOrden(claveInOrden, valorInOrden, clavesNoInOrden, valoresNoInOrden);
        }else {
            this.raiz = reconstruirConPostOrden(claveInOrden, valorInOrden, clavesNoInOrden, valoresNoInOrden);
        }
    }

    private NodoBinario<K, V> reconstruirConPreOrden(List<K> claveInOrden, List<V> valorInOrden,
                                                     List<K> clavesEnpreOrden, List<V> valoresEnPreOrden) {
        if (claveInOrden.isEmpty()){
            return (NodoBinario<K, V>) NodoBinario.nodoVacio();
        }

        int posDeClavePadreEnPreOrden = 0 ;
        K clavePadre = clavesEnpreOrden.get(posDeClavePadreEnPreOrden);
        V valorPadre = valoresEnPreOrden.get(posDeClavePadreEnPreOrden);
        int posDeClavePadreEnInOrden = this.posicionDeClave(clavePadre, claveInOrden);

        // para armar por la izquierda
        List<K> clavesInOrdenPorIzquierda = claveInOrden.subList(0, posDeClavePadreEnInOrden);
        List<V> valoresInOrdenPorIzquierda = valorInOrden.subList(0, posDeClavePadreEnInOrden);
        List<K> clavesPreOrdenPorIzquierda = clavesEnpreOrden.subList(0, posDeClavePadreEnInOrden);
        List<V> valoresPreOrdenPorIzquierda = valoresEnPreOrden.subList(0, posDeClavePadreEnInOrden);
        NodoBinario<K,V> hijoIzquierdo = reconstruirConPreOrden(clavesInOrdenPorIzquierda, valoresInOrdenPorIzquierda,
                                                                clavesPreOrdenPorIzquierda, valoresPreOrdenPorIzquierda);
        // para armar por la derecha
        List<K> clavesInOrdenPorDerecha = claveInOrden.subList(posDeClavePadreEnInOrden, claveInOrden.size());
        List<V> valoresInOrdenPorDerecha = valorInOrden.subList(posDeClavePadreEnInOrden, claveInOrden.size());
        List<K> clavesPreOrdenPorDerecha = clavesEnpreOrden.subList(posDeClavePadreEnInOrden, claveInOrden.size());
        List<V> valoresPreOrdenPorDerecha = valoresEnPreOrden.subList(posDeClavePadreEnInOrden, claveInOrden.size());
        NodoBinario<K,V> hijoDerecho = reconstruirConPreOrden(clavesInOrdenPorDerecha, valoresInOrdenPorDerecha,
                                                                clavesPreOrdenPorDerecha, valoresPreOrdenPorDerecha);
        // armando el nodo actual
        NodoBinario<K,V> nodoActual = new NodoBinario<>(clavePadre, valorPadre);
        nodoActual.setHijoIzquierdo(hijoIzquierdo);
        nodoActual.setHijoDerecho(hijoDerecho);
        return nodoActual;
    }

    private int posicionDeClave(K claveABuscar, List<K> listaDeClaves) {
        for (int i = 0; i < listaDeClaves.size(); i++) {
            K claveActual = listaDeClaves.get(i);
            if (claveActual.compareTo(claveABuscar) == 0){
                return i;
            }
        }
        return -1;
    }

    private NodoBinario<K,V> reconstruirConPostOrden(List<K> claveInOrden, List<V> valorInOrden,
                                                     List<K> clavesEnPostOrden, List<V> valoresEnPostOrden) {
        if (claveInOrden.isEmpty()){
            return (NodoBinario<K, V>) NodoBinario.nodoVacio();
        }

        int posDeClavePadreEnPostOrden = 0 ;
        K clavePadre = clavesEnPostOrden.get(posDeClavePadreEnPostOrden);
        V valorPadre = valoresEnPostOrden.get(posDeClavePadreEnPostOrden);
        int posDeClavePadreEnInOrden = this.posicionDeClave(clavePadre, claveInOrden);

        // para armar por la izquierda
        List<K> clavesInOrdenPorIzquierda = claveInOrden.subList(0, posDeClavePadreEnInOrden);
        List<V> valoresInOrdenPorIzquierda = valorInOrden.subList(0, posDeClavePadreEnInOrden);
        List<K> clavesPostOrdenPorIzquierda = clavesEnPostOrden.subList(0, posDeClavePadreEnInOrden);
        List<V> valoresPostOrdenPorIzquierda = valoresEnPostOrden.subList(0, posDeClavePadreEnInOrden);
        NodoBinario<K,V> hijoIzquierdo = reconstruirConPreOrden(clavesInOrdenPorIzquierda, valoresInOrdenPorIzquierda,
                clavesPostOrdenPorIzquierda, valoresPostOrdenPorIzquierda);
        // para armar por la derecha
        List<K> clavesInOrdenPorDerecha = claveInOrden.subList(posDeClavePadreEnInOrden, claveInOrden.size());
        List<V> valoresInOrdenPorDerecha = valorInOrden.subList(posDeClavePadreEnInOrden, claveInOrden.size());
        List<K> clavesPostOrdenPorDerecha = clavesEnPostOrden.subList(posDeClavePadreEnInOrden, claveInOrden.size());
        List<V> valoresPostOrdenPorDerecha = valoresEnPostOrden.subList(posDeClavePadreEnInOrden, claveInOrden.size());
        NodoBinario<K,V> hijoDerecho = reconstruirConPreOrden(clavesInOrdenPorDerecha, valoresInOrdenPorDerecha,
                clavesPostOrdenPorDerecha, valoresPostOrdenPorDerecha);
        // armando el nodo actual
        NodoBinario<K,V> nodoActual = new NodoBinario<>(clavePadre, valorPadre);
        nodoActual.setHijoIzquierdo(hijoIzquierdo);
        nodoActual.setHijoDerecho(hijoDerecho);
        return nodoActual;
    }

    @Override
    public void vaciar() {
        this.raiz = (NodoBinario<K, V>)NodoBinario.nodoVacio();
    }

    @Override
    public boolean esArbolVacio() {
        return NodoBinario.esNodoVacio(this.raiz);
    }

    @Override
    public void insertar(K claveInsertar, V valorInsertar) {
        if (claveInsertar == null){
            throw new IllegalArgumentException("clave no puede ser nula");
        }
        if (valorInsertar == null){
            throw new IllegalArgumentException("valor no puede ser nulo");
        }
        if (esArbolVacio()){
            this.raiz = new NodoBinario<>(claveInsertar, valorInsertar);
            return;
        }

        NodoBinario<K,V> nodoActual = this.raiz;
        NodoBinario<K,V> nodoAnterior = (NodoBinario<K, V>) NodoBinario.nodoVacio();

        while (!NodoBinario.esNodoVacio(nodoActual)){
            K claveActual = nodoActual.getClave();
            nodoAnterior = nodoActual;
            if (claveInsertar.compareTo(claveActual) < 0){
                nodoActual = nodoActual.getHijoIzquierdo();
            } else if (claveInsertar.compareTo(claveActual) > 0) {
                nodoActual = nodoActual.getHijoDerecho();
            }else {
                nodoActual.setValor(valorInsertar);
            }
        }
        NodoBinario<K,V> nodoNuevo = new NodoBinario<>(claveInsertar, valorInsertar);
        K claveDelPadre = nodoActual.getClave();
        if (claveInsertar.compareTo(claveDelPadre) < 0){
            nodoAnterior.setHijoDerecho(nodoNuevo);
        }else {
            nodoAnterior.setHijoDerecho(nodoNuevo);
        }
    }

    @Override
    public boolean contiene(K clave) {
        return this.buscar(clave) != null;
    }
    @Override
    public V buscar(K claveABuscar){
        if (claveABuscar == null){
            throw new IllegalArgumentException("clave no puede ser nula");
        }
        if(this.esArbolVacio()){
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
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int altura() {
        return 0;
    }

    @Override
    public int nivel() {
        return 0;
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
    public List<K> recorridoPreOrden() {
        return null;
    }

    @Override
    public List<K> recorridoInOrden() {
        return null;
    }

    @Override
    public List<K> recorridoPostOrden() {
        return null;
    }

    @Override
    public List<K> recorridoPorNiveles() {
        return null;
    }
}
