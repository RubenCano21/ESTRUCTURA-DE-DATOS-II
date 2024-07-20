package arbolString;


public class Main {
    public static void main(String[] args) {

        Arbol A1 = new Arbol();

        A1.insertar("juan");
        A1.insertar("lucas");
        A1.insertar("pedro");
        A1.insertar("miguel");
        A1.insertar("luiz");
        A1.insertar("lucas");
        A1.insertar("samuel");
        A1.insertar("juan");
        A1.insertar("samuel");
        A1.insertar("miguel");
        A1.insertar(" luiz ");
        A1.insertar("lucas");
        A1.insertar("pedro");

        A1.inOrden1();

        //System.out.println(A1.toString());
//        A1.frecuencia();
//        System.out.println("--------------------------");
//        A1.mostrarMenMay();
//        System.out.println("--------------------------");
//        A1.mostrarMayMen();
//        System.out.println("--------------------------");
//
//        String s1 = "hola como estan, que tal estan hoy?";
//        String s2 = "hola como estan, hoy estamos bien";
//
//        A1.iguales(s1,s2);
    }
}
