/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lse;

/**
 *
 * @author felix
 */
public class ProgPcpal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LSE listaPersonas = new LSE();
       
        listaPersonas.insertar( new Persona( "0960114855", 23, "Pep", "Ventura" ) );
        listaPersonas.insertar( new Persona( "0560114855", 23, "Marie", "Curie" ) );
        listaPersonas.insertar( new Persona( "1860114855", 23, "Sarah", "Cunihgan" ), 3 );
        listaPersonas.insertar( new Persona( "2160112335", 23, "Ralph", "Einstein" ), 1 );
        
        listaPersonas.imprimir();
        
        listaPersonas.eliminar( 2 );
        System.out.println("DESPUÉS DE ELIMINAR EL REGISTRO DE LA SEGUNDA PERSONA...");
        listaPersonas.imprimir();
        
        listaPersonas.eliminar( new Persona("1860114855") );
        System.out.println("DESPUÉS DE ELIMINAR EL REGISTRO DE LA PERSONA CON CI '1860114855'...");
        listaPersonas.imprimir();
        
        listaPersonas.eliminar(2);
        listaPersonas.eliminar(1);
        System.out.println("DESPUÉS DE ELIMINAR TODOS LOS REGISTROS");
        if ( listaPersonas.cantNodos == 0 )
            System.out.println("No hay registros de personas.");
        else
            listaPersonas.imprimir();
    }
    
}
