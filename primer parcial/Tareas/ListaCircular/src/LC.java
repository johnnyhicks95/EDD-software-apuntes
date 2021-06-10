/* 
Prueba: implemente el siguiente método:
En una lista circular, implemente un método que permita eliminar los nodos alternos.
 Es decir, el primer nodo no se borra, el segundo sí y así sucesivamente. Si la lista 
 tiene un único nodo, no se borra. Si no tiene nodos, no se hace nada. */
public class LC {
    Nodo primero;

    public LC() {
        this.primero = null;
    }

    public boolean borrarAlternos(){
        boolean borrado = false;
        // no hay datos, lista vacia
        if (this.primero == null) {
            return borrado;
        }

        // un único nodo, no se borra
        if ( this.primero.siguiente == this.primero ) {
            return borrado;
        } 

        // eliminar los nodos alternos.
        Nodo aux = this.primero;
        // adelanto el primero para recorrer desde el siguiente
        this.primero = this.primero.siguiente;

        while (this.primero.siguiente != this.primero)
            aux = aux.siguiente.siguiente;
            // apunto las referencias a null
            this.primero = null;
        // el primero vuelva a apuntar a si mismo
        this.primero = this.primero.siguiente;
        
        return !borrado;
    }
}
