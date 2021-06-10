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
public class Lista {

    Nodo primero;

    public Lista() {
        this.primero = null;
    }

    public boolean insertar(Object dato) {
        try {
            if (this.primero == null) { //lista vacía
                this.primero = new Nodo(dato);
                return true;
            }

            Nodo aux = this.primero;

            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }

            aux.siguiente = new Nodo(dato);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean insertarPorPosicion( Object dato, int pos ){
        Nodo nuevo = new Nodo( dato );
        // cuando es el primer elemento en posicion 0
        if (pos < 1 && pos > -1 ){
            this.primero = new Nodo(dato, null);
            return true;
        }
        
        // cuando no es el primer elemento en la lista
        Nodo aux = this.primero;

        int posActual = 1;
        while ( posActual != pos -1 ) {
            aux = aux.siguiente;
            posActual ++;
        }
        // nuevo va a hacer referencia por el ultimo
        nuevo.siguiente = aux.siguiente;
        // referencia por el ante penultimo a la posicion
        aux.siguiente = nuevo;
        return true;
        
    }
    
    public void imprimir(){
        Nodo aux = this.primero;
        while (aux != null){
            System.out.println(aux.dato.toString());
            aux = aux.siguiente;
        }
    }
    
    public Object buscar(int pos){
        int posActual = 0;
        Nodo aux = this.primero;
        while (aux != null && posActual != pos){
            aux = aux.siguiente;
            posActual ++;
        }
        if (aux != null)
            return aux.dato;
        return null;
    }

    public Object buscar( Object dato ) {
        if ( this.primero == null ) 
            return null;
        Nodo aux = this.primero;

        // recorro hasta el último
        while ( aux != null ) {
            // comparo el dato a los de la lista
            if ( aux.dato.equals( dato ) )
                    return aux.dato;

            aux = aux.siguiente;
        }
        // si no lo encuentra retorna null
        return null;
    }

    public Object[] buscarTodos( Object dato ) {
        int cantNodos = 0;
        // agregar un metodo que cuente los nodos

        // el arreglo que guarda los nodos
        Object[] datos = new Object[cantNodos];

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
                
        int posActual = 0;
        pos --;
        Nodo aux = this.primero;
       
        while (aux != null && posActual < pos){
            aux = aux.siguiente;
            posActual ++;
        }
        
        if (aux != null){
            // al ultimo hago referencia al null por el siguiente
            aux.siguiente = aux.siguiente.siguiente;
            return true;
        }
        
        return false;
    }
    
    
    
    
    public boolean borrar(Object dato){
        boolean borrado = false;
        // comparo el dato de la lista con el dato de busqueda
        while (this.primero != null && this.primero.dato.equals(dato)){
            // ultimo = al null del ultimo
            this.primero = this.primero.siguiente;
            borrado = true;
        }
        
        // tiene al menos un primer nodo
        if (this.primero != null){
            Nodo aux = this.primero;
            // buscar el ultimo nodo de la lista
            while (aux.siguiente != null){
                if (aux.siguiente.dato.equals(dato)){ //(aux.siguiente.dato == dato)
                    // buscar hacer referencia a null
                    aux.siguiente = aux.siguiente.siguiente;
                    borrado = true;
                }
                else
                    aux = aux.siguiente;
            }
        }
        return borrado;
    }
    
    
}
