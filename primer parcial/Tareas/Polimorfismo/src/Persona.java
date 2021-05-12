
public class Persona {
    String nombApell;
    int edad;
    String ci;

    Persona(String nombApell, String ci, int edad) {
        this.nombApell = nombApell;
        this.ci = ci;
        this.edad = edad;
    }

    void imprimirDatosPorConsola() {
        System.out.println(this.toString());
    }

    void saludar() {
        System.out.println("Saludos cordiales persona!");
    }

    @Override
    public String toString() {
        return this.nombApell + " (" + this.ci + ") ==> " + this.edad + " años";
    }
}
