package ArbolBinario;

import java.util.List;

public interface IArbolBusquedaBinario <K extends Comparable<K>,V>{

    void vaciar();
    boolean esArbolVacio();
    void insertar(K clave, V valor);
    boolean contiene(K calve);

    List<K> recorridoPreOrden();

}
