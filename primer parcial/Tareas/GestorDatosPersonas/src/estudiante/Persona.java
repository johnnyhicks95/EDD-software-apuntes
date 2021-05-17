package estudiante;

public class Persona {
    String nombre;
    int edad;
    String ci;

    public Persona(String nombre, int edad, String ci) {
        this.nombre = nombre;
        this.edad = edad;
        this.ci = ci;
    }

    

    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public int getEdad() {
        return edad;
    }



    public void setEdad(int edad) {
        this.edad = edad;
    }



    public String getCi() {
        return ci;
    }



    public void setCi(String ci) {
        this.ci = ci;
    }



    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", edad=" + edad + ", CI=" + ci + "]";
    }

    void imprimirDatosPorConsola(){
        System.out.println(this.toString());
    }
  
}
