package estudiante;

// almacena: personas, estudiantes
public class GestorPersonas {
    Persona[] personas;
    final int CANT_PERSONAS = 10;

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

    // opcion 2
    void mayoresA20(){
        for (Persona persona : this.personas) {
            if ( !(persona instanceof Persona) | persona != null && persona.edad > 20) {
                persona.imprimirDatosPorConsola();
            }
        }
    }

    // opcion 3, contar a ltotal de personas
    int contarEstudiantes(){
        int contador = 0;

        for (Persona persona : this.personas) {
            if ( persona instanceof Persona ) {
                contador++;
            }
        }
        return contador;
    }

    // opcion 4
    float edadPromedioPyE(){
        int contadorEdad = 0;
        float edades = 0;
        float promedio = 0;

        for (Persona persona : this.personas) {
            if (persona != null) {
                edades+=persona.getEdad();
                contadorEdad++;
            }
        }
        promedio = edades / contadorEdad;
        return promedio;
    }    

    // opcion 5: mostrar los datos de la persona de mayor edad
    int personaMayor(){
        // crear un vector con la cantidad de personas
        // añadir las edades al vector
        // recorrer el vector y comparar si es mayor o menor
        // devolver el valor mayor

        int contadorP = 0;

        for (Persona persona : this.personas) {
            if ( !(persona instanceof Estudiante) && persona != null) {
                contadorP ++;
            }
        }

        int[ ] edades =  new int[contadorP];

        int pos = 0;
        int contenedor = 0;
        while ( pos < edades.length ){
            contenedor = edades[ pos ];
            if (contenedor > edades[pos]){
                // reemplaza al valor anterior
                contenedor = edades[pos];
        } 
            pos ++;
        }
        return contenedor;
    }

    // opcion 6: 
    int personaMenor(){
        // crear un arreglo con la cantidad de personas
        // añadir las edades al arreglo
        // recorrer el arreglo y comparar si es mayor o menor
        // devolver el valor menor
        int contadorP = 0;

        for (Persona persona : this.personas) {
            if ( !(persona instanceof Estudiante) && persona != null) {
                contadorP ++;
            }
        }

        int[ ] edades =  new int[contadorP];

        int pos = 0;
        int contenedor = 0;
        while ( pos < edades.length ){
            contenedor = edades[ pos ];
            if (contenedor < edades[pos]){
                // reemplaza al valor anterior
                contenedor = edades[pos];
        } 
            pos ++;
        }
        return contenedor;

    }

    // opcion 7: mediana de las personas
    void personasMediana(){

    } 


}
