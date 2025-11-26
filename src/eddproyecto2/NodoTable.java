/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproyecto2;

/**
 *Nodo especializado para la Tabla Hash.
 * Contiene la clave, el valor (NodoArticulo) y un puntero al siguiente nodo
 * para manejar colisiones por encadenamiento.
 *
 * @author Sebastián Guillén
 */
public class NodoTable {
    String Clave;
    NodoArticulo Valor;
    NodoTable Pnext;

    public NodoTable(String Clave, NodoArticulo Valor) {
        this.Clave = Clave;
        this.Valor = Valor;
        this.Pnext = null;
    }
    
}
