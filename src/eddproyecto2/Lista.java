/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproyecto2;

/**
 *
 * @author ibrahimbarbar
 */
public class Lista<T> {
    private NodoLista<T> cabeza;
    private int tamano;

    public Lista() {
        this.cabeza = null;
        this.tamano = 0;
    }
/**
 * 
 * @param dato 
 */
    public void agregar(T dato) {
        NodoLista<T> nuevo = new NodoLista<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoLista<T> actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
        tamano++;
    }
/**
 * 
 * @param dato
 * @return 
 */
    public boolean contiene(T dato) {
        NodoLista<T> actual = cabeza;
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }
/**
 * 
 * @param indice
 * @return 
 */
    public T obtener(int indice) {
        if (indice < 0 || indice >= tamano) {
            return null;
        }
        NodoLista<T> actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getDato();
    }
/**
 * 
 * @return 
 */
    public int getTamano() {
        return tamano;
    }
/**
 * 
 * @return 
 */
    public boolean esVacia() {
        return cabeza == null;
    }
}
