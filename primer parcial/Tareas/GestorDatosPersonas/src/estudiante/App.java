
/* Cree un proyecto en el que implemente los métodos que se requieran para ingresar
 datos de un conjunto de personas (que pueden ser estudiantes o no). 
 El usuario del sistema podrá insertar los datos de tantas personas como requiera. 
 El sistema deberá proveer un menú de usuario que además de insertar los datos 
 de personas deberá permitir:

1. Determinar la cantidad de personas con más de 20 años de edad.
2. Determinar la cantidad de estudiantes del total de personas registradas.
3. Calcular la edad promedio de los estudiantes y la edad promedio de las personas, en sentido general.
4. Mostrar los datos de la persona de mayor edad.
5. Mostrar los datos de la persona de menor edad.
6. Calcular la mediana de las edades de las personas. 
*/
package estudiante;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        GestorPersonas g = new GestorPersonas();

        // muestras de personas
        g.insertar(new Persona("James Hetfield", 17, "0956978798"));
        g.insertar(new Persona("Robert Trujillo", 22, "1738384848"));
        g.insertar(new Estudiante("Kirk Hammet", 23, "1738384848"));
        g.insertar(new Estudiante("Lars Ulrich", 66, "1738384848"));

        // g.imprimirPorConsola();

        /********* menu con 8 opciones   *******/ 
        // 1. Insertar datos de persona:
        // 2. Cantidad Personas mayores de 20 años de edad:
        // 3. Mostrar cantidad de estudiantes:
        // 4. Calcular la edad promedio(personasn,estudiantes):
        // 5. Mostrar persona de mayor edad:
        // 6. Mostrar persona de menor edad:
        // 7. Calcular la mediana:
        // 8. Salir del programa!

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; // Guardaremos la opcion del usuario
        
        // Menu con un switch
        while (!salir) {
 
            System.out.println("1. Insertar datos de persona");
            System.out.println("2. Cantidad personas mayores de 20 años de edad");
            System.out.println("3. Mostrar cantidad de estudiantes");
            System.out.println("4. Calcular la edad promedio (personas,estudiantes)");
            System.out.println(" ");
            System.out.println("5. Mostrar persona de mayor edad");
            System.out.println("6. Mostrar persona de menor edad");
            System.out.println("7. Calcular la mediana de personas");
            System.out.println("8. Salir del programa!");
 
            try {
 
                System.out.print("Escribe una de las opciones: ");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1");
                        insertarPersona();
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        cantidadPMayores20(); 
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3");
                        cantidadEstudiantes();
                        break;
                    case 4:
                        System.out.println("Has seleccionado la opcion 4");
                        edadPromedio();
                        break;
                    case 5:
                        System.out.println("Has seleccionado la opcion 5");
                        mayorEdadP();
                        break;
                    case 6:
                        System.out.println("Has seleccionado la opcion 6");
                        menorEdadP();
                        break;
                    case 7:
                        System.out.println("Has seleccionado la opcion 7");
                        medianaPersonas();
                        break;
                    case 8:
                        System.out.println("Terminando programa .... Adiós! ");
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 8");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

        // finalizando 
        sn.close();
    }

    // funciones para procesamiento de datos
    
    private static void insertarPersona() {
        
    }

    private static void cantidadPMayores20() {

    }

    private static void cantidadEstudiantes() {

    }

    private static void edadPromedio() {

    }

    private static void menorEdadP() {

    }

    private static void mayorEdadP() {

    }

    private static void medianaPersonas() {

    }



}
