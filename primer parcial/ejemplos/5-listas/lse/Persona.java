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
public class Persona {
    String ci;
    int edad;
    String nombre;
    String apellido;

    Persona( String ci ){
        this.ci = ci;
        this.edad = -1;
        this.nombre = "";
        this.apellido = "";
    }

    Persona( String ci, int edad, String nombre, String apellido ){
        this.ci = ci;
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString(){
        return this.nombre + " " + this.apellido + "(edad: " + this.edad + ")";
    }
        
    @Override
    public boolean equals(Object p){
        if ( p instanceof Persona )
            return ((Persona)p).ci.equals(this.ci);
        return false;
    }
}
