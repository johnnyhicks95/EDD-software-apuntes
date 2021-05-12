public class App {
    public static void main(String[] args) throws Exception {
        GestorPersonas g = new GestorPersonas();
        
        g.insertar( new Persona("María Chávez", "0956978798", 18) );
        g.insertar( new Persona("Joseline Pilamunga", "1738384848", 22 ) );
        // g.insertar( new Estudiante("Joseline Pilamunga", "1738384848", 22 ) );
        
        // instancia de empleado
        g.insertar( new Persona("Pedro Delgado", "666555", 30 ) );


        g.imprimirPorConsola();
        
        
        System.out.println("La edad promedio de las personas es: " + g.edadPromedio());

        System.out.println();
        //System.out.println("El sueldo de Pedro");  
        //4. error de compilación
        // g.sueldoEmpleado();
        /* ejecutar metodo calcular sueldo. Reflexione en el por qué de lo que ocurre.*/
        /*El metodo calcular sueldo no está definido para la clase Persona  */

         // 5. Agregando el valor sueldoPorHora a la clase persona agrega a los objetos
         // ese valor (10), no da error en la compilación del programa
    }
}
