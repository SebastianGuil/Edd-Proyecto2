/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eddproyecto2;

/**
 *
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
        Vresumen = "Titulo" + this.Titulo + "\n Autores:";
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
        Vresumen = "Articulo:" + this.Resumen + "\n";
        
        
       return Vresumen;
    }
    
    
}
