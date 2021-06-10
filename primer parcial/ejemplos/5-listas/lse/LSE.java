//MÉTODOS FINALES LIBRO
package lse;

/**
 *
 * @author Cristian López
 * @reviewedBy Félix Fernández
 */

public class LSE {

    Nodo primero;
    int cantNodos;
    
    public LSE() {
        this.primero = null;
        this.cantNodos = 0;
    }

    public int insertar( Object dato ) {
        Nodo nuevo;
        try {
            nuevo = new Nodo( dato );            
        } catch ( Exception e ) {
            return Error.MEMORIA_INSUFICIENTE;
        }
       
        if ( this.primero == null ) {
            this.primero = nuevo;
        } else {
            getUltimo( ).siguiente = nuevo; 
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
        }
        catch ( Exception e ){
            return Error.MEMORIA_INSUFICIENTE;
        }
        if ( pos == 1 ) {
            if ( this.primero == null )
                this.primero = nuevo;
            else {
                nuevo.siguiente = this.primero;
                this.primero = nuevo;
            }
        } else{
            Nodo aux = this.primero;
            int posActual = 1;
            while ( posActual != pos -1 ) {
                aux = aux.siguiente;
                posActual ++;
            }
            nuevo.siguiente = aux.siguiente;
            aux.siguiente = nuevo;
        }
        this.cantNodos ++;
        return Error.NINGUNO;    
    }

    public int eliminar( int pos ) {
         if ( this.cantNodos == 0 ) 
            return Error.ESTRUCTURA_VACIA;
        if ( pos < 1 || pos > this.cantNodos ) {
            return Error.INDICE_FUERA_RANGO;
        }
        if ( pos == 1 ) 
            this.primero = this.primero.siguiente;
        else{
            Nodo aux = this.primero;
            int posActual = 1;
            while (posActual != (pos - 1)) {
                posActual++;
                aux = aux.siguiente;
            }
            aux.siguiente = aux.siguiente.siguiente;
        }
        cantNodos --;
        return Error.NINGUNO;
    }

    public int eliminar( Object dato ) {
        if ( this.primero == null ) 
            return Error.ESTRUCTURA_VACIA;
        boolean algoBorrado = false;
        while ( this.primero != null && this.primero.dato.equals ( dato ) ) {
            this.primero = this.primero.siguiente;
            cantNodos--;
            algoBorrado = true;
        }
        if ( this.primero != null ) {
            Nodo aux = this.primero;
            while ( aux.siguiente != null ) {
                if ( aux.siguiente.dato.equals( dato ) ) {
                    aux.siguiente = aux.siguiente.siguiente;
                    cantNodos--;
                    algoBorrado = true;
                } else {
                    aux = aux.siguiente;
                }
            }
        }
        return ( algoBorrado ) ? Error.NINGUNO : Error.NO_ENCONTRADO;
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
        if ( this.primero == null ) 
            return null;
        Nodo aux = this.primero;

        while ( aux != null ) {
            if ( aux.dato.equals( dato ) )
                    return aux.dato;

            aux = aux.siguiente;
        }
        return null;
    }

    public Object[] buscarTodos( Object dato ) {
        Object[] datos = new Object[this.cantNodos];

        Nodo aux = this.primero;
        int ultimoIgual = 0;
        
        while (aux != null) {
            if ( aux.dato.equals( dato ) ){
                datos[ ultimoIgual ] = aux.dato;
                ultimoIgual ++;
            }
            aux = aux.siguiente;
        }
        
        return datos;
    }
    
    public void imprimir( ) {
        Nodo aux = this.primero;
        while ( aux != null ) {
            if ( aux.dato != null ) {
                System.out.println( aux.dato.toString( ) );
            }
            aux = aux.siguiente;
        }
    }
    
    private Nodo getUltimo() {
        if ( this.primero == null )
            return null;
        Nodo aux = this.primero;
        while ( aux.siguiente != null )
            aux = aux.siguiente;
        return aux;
    }    
}
