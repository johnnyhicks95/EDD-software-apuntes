
package lde;

/**
 *
 * @author Roger
 */
public class Nodo {
    Object dato;
    Nodo siguiente;
    Nodo anterior;
    
    public Nodo(Object dato){
        this.dato=dato;
        this.siguiente=null;
        this.anterior=null;
    }
}
