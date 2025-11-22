/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproyecto2;

/**
 *
 * @author ibrahimbarbar
 */
import java.util.ArrayList;
import java.util.List;

public class Autor implements Comparable<Autor> {
    private String nombre;
    private List<String> titulosResumenes;

    public Autor(String nombre) {
        this.nombre = nombre;
        this.titulosResumenes = new ArrayList<>();
    }

    public void agregarResumen(String titulo) {
        if (!titulosResumenes.contains(titulo)) {
            titulosResumenes.add(titulo);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getTitulosResumenes() {
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
