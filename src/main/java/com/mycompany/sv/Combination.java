package com.mycompany.sv;

import java.util.ArrayList;

public class Combination {

    //clase cuyo unico proposito es crear las combinaciones

    /* 
    //prueba de la clase con n=5, k=2
   public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> combs = combine(5, 2);
        mostrarCombinaciones(combs);
    }
     */
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (n <= 0 || n < k) {
            return result;
        } else {
            ArrayList<Integer> item = new ArrayList<Integer>();
            crearEnteros(n, k, 1, item, result); // el 1 es necesario

            return result;
        }
    }

    private void crearEnteros(int n, int k, int start, ArrayList<Integer> item,
            ArrayList<ArrayList<Integer>> res) {
        if (item.size() == k) {
            res.add(new ArrayList<Integer>(item));
            return;
        }

        for (int i = start; i <= n; i++) {
            item.add(i);
            crearEnteros(n, k, i + 1, item, res);
            item.remove(item.size() - 1);
        }
    }

    /*------------------------------------------------------------------------*/
    public static void mostrarCombinaciones(ArrayList<ArrayList<Integer>> combinaciones) {

        for (int x = 0; x < combinaciones.size(); x++) {
            for (int y = 0; y < combinaciones.get(x).size(); y++) {
                System.out.print(combinaciones.get(x).get(y) + " ");
            }
            System.out.println();
        }
    }
}
