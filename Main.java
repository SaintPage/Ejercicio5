/*Angel de Jesús Mérida Jiménez Carné: 23661
En este programa se llevará a cabo un menú en el cual se despliegue con las opciones requeridas del programa,
entre ellas encontramos mostrar a todos los jugadores inscritos, los 3 mejores líberos y la cantidad de pasodres
con más de 80% de efectividad, acá se lleva toda la lógica.
*/
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collector;

import com.opencsv.CSVReader;

//Para compilar: javac -cp ".;./lib/commons-lang3-3.13.0.jar;./lib/opencsv-5.8.jar" Main.java Auxiliar.java Libero.java Pasador.java Jugador.java
// Para ejecutar el programa: java -cp ".;./lib/opencsv-5.8.jar;./lib/commons-lang3-3.13.0.jar" Main
public class Main {
    public static void main(String[] args) {
        boolean salir = false;
        //Creamos lista para guardar a todos los jugadores
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

        try{
            jugadores.clear();
            // Leemos el archiv csv
            CSVReader csvReader = new CSVReader(new FileReader("./files/jugadores.csv"));
            int count = 0;
            String[] fila = null;
            while( (fila = csvReader.readNext()) !=null){
                if (count == 0){
                    count++;
                    continue;
                }

                //Definimos tipo para identificar qué clase de jugador es:
                int tipo = Integer.parseInt(fila[0]);
                Jugador aux;
                //Si es 1 es igual a libero
                if(tipo == 1){
                    //Usando el objeto aux agregamos los datos del líbero
                    aux = new Libero();
                    ((Libero)aux).setRecibos(Integer.parseInt(fila[6]));
                }
                //Si es 2 es igual a pasador
                else if(tipo == 2){
                    aux = new Pasador();
                    ((Pasador)aux).setPases(Integer.parseInt(fila[7]));
                    ((Pasador)aux).setFintas(Integer.parseInt(fila[8]));
                }
                //Si es 3 es igual a Auxiliar
                else{
                    aux = new Auxiliar();
                    ((Auxiliar)aux).setAtaques(Integer.parseInt(fila[9]));
                    ((Auxiliar)aux).setBloqueosFallidos(Integer.parseInt(fila[10]));
                    ((Auxiliar)aux).setBloqueosEfectivos(Integer.parseInt(fila[11]));
                }
                
                //Por último agregamos todos los datos de la clase Jugador
                aux.setTipo(tipo);
                aux.setNombre(fila[1]);
                aux.setPais(fila[2]);
                aux.setErrores(Integer.parseInt(fila[3]));
                aux.setAces(Integer.parseInt(fila[4]));
                aux.setServicios(Integer.parseInt(fila[5]));
                // con un if le agregamos el método de calcular la efectividad de cada subclase
                if(tipo == 1){
                    ((Libero)aux).calcularEfectividad();
                }
                else if(tipo == 2){
                    ((Pasador)aux).calcularEfectividad();
                }
                else{
                    ((Auxiliar)aux).calcularEfectividad();
                }
                //por último se carga todos los datos a la lista de jugadores
                jugadores.add(aux);


            }
            System.out.println("Archivos de jugadores cargado exitosamente");

        }
        catch(Exception e){
            System.out.println("Error");
            e.printStackTrace();
        }

        //menu
        while (!salir){
            mostrarMenu();
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch (option){
                case 1:
                    //Opcion de mostrar todos los jugadores inscritos
                    System.out.println("Lista de jugadores: ");
                    for(int i=0; i<jugadores.size(); i++){
                        System.out.println(jugadores.get(i));
                    }
                    break;
                    // opción para los 3 mejores líberos
                case 2:
                    //Creé otra array list para facilitar el trabajo
                    ArrayList<Jugador> liberos = new ArrayList<Jugador>();
                    for (Jugador jugador : jugadores) {
                        if(jugador.getTipo() == 1){
                            liberos.add(jugador);
                        }
                    }
                    Comparator<Jugador> comparadorPorEfectividad = new Comparator<Jugador>() {
                        //Sobreescribimos
                        @Override
                        public int compare(Jugador jugador1, Jugador jugador2){
                            // Compara los jugadores en función de su efectividad de manera descendente
                            return Double.compare(jugador2.getEfectividad(), jugador1.getEfectividad());
                        }
                    };

                    // Ordenar la lista de jugadores utilizando el comparador
                    Collections.sort(liberos, comparadorPorEfectividad);
                    for(int i = 0; i < 3 && i < liberos.size(); i++){
                        Jugador jugador = liberos.get(i);
                        System.out.println("Nombre: " + jugador.getNombre() + ", Efectividad: " + jugador.getEfectividad());
                    }
                    
                    break;
                case 3:
                    // Contador de los jugadores con arriba 80% de efectividad
                    int contador = 0;
                    for (Jugador jugador : jugadores) {
                        if(jugador.getTipo() == 2 && jugador.getEfectividad() >= 80){
                            contador = contador +1;
                        }
                        
                    }
                    System.out.println("La cantidad de pasadores con efectividad de 80% o superior son: "+ contador);
                    break;
                case 4:
                    sc.close();
                    salir = true;
                    break;
                default:
                System.out.println("Esa opcion no existe");

            }
        }       
    }
    public static void mostrarMenu(){
        System.out.println("Menu");
        System.out.println("Elija una opcion");
        System.out.println("1. Mostrar todos los jugadores inscritos en el torneo");
        System.out.println("2. Los 3 mejores liberos en función de su efectividad");
        System.out.println("3. La cantidad de pasadores con más de un 80% de efectividad");
        System.out.println("4. Salir");
    }
}