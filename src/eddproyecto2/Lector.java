/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproyecto2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author sjgg2
 */
public class Lector {
    public File archivo;
    public String Titulo;
    public String[] Autores;
    public String Resumen;
    public String[] PalabrasClav;

    public Lector(File archivo) {
        this.archivo = archivo;
        this.Titulo = Titulo;
        this.Autores = Autores;
        this.Resumen = Resumen;
        this.PalabrasClav = PalabrasClav;
    }

    
    
    public void leer (){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.archivo));
            String linea;
            StringBuilder Titulo = new StringBuilder();
            StringBuilder Resumen = new StringBuilder();
            int Estado = 0;
            String AUT = "";
            while ((linea = reader.readLine()) != null ) {
                linea = linea.trim();
                if (linea.isEmpty()){
                    continue;
                }
                if (linea.equalsIgnoreCase("Autores")){
                Estado = 1;
                continue;
                }
                else if (linea.equalsIgnoreCase("Resumen")) {
                Estado = 2;
                continue;
                }
                else if (linea.toLowerCase().contains("palabras claves")) {
                String contenido = linea.substring(linea.indexOf(":") + 1).trim();
                this.PalabrasClav = contenido.split(",");
                continue;
                }
                switch (Estado){
                    case 0:
                        Titulo.append(linea);
                        this.Titulo = Titulo.toString();
                        break;
                    case 1:
                        AUT = AUT + linea + ",";
                        this.Autores = AUT.split(",");
                        break;
                    case 2:
                        Resumen.append(linea);
                        this.Resumen = Resumen.toString();
                        break;
                }
            }
            reader.close();
        }catch (IOException e) {
            System.out.println("Error leyendo archivo");
        }
    }

}
