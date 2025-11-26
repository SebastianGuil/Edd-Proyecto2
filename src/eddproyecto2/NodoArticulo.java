/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproyecto2;

/**
 *Clase que modela la inforación de una investigación científica.
 * Contiene el título, autores, resumen y palabras clave, además de funcionalidades
 * para analizar la frecuencia de términos.
 * @author sjgg2
 */
public class NodoArticulo {
    String Titulo;
    String [] Autores;
    String Resumen;
    String [] PalClaves;

    public NodoArticulo(String Titulo, String[] Autores, String Resumen, String[] PalClaves) {
        this.Titulo = Titulo;
        this.Autores = Autores;
        this.Resumen = Resumen;
        this.PalClaves = PalClaves;
    }
    
    
    public String VerResumen (){
        String Vresumen = "";
        Vresumen = "Titulo: " + this.Titulo + "\n Autores:\n";
        int i = 0;
        while ( i <Autores.length){
            Vresumen = Vresumen + Autores[i];
         if (i < Autores.length - 1){
             Vresumen = Vresumen + ", \n";
         }else{
              Vresumen = Vresumen + ". \n";
         }
         i = i +1;
        }
        Vresumen = "Articulo: " + this.Resumen + "\n";
        
        
       return Vresumen;
    }
    
    /**
     * Author: Daniel Barreda.
     * @return: Vresumen: un string con el resumen de la investigacion indicando titulo, autores y palabras clave con la frecuencia en la que aparecen
     */
    public String analizarResumen (){
        String Vresumen = "";
        Vresumen = "Titulo: " + this.Titulo + "\n Autores:";
        int i = 0;
        while ( i <Autores.length){
            Vresumen = Vresumen + Autores[i];
         if (i < Autores.length - 1){
             Vresumen = Vresumen + ", \n";
         }else{
              Vresumen = Vresumen + ". \nFrecuencia de las palabras clave: \n";
         }
         i = i +1;
        }
        int frecuencia;
        String strFrecuencia = "";
        for (int j = 0; j < this.PalClaves.length; j++){
            frecuencia = this.frecuencia(this.PalClaves[j]);
            strFrecuencia = strFrecuencia + (j + 1) + ".-" + this.PalClaves[j] + ": " + frecuencia + " veces.\n";
        }
        Vresumen = Vresumen + strFrecuencia;
        
       return Vresumen;
    }
    
    /**
     * Author: DanielBarreda
     * 
     * @param palabra: palabra clave cuya frecuencia se quiere obtener
     * @return: la frecuencia con la que aparece en el resumen 
     */
    public int frecuencia(String palabra){
        int frecuencia = this.Resumen.trim().split(palabra).length;
        return frecuencia;
    }
    
}
