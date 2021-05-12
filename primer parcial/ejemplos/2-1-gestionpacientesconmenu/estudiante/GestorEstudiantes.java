
// package estudiante;

public class GestorEstudiantes {

    Estudiante[ ] estudiantes;
    final int CANT_ESTUDIANTES = 3;

    GestorEstudiantes() {
        estudiantes = new Estudiante[ CANT_ESTUDIANTES ];
    }

    boolean insertarEstudiante( Estudiante estudiante ) {
        int i = 0;
        while ( i < estudiantes.length && estudiantes[ i ] != null ) {
            i++;
        }

        if ( i < estudiantes.length ) {
            estudiantes[ i ] = estudiante;
            return true;
        }
        return false;
    }

    public double promCalif( ){
       int pos = 0;
       double suma = 0;
       int cantCalif = 0;
       double calif;
        while ( pos < estudiantes.length ){
          if ( estudiantes[ pos ] != null ){
              calif = estudiantes[ pos ].promCalif();
              if (calif != -1){
                  suma += calif;
                  cantCalif ++;
              }
          } 
          pos ++;
        }
        return ( cantCalif == 0) ? -1 : suma / cantCalif;
    }
    
    Estudiante buscarEstudianteCedula(String cedula){
        for (Estudiante estudiante : estudiantes) {
            if (estudiante != null && estudiante.ci.equals(cedula)) {
                return estudiante; 
            }
        }
        return null;
    }

}


