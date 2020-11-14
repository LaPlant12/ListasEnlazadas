/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaenlazada;

import java.util.Scanner;

/**
 *
 * @author laplant
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int noNodos;
        
        System.out.println("Cuántos nodos?: ");
        noNodos = teclado.nextInt();
        System.out.println("Valor del nodo 1: ");
        ListaEnlazada lista = new ListaEnlazada(teclado.nextInt());
        
        for (int i = 2; i <= noNodos; i++) {
            System.out.println("Valor del nodo "+i+": ");
            lista.append(teclado.nextInt());
        }
        System.out.println("Tu lista: ");
        lista.mostrarLista();
        
        System.out.println("Borrar nodo con que dato?: ");
        int dato = teclado.nextInt();
        lista.borrar(dato, false);
        
        System.out.println("Tu lista: ");
        lista.mostrarLista();
        
        System.out.println("\n\n Eliminar el de en medio...");
        lista.eliminarMedio();
        System.out.println("Tu lista: ");
        lista.mostrarLista();
    }
    
}
