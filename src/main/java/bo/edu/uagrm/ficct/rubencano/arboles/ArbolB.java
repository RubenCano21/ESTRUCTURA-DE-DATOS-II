package bo.edu.uagrm.ficct.rubencano.arboles;

import bo.edu.uagrm.ficct.rubencano.Excepciones.ClaveNoExisteExcepcion;
import bo.edu.uagrm.ficct.rubencano.Excepciones.OrdenInvalidoExcepcion;

import java.util.Stack;

public class ArbolB<K extends Comparable<K>, V> extends ArbolMViasBusqueda<K,V> {

    private final int NRO_MINIMO_HIJOS;
    private final int NRO_MINIMO_DATOS;
    private final int NRO_MAXIMO_HIJOS;
    private final int NRO_MAXIMO_DATOS;
    private final int POSICION_INVALIDAD = -1;
    private final int VAL_MEDIO = (orden -1) / 2;

    public ArbolB (int orden) throws OrdenInvalidoExcepcion {
        super(orden);
        this.NRO_MAXIMO_HIJOS = orden;
        this.NRO_MAXIMO_DATOS = orden -1;
        this.NRO_MINIMO_DATOS = NRO_MAXIMO_DATOS / 2;
        this.NRO_MINIMO_HIJOS = NRO_MINIMO_DATOS +1;
    }

    @Override
    public void insertar(K claveAInsertar, V valorAInsertar) {
        if (super.esArbolVacio()){
            super.raiz = new NodoMVias<>(super.orden +1, claveAInsertar, valorAInsertar);
            return;
        }
        Stack<NodoMVias<K,V>> ramaHastaHoja = new Stack<>();
        NodoMVias<K,V> nodoActual = this.raiz;
        int posABajar;
        while (!NodoMVias.esNodoVacio(nodoActual)){
            ramaHastaHoja.add(nodoActual);
            posABajar = buscarPosicionPorDondeBajar(nodoActual, claveAInsertar);
            if (NodoMVias.esNodoVacio(nodoActual) && claveAInsertar.compareTo(nodoActual.getClave(posABajar)) == 0){
                nodoActual.setValor(posABajar,valorAInsertar);
                return;
            }
            nodoActual = nodoActual.getHijo(posABajar);
        }
        insertarDatoNodoOrdenadamente(ramaHastaHoja.peek(),claveAInsertar, valorAInsertar,
                NodoMVias.nodoVacio());
        dividir(ramaHastaHoja);
    }

    private void dividir(Stack<NodoMVias<K, V>> ramaActual) {
        NodoMVias<K,V> nodoActual = ramaActual.pop();
        if (nodoActual.nroDeClavesNoVacias() <= NRO_MAXIMO_DATOS){
            return;
        }
        K claveASubir = nodoActual.getClave(VAL_MEDIO);
        V valorASubir = nodoActual.getValor(VAL_MEDIO);
        if (nodoActual == raiz){
            NodoMVias<K,V> nuevoNodo = new NodoMVias<>(orden +1, claveASubir, valorASubir);
            NodoMVias<K,V> parteDerecha = new NodoMVias<>(orden +1);
            partirHaciaDerecha(nodoActual, parteDerecha);
            nuevoNodo.setHijo(0, nodoActual);
            nuevoNodo.setHijo(1, parteDerecha);
            this.raiz = nuevoNodo;
            return;
        }
        NodoMVias<K,V> nodoPadre = ramaActual.peek();
        NodoMVias<K,V> parteDerecha = new NodoMVias<>(orden +1);
        partirHaciaDerecha(nodoActual, parteDerecha);
        insertarDatoNodoOrdenadamente(nodoPadre, claveASubir, valorASubir, parteDerecha);
        dividir(ramaActual);
    }

    private void partirHaciaDerecha(NodoMVias<K, V> nodoActual, NodoMVias<K, V> parteDerecha) {
        int i = 0;
        int j;
        // coloca en la parte derecha los valores correctos del nodoActual
        for (j = VAL_MEDIO +1; j < orden; j++){
            parteDerecha.setClave(i, nodoActual.getClave(j));
            parteDerecha.setValor(i, nodoActual.getValor(j));
            parteDerecha.setHijo(i, nodoActual.getHijo(j));
            i++;
        }
        parteDerecha.setHijo(i, nodoActual.getHijo(j));
        // elimina la parte derecha del nodo actual
        for (j = VAL_MEDIO; j < orden; j++){
            nodoActual.setClave(j, (K) NodoMVias.datoVacio());
            nodoActual.setValor(j, (V) NodoMVias.datoVacio());
            nodoActual.setHijo(j +1, NodoMVias.nodoVacio());
        }
    }

    private void dividir(NodoMVias<K, V> nodoActual, Stack<NodoMVias<K,V>> pilaDeAnsestros) {
        final int POS_MEDIANA = NRO_MAXIMO_DATOS / 2;
        NodoMVias<K,V> nodoParteDerecha = new NodoMVias<>(super.orden);
        int j = 0;
        int i = 0;
        K claveMedio = nodoActual.getClave(POS_MEDIANA);
        V valorMedio = nodoActual.getValor(POS_MEDIANA);

        for (i = POS_MEDIANA +1; i < NRO_MAXIMO_HIJOS; i++){
            nodoParteDerecha.setClave(j, nodoActual.getClave(i));
            nodoParteDerecha.setValor(j, nodoActual.getValor(i));
            nodoParteDerecha.setHijo(j, nodoActual.getHijo(i));
            j++;
        }
        nodoParteDerecha.setHijo(j, nodoActual.getHijo(i));
        // elimina las referencias del nodo actual que ya no sirven como el nodo izquierdo
        for (i = POS_MEDIANA; i < NRO_MAXIMO_HIJOS; i++){
            nodoParteDerecha.setClave(i, (K) NodoMVias.datoVacio());
            nodoParteDerecha.setValor(i, (V) NodoMVias.datoVacio());
            nodoParteDerecha.setHijo(i + 1, NodoMVias.nodoVacio());
        }
        if (nodoActual == super.raiz){
            NodoMVias<K,V> nuevoNodo = new NodoMVias<>(super.orden);
            // colocamos los valores de llevara el nuevo nodo
            nodoParteDerecha.setClave(0, claveMedio);
            nodoParteDerecha.setValor(0, valorMedio);
            nodoParteDerecha.setHijo(0, nodoActual);
            nodoParteDerecha.setHijo(1, nodoParteDerecha);

            // la raiz ahora es el nuevo nodo
            super.raiz = nuevoNodo;
        }else {
            NodoMVias<K,V> nodoPadre = pilaDeAnsestros.pop();
            insertarDatoNodoOrdenadamente(nodoPadre, claveMedio, valorMedio,nodoParteDerecha);
            if (nodoPadre.nroDeClavesNoVacias() > NRO_MAXIMO_DATOS){
                dividir(nodoPadre, pilaDeAnsestros);
            }
        }
    }

    private void insertarDatoNodoOrdenadamente(NodoMVias<K, V> nodoActual, K claveAInsertar,
                                               V valorAInsertar, NodoMVias hijoDerecho) {
        int i =0;
        //identifico donde voy a insertar el nodo en el nodo(posicion)
        while (nodoActual.getClave(i) != NodoMVias.datoVacio()
                && claveAInsertar.compareTo(nodoActual.getClave(i)) > 0){
            i++;
        }
        // empujo los valores e hijos hacia adelante
        int l= nodoActual.nroDeClavesNoVacias() -1;
        for (int j = l; j >= i; j--){
            nodoActual.setClave(j+1, nodoActual.getClave(j));
            nodoActual.setValor(j+1, nodoActual.getValor(j));
        }
        for (int j = l+1; j >= i +1; j--){
            nodoActual.setHijo(j+1, nodoActual.getHijo(j));
        }
        // al fin inserto los valores
        nodoActual.setClave(i, claveAInsertar);
        nodoActual.setValor(i, valorAInsertar);
        nodoActual.setHijo(i+1, hijoDerecho);
    }

    @Override
    public V eliminar(K claveAEliminar) throws ClaveNoExisteExcepcion {
        if (claveAEliminar == NodoMVias.datoVacio()){
            throw new IllegalArgumentException("La clave a eliminar no puede ser nuela");
        }
        Stack<NodoMVias<K,V>> pilaDeAncestros = new Stack<>();
        NodoMVias<K,V> nodoActual = this.buscarNodoClave(claveAEliminar, pilaDeAncestros);

        if (NodoMVias.esNodoVacio(nodoActual)){
            throw new IllegalArgumentException("La clave no existe en el arbol");
        }
        int posicionDeLaClaveEnElNodo = super.buscarPosicionPorDondeBajar(nodoActual, claveAEliminar);
        V valorARetornar = nodoActual.getValor(posicionDeLaClaveEnElNodo);

        if (nodoActual.esHoja()){
            eliminarDatosDelNodo(nodoActual, posicionDeLaClaveEnElNodo);
            if (nodoActual.nroDeClavesNoVacias() < this.NRO_MINIMO_DATOS) {
                if (pilaDeAncestros.isEmpty()){
                    if (nodoActual.nroDeClavesNoVacias() == 0){
                        super.vaciar();
                    }
                } else {
                    this.prestarseOFusionar(nodoActual, pilaDeAncestros);
                }
            }
        }else {
            // creo que no funciona
            pilaDeAncestros.push(nodoActual);
            NodoMVias<K,V> nodoDelPredecesor = this.buscarNodoDelPredecesor(pilaDeAncestros,
                                                nodoActual.getHijo(posicionDeLaClaveEnElNodo));
            int posicionDelPredecesor = nodoDelPredecesor.nroDeClavesNoVacias() -1;
            K clavePredecesora = nodoDelPredecesor.getClave(posicionDelPredecesor);
            V valorPredecesor = nodoDelPredecesor.getValor(posicionDelPredecesor);
            if (nodoDelPredecesor.nroDeClavesNoVacias() < this.NRO_MINIMO_DATOS){
                this.prestarseOFusionar(nodoDelPredecesor, pilaDeAncestros);
            }
        }
        return valorARetornar;
    }

    private NodoMVias<K, V> buscarNodoDelPredecesor(Stack<NodoMVias<K, V>> pilaDeAncestros,
                                                    NodoMVias<K, V> nodoSalida) {
        NodoMVias<K,V> nodoActual = nodoSalida;
        while (!NodoMVias.esNodoVacio(nodoActual)){
            pilaDeAncestros.push(nodoActual);
            nodoActual = nodoActual.getHijo(nodoActual.nroDeClavesNoVacias());
        }
        nodoActual = pilaDeAncestros.pop();
        return nodoActual;
    }

    private void eliminarDatosDelNodo(NodoMVias<K, V> nodoActual,
                                      int posDatoAEliminar) {
        int i;
        for (i = posDatoAEliminar; i < nodoActual.nroDeClavesNoVacias(); i++){
            nodoActual.setClave(i, nodoActual.getClave(i + 1));
            nodoActual.setValor(i, nodoActual.getValor(i + 1));
            nodoActual.setHijo(i, nodoActual.getHijo(i + 1));
        }
        nodoActual.setClave(i, (K) NodoMVias.datoVacio());
        nodoActual.setValor(i, (V) NodoMVias.datoVacio());
        nodoActual.setHijo(i,  nodoActual.getHijo(i +1));
        nodoActual.setHijo(i, NodoMVias.nodoVacio());
    }

    private void prestarseOFusionar(NodoMVias<K, V> nodoActual, Stack<NodoMVias<K, V>> pilaDeAncestros) {
        NodoMVias<K,V> nodoPadre = pilaDeAncestros.peek();
        NodoMVias<K,V> nodoHermanoIzq = NodoMVias.nodoVacio();
        NodoMVias<K,V> nodoHermanoDer = NodoMVias.nodoVacio();
        int posBajoElPadre = 0;

        while (nodoPadre.getHijo(posBajoElPadre) != nodoActual){
            posBajoElPadre++;
        }
        if (posBajoElPadre +1 < nodoPadre.nroDeClavesNoVacias() +1){
            nodoHermanoDer = nodoPadre.getHijo(posBajoElPadre +1);
        }
        if (0 < nodoPadre.nroDeClavesNoVacias() -1){
            nodoHermanoIzq = nodoPadre.getHijo(posBajoElPadre -1);
        }

        if (nodoHermanoDer != NodoMVias.nodoVacio() &&
                nodoHermanoDer.nroDeClavesNoVacias() > NRO_MINIMO_DATOS){
            // se coloca en la ultima posicion del nodoActual el valor a bajar del padre
            int lim = nodoActual.nroDeClavesNoVacias();
            nodoActual.setClave(lim, nodoPadre.getClave(posBajoElPadre));
            nodoActual.setValor(lim, nodoPadre.getValor(posBajoElPadre));
            lim++;
            // sube el valor del hermano derecho al padre
            nodoPadre.setClave(posBajoElPadre, nodoHermanoDer.getClave(0));
            nodoPadre.setValor(posBajoElPadre, nodoHermanoDer.getValor(0));
            // el primer hijo del hermano derecho pasa a ser el ultimo del nodo actual
            nodoActual.setHijo(lim, nodoHermanoDer.getHijo(0));
            // se recorren los valores e hijos del hermano derecho en -1
            lim = nodoHermanoDer.nroDeClavesNoVacias();
            int i;
            for (i =0; i < lim; i++){
                nodoHermanoDer.setClave(i, nodoHermanoDer.getClave(i+1));
                nodoHermanoDer.setValor(i, nodoHermanoDer.getValor(i+1));
                nodoHermanoDer.setHijo(i, nodoHermanoDer.getHijo(i+1));
            }
            nodoHermanoDer.setHijo(i, nodoHermanoDer.getHijo(i +1));
            return;
        }
        if (nodoHermanoIzq != NodoMVias.nodoVacio() &&
                nodoHermanoIzq.nroDeClavesNoVacias() > NRO_MINIMO_DATOS) {
            //se recorren los valores del nodo actual +1
            int lim = nodoActual.nroDeClavesNoVacias();
            int i;
            for (i = lim; i < 0; i++) {
                nodoActual.setClave(i, nodoActual.getClave(i+1));
                nodoActual.setValor(i, nodoActual.getValor(i+1));
                nodoActual.setHijo(i, nodoActual.getHijo(i+1));
            }
            nodoActual.setHijo(i, nodoActual.getHijo(i+1));
            //se coloca en la posicion 0 el valor que baja
            nodoActual.setClave(0, nodoPadre.getClave(posBajoElPadre-1));
            nodoActual.setValor(0, nodoPadre.getValor(posBajoElPadre-1));
            //se sube el ultimo valor del hermano izquierdo
            lim = nodoHermanoIzq.nroDeClavesNoVacias();
            nodoPadre.setClave(posBajoElPadre-1, nodoHermanoIzq.getClave(lim-1));
            nodoPadre.setValor(posBajoElPadre-1, nodoHermanoIzq.getValor(lim-1));
            //se elimina el ultimo valor del hermano izquierdo
            nodoHermanoIzq.setClave(lim-1, (K) NodoMVias.datoVacio());
            nodoHermanoIzq.setValor(lim-1, (V) NodoMVias.datoVacio());
            //se coloca en el hijo 0 del nodo actual el hijo despues del
            nodoActual.setHijo(0, nodoHermanoIzq.getHijo(lim));
            //se elimina el ultimo hijo del hermano izquierdo
            nodoHermanoIzq.setHijo(lim, NodoMVias.nodoVacio());
            return;
        }
        if(nodoHermanoDer != NodoMVias.nodoVacio()){
            fusionConElDeAdelante(nodoActual, pilaDeAncestros);
        }else{
            fusionConElDeAtras(nodoActual, pilaDeAncestros);
        }
    }

    private void fusionConElDeAdelante(NodoMVias<K, V> nodoActual, Stack<NodoMVias<K, V>> pilaDeAncestros) {
        if (nodoActual.nroDeClavesNoVacias() > NRO_MINIMO_DATOS){
            return;
        }
        NodoMVias<K,V> nodoPadre = pilaDeAncestros.peek();
        int posNodoActualEnElPadre = buscarPosNodoHijo(nodoPadre, nodoActual);
        NodoMVias<K,V> hermanoIzq = nodoActual;
        K claveABajar = nodoPadre.getClave(posNodoActualEnElPadre);
        V valorABajar = nodoPadre.getValor(posNodoActualEnElPadre);
        int ultimaPosVaciaHermanoIzq = hermanoIzq.nroDeClavesNoVacias();
        NodoMVias<K,V> hermanoDer = nodoPadre.getHijo(posNodoActualEnElPadre +1);

        hermanoIzq.setClave(ultimaPosVaciaHermanoIzq, claveABajar);
        hermanoIzq.setValor(ultimaPosVaciaHermanoIzq, valorABajar);
        ultimaPosVaciaHermanoIzq++;
        int i =0;
        int limNodoHemanoDerecho = hermanoDer.nroDeClavesNoVacias();
        for (i = 0; i < limNodoHemanoDerecho; i++){
            hermanoIzq.setClave(ultimaPosVaciaHermanoIzq, hermanoDer.getClave(i));
            hermanoIzq.setValor(ultimaPosVaciaHermanoIzq, hermanoDer.getValor(i));
            hermanoIzq.setHijo(ultimaPosVaciaHermanoIzq, hermanoDer.getHijo(i));
            ultimaPosVaciaHermanoIzq++;
        }
        hermanoIzq.setHijo(ultimaPosVaciaHermanoIzq, hermanoDer.getHijo(i));
        int limNodoPadre = nodoPadre.nroDeClavesNoVacias();
        for (i = posNodoActualEnElPadre; i < limNodoPadre; i++){
            nodoPadre.setClave(i, nodoPadre.getClave(i +1));
            nodoPadre.setValor(i, nodoPadre.getValor(i +1));
            nodoPadre.setHijo(i +1, nodoPadre.getHijo(i +2));
        }
        nodoPadre.setHijo(posNodoActualEnElPadre +1, hermanoDer);
        nodoPadre.setHijo(posNodoActualEnElPadre, hermanoIzq);
        prestarseOFusionar(pilaDeAncestros.pop(), pilaDeAncestros);
    }

    private void fusionConElDeAtras(NodoMVias<K, V> nodoActual, Stack<NodoMVias<K, V>> pilaDeAncestros) {
        if(nodoActual.nroDeClavesNoVacias() > NRO_MINIMO_DATOS){
            return;
        }
        NodoMVias<K, V> nodoPadre = pilaDeAncestros.peek();
        int posNodoActualEnElPadre = buscarPosNodoHijo(nodoPadre, nodoActual);
        NodoMVias<K, V> hermanoIzquierdo = nodoPadre.getHijo(posNodoActualEnElPadre - 1);
        K claveABajar = nodoPadre.getClave(posNodoActualEnElPadre-1);
        V ValorABajar = nodoPadre.getValor(posNodoActualEnElPadre-1);
        eliminarDatosDelNodo(nodoPadre, posNodoActualEnElPadre-1);
        int ultimaPosVaciaHermanoIzquierdo = hermanoIzquierdo.nroDeClavesNoVacias();
        NodoMVias<K, V>hermanoDerecho = nodoActual;

        hermanoIzquierdo.setClave(ultimaPosVaciaHermanoIzquierdo, claveABajar);
        hermanoIzquierdo.setValor(ultimaPosVaciaHermanoIzquierdo, ValorABajar);
        ultimaPosVaciaHermanoIzquierdo++;
        int i;
        int limNodoHermanoDerecho = hermanoDerecho.nroDeClavesNoVacias();
        for (i = 0; i < limNodoHermanoDerecho; i++) {
            hermanoIzquierdo.setClave(ultimaPosVaciaHermanoIzquierdo, hermanoDerecho.getClave(i));
            hermanoIzquierdo.setValor(ultimaPosVaciaHermanoIzquierdo, hermanoDerecho.getValor(i));
            hermanoIzquierdo.setHijo(ultimaPosVaciaHermanoIzquierdo, hermanoDerecho.getHijo(i));
            ultimaPosVaciaHermanoIzquierdo++;
        }
        hermanoIzquierdo.setHijo(ultimaPosVaciaHermanoIzquierdo, hermanoDerecho.getHijo(i));
        int limNodoPadre = nodoPadre.nroDeClavesNoVacias();
        for (i = posNodoActualEnElPadre; i < limNodoPadre; i++) {
            nodoPadre.setClave(i, nodoPadre.getClave(i+1));
            nodoPadre.setValor(i, nodoPadre.getValor(i+1));
            nodoPadre.setHijo(i+1, nodoPadre.getHijo(i+2));
        }
        nodoPadre.setHijo(posNodoActualEnElPadre, hermanoDerecho);
        nodoPadre.setHijo(posNodoActualEnElPadre - 1, hermanoIzquierdo);
        prestarseOFusionar(pilaDeAncestros.pop(), pilaDeAncestros);
    }

    private int buscarPosNodoHijo(NodoMVias<K, V> nodoPadre, NodoMVias<K, V> nodoActual) {
        int limNodoPadre = nodoPadre.nroDeClavesNoVacias();
        for (int i = 0; i <= limNodoPadre; i++) {
            if (nodoPadre.getHijo(i) == nodoActual){
                return i;
            }
        }
        return -1;
    }

    private NodoMVias<K, V> buscarNodoClave(K claveABuscar, Stack<NodoMVias<K, V>> pilaDeAncestros) {
        return buscarNodoClave(claveABuscar, super.raiz, pilaDeAncestros);
    }

    private NodoMVias<K, V> buscarNodoClave(K claveABuscar, NodoMVias<K, V> nodoActual, Stack<NodoMVias<K, V>> pilaDeAncestros) {
        int posABajar = super.buscarPosicionPorDondeBajar(nodoActual, claveABuscar);
        if (claveABuscar.compareTo(nodoActual.getClave(posABajar)) == 0){
            return nodoActual;
        }else {
            pilaDeAncestros.add(nodoActual);
            return buscarNodoClave(claveABuscar, nodoActual.getHijo(posABajar), pilaDeAncestros);
        }
    }


}
