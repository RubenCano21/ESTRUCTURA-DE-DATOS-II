import ListaSimple.ListaS;

public class TestListaS {

    public static void main(String[] args) {
        ListaS L1 = new ListaS();

        L1.insertarPrim(1);
        L1.insertarPrim(2);
        L1.insertarPrim(3);
        L1.insertarPrim(4);
        L1.insertarUlt(5);
        L1.insertarUlt(5);
        L1.insertarUlt(5);
        L1.insertarUlt(5);

        System.out.println(L1.toString());
        L1.reemplazar(2,7);
        System.out.println(L1.toString());
        System.out.println(L1.frecuencia(5));
    }
}
