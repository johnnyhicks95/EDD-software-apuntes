public class EmpleadoPorHoras extends Persona {

    // atributos propios 
    int sueldoPorHora = 10;
    int horasTrabajadas = 8;

    EmpleadoPorHoras(String nombApell, String ci, int edad, int sueldoPorHora, int horasTrabajadas) {
        super(nombApell, ci, edad);

        this.sueldoPorHora = sueldoPorHora;
        this.horasTrabajadas = horasTrabajadas;
         
    }

    int calcularSueldo(){
        return sueldoPorHora * horasTrabajadas;
    }

    @Override
   public String toString(){
       return this.nombApell + " sueldo ==> " + calcularSueldo(); 
   }
    
}
