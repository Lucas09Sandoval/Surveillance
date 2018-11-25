package com.mycompany.sv;

import static com.mycompany.sv.Combinar.generarCombinaciones;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Camara camara1 = new Camara(1, 1);
        Camara camara2 = new Camara(2, 2);
        Camara camara3 = new Camara(3, 3);
        Camara camara4 = new Camara(4, 4);

        ArrayList<Camara> camaras = new ArrayList<Camara>();
        camaras.add(camara1);
        camaras.add(camara2);
        camaras.add(camara3);
        camaras.add(camara4);

        ArrayList<ArrayList<Camara>> combinaciones = generarCombinaciones(camaras);
        
        Combinar comb =new Combinar();
        comb.mostrarCombinadas(combinaciones);
        
        int n=4;//4 muros
        Solucion sol= new Solucion(4);
        sol.recibirCombinadas(combinaciones);
    }

}
