package com.mycompany.sv;

import java.util.ArrayList;

public class Combinar {
    
    //clase que agrega las combinaciones nuevas, usa la clase Combination
    
    //Este método debe ser modificado para distintos "K"
    public static ArrayList<ArrayList<Camara>> generarCombinaciones(ArrayList<Camara> camaras) {
        int n = camaras.size();
        int k = 1;
        Combination comb = new Combination();

        ArrayList<ArrayList<Integer>> combinaciones = comb.combine(n, 4);
        //comb.mostrarCombinaciones(combinaciones);

        ArrayList<ArrayList<Camara>> combinadas = agregarNuevas(combinaciones, camaras);

        return combinadas;

    }

    private static ArrayList<ArrayList<Camara>> agregarNuevas(ArrayList<ArrayList<Integer>> combinaciones, ArrayList<Camara> camaras) {
        ArrayList<ArrayList<Camara>> combinadas = new ArrayList<ArrayList<Camara>>();
        ArrayList<Camara> combinacion;
        int i;
                
        for (int x = 0; x < combinaciones.size(); x++) {
            combinacion = new ArrayList<Camara>();
            for (int y = 0; y < combinaciones.get(x).size(); y++) {
                
                i=(combinaciones.get(x).get(y)-1);     
                combinacion.add(camaras.get(i));
            }
            combinadas.add(combinacion);
        }
        
        return combinadas;
    }
    /*-------------------------------------------------------------------------------*/
    public static void mostrarCombinadas(ArrayList<ArrayList<Camara>> combinadas){
        for (int x = 0; x < combinadas.size(); x++) {
            for (int y = 0; y < combinadas.get(x).size(); y++) {
                System.out.print(combinadas.get(x).get(y).getA()+","+combinadas.get(x).get(y).getB()+" ");
            }
            System.out.println();
        }    
    }
}
