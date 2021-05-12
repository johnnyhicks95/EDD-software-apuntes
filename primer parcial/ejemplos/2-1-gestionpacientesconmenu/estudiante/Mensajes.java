// package estudiante;

/**
 *
 * @author felix
 */

public class Mensajes {
    
    public enum ENTRADA {
        OPCION             ("Opción: "),
        CEDULA             ("Cédula del estudiante: "),
        NOMBRE             ("Nombre del estudiante: "),
        APELLIDO           ( "Apellido del estudiante: " ),
        EDAD               ( "Edad del estudiante: " ),
        CONFIRM_OTRO_ESTUD ( "Inscribir otro estudiante (s/n)" ),
        CALIF              ( "Calificación: " );

        private String valor;

        private ENTRADA( String v ) {
            valor = v;
        }
        
        public String tx(){
            return valor;
        }
    }
   
    
    public enum ERROR {
        OPCION            ( "Número de opción no válida." ),
        CEDULA            ( "El número de cédula especificado no es válido." ),
        NOMBRE            ( "Solo se aceptan caracteres alfabéticos como parte del nombre." ),
        APELLIDO          ( "Solo se aceptan caracteres alfabéticos como parte del apellido." ),
        EDAD              ( "El valor ingresado debe ser un número entero entre 18 y 65." ),
        CALIF             ( "El valor ingresado no es válido como valor de calificación." ),
        VALOR_NO_VALIDO   ( "Valor no válido" ),
        NUEVO_ESTUD       ( "No fue posible insertar los datos del estudiante."), 
        CALIF_OVERFLOW    ( "Ya se registró la cantidad máxima de calificaciones. No fue posible registrar esta última calificación." ), 
        ESTUD_NO_EXISTE   ( "No existe estudiante matriculado con el número de cédula ingresado." ), 
        SIN_INGRESO_CALIF ( "ERROR: Este estudiante no tiene calificaciones registradas." ), 
        NO_EXISTEN_CALIF  ( "No se han registrado calificaciones de los estudiantes." );

        private String valor;

        private ERROR( String v ) {
            valor = v;
        }
        
        public String tx(){
            return valor;
        }
    }
 
    public enum NOTIF {
        DESPEDIDA            ( "HASTA PRONTO!!!" ),
        NUEVO_ESTUD_MATRIC   ( "Datos de estudiante ingresados satisfactoriamente." ), 
        INGRESAR_CALIFS      ( "Ingrese calificaciones del estudiante: (-1 para terminar)." ),
        NUEVA_CALIF_ING      ( "Calificación ingresada correctamente." ), 
        PROMEDIO_CALIF       ( "Promedio de calificaciones: " ), 
        PROMEDIO_CALIF_TOTAL ( "El promedio de calificaciones de los estudiantes es: " ), 
        DATOS_ESTUDIANTE     ( "Datos Del Estudiante" ), 
        CEDULA               ( "Cedula : " ), 
        NOMBRE               ( "Nombre : " ), 
        APELLIDO             ( "Apellido:" ), 
        EDAD                 ( "Edad:" );

        private String valor;

        private NOTIF( String v ) {
            valor = v;
        }
        
        public String tx(){
            return valor;
        }
    }
    
    
    
    public enum MENU {
        ENCABEZADO_MENU           ( "     *****    MENU PRINCIPAL ***       " ),
        ENCABEZADO_MENU_MATRICULA ( "     *****    MATRÍCULA DE ESTUDIANTES     *****    " ),
        ENCABEZADO_MENU_CALIF     ( "     *****    INGRESO DE CALIFICACIONES     *****    " ),
        OPCION1                   ( "1  MATRICULAR ESTUDIANTE" ),
        OPCION2                   ( "2. INGRESAR DATOS DE CALIFICACION DE UN ESTUDIANTE" ),
        OPCION3                   ( "3. DETERMINAR EL PROMEDIO DE NOTAS DE UN ESTUDIANTE" ),
        OPCION4                   ( "4. DETERMINAR EL PROMEDIO DE NOTAS DEL CURSO" ),
        OPCION5                   ( "5. SALIR" );

        private String valor;

        private MENU( String v ) {
            valor = v;
        }
        
        public String tx(){
            return valor;
        }
    }
    
}
