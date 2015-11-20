/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpiderEngine;

/**
 *
 * @author gabriel
 */
public class strings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String p= "/home/gabriel/Dropbox/Datos 1/SEGUNDO PROYECTO/SpiderEngine2/lecturas/Caliente/Carta al Estudiante.pdf";
        System.out.println(p);
        String[] arreglo= p.split("/");
       arreglo[2]="nombre";
       String palabra = "";
       for(int i=0;i<arreglo.length;i++){
           
           palabra+=arreglo[i];
           palabra+="/";
       }
       System.out.println(palabra);
    }
    
}
