/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlreader;


import Logica.MyURL;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.*;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Isaac Núñez
 */
public class LeerURL {
    org.w3c.dom.Document dom;
javax.xml.parsers.DocumentBuilderFactory dbf;
javax.xml.parsers.DocumentBuilder db;
public LeerURL(){
        dbf = javax.xml.parsers.DocumentBuilderFactory.newInstance();
        try
        {
          db = dbf.newDocumentBuilder();
          dom = db.parse("ejem.xml");
        }
        catch(Exception ex) {}
        org.w3c.dom.Element rootElement = dom.getDocumentElement();
        org.w3c.dom.NodeList nodeList = rootElement.getElementsByTagName("URL");
        if(nodeList != null && nodeList.getLength()>0)
        {
          for(int i=0;i<nodeList.getLength();i++)
          {
            org.w3c.dom.Element element = (Element)nodeList.item(i);
            if(element.getFirstChild().getNodeValue().equals("link")){
                System.out.println("link "+element.getFirstChild().getNodeValue());
                
            } 
            
            }
          }
        }
        
    


    
}
