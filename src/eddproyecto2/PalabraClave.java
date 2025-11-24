/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproyecto2;

/**
 *
 * @author ibrahimbarbar
 */
public class PalabraClave implements Comparable<PalabraClave> {
    private String palabra;
    private Lista<String> titulosResumenes;

    public PalabraClave(String palabra) {
        this.palabra = palabra;
        this.titulosResumenes = new Lista<>();
    }

    public void agregarResumen(String titulo) {
        if (!titulosResumenes.contiene(titulo)) {
            titulosResumenes.agregar(titulo);
        }
    }

    public String getPalabra() {
        return palabra;
    }

    public Lista<String> getTitulosResumenes() {
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