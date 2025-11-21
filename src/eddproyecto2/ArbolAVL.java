/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproyecto2;

import java.text.Collator;
import java.util.Locale;

public class ArbolAVL {
    private NodoAVL raiz;
    private final Collator collator;

    public ArbolAVL() {
    
        collator = Collator.getInstance(new Locale("es", "ES"));
        collator.setStrength(Collator.PRIMARY);
    }

    public NodoAVL getRaiz() {
        return raiz;
    }



    public void insertar(String dato, Object resumenAsociado) {
        raiz = insertarRec(raiz, dato, resumenAsociado);
    }


    public NodoAVL buscar(String dato) {
        return buscarRec(raiz, dato);
    }


    public String inOrden() {
        StringBuilder sb = new StringBuilder();
        inOrdenRec(raiz, sb);
        return sb.toString();
    }

  

    private NodoAVL insertarRec(NodoAVL nodo, String dato, Object resumenAsociado) {
        if (nodo == null) {
            NodoAVL nuevo = new NodoAVL(dato);
            nuevo.agregarResumen(resumenAsociado);
            return nuevo;
        }

        int comparacion = collator.compare(dato, nodo.dato);

        if (comparacion < 0)
            nodo.izquierda = insertarRec(nodo.izquierda, dato, resumenAsociado);
        else if (comparacion > 0)
            nodo.derecha = insertarRec(nodo.derecha, dato, resumenAsociado);
        else {
            nodo.agregarResumen(resumenAsociado);
            return nodo;
        }


        nodo.altura = 1 + max(altura(nodo.izquierda), altura(nodo.derecha));

      
        int fe = getFactorEquilibrio(nodo);

     

      
        if (fe > 1 && collator.compare(dato, nodo.izquierda.dato) < 0)
            return rotacionDerecha(nodo);

       
        if (fe < -1 && collator.compare(dato, nodo.derecha.dato) > 0)
            return rotacionIzquierda(nodo);

   
        if (fe > 1 && collator.compare(dato, nodo.izquierda.dato) > 0) {
            nodo.izquierda = rotacionIzquierda(nodo.izquierda);
            return rotacionDerecha(nodo);
        }


        if (fe < -1 && collator.compare(dato, nodo.derecha.dato) < 0) {
            nodo.derecha = rotacionDerecha(nodo.derecha);
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    private NodoAVL buscarRec(NodoAVL nodo, String dato) {
        if (nodo == null) return null;
        
        int comparacion = collator.compare(dato, nodo.dato);
        
        if (comparacion == 0) return nodo;
        if (comparacion < 0) return buscarRec(nodo.izquierda, dato);
        return buscarRec(nodo.derecha, dato);
    }

    private void inOrdenRec(NodoAVL nodo, StringBuilder sb) {
        if (nodo != null) {
            inOrdenRec(nodo.izquierda, sb);
            sb.append(nodo.dato).append("\n"); // Formato simple
            inOrdenRec(nodo.derecha, sb);
        }
    }

   

    private int altura(NodoAVL N) {
        return (N == null) ? 0 : N.altura;
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private int getFactorEquilibrio(NodoAVL N) {
        return (N == null) ? 0 : altura(N.izquierda) - altura(N.derecha);
    }

    private NodoAVL rotacionDerecha(NodoAVL y) {
        NodoAVL x = y.izquierda;
        NodoAVL T2 = x.derecha;

    
        x.derecha = y;
        y.izquierda = T2;

      
        y.altura = max(altura(y.izquierda), altura(y.derecha)) + 1;
        x.altura = max(altura(x.izquierda), altura(x.derecha)) + 1;

        return x;
    }

    private NodoAVL rotacionIzquierda(NodoAVL x) {
        NodoAVL y = x.derecha;
        NodoAVL T2 = y.izquierda;

     
        y.izquierda = x;
        x.derecha = T2;

       
        x.altura = max(altura(x.izquierda), altura(x.derecha)) + 1;
        y.altura = max(altura(y.izquierda), altura(y.derecha)) + 1;

        return y;
    }
}

class NodoAVL {
    String dato;                 
    ListaDinamica resumenes;     
    NodoAVL izquierda, derecha;
    int altura;

    public NodoAVL(String dato) {
        this.dato = dato;
        this.resumenes = new ListaDinamica();
        this.altura = 1;
    }
    
    public void agregarResumen(Object resumen) {
        this.resumenes.agregar(resumen);
    }
    
   
    public ListaDinamica getResumenes() {
        return this.resumenes;
    }
}

class ListaDinamica {
    private NodoLista cabeza;
    private int tamano;

    private class NodoLista {
        Object contenido;
        NodoLista siguiente;
        NodoLista(Object c) { this.contenido = c; this.siguiente = null; }
    }

    public void agregar(Object obj) {
        NodoLista nuevo = new NodoLista(obj);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoLista temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
        }
        tamano++;
    }
    
    public int getTamano() { return tamano; }
    
    
    public Object[] toArray() {
        Object[] arr = new Object[tamano];
        NodoLista temp = cabeza;
        int i = 0;
        while(temp != null) {
            arr[i++] = temp.contenido;
            temp = temp.siguiente;
        }
        return arr;
    }
}