import ListaSimple.ListaS;

public class TestListaS {

    public static void main(String[] args) {
        ListaS L1 = new ListaS();
        ListaS L2 = new ListaS();
        ListaS L3 = new ListaS();

//        L1.insertarPrim(1);
//        L1.insertarUlt(2);
//        L1.insertarUlt(5);
//        L1.insertarUlt(4);
//        L1.insertarUlt(9);
//        L1.insertarUlt(6);

        L3.insertarUlt(3);
        L3.insertarUlt(3);
        L3.insertarUlt(2);
        L3.insertarUlt(5);

        L2.insertarUlt(6);
        L2.insertarUlt(7);
        L2.insertarUlt(8);
        L2.insertarUlt(9);

        //System.out.println("L1-> "+L1.toString());
        System.out.println("L2-> "+L2.toString());
        System.out.println("L3-> "+L3.toString());
//        L1.reemplazar(2,7);
//        System.out.println(L1.toString());
//        System.out.println(L1.frecuencia(5));
//        System.out.println("Son iguales: " + L1.iguales());
//        System.out.println("Se encuentra: " + L1.seEncuentra(9));

        //L1.insertarUlt(L2);
       // L1.insertarLugar(6);
       // System.out.println("InsertarLugar "+L1.toString());
//        System.out.println("Diferentes: "+L1.diferentes());
//        System.out.println("Mayor L1: "+L1.mayorElem());
//        System.out.println("OrdenadoAsc L1: "+L1.ordenadoAsc());
//        System.out.println("Ordenado L2: "+L2.ordenado());
//        System.out.println("Pares L1: "+L1.pares());
//        System.out.println("ParImpar L1: "+L1.parImpar());
//        System.out.println("ExisteFrec L1: "+L1.existeFrec(2));
//        System.out.println("MismaFrec L1: "+L1.mismaFrec());
//        System.out.println("Poker L1: "+L1.poker());
//        System.out.println("ExistePar L1: "+L1.existePar());
//        System.out.println("TodosPares L1: "+L1.todoPares());
//        System.out.println("TodosImpares L1: "+L1.todoImpares());
//        System.out.println("Alternos L1: "+L1.alternos());
        L1.intercalar(L2, L3);
        System.out.println("Intercalar L2 y L3: " + L1);
    }
}
