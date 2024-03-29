/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab4;

/**
 *
 * @author Cano
 */
public class Test {
    
    public static void main(String[] args) {
        
        Lista L1 = new Lista();
        Lista L2 = new Lista();
        Lista L3 = new Lista();
        
//        L1.insertarPrim(1);
//        L1.insertarUlt(2);
//        L1.insertarUlt(5);
//        L1.insertarUlt(8);
//        L1.insertarUlt(7);
//        L1.insertarUlt(4);
        
        
        L2.insertarPrim(1);
        L2.insertarUlt(2);
        L2.insertarUlt(5);
        L2.insertarUlt(8);
        L2.insertarUlt(7);
        L2.insertarUlt(4);
        
        
        L3.insertarUlt(9);
        L3.insertarUlt(7);
        L3.insertarUlt(5);
        L3.insertarUlt(4);
        L3.insertarUlt(3);
        //L2.insertarUlt(2);
//        L1.insertarUlt(61);
//        L1.insertarUlt(3);
//        L1.insertarUlt(7);
       // System.out.println("L1-> " +L1.toString());
        System.out.println("L2-> " +L2.toString());
        System.out.println("L3-> " +L3.toString());
       // System.out.println(L1.iguales());
       // System.out.println(L1.diferentes());
        //System.out.println("MayorElem: " +L1.mayorElem());
        //System.out.println("MenorElem: " +L1.menorElem());
       // System.out.println("Ordenado: " +L1.ordenado());
        //System.out.println("Pares: " +L1.pares());
        //System.out.println("ParImpar: " +L1.parImpar());
        //L1.reemplazar(2, 7);
        //System.out.println(L1);
        //System.out.println("SeEncuentra: " + L1.seEncuentra(4));
        //System.out.println("Frecuencia: " + L1.frecuencia(2));
        //System.out.println("Exite Frecuencia: " + L1.existeFrec(2));
        //System.out.println("Poker: " + L1.poker());
        //System.out.println("Existe par: " + L1.existePar());
        //System.out.println("Alternos: " + L1.alternos());
        L1.intercalar(L2, L3);
        System.out.println("Intercalar: " +L1.toString());
    }
}
