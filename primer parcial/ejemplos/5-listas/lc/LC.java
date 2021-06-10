//METODOS FINALES LIBRO
package LC;

/**
 *
 * @author Roger
 * @reviewedBy Félix Fernández
 */

public class LC {

    Nodo primero;    
    int cantNodos;

    LC(){
        this.primero = null;
        this.cantNodos = 0;
    }
    
    public int insertar(Object dato) {
        Nodo nuevo;
        try {                                                                               
            nuevo = new Nodo( dato );            
        } catch (Exception e) {
            return Error.MEMORIA_INSUFICIENTE;
        }
        if (this.primero == null) { //si la lista está vacía
            this.primero = nuevo; // el nuevo nodo será el primer nodo de la lista
            this.primero.siguiente = this.primero; // y el nuevo nodo hará referencia a sí mismo por el siguiente.
        } else {
            this.getUltimo().siguiente = nuevo;
            nuevo.siguiente = this.primero;
        }
        cantNodos++;
        return Error.NINGUNO;
    }

    public int insertar( Object dato, int pos ) {
        if ( pos > cantNodos + 1 || pos < 1 ) {
            return Error.INDICE_FUERA_RANGO;
        }
        
        Nodo nuevo;
        try {
            nuevo = new Nodo( dato );            
        } catch ( Exception e ) {
            return Error.MEMORIA_INSUFICIENTE;
        }
        
        if ( pos == 1 ) {
            if ( this.primero == null ) {
                this.primero.siguiente = this.primero = nuevo;
            } else {
                nuevo.siguiente = this.primero;
                getUltimo().siguiente = nuevo;                
                this.primero = nuevo;
            }
            cantNodos++;
            return Error.NINGUNO;
        }
        int posActual = 1;
        Nodo aux = this.primero;
        while (posActual != (pos - 1)) {
            aux = aux.siguiente;
            posActual++;
        }
        
        nuevo.siguiente = aux.siguiente;
        aux.siguiente = nuevo;
   
        cantNodos++;
        return Error.NINGUNO;
    }

    public int eliminar( int pos ) {
        if ( this.primero == null ) {
            return Error.ESTRUCTURA_VACIA;
        }
        if ( pos < 1 || pos > this.cantNodos ) {
            return Error.INDICE_FUERA_RANGO;
        }
        if ( pos == 1 ) {
            if ( this.primero.siguiente == this.primero ) {
                this.primero = null;
            } else {
                this.primero = this.primero.siguiente;
                this.getUltimo().siguiente = this.primero;
            }
        } else {
            Nodo aux = this.primero;
            int posActual = 1;
            while ( posActual != pos - 1 ) {
                posActual++;
                aux = aux.siguiente;
            }
            aux.siguiente = aux.siguiente.siguiente;
        }
    
        cantNodos--;
        return Error.NINGUNO;
    }

    public int eliminar( Object dato ) {
        if (this.primero == null) {
            return Error.ESTRUCTURA_VACIA;
        }
        boolean algoBorrado = false;
        Nodo ultimo  = this.getUltimo();
        while ( this.primero != null && this.primero.dato.equals( dato ) ) {
            if ( this.primero == ultimo ) {
                this.primero = null;                
            } else {
                this.primero = this.primero.siguiente;
                ultimo.siguiente = this.primero;                
            }
            algoBorrado = true;
            this.cantNodos --;
        }
        if ( this.primero != null ){
            Nodo aux = this.primero;
            while ( aux.siguiente != this.primero ) {
                if (aux.siguiente.dato.equals( dato ) ) {
                    aux.siguiente = aux.siguiente.siguiente;
                    algoBorrado = true;
                    cantNodos--;
                } else 
                    aux = aux.siguiente;
            }
        }
        return (algoBorrado) ? Error.NINGUNO : Error.NO_ENCONTRADO; 
    }

    public Object buscar( int pos ) {
        if ( this.primero == null || pos < 1 || pos > this.cantNodos )
            return null;
        Nodo aux = this.primero;
        int posActual = 1;
        do {
            if ( posActual == pos ) {
                return aux.dato; 
            }
            posActual++;
            aux = aux.siguiente;
        } while ( true );
    }

    public Object buscar( Object dato ) {
        if ( this.primero != null ) {
            Nodo aux = this.primero;
            do {
                if ( aux.dato.equals( dato ) )
                    return aux.dato;
                aux = aux.siguiente;
            } while ( aux != this.primero );
        }
        return null;
    }
    
 public Object[] buscarTodos( Object dato ) {
        Object[] datos = new Object[this.cantNodos];

        Nodo aux = this.primero;
        int ultimoIgual = 0;
        
        do {
            if ( aux.dato.equals( dato ) ){
                datos[ ultimoIgual ] = aux.dato;
                ultimoIgual ++;
            }
            aux = aux.siguiente;
        } while ( aux != this.primero );
        
        return datos;
 }
 
    public void imprimir( ) {
        if (this.primero == null) {
            return;
        }
        Nodo aux = this.primero;
        do {
            if ( aux.dato != null ) {
                System.out.println( aux.dato.toString( ) );
            }
            aux = aux.siguiente;
        } while ( aux != this.primero );
    }

    private Nodo getUltimo( ) {
        if ( this.primero == null )
            return null;
        Nodo aux = this.primero;
        while ( aux.siguiente != this.primero )
            aux = aux.siguiente;
        return aux;
    }

}
