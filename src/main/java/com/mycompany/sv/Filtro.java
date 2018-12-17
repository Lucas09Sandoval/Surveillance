package com.mycompany.sv;

import java.util.ArrayList;
import java.util.Arrays;

public class Filtro {

    /*
    Método para filtrar camaras, y asi evitar combinaciones innecesarias
     */
    public static ArrayList<Camara> filtrar(ArrayList<Camara> camaras, int n) {
        Integer[] v1;
        Integer[] v2;

        ArrayList<Camara> nuevas = new ArrayList<Camara>();

        boolean existe;
        int aux;

        for (int x = 0; x < camaras.size(); x++) {
            aux = x + 1;
            v1 = convertirCamaraAvector(camaras.get(x), n);
            existe = false;

            while (aux != camaras.size()) {
                v2 = convertirCamaraAvector(camaras.get(aux), n);

                if (estaContenido(v2, v1)) {
                    existe = true;
                }
                aux++;
            }
            if (!existe) {
                nuevas.add(camaras.get(x));
            }

        }

        //mostrarCamarasUtiles(nuevas);

        return nuevas;
    }

    //Método que confirma si v1 contiene a v2
    private static boolean estaContenido(Integer[] v1, Integer[] v2) {
        return Arrays.asList(v1).containsAll(Arrays.asList(v2));
    }

    private static Integer[] convertirCamaraAvector(Camara camara, int n) {
        if (camara.getVolteado()) {
            //camara volteada            
            return alReves(camara, n);
        } else {
            //si a<b, no es necesario entregar como parámetro el "n" (muros)
            return normalAB(camara);
        }
    }

    private static Integer[] alReves(Camara camara, int n) {
        int largoIzq = camara.getB();
        int largoDer = n - camara.getA() + 1;
        int largoTotal = largoIzq + largoDer;

        Integer[] v = new Integer[largoTotal];

        int aux = 1;
        int aux2 = 0;

        while (aux != camara.getB() + 1) {
            v[aux2] = aux;
            aux++;
            aux2++;
        }
        aux = camara.getA();
        while (aux != n + 1) {
            v[aux2] = aux;
            aux++;
            aux2++;
        }
        return v;
    }

    private static Integer[] normalAB(Camara camara) {
        int largo = camara.getB() - camara.getA() + 1;
        Integer[] v = new Integer[largo];
        int aux = camara.getA();
        int aux2 = 0;

        while (aux != camara.getB() + 1) {
            v[aux2] = aux;
            aux++;
            aux2++;
        }
        return v;
    }

    /*------------------------------------------------------------------------------------*/
    //Método para mostrar contenido de un vector
    private static void mostrarVector(Integer[] v) {
        System.out.println(Arrays.toString(v));
    }

    private static void mostrarCamarasUtiles(ArrayList<Camara> camaras) {
        for (int x = 0; x < camaras.size(); x++) {
            System.out.println("(" + (x + 1) + ") " + camaras.get(x).getA() + "," + camaras.get(x).getB());
        }
    }
}
