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
public class GestorPersonas {

    Persona[] personas;
    final int CANT_PERSONAS = 5;

    GestorPersonas() {
        personas = new Persona[this.CANT_PERSONAS];
    }

    boolean insertar(Persona persona){
        boolean insertado = false;
        int pos = 0;
        while (!insertado && pos < this.personas.length){
            if ( this.personas[ pos ] == null ){
                this.personas[ pos ] = persona;
                return true;
            }
            pos ++;
        }
        return false;
    }
    
    int edadPromedio() {
        int sumaEdades = 0;
        int cantPersonas = 0;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null) {
                sumaEdades += personas[i].edad;
                cantPersonas++;
            }
        }
        return sumaEdades / cantPersonas;
    }

    void imprimirPorConsola() {
        for (Persona persona : this.personas) {
            if (persona != null) {
                persona.imprimirDatosPorConsola();
            }
        }
    }

}
