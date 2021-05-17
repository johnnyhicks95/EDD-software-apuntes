package estudiante;

public class Estudiante extends Persona {
    
    String [] materiasMatriculadas;
    final int CANT_MAX_MATERIAS = 5;

    public Estudiante(String nombre, int edad, String ci) {
        super(nombre, edad, ci);
        materiasMatriculadas = new String [CANT_MAX_MATERIAS];
    }

    
}
