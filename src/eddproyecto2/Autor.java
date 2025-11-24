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

    public Autor(String nombre) {
        this.nombre = nombre;
        this.titulosResumenes = new Lista<>();
    }

    public void agregarResumen(String titulo) {
        if (!titulosResumenes.contiene(titulo)) {
            titulosResumenes.agregar(titulo);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Lista<String> getTitulosResumenes() {
        return titulosResumenes;
    }

    @Override
    public int compareTo(Autor o) {
        return this.nombre.compareToIgnoreCase(o.nombre);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
