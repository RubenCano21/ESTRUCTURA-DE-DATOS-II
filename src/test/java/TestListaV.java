import ListasVectores.ListaV;

public class TestListaV {
    public static void main(String[] args) {

        ListaV L1 = new ListaV();

        L1.insertarUlt(2);
        L1.insertarUlt(3);
        L1.insertarUlt(4);
        L1.insertarUlt(6);
        L1.insertarUlt(7);
        L1.insertarUlt(8);

        System.out.println(L1.toString());
        //System.out.println("Menor: " + L1.menor());
        L1.eliminarIesimo(2);
        System.out.println(L1.toString());
    }
}
