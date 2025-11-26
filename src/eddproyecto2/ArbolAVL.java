/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproyecto2;

/**
 *
 * Implementación de un Árbol Binario de Búsqueda Balanceado (AVL).
 * @author ibrahimbarbar
 */
public class ArbolAVL<T extends Comparable<T>> {
    private NodoAVL<T> raiz;
/**
     * Inserta un nuevo elemento en el árbol AVL manteniendo su balance.
     * Si el árbol se desbalancea tras la inserción, se aplican rotaciones automáticas.
     * * @param dato El dato a insertar.
     */
    public void insertar(T dato) {
        raiz = insertar(raiz, dato);
    }

    private NodoAVL<T> insertar(NodoAVL<T> nodo, T dato) {
        if (nodo == null) {
            return new NodoAVL<>(dato);
        }
        if (dato.compareTo(nodo.dato) < 0) {
            nodo.izquierda = insertar(nodo.izquierda, dato);
        } else if (dato.compareTo(nodo.dato) > 0) {
            nodo.derecha = insertar(nodo.derecha, dato);
        } else {
            return nodo;
        }
        nodo.altura = 1 + Math.max(altura(nodo.izquierda), altura(nodo.derecha));
        int balance = obtenerBalance(nodo);
        if (balance > 1 && dato.compareTo(nodo.izquierda.dato) < 0) {
            return rotarDerecha(nodo);
        }
        if (balance < -1 && dato.compareTo(nodo.derecha.dato) > 0) {
            return rotarIzquierda(nodo);
        }
        if (balance > 1 && dato.compareTo(nodo.izquierda.dato) > 0) {
            nodo.izquierda = rotarIzquierda(nodo.izquierda);
            return rotarDerecha(nodo);
        }
        if (balance < -1 && dato.compareTo(nodo.derecha.dato) < 0) {
            nodo.derecha = rotarDerecha(nodo.derecha);
            return rotarIzquierda(nodo);
        }
        return nodo;
    }

    public T buscar(T dato) {
        return buscar(raiz, dato);
    }
/**
     * Busca un elemento específico dentro del árbol.
     * * @param T dato 
     * @return El objeto encontrado en el árbol, o null si no existe.
     */
    private T buscar(NodoAVL<T> nodo, T dato) {
        if (nodo == null) {
            return null;
        }
        if (dato.compareTo(nodo.dato) == 0) {
            return nodo.dato;
        }
        if (dato.compareTo(nodo.dato) < 0) {
            return buscar(nodo.izquierda, dato);
        }
        return buscar(nodo.derecha, dato);
    }
/**
     * Genera una lista ordenada con todos los elementos del árbol.
     * Realiza un recorrido in orden (Izquierda-Raíz-Derecha).
     * 
     * * @return Una Lista con los elementos ordenados ascendentemente.
     */
    public Lista<T> obtenerListaInOrder() {
    Lista<T> lista = new Lista<>();
    inOrder(raiz, lista);
    return lista;
}

    private void inOrder(NodoAVL<T> nodo, Lista<T> lista) {
    if (nodo != null) {
        inOrder(nodo.izquierda, lista);
        lista.agregar(nodo.dato); 
        inOrder(nodo.derecha, lista);
    }
}

    private int altura(NodoAVL<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.altura;
    }

    private int obtenerBalance(NodoAVL<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        return altura(nodo.izquierda) - altura(nodo.derecha);
    }

    private NodoAVL<T> rotarDerecha(NodoAVL<T> y) {
        NodoAVL<T> x = y.izquierda;
        NodoAVL<T> T2 = x.derecha;
        x.derecha = y;
        y.izquierda = T2;
        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;
        x.altura = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;
        return x;
    }

    private NodoAVL<T> rotarIzquierda(NodoAVL<T> x) {
        NodoAVL<T> y = x.derecha;
        NodoAVL<T> T2 = y.izquierda;
        y.izquierda = x;
        x.derecha = T2;
        x.altura = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;
        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;
        return y;
    }
}