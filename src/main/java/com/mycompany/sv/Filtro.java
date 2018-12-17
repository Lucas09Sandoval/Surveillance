package com.mycompany.sv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Filtro {

    /*
    Método para filtrar camaras, hace uso de "objetos opcionales"
    para prevenir problemas al trabajar con objetos nulos en un vector
     */
    public static ArrayList<Camara> filtrar(ArrayList<Camara> camaras, int n) {
        Integer[] v1;
        Integer[] v2;
        //v1 = convertirAvector(camaras.get(x), n);

        //convertir a vector para filtrar facilmente
        Camara[] temporal = camaras.toArray(new Camara[camaras.size()]);

        for (int x = 0; x < temporal.length; x++) {
            Optional<Camara> camaraX = Optional.ofNullable(temporal[x]);

            if (camaraX.isPresent()) {//si es nulo, se ignorara
                v1 = convertirCamaraAvector(temporal[x], n);

                for (int y = x + 1; y < temporal.length; y++) {
                    Optional<Camara> camaraY = Optional.ofNullable(temporal[y]);

                    if (camaraY.isPresent()) {
                        v2 = convertirCamaraAvector(temporal[y], n);

                        if (estaContenido(v1, v2)) {
                            temporal[y] = null;
                        } else {
                            if (estaContenido(v2, v1)) {
                                temporal[x] = null;
                            }
                        }

                    }

                }
            }

        }
        //volver a convertir a ArrayList
        ArrayList<Camara> nuevas = new ArrayList<Camara>();
        for (int z = 0; z < camaras.size(); z++) {
            Optional<Camara> camaraZ = Optional.ofNullable(temporal[z]);
            if (camaraZ.isPresent()) {
                nuevas.add(temporal[z]);
            }
        }

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

    //Método para mostrar contenido de un vector
    private static void mostrarVector(Integer[] v) {
        System.out.println(Arrays.toString(v));
    }

    //Aqui abajo se encuentran todos los ejemplos de como usar los métodos de esta clase 
    
    /*
    //Ejemplo de filtro de varias camaras
    public static void main(String[] args) {
        Camara camara = new Camara(11, 3);
        Camara camara1 = new Camara(1, 3);
        Camara camara2 = new Camara(1, 4);
        Camara camara3 = new Camara(1, 5);
        Camara camara4 = new Camara(1, 7);
        Camara camara5 = new Camara(8, 9);
        Camara camara6 = new Camara(10, 11);
        ArrayList<Camara> camaras = new ArrayList<Camara>();
        camaras.add(camara);
        camaras.add(camara1);
        camaras.add(camara2);
        camaras.add(camara3);
        camaras.add(camara4);
        camaras.add(camara5);
        camaras.add(camara6);

        ArrayList<Camara> nuevas = filtrar(camaras, 15);

        //se espera 1 de resultado, pues las camaras de 1 a 3 estan contenidas en 4
        for (int x = 0; x < nuevas.size(); x++) {
            System.out.println(nuevas.get(x).getA() + " " + nuevas.get(x).getB());
        }
        System.out.println("Largo de nuevas: " + nuevas.size());
    }
    */
    /*--------------------------------------------------------------*/
    /*
    Ejemplo de convertir a vector
    
    public static void main(String[] args) {
        Camara camara = new Camara(3,2);
        Integer[] vector =convertirAvector(camara,5);
        mostrarVector(vector);
    }
     */
    
    /*--------------------------------------------------------------*/
 
    /*
    Ejemplo de saber si esta contenido
    
    public static void main(String[] args) {

        Integer[] v1 = {0, 1, 2, 3, 4};
        Integer[] v2 = {0, 1, 2, 3};

    //se confirma si v2 esta en v1
        boolean contenido = estaContenido(v1, v2);

        if (contenido) {
            System.out.println("v2 esta contenido en v1");

        } else {
            System.out.println("v2 NO ESTA CONTENIDO en v1");
        }
    }    
    */
}
