/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.consola;

import validacion.Validador;
import java.util.Scanner;

/**
 *
 * @author felix
 */
public class Consola 
{ 
    private static Consola instancia = null; 
    public Scanner entrada; 
  
    private Consola() 
    { 
        entrada = new Scanner( System.in );
    } 
  
    public static Consola get_() 
    { 
        if (instancia == null) 
            instancia = new Consola(); 
  
        return instancia; 
    } 
    
    public static String ingresarDato(String mensajeEntrada, String mensajeError, int tipoValidador){
        boolean datoValido;
        String dato;
        do{
            System.out.println( mensajeEntrada );
            dato = Consola.get_().entrada.nextLine( );  
            datoValido = Validador.validar( dato, tipoValidador );
            if ( !datoValido )
                System.out.println( mensajeError );
        } while ( !datoValido );
        return dato;        
    }
    
} 
