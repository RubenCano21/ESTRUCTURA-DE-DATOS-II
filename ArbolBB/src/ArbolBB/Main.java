package ArbolBB;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Arbol A1 = new Arbol();

        A1.insertar(50);
        A1.insertar(80);
        A1.insertar(20);
        A1.insertar(70);
        A1.insertar(90);
        A1.insertar(10);
        A1.insertar(40);

//        System.out.println("PreOrden");
//        A1.preOrden();
//        System.out.println("\ninOrden");
        A1.inOrden();
//        System.out.println("\nPostOrden");
//        A1.postOrden();
//        System.out.println("\n-------------------------------------");
//
//
//        System.out.println("SeEncuentra: "+ A1.seEncuentra(12));
//        System.out.println("cantidad: "+ A1.cantidad());
//        System.out.println("suma: "+ A1.suma());
//        System.out.println("menor: "+ A1.menor());
//        System.out.println("mayor: "+ A1.mayor());
//        System.out.println("CantidadTerm: "+ A1.cantidadTerm());
//        System.out.println("SumaPares: "+ A1.sumaPares());

//        List<Integer> list = new ArrayList<>();
//
//        list = A1.generarElem(5,10,50);
//        System.out.println(list);
//
////        A1.insertarX(list.get(1));
////        A1.insertarX(list.get(2));
////        A1.insertarX(list.get(3));
////        A1.insertarX(list.get(4));
////        A1.insertarX(list.get(5));
//
//        System.out.println("InOrden: ");
//        A1.inOrden();
//        System.out.println("");
//        A1.desc();
//        System.out.println("\nSe encuentra: "+A1.SeEncuentra(10));
//        System.out.println("Cantidad: "+A1.Cantidad());
//        System.out.println("Suma: "+A1.Suma());
//        System.out.println("Menor: "+A1.Menor());
//        System.out.println("Lineal: "+A1.lineal());
//        System.out.println("inmediatoSup: "+A1.inmediatoSup(15));
//        System.out.println("inmediatoInf: "+A1.inmediatoInf(15));
//        A1.mostrarTerm();
//        System.out.println("\nMostrarNivel: ");
//        A1.mostrarNivel(2);
    }
}