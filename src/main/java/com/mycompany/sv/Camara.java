package com.mycompany.sv;


public class Camara {

    private int a;
    private int b;
    private boolean volteado;
//si b > a, las camaras cubren de 1 hasta "a" y de "b" hasta "n"

    public Camara(int a, int b) {
        this.a = a;
        this.b = b;
        this.volteado = (b < a);
        /* para el boleano "volteado"
        ejemplo: (a=4,b=7), la camara cubrira desde a hasta b
        ejemplo: (a=20,b=10), la camara cubrira de 1 hasta 10 y de 20 hasta "n"
         */
    }

    //Métodos get y set
    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setVolteado(boolean volteado) {
        this.volteado = volteado;
    }

    public boolean getVolteado() {
        return volteado;
    }

    public boolean isVolteado() {
        return volteado;
    }
}
