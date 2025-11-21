/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproyecto2;

import java.io.*;

public class Persistencia {

  
    public static void guardarDatos(Sistema sistema) {
        try {
            FileOutputStream fileOut = new FileOutputStream("supermetro_data.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(sistema);
            out.close();
            fileOut.close();
            System.out.println("Datos guardados correctamente en supermetro_data.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    
    public static Sistema cargarDatos() {
        Sistema sistema = null;
        try {
            FileInputStream fileIn = new FileInputStream("supermetro_data.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            sistema = (Sistema) in.readObject();
            in.close();
            fileIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontraron datos previos. Iniciando sistema vacío.");
            return new Sistema(); // Retorna un sistema nuevo si no hay archivo
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
            return new Sistema();
        }
        return sistema;
    }
}