import ListaDoble.ListaD;

public class TestListaD {

    public static void main(String[] args) {

        ListaD L1 = new ListaD();
        ListaD L2 = new ListaD();
        ListaD L3 = new ListaD();

        L1.insertarUlt(1);
        L1.insertarUlt(2);
        L1.insertarUlt(5);
        L1.insertarUlt(4);
        L1.insertarUlt(7);

//        L2.insertarUlt(9);
//        L2.insertarUlt(8);
//        L2.insertarUlt(7);
//        L2.insertarUlt(2);
//
//        L3.insertarUlt(2);
//        L3.insertarUlt(3);
//        L3.insertarUlt(5);
//        L3.insertarUlt(7);

        System.out.println("L1->"+ L1);
//        System.out.println("L2->"+ L2);
//        System.out.println("L3->"+ L3);
//        System.out.println("Diferentes: "+L1.diferentes());
//        System.out.println("ElemMayor: " + L1.mayorElem());
//        L1.reemplazar(7,9);
//        System.out.println("Reemplazar: " + L1);
//        System.out.println("Frecuencia: " + L1.frecuencia(1));
//        System.out.println("ExisteFrecuencia: " + L1.existeFrec(3));
//        System.out.println("Poker: " + L1.poker());
//        System.out.println("ExistePar : " + L1.existePar());
//        System.out.println("ExisteImpar : " + L1.existeImpar());
//        System.out.println("TodosPares : " + L1.todosPares());
//        System.out.println("TodosImpares : " + L1.todosImpares());
//        System.out.println("ExisteParImpar : " + L1.existeParImpar());
//        System.out.println("Alternos : " + L1.alternos());
//        System.out.println("Palindromo : " + L1.palindrome());
//        L1.invertir();
//        System.out.println("Invertir : " + L1);
        //L1.insertarPrim(L2);
        //L1.insertarUlt(L2);
//        L1.insertarAsc(2);
//        System.out.println("L1"+ L1);
//        L2.insertarDesc(5);
//        System.out.println("L2-> "+ L2);
//        L1.concatenar(L2, L3);
//        System.out.println("L1"+ L1);
//        L1.insertarIesimo(L2, 1);
//        System.out.println("L1"+ L1);
        //L1.concatenar(L2,L3);
//        L1.intercalar(L2,L3);
//        System.out.println("Concatenar: "+L1);
//        L1.eliminarPrim();
//        System.out.println("EliminarPrim: " + L1);
//        L1.eliminarUlt();
//        System.out.println("EliminarUlt: " + L1);
//        L1.eliminarIesimo(2);
//        System.out.println("EliminarIesimo: " + L1);
//        L1.eliminarPrim(2);
//        System.out.println("EliminarPrim(n): " + L1);
//        L1.eliminarUlt(2);
//        System.out.println("EliminarUlt(n): " + L1);
//        L1.eliminarTodo(2);
//        System.out.println("EliminarUlt(n): " + L1);
//        L1.eliminarIesimo(2, 2);
//        System.out.println("EliminarIesimo(i, n): " + L1);
//        L1.eliminarExtremos( 1);
//        System.out.println("EliminarExtremos( n): " + L1);
        L1.eliminarPares();
        System.out.println("Eliminarpares(): " + L1);
    }
}
