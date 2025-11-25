/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproyecto2;

/**
 * 
 * @author ibrahimbarbar
 */
public class Autor implements Comparable<Autor> {
    private String nombre;
    private Lista<String> titulosResumenes;
/**
 * 
 * @param nombre 
 */
    public Autor(String nombre) {
        this.nombre = nombre;
        this.titulosResumenes = new Lista<>();
    }
/**
 * 
 * @param titulo 
 */
    public void agregarResumen(String titulo) {
        if (!titulosResumenes.contiene(titulo)) {
            titulosResumenes.agregar(titulo);
        }
    }
/**
 * 
 * @return 
 */
    public String getNombre() {
        return nombre;
    }
/**
 * 
 * @return 
 */
    public Lista<String> getTitulosResumenes() {
        return titulosResumenes;
    }
/**
 * 
 * @param o
 * @return 
 */
    @Override
    public int compareTo(Autor o) {
        return this.nombre.compareToIgnoreCase(o.nombre);
    }
/**
 * 
 * @return 
 */
    @Override
    public String toString() {
        return nombre;
    }
}
