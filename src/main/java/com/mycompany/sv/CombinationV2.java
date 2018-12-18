package com.mycompany.sv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class CombinationV2 {

    /*
    Creado en base a:
    https://rosettacode.org/wiki/Combinations#Java
     */
    
    /*
    Para probar lo que hace esta clase
    public static void main(String[] args) {
        ArrayList<int[]> prueba=generarCombs(3);
        mostrar(prueba);
    }
    */

    public static ArrayList<int[]> generarCombs(int n) {        
        ArrayList<int[]> soluciones = new ArrayList<int[]>();
        
        ArrayList<int[]> creadas;
        for (int k = 1; k <= n; k++) {
            creadas = crearCombs(k,n);
            soluciones=agregar(soluciones,creadas);
        }
        return soluciones;
    }    
    
    private static ArrayList<int[]> agregar(ArrayList<int[]> soluciones,ArrayList<int[]> creadas){
        for(int x=0;x<creadas.size();x++){
            soluciones.add(creadas.get(x));
        }
        return soluciones;
    }

    private static ArrayList<int[]> crearCombs(int k, int n) {
        LinkedList<String[]> combinaciones = comb(k, n);

        ArrayList<int[]> nuevas = new ArrayList<int[]>();

        for (int x = 0; x < combinaciones.size(); x++) {
            nuevas.add(convertir(combinaciones.get(x)));
        }

        return nuevas;
    }

    private static int[] convertir(String[] raw) {
        String numero="";
        
        for (String raw1 : raw) {
            numero = numero + raw1;
        }
        

        int[] num = new int[numero.length()];

        //int aux;
        
        for (int i = 0; i < numero.length(); i++) {
             num[i] = numero.charAt(i) - '0';         
        }
        return num;
    }    

    /*---------------------*/
    public static void mostrar(ArrayList<int[]> soluciones) {
        for (int i = 0; i < soluciones.size(); i++) {
            System.out.println(Arrays.toString(soluciones.get(i)));
        }
    }    
    /*--------------------------------------*/
    //No tocar de aqui hacia abajo

    private static String[] bitprint(int u) {
        String s = "";
        for (int n = 0; u > 0; ++n, u >>= 1) {
            if ((u & 1) > 0) {
                s += n+" ";
            }
        }
        String[] sols=s.split(" ");
        return sols;
    }

    private static int bitcount(int u) {
        int n;
        for (n = 0; u > 0; ++n, u &= (u - 1));//Turn the last set bit to a 0
        return n;
    }

    private static LinkedList<String[]> comb(int c, int n) {
        LinkedList<String[]> s = new LinkedList<String[]>();
        for (int u = 0; u < 1 << n; u++) {
            if (bitcount(u) == c) {
                s.push(bitprint(u));
            }
        }
        return s;
    }
}
