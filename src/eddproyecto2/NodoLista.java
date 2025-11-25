/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproyecto2;

/**
 *
 * @author ibrahimbarbar
 */
public class NodoLista<T> {
    private T dato;
    private NodoLista<T> siguiente;
/**
 * 
 * @param dato 
 */
    public NodoLista(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
/**
 * 
 * @return 
 */
    public T getDato() {
        return dato;
    }
/**
 * 
 * @param dato 
 */
    public void setDato(T dato) {
        this.dato = dato;
    }
/**
 * 
 * @return 
 */
    public NodoLista<T> getSiguiente() {
        return siguiente;
    }
/**
 * 
 * @param siguiente 
 */
    public void setSiguiente(NodoLista<T> siguiente) {
        this.siguiente = siguiente;
    }
}
