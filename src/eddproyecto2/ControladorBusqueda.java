/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproyecto2;

/**
 *
 * @author ibrahimbarbar
 */
import java.util.List;

public class ControladorBusqueda {
    private ArbolAVL<Autor> arbolAutores;
    private ArbolAVL<PalabraClave> arbolPalabras;

    public ControladorBusqueda(ArbolAVL<Autor> arbolAutores, ArbolAVL<PalabraClave> arbolPalabras) {
        this.arbolAutores = arbolAutores;
        this.arbolPalabras = arbolPalabras;
    }

    public List<Autor> obtenerAutoresOrdenados() {
        return arbolAutores.obtenerListaInOrder();
    }

    public List<String> buscarResumenesPorAutor(String nombreAutor) {
        Autor busqueda = new Autor(nombreAutor);
        Autor encontrado = arbolAutores.buscar(busqueda);
        if (encontrado != null) {
            return encontrado.getTitulosResumenes();
        }
        return null;
    }

    public List<PalabraClave> obtenerPalabrasClaveOrdenadas() {
        return arbolPalabras.obtenerListaInOrder();
    }

    public List<String> buscarResumenesPorPalabra(String palabra) {
        PalabraClave busqueda = new PalabraClave(palabra);
        PalabraClave encontrado = arbolPalabras.buscar(busqueda);
        if (encontrado != null) {
            return encontrado.getTitulosResumenes();
        }
        return null;
    }
}