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

public class PalabraClave implements Comparable<PalabraClave> {
    private String palabra;
    private List<String> titulosResumenes;

    public PalabraClave(String palabra) {
        this.palabra = palabra;
        this.titulosResumenes = new ArrayList<>();
    }

    public void agregarResumen(String titulo) {
        if (!titulosResumenes.contains(titulo)) {
            titulosResumenes.add(titulo);
        }
    }

    public String getPalabra() {
        return palabra;
    }

    public List<String> getTitulosResumenes() {
        return titulosResumenes;
    }

    @Override
    public int compareTo(PalabraClave o) {
        return this.palabra.compareToIgnoreCase(o.palabra);
    }

    @Override
    public String toString() {
        return palabra;
    }
}