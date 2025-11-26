/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproyecto2;

/**
 *Implementación de una Tabla Hash para el almacenamiento eficiente de Resúmenes.
 * Maneja las colisiones mediante encadenamiento.
 * Permite acceso directo a las investigaciones con complejidad O(1) en el caso promedio.
 * @author Sebastian Guillen
 */
public class HashTable {
    private int Tablesize;
    private NodoTable[] Table;

    public HashTable(int Size) {
        this.Tablesize = Size;
        this.Table = new NodoTable[this.Tablesize];
    }
    
    
    /**
     * Calcula el índice del arreglo donde debe almacenarse una clave.
     * Utiliza una función polinómica personalizada para distribuir las claves uniformemente.
     * * @param Clave El título de la investigación o palabra clave.
     * @return Un entero representando el índice válido en la tabla.
     */
    public int getIndiceHash(String Clave) {
        char[] arrCodigo = Clave.trim().toLowerCase().toCharArray();
        int Codigo = 0;
        for (int i=0; i< arrCodigo.length - 1; i++){
            Codigo = Codigo + (arrCodigo[i]*20^(arrCodigo.length - (i+1)));
        }
        int Indice = Codigo % this.Tablesize;
        return Math.abs(Indice);
    }
    
    public Lista<NodoArticulo> obtenerTodos() {
    Lista<NodoArticulo> listaCompleta = new Lista<>();
    for (int i = 0; i < this.Tablesize; i++) {
        NodoTable actual = this.Table[i];
        while (actual != null) {
            listaCompleta.agregar(actual.Valor);
            actual = actual.Pnext;
        }
    }
    return listaCompleta;
}
    /**
     * Inserta un nuevo nodo en la tabla hash.
     * Si el índice ya está ocupado, maneja la colisión agregando el nodo a la lista enlazada.
     * * @param NClave La clave única (título).
     * @param NValor El objeto NodoArticulo que contiene la información.
     */
    public void Insertar (String NClave, NodoArticulo NValor){
        int IndiceHash = getIndiceHash(NClave);
        NodoTable Pnew = new NodoTable(NClave, NValor);
        if (this.Table[IndiceHash]==null){
            this.Table[IndiceHash] = Pnew;
        }else{
            NodoTable Aux = this.Table[IndiceHash];
            while (Aux.Pnext != null){
                Aux = Aux.Pnext;
            }
            Aux.Pnext = Pnew;
        }
    }
    
    public String getValor (String Clave){
        String Final = "";
        int IndiceHash = getIndiceHash (Clave);
        NodoTable Aux = this.Table[IndiceHash];
        while(Aux!=null){
            if (Aux.Clave.equals(Clave)){
                String Autores = "";
                String Palabras = "";
                Final = Final + "El titulo es: " + Aux.Valor.Titulo + "\n";
                for (int i = 0; i < Aux.Valor.Autores.length; i++) {
                Autores = Autores + Aux.Valor.Autores[i].trim();
                if (i < Aux.Valor.Autores.length - 1) {
                Autores = Autores + ", ";
                }}
                for (int i = 0; i < Aux.Valor.PalClaves.length; i++) {
                Palabras = Palabras + Aux.Valor.PalClaves[i].trim();
                if (i < Aux.Valor.PalClaves.length - 1) {
                Palabras = Palabras + ", ";}
                }
                Final = Final + "Los Autores son: " + Autores+ "\n";
                Final = Final + "El Resumen es: " + Aux.Valor.Resumen + "\n";
                Final = Final + "Las Palabras Claves son: " + Palabras;
            }
            Aux = Aux.Pnext;
        }
       return Final; 
    }
    
    public NodoArticulo getNodoArticulo(int indiceHash){
        return this.Table[indiceHash].Valor;
    }
    
    public NodoTable getNodoTable(int indiceHash){
        return this.Table[indiceHash];
    }
            
            
    public boolean existe (String clave){
        int IndiceHash = getIndiceHash(clave);
        NodoTable Aux = this.Table[IndiceHash];
        if (Aux == null){
            return false;
        }else{
            return true;
        }
    }
    /**
     * /**
     * Author: DanielBarreda
     * Method: Itera por todos los indices del hash table en busqueda de valores distintos de null.
     * @return: cadena: un string con todos los nombres de investigaciones disponibles. 
     */
    
    public String mapear(){
        String cadena = "";
        for (int i=0; i< this.Tablesize; i++){
            if (this.Table[i] != null)
                cadena = cadena + this.Table[i].Valor.Titulo + "\n";
        }
        return cadena;
    }
    
}
