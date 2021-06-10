/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listadoblementeenlazada.sw.pkg20.pkg21;

/**
 *
 * @author felix
 */
public class ProgPcpal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaDE estudiantes = new ListaDE(); // relativamente equivalente a: Estudiante[] estudiantes = new Estudiante[5];
        estudiantes.insertar( new Estudiante( "Mauricio Toapanta" ) );
        estudiantes.insertarPorPrimero(new Estudiante( "María Pérez" ) );
        estudiantes.insertarPos(new Estudiante( "Rafael Urquiola" ), 0 );
        
        Estudiante e = ( Estudiante ) estudiantes.buscar( 1 );
        
        (( Estudiante ) estudiantes.buscar( 0 )).nombApell = "Jefferson Ramos";
        
        e.mejorAmigo = ( Estudiante ) estudiantes.primero.dato;
                
        System.out.println("El mejor amigo de " + e.nombApell + " es: " + e.mejorAmigo.toString()); 
        
        estudiantes.imprimir();
    }
    
}
