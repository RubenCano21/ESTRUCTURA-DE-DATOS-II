package bo.edu.uagrm.ficct.rubencano.ui;

import bo.edu.uagrm.ficct.rubencano.Excepciones.ClaveNoExisteExcepcion;
import bo.edu.uagrm.ficct.rubencano.Excepciones.OrdenInvalidoExcepcion;
import bo.edu.uagrm.ficct.rubencano.arboles.ArbolB;
import bo.edu.uagrm.ficct.rubencano.arboles.IArbolBusqueda;

public class TestArbolB {

    public static void main(String[] args) throws OrdenInvalidoExcepcion, ClaveNoExisteExcepcion {

        IArbolBusqueda<Integer, String> arbolB = new ArbolB<>(4);

        arbolB.insertar(300, "A");
        arbolB.insertar(500, "B");
        arbolB.insertar(100, "C");
        arbolB.insertar(50, "D");
        arbolB.insertar(400, "E");
        arbolB.insertar(800, "F");
        arbolB.insertar(90, "G");
        arbolB.insertar(91, "H");
        arbolB.insertar(70, "I");
        arbolB.insertar(75, "J");
        arbolB.insertar(99, "K");

        System.out.println("Recorrido en InOrden: "+ arbolB.recorridoEnInOrden());
        System.out.println("Recorrido en PreOrden: "+ arbolB.recorridoEnPreOrden());
        System.out.println("Recorrido en PostOrden: "+ arbolB.recorridoEnPostOrden());
        System.out.println("Recorrido por Niveles: "+ arbolB.recorridoPorNiveles());

        System.out.println("\nOTROS METODOS");
        System.out.println("Es arbol vacio: "+arbolB.esArbolVacio());
        System.out.println("Altura del arbol: "+ arbolB.altura());
        System.out.println("Size: " + arbolB.size());
        System.out.println("Eliminar clave: " +arbolB.eliminar(50));
        System.out.println("Recorrido en InOrden: "+ arbolB.recorridoEnInOrden());
    }
}
