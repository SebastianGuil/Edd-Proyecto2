/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproyecto2;

/**
 *
 * @author ibrahimbarbar
 */
public class ControladorBusqueda {
    private ArbolAVL<Autor> arbolAutores;
    private ArbolAVL<PalabraClave> arbolPalabras;
/**
 * 
 * @param arbolAutores
 * @param arbolPalabras 
 */
    public ControladorBusqueda(ArbolAVL<Autor> arbolAutores, ArbolAVL<PalabraClave> arbolPalabras) {
        this.arbolAutores = arbolAutores;
        this.arbolPalabras = arbolPalabras;
    }
/**
 * 
 * @return 
 */
    public Lista<Autor> obtenerAutoresOrdenados() {
        return arbolAutores.obtenerListaInOrder();
    }
/**
 * 
 * @param nombreAutor
 * @return 
 */
    public Lista<String> buscarResumenesPorAutor(String nombreAutor) {
        Autor busqueda = new Autor(nombreAutor);
        Autor encontrado = arbolAutores.buscar(busqueda);
        if (encontrado != null) {
            return encontrado.getTitulosResumenes();
        }
        return null;
    }
/**
 * 
 * @return 
 */
    public Lista<PalabraClave> obtenerPalabrasClaveOrdenadas() {
        return arbolPalabras.obtenerListaInOrder();
    }
/**
 * 
 * @param palabra
 * @return 
 */
    public Lista<String> buscarResumenesPorPalabra(String palabra) {
        PalabraClave busqueda = new PalabraClave(palabra);
        PalabraClave encontrado = arbolPalabras.buscar(busqueda);
        if (encontrado != null) {
            return encontrado.getTitulosResumenes();
        }
        return null;
    }
}