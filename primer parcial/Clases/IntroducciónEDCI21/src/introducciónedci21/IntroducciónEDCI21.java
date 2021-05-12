/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package introducciónedci21;

/**
 *
 * @author felix
 */
public class IntroducciónEDCI21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        GestorPersonas g = new GestorPersonas();
        
        g.insertar( new Persona("María Chávez", "0956978798", 18) );
        g.insertar( new Persona("Joseline Pilamunga", "1738384848", 22 ) );
        g.insertar( new Estudiante("Joseline Pilamunga", "1738384848", 22 ) );
        
        g.imprimirPorConsola();
        
        
        System.out.println("La edad promedio de las personas es: " + g.edadPromedio());
       
    }
    
}
