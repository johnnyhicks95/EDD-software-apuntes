package estudiante;

import validacion.Validador;
import interfaz.consola.Consola;

public class Menu {
    
    public static void menuGeneral(GestorEstudiantes gestorEstudiantes) {
        int ope;
        do {
            Menu.imprimirMenuGnral();

            ope = Integer.parseInt(Consola.ingresarDato( Mensajes.ENTRADA.OPCION.tx( ),
                                                         Mensajes.ERROR.OPCION.tx( ),
                                                         Validador.MENU ) );
            
            switch (ope) {
                case 1:
                    matricularEstudiantes(gestorEstudiantes);
                    break;
                case 2:
                    ingresarCalificaciones(gestorEstudiantes);
                    break;
                case 3:
                    calcPromCalifEst(gestorEstudiantes);
                    break;
                case 4:
                    promNotasCurso(gestorEstudiantes);
                    break;
                case 5:
                    System.out.println(Mensajes.NOTIF.DESPEDIDA.tx());
                    break;
                default:
                    System.out.println(Mensajes.ERROR.VALOR_NO_VALIDO.tx());
                    break;
            }
        } while (ope != 5);
    }

    private static void matricularEstudiantes(GestorEstudiantes gestorEstudiantes) {
        String ope;
        do {
            System.out.println(Mensajes.MENU.ENCABEZADO_MENU_MATRICULA.tx()); 
            matricularEstudiante(gestorEstudiantes);
            System.out.println(Mensajes.ENTRADA.CONFIRM_OTRO_ESTUD.tx());
            ope = Consola.get_().entrada.nextLine();
        } while ("s".equals(ope.toLowerCase()));

    }

    //menu donde se ingresa los datos case 1:
    private static void matricularEstudiante(GestorEstudiantes gestorEstudiantes) {
        String ci = Consola.ingresarDato(Mensajes.ENTRADA.CEDULA.tx(),
                                         Mensajes.ERROR.CEDULA.tx(),
                                         Validador.CEDULA);

        String nombre = Consola.ingresarDato(Mensajes.ENTRADA.NOMBRE.tx(),
                                             Mensajes.ERROR.NOMBRE.tx(),
                                             Validador.SOLO_LETRAS);

        String apellido = Consola.ingresarDato(Mensajes.ENTRADA.APELLIDO.tx(),
                                               Mensajes.ERROR.APELLIDO.tx(),
                                               Validador.SOLO_LETRAS);

        int edad = Integer.parseInt(Consola.ingresarDato(Mensajes.ENTRADA.EDAD.tx(),
                                                         Mensajes.ERROR.EDAD.tx(),
                                                         Validador.EDAD_EST));

        if (!gestorEstudiantes.insertarEstudiante(new Estudiante(ci, nombre, apellido, edad))) {
            System.out.println(Mensajes.ERROR.NUEVO_ESTUD.tx());
        } else {
            System.out.println(Mensajes.NOTIF.NUEVO_ESTUD_MATRIC.tx());
        }

    }

    private static void ingresarCalificaciones(GestorEstudiantes gestorEstudiantes) {
        System.out.println(Mensajes.MENU.ENCABEZADO_MENU_CALIF.tx());
        String cedula = Consola.ingresarDato(Mensajes.ENTRADA.CEDULA.tx(),
                                             Mensajes.ERROR.CEDULA.tx(),
                                             Validador.CEDULA);
        Estudiante e = gestorEstudiantes.buscarEstudianteCedula(cedula);
        if (e != null) {
            e.imprimirXConsola();
            double calificacion;
            boolean registroCalif;
            System.out.println(Mensajes.NOTIF.INGRESAR_CALIFS.tx());
            do {
                calificacion = Double.parseDouble(Consola.ingresarDato(Mensajes.ENTRADA.CALIF.tx(),
                                                                       Mensajes.ERROR.CALIF.tx(),
                                                                       Validador.CALIF));
                registroCalif = false;
                if (calificacion != -1) {
                    if (e.registraCalif(calificacion)) {
                        System.out.println(Mensajes.NOTIF.NUEVA_CALIF_ING.tx());
                        registroCalif = true;
                    }
                }
            } while (registroCalif);

            if (calificacion != -1) {
                System.out.println(Mensajes.ERROR.CALIF_OVERFLOW.tx());
            }
        } else {
            System.out.println(Mensajes.ERROR.ESTUD_NO_EXISTE.tx());
        }
    }

    private static void calcPromCalifEst(GestorEstudiantes gestorEstudiantes) {
        String cedula = Consola.ingresarDato(Mensajes.ENTRADA.CEDULA.tx(),
                                             Mensajes.ERROR.CEDULA.tx(),
                                             Validador.CEDULA);
        Estudiante e = gestorEstudiantes.buscarEstudianteCedula(cedula);
        if ( e != null ) {
            e.imprimirXConsola( );
            double promCalif = e.promCalif( );
            if ( promCalif == -1 ) {
                System.out.println(Mensajes.ERROR.SIN_INGRESO_CALIF.tx());
            } else {
                System.out.println(Mensajes.NOTIF.PROMEDIO_CALIF.tx() + promCalif);

            }
        } else {
            System.out.println(Mensajes.ERROR.ESTUD_NO_EXISTE.tx());
        }
    }

    private static void promNotasCurso(GestorEstudiantes gestorEstudiantes) {
        double promCalif = gestorEstudiantes.promCalif();
        if (promCalif == -1) {
            System.out.println(Mensajes.ERROR.NO_EXISTEN_CALIF.tx());
        } else {
            System.out.println(Mensajes.NOTIF.PROMEDIO_CALIF_TOTAL.tx() + promCalif);
        }
    }

    private static void imprimirMenuGnral() {
        System.out.println(Mensajes.MENU.ENCABEZADO_MENU.tx());
        System.out.println(Mensajes.MENU.OPCION1.tx());
        System.out.println(Mensajes.MENU.OPCION2.tx());
        System.out.println(Mensajes.MENU.OPCION3.tx());
        System.out.println(Mensajes.MENU.OPCION4.tx());
        System.out.println(Mensajes.MENU.OPCION5.tx());
    }

}
