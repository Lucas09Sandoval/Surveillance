package tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.sv.Camara;
import com.mycompany.sv.Combinar;
import com.mycompany.sv.Filtro;
import com.mycompany.sv.Solucion;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class testProblemas {
    
    @Parameters
    public static ArrayList<ArrayList<Camara>> data() {
        ArrayList<ArrayList<Camara>> datos = new ArrayList<ArrayList<Camara>>();
        
        ///este es el parámetro, datos almacena los parametros(listas de camaras)
        ArrayList<Camara> camaras = new ArrayList<Camara>();
        camaras.add(new Camara(1, 2));
        camaras.add(new Camara(1, 5));
        camaras.add(new Camara(5, 6));
        camaras.add(new Camara(7, 8));
        datos.add(camaras);
        
        //otro parámetro        
        ArrayList<Camara> camaras2 = new ArrayList<Camara>();
        camaras2.add(new Camara(1, 2));
        camaras2.add(new Camara(3, 6));
        camaras2.add(new Camara(7, 8));
        datos.add(camaras2);
        
        return datos;
    }
    
    private ArrayList<Camara> camaras;
    
    public testProblemas(ArrayList<Camara> camaras){
        this.camaras=camaras;        
    }
    

    @Test
    public void testFiltrar() {

        int n = 8;//muros
        
        ArrayList<Camara> filtradas = Filtro.filtrar(camaras, n);
        
        ArrayList<ArrayList<Camara>> combinaciones = new ArrayList<ArrayList<Camara>>();

        ArrayList<ArrayList<Camara>> aux;
        for (int x = 1; x <= filtradas.size(); x++) {

            aux = Combinar.generarCombinaciones(filtradas, x);

            for (int z = 0; z < aux.size(); z++) {
                combinaciones.add(aux.get(z));
            }
        }
        Solucion sol = new Solucion(n);

        String esperado = "3";
        String resultado = sol.recibirCombinadas(combinaciones);

        assertEquals(esperado, resultado);
    }
    
    @Test
    public void testFiltrar2() {

        int n = 9;//muros
        
        ArrayList<Camara> filtradas = Filtro.filtrar(camaras, n);
        
        ArrayList<ArrayList<Camara>> combinaciones = new ArrayList<ArrayList<Camara>>();

        ArrayList<ArrayList<Camara>> aux;
        for (int x = 1; x <= filtradas.size(); x++) {

            aux = Combinar.generarCombinaciones(filtradas, x);

            for (int z = 0; z < aux.size(); z++) {
                combinaciones.add(aux.get(z));
            }
        }
        Solucion sol = new Solucion(n);

        String esperado = "impossible";
        String resultado = sol.recibirCombinadas(combinaciones);

        assertEquals(esperado, resultado);
    }
}
