/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author felix
 */
public class Validador {
    
    public static final int MENU        = 0;
    public static final int SOLO_LETRAS = 1;
    public static final int CEDULA      = 2;
    public static final int EDAD_EST    = 3;
    public static final int CALIF       = 4;

    public static boolean esCalif(String calif){
        String regex = "[+-]?([0-9]*[.])?[0-9]+";
            if ( calif.matches( regex ) ){
                double valorCalif = Double.parseDouble ( calif );
                return ( valorCalif == -1 || ( valorCalif >= 0 && valorCalif <= 10 ) );
            }
            return false;
    }
    
    public static boolean esMenu(String opcion){
        String regex = "-?[1-5]+";
            if ( opcion.matches( regex ) ){
                int valorOpcion = Integer.parseInt( opcion );
                return ( valorOpcion == -1 || ( valorOpcion > 0 && valorOpcion < 6 ) );
            }
            return false;
    }
    
    public static boolean esSoloLetras(String cadena) {
        String regex = "[ñÑáéíóúÁÉÍÓÚA-Za-z].+";
        return ( cadena.matches( regex ) );
    }

    public static boolean esCedula( String cedula ) {
        boolean cedulaCorrecta;
        try {
            if (cedula.length( ) == 10 ) {
                // Coeficientes de validación cédula
                // El decimo digito se lo considera dígito verificador
                int[ ] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
                int verificador = Integer.parseInt( cedula.substring( 9, 10 ) );
                int suma = 0; 
                int digito;
                for ( int i = 0; i < ( cedula.length( ) - 1 ); i++ ) {
                    digito = Integer.parseInt( cedula.substring( i, i + 1 ) ) * coefValCedula[ i ];
                    suma += ( ( digito % 10 ) + ( digito / 10 ) );
                }

                cedulaCorrecta = ( ( suma % 10 == 0 && verificador == 0  ) ||  ( 10 - suma % 10 == verificador ) );
            } else {
                cedulaCorrecta = false;
            }
        } catch ( Exception e ) {
            cedulaCorrecta = false;
        }
        return cedulaCorrecta;
    }
    
    public static boolean esEdadEstudiar( String edad ){
        String regex = "[0-9]+";
        if ( edad.matches( regex ) ){
            int valorEdad = Integer.parseInt( edad );
            return ( valorEdad > 17 && valorEdad < 65 );
        }
        return false;
    }

    public static boolean validar( String dato, int tipoValidador ) {
        boolean esValido;
        switch ( tipoValidador ) {
            case MENU:
                esValido = esMenu( dato );
                break;
            case SOLO_LETRAS:
                esValido = esSoloLetras( dato );
                break;
            case CEDULA:
                esValido = esCedula( dato );
                break; 
            case EDAD_EST:
                esValido = esEdadEstudiar (dato );
                break;  
            case CALIF:
                esValido = esCalif( dato );
                break;
            default:
                throw new AssertionError( );
        }
        return esValido;
    }
}
