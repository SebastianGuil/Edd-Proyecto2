/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproyecto2;

/**
 *
 * @author ibrahimbarbar
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GestorArchivos {
/**
 * 
 * @param resumenesFormateados
 * @param rutaArchivo
 * @throws IOException 
 */
    public void guardarInformacion(Lista<String> resumenesFormateados, String rutaArchivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (int i = 0; i < resumenesFormateados.getTamano(); i++) {
            String resumen = resumenesFormateados.obtener(i);
            writer.write(resumen);
            writer.newLine();
            writer.write("---"); 
            writer.newLine();
        }

    }
}
}
