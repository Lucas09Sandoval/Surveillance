package tests;

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
public class testMetodos {

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
        
        return datos;
    }
    
    private ArrayList<Camara> camaras;
    
    public testMetodos(ArrayList<Camara> camaras){
        this.camaras=camaras;        
    }

    @Test
    public void testFiltrar() {

        int esperado = 3;//la segunda contiene a la primera, por eso se reduce en 1
        ArrayList<Camara> filtradas = Filtro.filtrar(camaras, 10);
        //el 10 de aqui es la cantidad de muros a tomar encuenta
        //es necesario para las camaras (a>b)
        int resultado = filtradas.size();

        assertEquals(esperado, resultado);
    }

    @Test
    public void testCombinatoria() {

        int esperado = 15;
        //en este caso no se filtrar las camaras
        //se cuentan las combs de 1,2,3....n camaras (en este caso n=4, por los parámetros)
        //entonces combs C(1,4)=4
        //C(2,4)=6
        //C(3,4)=4
        //C(4,4)=1
        //la suma de los C da 15 (combs de k=1 hasta n)

        ArrayList<ArrayList<Camara>> combinaciones = Combinar.generarCombinaciones(camaras);

        //el 4 de aqui es la cantidad de muros a tomar encuenta, es necesario para camaras (a>b)
        int resultado = combinaciones.size();

        assertEquals(esperado, resultado);
    }

    @Test
    public void testSolucion() {

        int n = 9;
        //en las camaras falta la 9, por eso falso

        boolean esperado = false;

        Solucion sol = new Solucion(n);

        //el 4 de aqui es la cantidad de muros a tomar encuenta, es necesario para camaras (a>b)
        boolean resultado = sol.generarVector(camaras);

        assertEquals(esperado, resultado);

    }
}
