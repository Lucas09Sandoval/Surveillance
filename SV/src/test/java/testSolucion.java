
import com.mycompany.sv.Camara;
import com.mycompany.sv.Solucion;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class testSolucion {
    
    @Test
    public void testAMenorQueB() {
        System.out.println("test a<b");
        Camara camara1 = new Camara(1, 3);
        Camara camara2 = new Camara(2, 5);
        int n = 5;//5 muros
        ArrayList<Camara> camaras = new ArrayList<Camara>();
        camaras.add(camara1);
        camaras.add(camara2);

        Solucion sol = new Solucion(n);

        String obtenido = sol.generarVector(camaras);
        String esperado = "2";

        System.out.println(obtenido);

        assertEquals(esperado, obtenido);
    }

    @Test
    public void testBMenorQueA() {
        System.out.println("test b<a");
        Camara camara1 = new Camara(3, 2);
        int n = 5;//5 muros
        ArrayList<Camara> camaras = new ArrayList<Camara>();
        camaras.add(camara1);

        Solucion sol = new Solucion(n);

        String obtenido = sol.generarVector(camaras);
        String esperado = "1";

        System.out.println(obtenido);

        assertEquals(esperado, obtenido);
    }

    @Test
    public void testImpossible() {
        System.out.println("test imposible a<b");
        Camara camara1 = new Camara(1, 2);
        //falta el muro 3;
        Camara camara2 = new Camara(4, 5);
        int n = 5;//5 muros
        ArrayList<Camara> camaras = new ArrayList<Camara>();
        camaras.add(camara1);
        camaras.add(camara2);

        Solucion sol = new Solucion(n);

        String obtenido = sol.generarVector(camaras);
        String esperado = "impossible";

        System.out.println(obtenido);

        assertEquals(esperado, obtenido);
    }

    @Test
    public void testImpossible2() {
        System.out.println("test imposible b<a");
        Camara camara1 = new Camara(3, 1);
        //falta el muro 2;
        int n = 5;//5 muros
        ArrayList<Camara> camaras = new ArrayList<Camara>();
        camaras.add(camara1);

        Solucion sol = new Solucion(n);

        String obtenido = sol.generarVector(camaras);
        String esperado = "impossible";

        System.out.println(obtenido);

        assertEquals(esperado, obtenido);
    }
}
