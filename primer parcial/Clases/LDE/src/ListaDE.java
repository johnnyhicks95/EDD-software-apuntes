public class ListaDE {

    NodoDE primero;
    NodoDE ultimo;

    int cant;

    ListaDE() {
        this.primero = this.ultimo = null;
    }

    public boolean insertar( Object dato ){
        try{
            // lista vacia
            if( this.primero == null ){
                this.primero = new NodoDE(dato);
                return true;
            }

            // declaro una referencia al primero
            NodoDE ultimo = this.primero;
            // buscar el ultimo nodo
            while( ultimo.siguiente != null ){
                ultimo = ultimo.siguiente;
            }
            // insertar el nodo
            ultimo.siguiente = new NodoDE(dato);
            // enlazo el anterior al ultimo
            ultimo.siguiente.anterior = ultimo;
            return true;
        } catch(Exception e){
            return false;
        }
    }

    // se construye con un auxiliar
    public boolean insertarPorPrimero(Object dato){
        NodoDE nuevo;
        try {
            nuevo = new NodoDE(dato);
        } catch (Exception e) {
            return false;
        }

        if (this.primero == null){

            nuevo.siguiente = this.primero;
            this.primero.anterior = nuevo;
        }
        else 
            this.ultimo = nuevo;
        this.primero = nuevo;
        this.cant++;

        return true;
    }

    // se construye sin necesidad de un auxiliar
    public boolean insertarOtroPorPrimero(Object dato){
        try {
            if (this.primero == null){

                return true;
            }

            this.primero.anterior = new NodoDE(dato);
            this.primero.anterior.siguiente = this.primero;
            // le manda hacia atrás la referencia
            this.primero= this.primero.anterior;
            
            this.cant++;
            return true;

        } catch (Exception e) {
          return false;
        }
    }

    public boolean insertar (Object dato, int pos){
        

        return true;
    } 

    void imprimir() {
        NodoDE aux = this.primero;
        while (aux != null) {
            System.out.println(aux.dato.toString());
            aux = aux.siguiente;
        }
    }

    public Object buscar(int pos){
        int posActual=0;

        NodoDE aux = this.primero;
        while( aux != null && posActual !=pos ){
            aux = aux.siguiente;
            posActual++;
        }
        if( aux != null )
            return aux.dato;

        return null;
    }

    public boolean borrar(int pos){
        // corresponde a validar que pos no sea mayor a la
        // cantidad de datos
        if(pos < 0){
            return false;
        }

        if (pos == 0){
            if(this.primero != null){
                this.primero = this.primero.siguiente;
                //
                if (this.primero != null)
                    this.primero.anterior = null;
                return true;
            }
            else 
                return false;
        }
        // buscar la penultima posicion
        int posActual = 0;
        pos --;
        NodoDE aux = this.primero;

        while ( aux != null && posActual< pos){
            aux = aux.siguiente;
            posActual++;
        }

        // procedo a eliminar
        if( aux != null){
            aux.siguiente = aux.siguiente.siguiente;
            if ( aux.siguiente != null )
                aux.siguiente.anterior = aux; 
            /* if ( aux. siguiente == null )
                this.ultimo = aux; */
            return true;
        }

        return false;
    }

    public boolean borrar ( Object dato ){
        boolean borrado = false;

        while( this.primero !=null && this.primero.dato.equals(dato)){
            this.primero = this.primero.siguiente;
            //
            if (this.primero !=null)
                this.primero.anterior = null;
            borrado = true;
        }
        // compruebo que no me esté qudando con la lista vacía
        if ( this.primero != null ){
            NodoDE aux = this.primero;

            while(aux.siguiente!=null){
                if(aux.siguiente.dato.equals(dato)){
                    aux.siguiente = aux.siguiente.siguiente;
                    if ( aux.siguiente != null )
                        aux.siguiente.anterior = aux;
                    borrado = true;
                }
                else 
                    aux = aux.siguiente;
            }
        }
 
        return borrado;
    }

}