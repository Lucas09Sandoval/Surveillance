package usuario;

import com.mycompany.sv.Camara;
import com.mycompany.sv.Combinar;
import com.mycompany.sv.Filtro;
import com.mycompany.sv.Solucion;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        //primero que todo se debe obtener los datos del usuario
        int[] vector = obtenerNK();
        
        int n= vector[0];
        int k= vector[1];

        ArrayList<Camara> camaras = obtenerCamaras(n, k);
        
        //Se filtran las camaras, para no crear combinaciones innecesarias
        ArrayList<Camara> filtradas = Filtro.filtrar(camaras,n);
        
        //mostrarCamaras(filtradas); //muestra las filtradas
        
                
        //arraylist que guarda otro arraylist que son las combinaciones de camaras
        ArrayList<ArrayList<Camara>> combinaciones = new ArrayList<ArrayList<Camara>>();
        
        ArrayList<ArrayList<Camara>> aux;/*auxiliar para agregar a "combinaciones"(el array de arriba)
        las nuevas combs obtenidas*/

        //k es el k del binomio de newton
        for (int x = 1; x <= filtradas.size(); x++) {

            aux = Combinar.generarCombinaciones(filtradas, x);
            /*combinaciones en un principio esta vacio,
            asi que se llena con los diferentes C(n,k)
            por eso el for con "aux" de abajo
            (aux obtiene las combinaciones para distintos k)*/

            for (int z = 0; z < aux.size(); z++) {
                combinaciones.add(aux.get(z));
            }
        }
        //muestra las combinaciones creadas
        //comb.mostrarCombinadas(combinaciones);
        
        //se debe probar la sucion para n muros
        Solucion sol = new Solucion(n);
        //aqui se imprime si es posible o no
        System.out.println(sol.recibirCombinadas(combinaciones));

    }
    
    /*-----------------------------------------------------------------------*/
    
    //muros (n) y total de camaras (k)
    private static int[] obtenerNK(){
        Scanner sc = new Scanner(System.in);
        String[] datosNK = (sc.nextLine()).split(" ");
        int[] vector= new int[2];
        vector[0] = Integer.parseInt(datosNK[0]);
        vector[1] = Integer.parseInt(datosNK[1]);
        
        return vector;
    }

    //datos ingresados por un usuario en cada camara (a y b)
    private static ArrayList<Camara> obtenerCamaras(int n, int k) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Camara> camaras = new ArrayList<Camara>();

        String[] datosAB;
        int a;
        int b;
        Camara camara;

        for (int x = 0; x < k; x++) {
            do {
                sc = new Scanner(System.in);
                datosAB = (sc.nextLine()).split(" ");

                a = Integer.parseInt(datosAB[0]);
                b = Integer.parseInt(datosAB[1]);

                camara = new Camara(a, b);

                if (n < a || n < b) {
                    System.out.println("a y b no puede ser mayor que n");
                }

            } while (n < a || n < b);
            camaras.add(camara);

        }

        return camaras;
    }

    //método para mostrar contenido
    private static void mostrarCamaras(ArrayList<Camara> camaras) {
        for (int x = 0; x < camaras.size(); x++) {
            System.out.println("(" + (x + 1) + ") " + camaras.get(x).getA() + "," + camaras.get(x).getB());
        }
    }

}
