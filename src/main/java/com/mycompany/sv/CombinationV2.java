package com.mycompany.sv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class CombinationV2 {

    /*
    //Para probar lo que hace esta clase
    public static void main(String[] args) {
        ArrayList<int[]> prueba=generarCombs(12);
        mostrar(prueba);
    }
    */

    //método que genera los enteros que son las combinaciones para distintos k
    public static ArrayList<int[]> generarCombs(int n) {
        ArrayList<int[]> soluciones = new ArrayList<int[]>();

        ArrayList<int[]> creadas;
        for (int k = 1; k <= n; k++) {
            creadas = crearCombs(k, n);
            soluciones = agregar(soluciones, creadas);
        }
        return soluciones;
    }

    private static ArrayList<int[]> agregar(ArrayList<int[]> soluciones, ArrayList<int[]> creadas) {
        for (int x = 0; x < creadas.size(); x++) {
            soluciones.add(creadas.get(x));
        }
        return soluciones;
    }

    private static ArrayList<int[]> crearCombs(int k, int n) {
        LinkedList<String> combinaciones = comb(k, n);

        ArrayList<int[]> nuevas = new ArrayList<int[]>();

        for (int x = 0; x < combinaciones.size(); x++) {
            nuevas.add(convertir(combinaciones.get(x)));
        }

        return nuevas;
    }

    private static int[] convertir(String raw) {
        String[] numeros = raw.split(" ");

        int[] num = new int[numeros.length];

        for (int x = 0; x < numeros.length; x++) {
            num[x] = Integer.parseInt(numeros[x]);
        }

        return num;
    }

    /*-----------------------------------*/
    
    //Métodos para escribir los enteros
    public static String bitprint(int u) {
        String s = "";
        for (int n = 0; u > 0; ++n, u >>= 1) {
            if ((u & 1) > 0) {
                s += n + " ";
            }
        }
        return s;
    }

    public static int bitcount(int u) {
        int n;
        for (n = 0; u > 0; ++n, u &= (u - 1));
        return n;
    }

    public static LinkedList<String> comb(int c, int n) {
        LinkedList<String> s = new LinkedList<String>();
        for (int u = 0; u < 1 << n; u++) {
            if (bitcount(u) == c) {
                s.push(bitprint(u));
            }
        }
        Collections.sort(s);
        return s;
    }

    /*---------------------*/
    public static void mostrar(ArrayList<int[]> soluciones) {
        for (int i = 0; i < soluciones.size(); i++) {
            System.out.println(Arrays.toString(soluciones.get(i)));
        }
    }
}
