package ArbolBB;

public class MainListaA {

    public static void main(String[] args) {
        ListaArbol L1 = new ListaArbol();

        L1.generar(100,0,1000);
        L1.mostrar();
        System.out.println("-----------mostrarMayMen---------------------");
        L1.mostrarMayMen();
        System.out.println("------mostrarImpares------");
        L1.mostrarImpares();
        L1.mostrarPrimos();
        L1.mostrarMayMenDig();
        L1.mostrarMayMenTodo();
        //System.out.println(L1.mostrar());
        //L1.getNumbersWithSameLastDigit(5);
        //L1.mostrar();
    }
}
