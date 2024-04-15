import ListaDoble.ListaD;

public class TestListaD {

    public static void main(String[] args) {

        ListaD L1 = new ListaD();
        ListaD L2 = new ListaD();
        ListaD L3 = new ListaD();

        L1.insertarUlt(7);
        L1.insertarUlt(4);
        L1.insertarUlt(5);
        L1.insertarUlt(6);
        L1.insertarUlt(7);

        L2.insertarUlt(9);
        L2.insertarUlt(8);
        L2.insertarUlt(7);
        L2.insertarUlt(2);

        L3.insertarUlt(2);
        L3.insertarUlt(3);
        L3.insertarUlt(5);
        L3.insertarUlt(7);

        System.out.println("L1->"+ L1);
        System.out.println("L2->"+ L2);
        System.out.println("L3->"+ L3);
        System.out.println("Diferentes: "+L1.diferentes());
        System.out.println("ElemMayor: " + L1.mayorElem());
        L1.reemplazar(7,9);
        System.out.println("Reemplazar: " + L1);
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
    }
}
