/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproyecto2;

/**
 *Nodo fundamental para la estructura del Árbol AVL.
 * Contiene el dato, la referencia a los hijos izquierdo y derecho, y la altura del nodo
 * para cálculos de balanceo.
 * @author ibrahimbarbar
 */
public class NodoAVL<T extends Comparable<T>> {
    T dato;
    int altura;
    NodoAVL<T> izquierda;
    NodoAVL<T> derecha;

    public NodoAVL(T dato) {
        this.dato = dato;
        this.altura = 1;
    }
}
