public class Estudiante extends Persona{
    String [] materiasMatriculadas;
    final int CANT_MAX_MATERIAS = 7;
    
    Estudiante(String nombApell, String ci, int edad){
        super(nombApell, ci, edad);
        materiasMatriculadas = new String [CANT_MAX_MATERIAS];
    }
    
   @Override
   public String toString(){
       int cantMateriasMatriculadas = 0;
       for (String materia : this.materiasMatriculadas) 
           if ( materia != null )
               cantMateriasMatriculadas ++;
       return this.nombApell + " (" + this.ci + ") ==> " + cantMateriasMatriculadas + " materias matriculadas"; 
   }
}
