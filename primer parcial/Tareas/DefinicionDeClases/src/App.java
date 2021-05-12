public class App {
    public static void main(String[] args) throws Exception {

        GestorPersonas g = new GestorPersonas();
        
        g.insertar( new Persona("María Chávez", "0956978798", 18) );
        g.insertar( new Persona("Joseline Pilamunga", "1738384848", 22 ) );
        g.insertar( new Estudiante("Pedro Delgado", "1738384848", 22 ) );
        
        g.personas[3] = new Estudiante("Angie", "12341234", 26);
        // g.personas[3].setNombre
        g.imprimirPorConsola();
        System.out.println();
        System.out.println("La edad promedio de las personas es: " + g.edadPromedio());
       
    }
}
