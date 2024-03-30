package listasSimples;

public class Test {

    public static void main(String[] args) {

        Lista L1 = new Lista();

        L1.insertarPrim(2);
        L1.insertarPrim(3);
        L1.insertarPrim(4);
        L1.insertarPrim(5);
        L1.insertarPrim(5);

        System.out.printf("L1-> " + L1.toString());
    }
}
