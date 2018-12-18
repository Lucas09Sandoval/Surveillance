package com.mycompany.sv;

import java.util.ArrayList;
import java.util.Arrays;

public class Combinar {
    
    //clase que agrega las combinaciones nuevas, usa la clase Combination
    
    public static ArrayList<ArrayList<Camara>> generarCombinaciones(ArrayList<Camara> camaras) {
        
        ArrayList<int[]> combinaciones=CombinationV2.generarCombs(camaras.size());
        //mostrar(combinaciones);

        ArrayList<ArrayList<Camara>> combinadas = agregarNuevas(combinaciones, camaras);

        return combinadas;

    }

    private static ArrayList<ArrayList<Camara>> agregarNuevas(ArrayList<int[]> combinaciones, ArrayList<Camara> camaras) {
        ArrayList<ArrayList<Camara>> combinadas = new ArrayList<ArrayList<Camara>>();
        ArrayList<Camara> combinacion;
        int i;
                
        for (int x = 0; x < combinaciones.size(); x++) {
            combinacion = new ArrayList<Camara>();
            for (int y = 0; y < combinaciones.get(x).length; y++) {
                
                i=(combinaciones.get(x)[y]);     
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
    /*---------------------*/
    public static void mostrar(ArrayList<int[]> soluciones) {
        for (int i = 0; i < soluciones.size(); i++) {
            System.out.println(Arrays.toString(soluciones.get(i)));
        }
    }  
}
