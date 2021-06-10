public class ListaCircular{
    Nodo primero;

    public ListaCircular() {
        this.primero = null;
    }

    public boolean insertar(Object dato) {
        try {
            if (this.primero == null) { //lista vacía
                // agrego el nuevo nodo en primero de la lista
                this.primero = new Nodo(dato);
                // hacer referencia a si mismo
                this.primero.siguiente = this.primero; 
                return true;
            }

            // Nodo aux = this.primero;
            Nodo ultimo = this.primero;

            // while (ultimo.siguiente != null) {
            while (ultimo.siguiente != this.primero) {
                ultimo = ultimo.siguiente;
            }

            // Nodo nuevo = new Nodo(dato, this.primero);
            
            // hago referencia del utimo al nuevo
            /* ultimo.siguiente = nuevo;  
            ultimo.siguiente = new Nodo(dato); */
            ultimo.siguiente = new Nodo(dato, this.primero);

            // es equivalente a:
            // ultimo.siguiente = new Nodo()dato;
            //ultimo.siguiente.siguiente = this.primero;
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    boolean insertarPorPrimero(Object dato) {
        Nodo nuevo;
        try {
            nuevo = new Nodo(dato);
        } catch (Exception e) {
            return false;
        }
        if (this.primero == null) //lista vacía
            this.primero = nuevo;
            //this.primero = new Nodo(dato,this.primero);
        else{
           nuevo.siguiente = this.primero; 
           this.primero = nuevo;
        }
        return true;
    }

    // insertar por posición
    public void insertarEn(int pos, Object dato) {
        
        // when position is zero
        if ( pos < 1 && pos < -1 ) {
            insertarPorPrimero(dato);
        }
        
        Nodo nuevo = new Nodo(dato);
        // nuevo.dato = dato;
        // nuevo.siguiente = null;

        // cuando no es el primer elemento en la lista
        Nodo aux = this.primero;

        int posActual = 0;
        while ( posActual != pos -1 ) {
            aux = aux.siguiente;
            posActual ++;
        }

        // intercambio la direccion del nodo
        nuevo.siguiente = aux.siguiente; // nodo.siguiente is new nodo; n.siguiente is last position
        aux.siguiente = nuevo; // update location at node

    }


    // pendiente
    public void imprimir(){
        if (this.primero == null) {
            return;
        }
        Nodo aux = this.primero;
        while (aux != null){
            System.out.println(aux.dato.toString());
            aux = aux.siguiente;
        }

        //
        if (primero == null)
            return;
        // Nodo aux = this.primero;
        do{
            System.out.println(aux.dato.toString());
        } while ( aux !=this.primero );
    }
    
    public Object buscar(int pos){
        int posActual = 0;
        Nodo aux = this.primero;
        // comprobar que la lista esta vacia 
        // o la pos no sea mayor a 1
        if ( this.primero == null || pos < 1 )
            return null;

        // la lista no está vacía
        while (aux != null && posActual != pos){
            aux = aux.siguiente;
            posActual ++;
        }
        if (aux != null)
            return aux.dato;
        return null;
    }
    
    public boolean borrar(int pos){
        // lo inserta en la primera posición [0]
        if (pos == 0 )
            if (this.primero != null){
                // cambio la referencia, el garbage lo elimina en memoria
                this.primero = this.primero.siguiente;
                return true;
            }
            else
                return false;
        

        if ( pos == 1 ) {
            // borro el primer elemento
            if ( this.primero.siguiente == this.primero ) {
                this.primero = null;
                return true;
            } 

            this.primero = this.primero.siguiente;
            // buscar al ultimo nodo y hacer que apunte a si mismo
            while ( this.primero.siguiente != this.primero )
                this.primero = this.primero.siguiente;
            this.primero.siguiente = this.primero;
            return true;
            
        } 
        // posicion mayor a 1
       int posActual = 0;
        pos --;
        Nodo aux = this.primero;
       
        while (aux != this.primero && posActual < pos){
            aux = aux.siguiente;
            posActual ++;
        }
        
        if (aux != this.primero){
            // al ultimo hago referencia al null por el siguiente
            aux.siguiente = aux.siguiente.siguiente;
            return true;
        }
        
        return false;
    }
    
    
    
    
    public boolean borrar(Object dato){
        boolean borrado = false;
        // no hay datos, lista vacia
        if (this.primero == null) {
            return borrado;
        }
        // el primer elemento en lista
        while (this.primero != null && this.primero.dato.equals(dato)){
            //
            if ( this.primero.siguiente != this.primero ) 
                this.primero = null; 
            this.primero = this.primero.siguiente;
            borrado = true;
        }
        
        // mas de un elemento en lista
        if (this.primero != null){
            Nodo ultimo = this.primero;
            while (ultimo.siguiente != null){
                if (ultimo.siguiente.dato.equals(dato)){ //(ultimo.siguiente.dato == dato)
                    ultimo.siguiente = ultimo.siguiente.siguiente;
                    borrado = true;
                }
                else
                    ultimo = ultimo.siguiente;
            }
        }
        return borrado;
    }
    
    // metodo ara encontrar por el ultimo
    private Nodo getUltimo( ) {
        if ( this.primero == null )
            return null;
        Nodo aux = this.primero;
        while ( aux.siguiente != this.primero )
            aux = aux.siguiente;
        return aux;
    }

}