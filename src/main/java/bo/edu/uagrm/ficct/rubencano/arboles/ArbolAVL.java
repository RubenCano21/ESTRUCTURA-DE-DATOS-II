package bo.edu.uagrm.ficct.rubencano.arboles;

import bo.edu.uagrm.ficct.rubencano.Excepciones.ClaveNoExisteExcepcion;

public class ArbolAVL<K extends Comparable<K>, V> extends ArbolBinarioBusqueda<K,V> {

    private static final int LIMITE_MAXIMO = 1;

    @Override
    public void insertar(K claveAInsertar, V valorAsociado) {
        if (claveAInsertar == null){
            throw new IllegalArgumentException("Clave no puede ser nula");
        }
        if (valorAsociado == null){
            throw new IllegalArgumentException("Valor no puede ser nulo");
        }
        super.raiz = insertar(super.raiz, claveAInsertar, valorAsociado);
    }

    private NodoBinario<K, V> insertar(NodoBinario<K, V> nodoActual, K claveAInsertar, V valorAsociado) {

        if (NodoBinario.esNodoVacio(nodoActual)){
            NodoBinario<K,V> nodoNuevo = new NodoBinario<>(claveAInsertar, valorAsociado);
            return nodoActual;
        }
        K claveDelNodoActual = nodoActual.getClave();
        if (claveAInsertar.compareTo(claveDelNodoActual) < 0){
            NodoBinario<K,V> supuestoNuevoHijoIzq = insertar(nodoActual.getHijoIzquierdo(), claveAInsertar, valorAsociado);
            nodoActual.setHijoIzquierdo(supuestoNuevoHijoIzq);
            return balancear(nodoActual);
        }
        nodoActual.setValor(valorAsociado);
        return nodoActual;
    }

    private NodoBinario<K, V> balancear(NodoBinario<K, V> nodoActual) {
        int alturaRamaIzq = super.altura(nodoActual.getHijoIzquierdo());
        int alturaRamaDer = super.altura(nodoActual.getHijoDerecho());
        int diferencia = alturaRamaIzq - alturaRamaDer;

        if (diferencia > LIMITE_MAXIMO){
            // hay que balancear, rotacion a la derecha preguntando si es simple o doble
            NodoBinario<K,V> hijoIzquierdo = nodoActual.getHijoIzquierdo();
            alturaRamaIzq = altura(hijoIzquierdo.getHijoIzquierdo());
            alturaRamaDer = altura(hijoIzquierdo.getHijoDerecho());

            if (alturaRamaDer > alturaRamaIzq){
                return rotacionDobleDerecha(nodoActual);
            }else {
                return rotacionSimpleDerecha(nodoActual);
            }
        } else if (diferencia < -LIMITE_MAXIMO) {
            NodoBinario<K,V> hijoDerecho = nodoActual.getHijoDerecho();
            alturaRamaIzq = altura(hijoDerecho.getHijoDerecho());
            alturaRamaDer = altura(hijoDerecho.getHijoDerecho());

            if (alturaRamaDer < alturaRamaIzq){
                return rotacionDobleIzquierda(nodoActual);
            }else {
                return rotacionSimpleIzquierda(nodoActual);
            }
        }
        return nodoActual;
    }

    public NodoBinario<K, V> rotacionSimpleDerecha(NodoBinario<K, V> nodoActual) {
        NodoBinario<K,V> nodoQueRota = nodoActual.getHijoIzquierdo();
        nodoActual.setHijoIzquierdo(nodoQueRota.getHijoDerecho());
        nodoQueRota.setHijoDerecho(nodoActual);
        return nodoQueRota;
    }

    private NodoBinario<K, V> rotacionSimpleIzquierda(NodoBinario<K, V> nodoActual) {
        NodoBinario<K,V> nodoQueRota = nodoActual.getHijoDerecho();
        nodoActual.setHijoDerecho(nodoQueRota.getHijoIzquierdo());
        nodoQueRota.setHijoIzquierdo(nodoActual);
        return nodoQueRota;
    }

    private NodoBinario<K, V> rotacionDobleIzquierda(NodoBinario<K, V> nodoActual) {
        nodoActual.setHijoIzquierdo(rotacionSimpleDerecha(nodoActual.getHijoDerecho()));
        return this.rotacionSimpleDerecha(nodoActual);
    }

    private NodoBinario<K, V> rotacionDobleDerecha(NodoBinario<K, V> nodoActual) {
        nodoActual.setHijoIzquierdo(rotacionSimpleIzquierda(nodoActual.getHijoIzquierdo()));
        return this.rotacionSimpleDerecha(nodoActual);
    }

    @Override
    public V eliminar(K claveAEliminar) throws ClaveNoExisteExcepcion {
        if (claveAEliminar == null){
            throw new IllegalArgumentException("no acepta nulos");
        }
        V valorARetornar = buscar(claveAEliminar);
        if (valorARetornar == null){
            throw new IllegalArgumentException("No acepta nulos");
        }
        this.raiz = eliminar(this.raiz, claveAEliminar);
        return valorARetornar;
    }

    public NodoBinario<K,V> eliminar(NodoBinario<K,V> nodoActual, K claveAEliminar){
        K claveActual = nodoActual.getClave();
        if (claveAEliminar.compareTo(claveActual) > 0){
            NodoBinario<K,V> posibleNuevoHijoDer = eliminar(nodoActual.getHijoDerecho(), claveAEliminar);
            nodoActual.setHijoDerecho(posibleNuevoHijoDer);
            return balancear(nodoActual);
        }

        if (claveAEliminar.compareTo(claveActual) < 0){
            NodoBinario<K,V> posibleNuevoHijoIzq = eliminar(nodoActual.getHijoIzquierdo(), claveAEliminar);
            nodoActual.setHijoIzquierdo(posibleNuevoHijoIzq);
            return balancear(nodoActual);
        }

        // entonces ya lo encontro, tomar los caso
        // Caso: 1 si es hoja
        if (nodoActual.esHoja()){
            return (NodoBinario<K, V>) NodoBinario.nodoVacio();
        }

        //caso: 2 => si tiene un hijo
        if (!nodoActual.esVacioHijoIzquierdo() && nodoActual.esVacioHijoDerecho()){
            return balancear(nodoActual.getHijoDerecho());
        }
        if (nodoActual.esVacioHijoIzquierdo() && !nodoActual.esVacioHijoDerecho()){
            return balancear(nodoActual.getHijoDerecho());
        }

        // caso 3 => tiene ambos hijos
        NodoBinario<K,V> nodoReemplazo = this.getSucesor(nodoActual.getHijoDerecho());
        NodoBinario<K,V> posibleNuevoHijoDerecho = eliminar(nodoActual.getHijoDerecho(), nodoReemplazo.getClave());
        nodoActual.setClave(nodoReemplazo.getClave());
        nodoReemplazo.setValor(nodoReemplazo.getValor());

        return balancear(nodoActual);
    }




















}
