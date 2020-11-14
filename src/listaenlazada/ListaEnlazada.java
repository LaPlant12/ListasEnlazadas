/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaenlazada;

/**
 *
 * @author laplant
 */
public class ListaEnlazada {
    Nodo cabeza;
    int noNodos;
    
    public ListaEnlazada(int dato){
        cabeza = new Nodo(dato);
        noNodos = 1;
    }
    
    public void append(int dato){ //el rios le dice insEnd, quesesamamada
        Nodo actual = cabeza;
        while(actual.siguiente != null)
            actual = actual.siguiente;
        actual.siguiente = new Nodo(dato);
        noNodos++;
    }
    
    public void prepend(int dato){
        Nodo cabezaNueva = new Nodo(dato);
        cabezaNueva.siguiente = cabeza;
        cabeza = cabezaNueva;
        noNodos++;
    }
    
    /*Pide un dato a buscar y un booleano para decidir si borrar
      todos los nodos que contengan el dato que se quiere buscar
      o solo el primero que encuentre.
      para "borrar" lo que hace es que al encontrar el nodo a borrar
      el nodo anterior a este cambia su nodo siguiente por el siguiente
      del que se quiere borrar, medio confuso lo sé jaja
      gráficamente se podría decir que en lugar de borrarlo, lo salta.
      más sencillo, no? No sé explicar jaja*/
    public void borrar(int dato, boolean todos){ 
        boolean seEncontro = false;
        
        if(cabeza.dato == dato){
            cabeza = cabeza.siguiente;
            seEncontro = true;
            noNodos--;
        }
        else{
            Nodo actual = cabeza;
            while(actual.siguiente.siguiente != null){
                if(actual.siguiente.dato == dato){
                    actual.siguiente = actual.siguiente.siguiente;
                    seEncontro = true;
                    noNodos--;
                    if(todos == false)
                        break;
                }
                else
                    actual = actual.siguiente;
            }
            if(actual.siguiente.dato == dato && seEncontro == false){
                actual.siguiente = null;
                seEncontro = true;
                noNodos--;
            }
        }
        
        if(seEncontro = false)
            System.out.println("No se encontró");
        else
            System.out.println("Borrado");
    }
    
    public void eliminarMedio(){ //borra el/los nodos que estén en medio de la lista
        int iteraciones;
        Nodo actual = cabeza;
        
        if(noNodos % 2 == 0){
            iteraciones = noNodos/2; //ojo: cuando es par hay dos nodos en medio y ambos se remueven
            for (int i = 2; i < iteraciones; i++) {
                actual = actual.siguiente;
            }
            actual.siguiente = actual.siguiente.siguiente.siguiente;
        }
        else{
            iteraciones = ((noNodos-1) / 2) + 1;
            for (int i = 2; i < iteraciones; i++) {
                actual = actual.siguiente;
            }
            actual.siguiente = actual.siguiente.siguiente;
        }
    }
    
    public void mostrarLista(){
        Nodo actual = cabeza;
        int i = 1;
        while(actual.siguiente != null){
            System.out.println("Nodo " + i +": "+actual.dato+ "\n|\nv");
            i++;
            actual = actual.siguiente;
        }
        System.out.println("Nodo " + i +": "+actual.dato);
    }
}
