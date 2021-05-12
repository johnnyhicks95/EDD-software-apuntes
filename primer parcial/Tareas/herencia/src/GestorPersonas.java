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

    // 4 ejecutar metodo calcular sueldo. Reflexione en el por qué de lo que ocurre.
    /* void sueldoEmpleado(){
        for (Persona persona : this.personas) {
            if (persona != null) {
                // persona.imprimirDatosPorConsola();
                persona.calcularSueldo();
            }
        }
    } */

    /*El metodo calcular sueldo no está definido para la clase Persona  */


   
}
