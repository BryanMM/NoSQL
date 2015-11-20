/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpiderEngine;

import Logica.Facade;
import Spiderbot.MySpiderBot;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Gabriel
 */
public class pruebagabo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException, ParserConfigurationException, SAXException {
        // TODO code application logic here
       MySpiderEngine _prueba=new MySpiderEngine(new Facade());
       //_prueba.buscar("java arbol");
        
    }
    
}
