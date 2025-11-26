/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproyecto2;

/**
 * Representa a un autor dentro del sistema.
 * Almacena el nombre del autor y una lista de los títulos de las investigaciones
 * en las que ha participado.
 * @author ibrahimbarbar
 */
public class Autor implements Comparable<Autor> {
    private String nombre;
    private Lista<String> titulosResumenes;

    public Autor(String nombre) {
        this.nombre = nombre;
        this.titulosResumenes = new Lista<>();
    }
/**
     * Asocia una nueva investigación a este autor.
     * Solo agrega el título si este no se encuentra ya en la lista.
     * * @param titulo El título de la investigación a agregar.
     */
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
