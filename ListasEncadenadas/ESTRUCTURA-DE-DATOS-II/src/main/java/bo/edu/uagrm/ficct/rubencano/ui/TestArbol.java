package bo.edu.uagrm.ficct.rubencano.ui;

import bo.edu.uagrm.ficct.rubencano.arboles.ArbolBinarioBusqueda;

public class TestArbol {

    public static void main(String[] args) {

        ArbolBinarioBusqueda<Integer,String> arbolPrueba = new ArbolBinarioBusqueda<>();

        /*Scanner entrada= new Scanner(System.in);
        System.out.println("elija el tipo de arbol,ABB, AVL");


        String tipoDeArbol=entrada.next();
        tipoDeArbol=tipoDeArbol.toUpperCase();
        switch(tipoDeArbol){

            case("ABB"):
                arbolPrueba=new ArbolBinarioBusqueda<>();
                break;

            case("AVL"):
                arbolPrueba=new ArbolAVL<>();
                break;

            default:
                System.out.println("tipo de arbol invaldo, escogiendo.. arbol binario de Mvias");
                arbolPrueba=new ArbolBinarioBusqueda<>();
        }*/

        arbolPrueba.insertar(20, "cristian soza");
        arbolPrueba.insertar(7, "julio gonzales");
        arbolPrueba.insertar(23, "llanos");
        arbolPrueba.insertar(9, "mario");
        arbolPrueba.insertar(11, "armando");
        arbolPrueba.insertar(25, "julia");
        arbolPrueba.insertar(4, "berta");
        arbolPrueba.insertar(3, "marcela");
        arbolPrueba.insertar(22, "carol");
        arbolPrueba.insertar(10, "valeria");
        arbolPrueba.insertar(8, "valeria");
        arbolPrueba.insertar(24, "valeria");
        arbolPrueba.insertar(50, "valeria");
        arbolPrueba.insertar(100, "valeria");
        arbolPrueba.insertar(35, "valeria");

        arbolPrueba.insertar(5, "valeria");
        //arbolPrueba.insertar(12, "valeria");

        //System.out.println(arbolPrueba.mostrarArbol());
        //System.out.println(arbolPrueba.mostrarArbol());
        System.out.println("Recorrido en InOrden: "+arbolPrueba.recorridoEnInOrden());
        System.out.println("Recorrido en PreOrden: " + arbolPrueba.recorridoEnPreOrden());
        System.out.println("Recorrido en PostOrden: " + arbolPrueba.recorridoEnPostOrden());
        System.out.println("Recorrido por Niveles: " + arbolPrueba.recorridoPorNiveles());

        System.out.println("\nMETODOS RECURSIVOS\n");
        System.out.println("Recorrido en InOrden Rec:"+arbolPrueba.recorridoEnInOrdenRecursivo());
        System.out.println("Recorrido en PreOrden Rec: " + arbolPrueba.recorridoEnPreOrdenRecursivo());
        System.out.println("Recorrido en PostOrden Rec: " + arbolPrueba.recorridoEnPostOrdenRecursivo());

        System.out.println("altura: "+arbolPrueba.altura());
        System.out.println("nivel: "+arbolPrueba.nivel());
        System.out.println(arbolPrueba.cantidadDeHijosDerechos());
        System.out.println("Cantidad solo hijos Izq Rec: " + arbolPrueba.cantidadNodosSoloHijoIzqRec());
        System.out.println("Cantidad solo hijos Izq Ite: " + arbolPrueba.cantidadDeNodosSoloHijoIzquierdo());
        System.out.println("Cantidad de hijos Izq en nivel: " + arbolPrueba.cantidadDeHijosIzquierdoEnNivel(2));
        System.out.println("Cantidad de hijos Izq despues de nivel:" + arbolPrueba.cantidadDeHijosIzquierdoDespuesDeNivel(2));
        System.out.println("Cantidad de hijos Izq Antes de nivel:" + arbolPrueba.cantidadDeHijosIzquierdoAntesDeNivel(2));
        System.out.println("Son arboles similares?: " +arbolPrueba.arbolSimilar(arbolPrueba));
        System.out.println("Cantidad de ambos hijos en un nivel: " + arbolPrueba.cantidadNodosAmbosHijos(1));
        System.out.println("Es el arbol lleno?: " + arbolPrueba.arbolEstaLleno());
        System.out.println("Arbol invertido: " + arbolPrueba.arbolInvertido());
        System.out.println("Tienen nodos completos: "+arbolPrueba.tieneNodosCompletosEnNivel(2));
        System.out.println("Cantidad de hojas en el Arbol: " + arbolPrueba.contarHojas());
        System.out.println("Cantidad de hojas en el Arbol en nivel: " + arbolPrueba.contarHojasEnNivel(1));

        //System.out.println("Recorrido por Niveles: " + arbolPrueba.recorridoPorNiveles());
       /* IArbolBusqueda<Integer, String> arbolPrueba = new ArbolBinarioBusqueda<>();

        arbolPrueba.insertar(50,"Azul");
        arbolPrueba.insertar(78,"Naranja");
        arbolPrueba.insertar(74,"Zapato");
        arbolPrueba.insertar(30,"Jeans");
        arbolPrueba.insertar(44,"Amarillo");
        arbolPrueba.insertar(20,"Negro");
        arbolPrueba.insertar(25,"Cafe");
        arbolPrueba.insertar(24,"Camisa");
        arbolPrueba.insertar(23,"Mesa");
        arbolPrueba.insertar(28,"TV");
        */


    }
}
