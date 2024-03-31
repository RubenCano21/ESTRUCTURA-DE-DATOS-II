package ArbolBinario;

import java.util.List;

public interface IArbolBusquedaBinario <K extends Comparable<K>,V>{

    void vaciar();
    boolean esArbolVacio();
    void insertar(K clave, V valor);
    boolean contiene(K calve);
    int size();
    int altura();
    int nivel();
    K minimo();
    K maximo();
    V buscar(K clave);

    List<K> recorridoPreOrden();
    List<K> recorridoInOrden();
    List<K> recorridoPostOrden();
    List<K> recorridoPorNiveles();

}
