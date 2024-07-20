package ABBListasLib;

import java.util.ArrayList;

public class MainArbolL {

    public static void main(String[] args) {

        ArbolL A1 = new ArbolL();

        A1.insertar(2);
        A1.insertar(5);
        A1.insertar(6);
        A1.insertar(27);
        A1.insertar(9);

        A1.inOrden();
        System.out.println("La Suma es: " +A1.suma());
        System.out.println("El menor es: " +A1.menor());

        ArrayList<Integer> lista = new ArrayList<>();

        A1.sumarNivel(lista);

        System.out.println("Suma de elemenetos por Nivel:");
        for (int i = 0; i < lista.size() ; i++) {
            System.out.println("Nivel: " + i + ": " + lista.get(i));
        }

        System.out.println("Altura mayor: " + A1.alturaMayor());
    }
}
