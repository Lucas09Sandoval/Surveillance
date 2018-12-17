package com.mycompany.sv;

import java.util.ArrayList;

public class Solucion {

    private int n;//debe recibir un "n", para saber hasta donde debe realizar la cuenta

    //constructor
    public Solucion(int n) {
        this.n = n;
    }

    public String recibirCombinadas(ArrayList<ArrayList<Camara>> combinadas) {

        /*siempre empieza desde la combinación de menor largo
            al comprobar la combinacion recibida, si sigue siendo falso el 
        "boleano" al terminar el for, significa que con esas camaras es 
        imposible solucionar el problema todas las camaras
         */
        boolean boleano = false;
        for (int x = 0; x < combinadas.size(); x++) {
            boleano = generarVector(combinadas.get(x));
            if (boleano == true) {
                /*Si ocurre este if, no es necesario confirmar el resto de combinaciones,
                pues esta combinadas.get(x) será la combinacion(o una de las combinaciones)
                que soluciona el problema con menor largo*/
                this.n = combinadas.get(x).size();
                x = combinadas.size();
            }
        }
        
        if (boleano == true) {
            return String.valueOf(this.n);
        } else {
            return "impossible";
        }
    }

    //Método que genera un vector boleano, que prueba si una combinación de camaras es una solución
    public boolean generarVector(ArrayList<Camara> combinacion) {
        boolean[] vector = new boolean[this.n];
        /*n+1, porque el vector se que crea incluye el 0, 
        cosa que no queremos comprobar*/
        int aux;
        int ai;
        int bi;
        boolean volteado;

        for (int x = 0; x < combinacion.size(); x++) {
            ai = combinacion.get(x).getA()-1;
            bi = combinacion.get(x).getB()-1;
            volteado = combinacion.get(x).getVolteado();

            if (volteado) {
                aux = 0;
                while (aux <= bi) {
                    vector[aux] = true;
                    aux++;
                }
                aux = ai;
                while (aux < this.n) {
                    vector[aux] = true;
                    aux++;
                }
            } else {
                while (ai <= bi) {
                    vector[ai] = true;
                    ai++;
                }
            }
        }

        boolean solucion = comprobarVector(vector);
        return solucion;
    }

    //método que comprueba si es solución o no
    private static boolean comprobarVector(boolean[] vector) {
        int constante = 0;
        if (esSolucion(vector, constante)) {
            return true;
        } else {
            return false;
        }
    }

    /*
    Recursivo
    Si este método retorna un true, significa que sera solución
     */
    private static boolean esSolucion(boolean[] vector, int constante) {
        boolean res;
        if (constante == vector.length - 1) {
            if (vector[constante] == true) {
                res = true;
            } else {
                res = false;
            }

        } else {
            if (vector[constante] == true) {
                res = esSolucion(vector, constante + 1);
            } else {
                res = false;
            }
        }
        return res;
    }

    //Métodos get y set
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

}
