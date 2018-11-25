package com.mycompany.sv;

import static com.mycompany.sv.Combinar.generarCombinaciones;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //camaras ingresadas por el usuario
        Camara camara1 = new Camara(2, 1);
        Camara camara2 = new Camara(3, 1);
        
        //se agregan a una lista de camaras
        ArrayList<Camara> camaras = new ArrayList<Camara>();
        camaras.add(camara1);
        camaras.add(camara2);

        /*objeto de la clase combinar, 
        para generar las combinaciones,
        usa a la clase combination*/
        Combinar comb = new Combinar();

        //arraylist que guarda otro arraylist que son las combinaciones de camaras
        ArrayList<ArrayList<Camara>> combinaciones = new ArrayList<ArrayList<Camara>>();
        
        ArrayList<ArrayList<Camara>> aux;/*auxiliar para agregar a "combinaciones"(el array de arriba)
        las nuevas combs obtenidas*/

        //k es el k del binomio de newton
        for (int k = 1; k <= camaras.size(); k++) {

            aux = comb.generarCombinaciones(camaras, k);
            /*combinaciones en un principio esta vacio,
            asi que se llena con los diferentes C(n,k)
            por eso el for con "aux" de abajo
            (aux obtiene las combinaciones para distintos k)*/

            for (int z = 0; z < aux.size(); z++) {
                combinaciones.add(aux.get(z));
            }

        }
        //muestra las combinaciones creadas
        comb.mostrarCombinadas(combinaciones);

        //aqui se comprueban las combs, para saber si es posible solucionar el problema
        int n = 4;//4 muros
        Solucion sol = new Solucion(4);
        //aqui se imprime si es posible o no
        sol.recibirCombinadas(combinaciones);
    }

}
