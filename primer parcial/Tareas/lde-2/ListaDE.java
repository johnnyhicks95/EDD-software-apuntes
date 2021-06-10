/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listadoblementeenlazada.sw.pkg20.pkg21;

/**
 *
 * @author felix
 */
public class ListaDE {

    NodoDE primero;
    NodoDE ultimo;

    ListaDE() {
        this.primero = this.ultimo = null;
    }

    boolean insertar(Object dato) {
        NodoDE nuevo;
        try {
            nuevo = new NodoDE(dato);
        } catch (Exception e) {
            return false;
        }
        if (this.primero == null) //lista vacía
        {
            this.primero = this.ultimo = nuevo;
        } else {
            this.ultimo.siguiente = nuevo;
            nuevo.anterior        = this.ultimo;
            this.ultimo           = nuevo;
        }
        return true;
    }

    boolean insertarPorPrimero(Object dato) {
        NodoDE nuevo;
        try {
            nuevo = new NodoDE(dato);
        } catch (Exception e) {
            return false;
        }
        if (this.primero == null) //lista vacía
            this.primero = this.ultimo = nuevo;
        else{
           nuevo.siguiente = this.primero; 
           this.primero.anterior = nuevo;
           this.primero = nuevo;
        }
        return true;
    }
    
    boolean insertarPos( Object dato, int pos ){
        if ( pos < 0 )
            return false; //posición inválida
        if ( pos == 0 )
            return insertarPorPrimero( dato ); 
        int posActual = 0;
        NodoDE aux = this.primero;
        pos = -- pos ;
        while ( posActual < pos  && aux != null ){
            aux = aux.siguiente;
            posActual ++;
        }
        if ( aux == null )
            return false; //no es válida la posición. 
        else {
            NodoDE nuevo;
            try{
                nuevo = new NodoDE( dato );
            }
            catch ( Exception e ){
                return false;  //no hay memoria suficiente
            }
            nuevo.siguiente = aux.siguiente;
            aux.siguiente   = nuevo;
            nuevo.anterior = aux;
            if ( nuevo.siguiente != null )
                    nuevo.siguiente.anterior = nuevo;
            if ( this.ultimo == aux )
                this.ultimo = nuevo;
            return true;
        }
    }
    
    public Object buscar( int pos ){
        if ( pos < 0 )
            return null;
        int posActual = 0;
        NodoDE aux = this.primero;
        while ( posActual < pos && aux != null ){
            aux = aux.siguiente;
            posActual ++;
        }
        return ( aux == null ) ? null : aux.dato;
    }
    
    public boolean borrar ( Object dato ){
        return false;
    }
    
    public boolean borrar ( int pos ){
        if ( pos < 0  || this.primero == null )
            return false;
        if ( pos == 0 ){
            this.primero = this.primero.siguiente; 
            if ( this.primero != null )
                this.primero.anterior = null;
            else
                this.ultimo = null;
            return true;
            
        }
        int posAct = 0;
        NodoDE aux = this.primero;
        while ( posAct != pos - 1 && aux.siguiente != null){
            aux = aux.siguiente;
            posAct += 1;
        }
        if ( aux.siguiente != null ){
            aux.siguiente = aux.siguiente.siguiente;     
            if ( aux.siguiente != null )
                aux.siguiente.anterior = aux; 
            if ( aux. siguiente == null )
                this.ultimo = aux;
            return true;
        }
        return false;
    }
    
    

    void imprimir() {
        NodoDE aux = this.primero;
        while (aux != null) {
            System.out.println(aux.dato.toString());
            aux = aux.siguiente;
        }
    }
    
    /*
    void imprimir( ComandoImpresion comando) {
        NodoDE aux = this.primero;
        while (aux != null) {
            System.out.println(comando.textoAImprimir( aux.dato ));
            aux = aux.siguiente;
        }
    }
*/
}
