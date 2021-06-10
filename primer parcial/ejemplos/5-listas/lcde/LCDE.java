package LCDE;

/**
 *
 * @author Roger
 */
public class LCDE {

    Nodo primero;
    int cantNodos;

    public LCDE() {
        this.primero   = null;
        this.cantNodos = 0;
    }

    public int insertar(Object dato) {
        Nodo nuevo;
        try {
            nuevo = new Nodo(dato);
        } catch (Exception e){
            return Error.MEMORIA_INSUFICIENTE;
        }
        if (this.primero == null) {
            this.primero.siguiente = this.primero.anterior = this.primero = nuevo;
        } else {
            nuevo.siguiente = this.primero;
            nuevo.anterior  = this.primero.anterior; 
            this.primero.anterior.siguiente = nuevo;
            this.primero.anterior = nuevo;
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
            if ( this.primero == null ) {
                this.primero.anterior = this.primero.siguiente = this.primero = nuevo;
            } else {
                nuevo.anterior = this.primero.anterior;
                nuevo.siguiente = this.primero;
                this.primero.anterior.siguiente = nuevo;
                this.primero = this.primero.anterior = nuevo;
            }
        } else {
            int posActual = 1;
            Nodo aux = this.primero;
            while ( posActual != ( pos - 1 ) ) {
                aux = aux.siguiente;
                posActual++;
            }
            nuevo.siguiente = aux.siguiente;
            nuevo.anterior = aux;
            aux.siguiente.anterior = nuevo;
            aux.siguiente = nuevo;
        }
                
        this.cantNodos ++;
        return Error.NINGUNO;
    }

    public int eliminar( int pos ) {
        if ( this.cantNodos == 0 ) 
            return Error.ESTRUCTURA_VACIA; 
        if ( pos < 1 || pos > cantNodos ) {
            return Error.INDICE_FUERA_RANGO;
        }

        if ( pos == 1 ) {
            if ( this.primero.siguiente == this.primero ) {
                this.primero = null;
            } else {
                this.primero.anterior.siguiente = this.primero = this.primero.siguiente;
                this.primero.anterior = this.primero.anterior.anterior;
            }   
        } else {
            Nodo aux = this.primero;
            int posActual = 1;
            while ( posActual != pos - 1 ) {
                aux = aux.siguiente;
                posActual ++;
            }
            aux.siguiente = aux.siguiente.siguiente;
            aux.siguiente.anterior = aux.siguiente.anterior.anterior;
        }
        cantNodos--;
        return Error.NINGUNO;
    }

    public int eliminar( Object dato ) {
        if (this.primero == null) 
            return Error.ESTRUCTURA_VACIA;
        
        boolean algoBorrado = false;
        
        while ( this.primero != null && this.primero.dato.equals ( dato ) ) {
             if ( this.primero.siguiente == this.primero ) {
                this.primero = null;
            } else {
                this.primero.anterior.siguiente = this.primero = this.primero.siguiente;
                this.primero.anterior = this.primero.anterior.anterior;
            } 
            cantNodos --;
            algoBorrado = true;
        }
        if ( this.primero != null ){
            Nodo aux = this.primero;
            while ( aux.siguiente != this.primero ) {
                if ( aux.siguiente.dato.equals ( dato ) ) {
                    aux.siguiente = aux.siguiente.siguiente;
                    aux.siguiente.anterior = aux;
                    cantNodos--;
                    algoBorrado = true;
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
            if (aux.dato != null) {
                System.out.println(aux.dato.toString());
            }
            aux = aux.siguiente;
        } while (aux != this.primero);
    }

}
