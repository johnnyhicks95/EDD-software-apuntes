public class Persona {
    String nombApell;
   int edad;
   String ci;

   int sueldoPorHora = 10;
   
   Persona(String nombApell, String ci, int edad){
       this.nombApell =  nombApell;
       this.ci        =  ci;
       this.edad      = edad;
   }
   
   void imprimirDatosPorConsola(){
       System.out.println(this.toString());
   }
   
   @Override
   public String toString(){
       return this.nombApell + " (" + this.ci + ") ==> " + this.edad + " años"; 
   }
}
