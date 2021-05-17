package estudiante;

public class Estudiante {
    String ci;
    String nombre,ape;
    int edad;
    double[] calificaciones;
    final int CANT_NOTAS = 7;
    
    
    Estudiante( String ci, String nombre, String ape, int edad ){
       this.ci             = ci;
       this.nombre         = nombre;
       this.ape            = ape;
       this.edad           = edad;
       this.calificaciones = new double[ CANT_NOTAS ];
       inicializarCalif( );
    }
    
    public String nombApell( ){
        return nombre + " " + ape;
    }
    
    // inicializacion de la calificaciones
   private void inicializarCalif( ) {
        int pos = 0;
        while ( pos < calificaciones.length ){
            calificaciones[ pos ] = -1;
            pos ++;
        }
    }
   
   
    boolean registraCalif ( double calif ){
        int pos = 0;
        while ( pos < this.calificaciones.length ){
          if ( this.calificaciones[ pos ] == -1 ){
              this.calificaciones[ pos ] = calif;
              return true;
          }
          pos ++;
        }
            
        return false;
    }
        
    public double promCalif( ) {
        int pos = 0;
        double suma = 0;
        int cantCalif = 0;
        while ( pos < calificaciones.length ) {
            if ( calificaciones[pos] != -1 ) {
                suma += calificaciones[ pos ];
                cantCalif ++;
            }
            pos ++;
        }
        
       return ( cantCalif == 0 ) ? -1 : suma / cantCalif;
    }
 
    public void imprimirXConsola( ) {
        System.out.println(Mensajes.NOTIF.DATOS_ESTUDIANTE.tx());
        System.out.println(Mensajes.NOTIF.CEDULA.tx() + this.ci);
        System.out.println(Mensajes.NOTIF.NOMBRE.tx() + this.nombre);
        System.out.println(Mensajes.NOTIF.APELLIDO.tx() + this.ape);
        System.out.println(Mensajes.NOTIF.EDAD.tx() + this.edad);
    }
    
    
}
