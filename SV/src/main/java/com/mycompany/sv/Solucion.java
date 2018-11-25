package com.mycompany.sv;

import java.util.ArrayList;

public class Solucion {

    private int n;//debe recibir un "n", para saber hasta donde debe realizar la cuenta

    //constructor
    public Solucion(int n) {
        this.n = n;
    }

    public void recibirCombinadas(ArrayList<ArrayList<Camara>> combinadas) {

        String s = "";
        for (int x = 0; x < combinadas.size(); x++) {
            s = generarVector(combinadas.get(x));
        }
        System.out.println(s);
    }

    //Método que genera un vector boleano, que prueba si una combinación de camaras es una solución
    public String generarVector(ArrayList<Camara> combinacion) {
        boolean[] vector = new boolean[this.n + 1];
        /*n+1, porque el vector se que crea incluye el 0, 
        cosa que no queremos comprobar*/
        int aux;
        int ai;
        int bi;
        boolean volteado;

        for (int x = 0; x < combinacion.size(); x++) {
            ai = combinacion.get(x).getA();
            bi = combinacion.get(x).getB();
            volteado = combinacion.get(x).getVolteado();

            if (volteado) {
                aux = 1;
                while (aux <= bi) {
                    vector[aux] = true;
                    aux++;
                }
                aux = ai;
                while (aux <= this.n) {
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
        if (solucion) {
            try {
                if (this.n > combinacion.size()) {
                    n = combinacion.size();
                } else {
                    n = n;//no cambiara su valor
                }
            } catch (Exception e) {
                this.n = combinacion.size();
            }
            return String.valueOf(this.n);
        } else {
            return "impossible";
        }
    }

    //método que comprueba si es solución o no
    private static boolean comprobarVector(boolean[] vector) {
        int constante = 1;//el 0 no se debe comprobar por razones logicas
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
