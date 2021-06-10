/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaseedci21;

/**
 *
 * @author felix
 */
public class Nodo {
   Object dato;
   Nodo   siguiente;
   
   public Nodo(Object dato){
       this.dato = dato;
       this.siguiente = null;       
   }
   
   public Nodo(Object dato, Nodo siguiente){
       this.dato = dato;
       this.siguiente = siguiente;
   }
}
