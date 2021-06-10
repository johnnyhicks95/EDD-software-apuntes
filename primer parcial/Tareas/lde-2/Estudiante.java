/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listadoblementeenlazada.sw.pkg20.pkg21;

/**
 *
 * @author felix
 */
public class Estudiante {
   String nombApell;
   Estudiante mejorAmigo;
   
   Estudiante ( String nombApell) {
       this.nombApell = nombApell;
       this.mejorAmigo = null;
   }
   
   void mejorAmigo( Estudiante amigo ){
       this.mejorAmigo = amigo;
   }
   
   
   
   @Override
   public String toString(){
       return this.nombApell;
   }
   
}
