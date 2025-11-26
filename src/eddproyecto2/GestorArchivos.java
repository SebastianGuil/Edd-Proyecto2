/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproyecto2;

/**
 *Se encarga de las operaciones de Entrada/Salida y/o relacionadas con el almacenamiento.
 * @author ibrahimbarbar
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GestorArchivos {

    public void guardarInformacion(Lista<String> resumenesFormateados, String rutaArchivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (int i = 0; i < resumenesFormateados.getTamano(); i++) {
            String resumen = resumenesFormateados.obtener(i); // Obtenemos manual
            writer.write(resumen);
            writer.newLine();
            writer.write("---"); 
            writer.newLine();
        }

    }
}
    /**
     * Guarda todas las investigaciones cargadas en un archivo de texto plano.
     * El formato de salida es compatible con el formato de lectura del sistema.
     * * @param articulos La lista completa de nodos de artículo proveniente del HashTable.
     */
    public void guardarRepositorio(Lista<NodoArticulo> articulos) {
        String ruta = "repositorio.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {
            for (int i = 0; i < articulos.getTamano(); i++) {
                NodoArticulo art = articulos.obtener(i);
                writer.write(art.Titulo);
                writer.newLine();
                writer.write("Autores");
                writer.newLine();
                String lineaAutores = "";
                for (int k = 0; k < art.Autores.length; k++) {
                    lineaAutores += art.Autores[k];
                    if (k < art.Autores.length - 1) {
                        lineaAutores += ", ";
                }
            }
            writer.write(lineaAutores);
            writer.newLine();
            writer.write("Resumen");
            writer.newLine();
            writer.write(art.Resumen); // Asumimos que el resumen no tiene saltos de linea locos
            writer.newLine();
            writer.write("Palabras claves: "); 
            String lineaPalabras = "";
            for (int k = 0; k < art.PalClaves.length; k++) {
                lineaPalabras += art.PalClaves[k];
                if (k < art.PalClaves.length - 1) {
                    lineaPalabras += ", ";
                }
            }
            writer.write(lineaPalabras + "."); 
            writer.newLine();
            writer.write("--------------------------------------------------");
            writer.newLine();
        }
            System.out.println("Información guardada correctamente en " + ruta);
        } catch (IOException e) {
            System.err.println("Error guardando el archivo: " + e.getMessage());
    }
}
    
    
}
