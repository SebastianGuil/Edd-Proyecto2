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
    private ArbolAVL<String> arbolTitulos;

    public ControladorBusqueda(ArbolAVL<Autor> arbolAutores, ArbolAVL<PalabraClave> arbolPalabras) {
        this.arbolAutores = arbolAutores;
        this.arbolPalabras = arbolPalabras;
        this.arbolTitulos = new ArbolAVL<>();
    }
    
    public void insertarTitulo(String titulo) {
        arbolTitulos.insertar(titulo);
    }
    
    public Lista<Autor> obtenerAutoresOrdenados() {
        return arbolAutores.obtenerListaInOrder();
    }
    
    public void AgregarAutor(String nombreAutor, String tituloInvestigacion) {
        Autor autorBusqueda = new Autor(nombreAutor);
        Autor autorExistente = arbolAutores.buscar(autorBusqueda);
        if (autorExistente != null) {
            autorExistente.agregarResumen(tituloInvestigacion);
        } else {
            autorBusqueda.agregarResumen(tituloInvestigacion);
            arbolAutores.insertar(autorBusqueda);
    }
}
    
    public void agregarPalabraClave(String palabra, String tituloInvestigacion) {
        String palabraLimpia = palabra.trim();
        if (palabraLimpia.endsWith(".")) {
            palabraLimpia = palabraLimpia.substring(0, palabraLimpia.length() - 1);
        }
        PalabraClave busqueda = new PalabraClave(palabraLimpia);
        PalabraClave encontrada = arbolPalabras.buscar(busqueda);
        if (encontrada != null) {
            encontrada.agregarResumen(tituloInvestigacion);
        } else {
            busqueda.agregarResumen(tituloInvestigacion);
            arbolPalabras.insertar(busqueda);
    }
}
    
    public Lista<String> buscarResumenesPorAutor(String nombreAutor) {
        Autor busqueda = new Autor(nombreAutor);
        Autor encontrado = arbolAutores.buscar(busqueda);
        if (encontrado != null) {
            return encontrado.getTitulosResumenes();
        }
        return null;
    }

    public Lista<String> obtenerListaTitulos() {
    return arbolTitulos.obtenerListaInOrder(); 
    }
    public Lista<PalabraClave> obtenerPalabrasClaveOrdenadas() {
        return arbolPalabras.obtenerListaInOrder();
    }

    public Lista<String> buscarResumenesPorPalabra(String palabra) {
        PalabraClave busqueda = new PalabraClave(palabra);
        PalabraClave encontrado = arbolPalabras.buscar(busqueda);
        if (encontrado != null) {
            return encontrado.getTitulosResumenes();
        }
        return null;
    }
    
    public String ListaInvestigaciones() {
        Lista<String> listaOrdenada = arbolTitulos.obtenerListaInOrder();
        StringBuilder Lista = new StringBuilder();
        
        for (int i = 0; i < listaOrdenada.getTamano(); i++) {
            Lista.append(listaOrdenada.obtener(i)).append("\n");
        }
        return Lista.toString();
    }
    
    
}