/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spiderbot;

import Interfaz.VentanaSpider;
import Logica.Facade;
import java.io.IOException;

/**
 *
 * @author gabriel
 */
public class Inicializador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here
         MySpiderBot _nuevo = new MySpiderBot(new Facade());
        VentanaSpider ventana=new VentanaSpider(new Facade());
        ventana.setVisible(true);
    }
    
}
