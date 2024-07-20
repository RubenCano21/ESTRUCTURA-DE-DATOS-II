package ListasD;

public class TestListaD {

    public static void main(String[] args) {

        Lista L = new Lista();

        L.generar(10,1,100);

        System.out.println(L.toString());

        System.out.println("----------------------");
        L.mostrarPrimos();
        System.out.println("\n----------------------");
        L.mostrarImpares();
        System.out.println("\n----------------------");
        L.mostrarMayMen();
        System.out.println("\n----------------------");
        L.mostrarMayMenDig();
        System.out.println("\n----------------------");
        L.mostrarMayMenTodo();
    }
}
