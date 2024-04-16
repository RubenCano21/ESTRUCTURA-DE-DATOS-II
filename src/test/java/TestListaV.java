import ListasVectores.ListaV;

public class TestListaV {
    public static void main(String[] args) {

        ListaV L1 = new ListaV();
        ListaV L2 = new ListaV();
        ListaV L3 = new ListaV();

        L1.insertarUlt(2);
        L1.insertarUlt(3);
        L1.insertarUlt(4);
        L1.insertarUlt(2);
        L1.insertarUlt(7);
        L1.insertarUlt(8);

        L2.insertarUlt(4);
        L2.insertarUlt(7);
        L2.insertarUlt(9);
        L2.insertarUlt(3);

        L3.insertarUlt(2);
        L3.insertarUlt(5);
        L3.insertarUlt(7);
        L3.insertarUlt(6);

        System.out.println("L1-> " +L1.toString());
        System.out.println("L2-> " +L2.toString());
        System.out.println("L3-> " +L3.toString());
        //System.out.println("Menor: " + L1.menor());
//        L1.eliminarIesimo(2);
//        System.out.println(L1.toString());
//        L1.insertarIesimo(5,3);
//        L1.insertarPrim1(1);
//        System.out.println("L1-> " +L1);
//        L1.insertarUlt1(21);
//        System.out.println("L1-> " +L1);
//        L1.eliminarPrim1();
//        System.out.println("L1-> " +L1);
//        L1.eliminarUlt1();
//        System.out.println("L1-> " +L1);
//        L1.eliminarTodo(2);
//        System.out.println("L1-> " +L1);
//        L1.eliminarPares();
//        System.out.println("EliminarPares: " +L1);
//        L1.eliminarUnicos();
//        System.out.println("EliminarUnicos: " +L1);
//        L1.eliminarTodo(L2);
//        System.out.println("EliminarTodos: " +L1);
//        L1.pasarDigitos(2354212);
//        System.out.println("PasarDigitos: " +L1);
//        L1.rotarIzqDer(2);
//        System.out.println("RotarIzqDer: " +L1);
//        L1.rotarDerIzq(2);
//        System.out.println("RotarDerIzq: " +L1);
//        L1.eliminarPrim(6);
//        System.out.println("EliminarPrim(n): " +L1);
//        L1.eliminarUlt(6);
//        System.out.println("EliminarUlt(n): " +L1);
//        L1.insertarIesimo(L2,3);
//        System.out.println("EliminarUlt(n): " +L1);
//        L1.insertarLugasAsc(5);
//        System.out.println("InsertarLugarAsc: " +L1);
//        L1.comunes(L2, L3);
//        System.out.println("Comunes: " +L1);
//        L1.intercalar(L2, L3);
//        System.out.println("Comunes: " +L1);

        System.out.println("MismosElem: " +L1.mismosElem(L2));
    }
}
