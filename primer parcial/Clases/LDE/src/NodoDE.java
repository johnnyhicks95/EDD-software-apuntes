public class NodoDE {
    Object dato;
    NodoDE siguiente;
    NodoDE anterior;
    
    NodoDE ( Object dato ){
        this.dato = dato;
        this.siguiente = this.anterior = null;
    }
}