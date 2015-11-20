/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spiderbot;

import Interfaz.VentanaSpider;
import Logica.Facade;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

/**
 *
 * @author Gabriel
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     * @throws java.io.FileNotFoundException
     * @throws org.apache.tika.exception.TikaException
     * @throws org.xml.sax.SAXException
     */
    public static void main(String[] args) throws IOException, InterruptedException, FileNotFoundException, TikaException, SAXException {
        MySpiderBot _nuevo = new MySpiderBot(new Facade());
        VentanaSpider ventana=new VentanaSpider(new Facade());
        ventana.setVisible(true);
        
        
        
       
        // TODO code application logic here
    }
    
}
