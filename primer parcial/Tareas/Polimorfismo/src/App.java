public class App {
    public static void main(String[] args) throws Exception {
        GestorPersonas g = new GestorPersonas();
        
        g.insertar( new Persona("María Chávez", "0956978798", 18) );
        g.insertar( new Persona("Joseline Pilamunga", "1738384848", 29 ) );
        g.insertar( new Estudiante("Rosa Quinteros", "1728284248", 20 ) );
        g.insertar( new Estudiante("Paúl Correa", "17656548", 26 ) );
        
        // g.imprimirPorConsola();
        
        // System.out.println("La edad promedio de las personas es: " + g.edadPromedio());
        System.out.println("--Ejecutando saludos:");
        g.mostrarSaludos();
    }
}
