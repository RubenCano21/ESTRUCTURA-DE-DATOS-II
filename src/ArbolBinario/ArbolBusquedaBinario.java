package ArbolBinario;

import java.util.List;

public class ArbolBusquedaBinario <K extends Comparable<K>,V> implements IArbolBusquedaBinario<K,V>{

    protected NodoBinario<K,V> raiz;

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
      /*  if (!claveInsertar == null){
            throw new IllegalArgumentException("clave no puede ser nula");
        }
        if (!valorInsertar == null){
            throw new IllegalArgumentException("valor no puede ser nulo");
        }
        if (esArbolVacio()){
            this.raiz = new NodoBinario<>(claveInsertar, valorInsertar);
            return;
        }*/

        //NodoBinario<K,V> nuevoNodo = new NodoBinario<>()
    }

    @Override
    public boolean contiene(K calve) {
        return false;
    }

    @Override
    public List<K> recorridoPreOrden() {
        return null;
    }
}
