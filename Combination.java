package com.mycompany.sv;

import java.util.ArrayList;

public class Combination {
    
    /* Esta clase fue creada basada en:
    https://www.youtube.com/watch?v=l_9joTQCr-8
    */

    public static void main(String[] args) {        
        ArrayList<Camara> camaras = new ArrayList<Camara>();
        Camara camara1 = new Camara(1,2,"1");
        Camara camara2 = new Camara(2,3,"2");
        Camara camara3 = new Camara(3,4,"3");
        
        camaras.add(camara1);
        camaras.add(camara2);
        camaras.add(camara3);
        
        boolean[] B = new boolean[camaras.size()];
        Combination c = new Combination();
        
        for(int k=1;k<=camaras.size();k++){
        c.subset(camaras, k, 0, 0, B);}
    }

    public void subset(ArrayList<Camara> camaras, int k, int start, int current, boolean[] used) {
        if (current == k) {
            for (int i = 0; i < camaras.size(); i++) {
                if (used[i] == true) {
                    System.out.print(camaras.get(i).getA()+","+camaras.get(i).getB() + " ");
                    System.out.println("lol");
                }
            }
            System.out.println();
            return;
        }
        if (start == camaras.size()) {
            return;
        }
        used[start]=true;
        subset(camaras,k,start+1,current+1,used);
        
        used[start]=false;
        subset(camaras,k,start+1,current,used);
    }
}
