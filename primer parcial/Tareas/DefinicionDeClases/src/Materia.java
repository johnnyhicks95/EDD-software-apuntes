public class Materia {
    String nombre;
    int cantHoras;

    Materia(String nombre, int cantHoras) {
        this.nombre = nombre;
        this.cantHoras = cantHoras;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantHoras() {
        return cantHoras;
    }

    public void setCantHoras(int cantHoras) {
        this.cantHoras = cantHoras;
    }

  
    
}
