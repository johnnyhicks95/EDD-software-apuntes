
package _06_LCDE;

/**
 *
 * @author Roger
 */
public class Nodo {
    Object dato;
    Nodo anterior;
    Nodo siguiente;
    
    public Nodo(Object dato){
        this.dato=dato;
        this.siguiente=null;
        this.anterior=null;
    }
}
