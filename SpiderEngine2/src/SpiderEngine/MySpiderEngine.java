/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpiderEngine;
import Arboles.BinaryT;
import Logica.Keyword;
import Logica.MyURL;
import estructurasdedatos.*;
import Interfaz.InterfazGrafica;
import Logica.Facade;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import xmlreader.XMLData;

import xmlreader.XMLReader;



/**
 *
 * @author Gabo
 */
public class MySpiderEngine {
    
    private ListaCircularDoble<MyURL> _urlRecuperadas;
    private BinaryT<Keyword> _binarioKeywords;
    

    private Facade _manager;
    
   

    /**
     *
     * @param _pManager
     */
    public MySpiderEngine(Facade _pManager) throws ParserConfigurationException, SAXException, IOException{
       
        this._manager = _pManager;
        _urlRecuperadas=new ListaCircularDoble();
        XMLData leer= new XMLData();
        this._binarioKeywords=leer.LeerData();
        
       
    }
    public MySpiderEngine(InterfazGrafica pInterfaz) throws ParserConfigurationException, SAXException, IOException{
        XMLData leer= new XMLData();
        this._binarioKeywords=leer.LeerData();
        pInterfaz.setVisible(true);
        
        
    }



    /**
     *
     * @param pUrl
     */
    public void asignarTrustWorthy(MyURL pUrl){
    }

    /**
     *
     * @param pKey
     */
    public ListaCircularDoble<String>  buscar(String pFrase){
        ListaCircularDoble<String> _listaResultados=new ListaCircularDoble();
        String[] _arreglo=pFrase.split(" ");
        System.out.println(_arreglo[0]);
        System.out.println(_binarioKeywords.isEmpty());
                for (int c = 0; c < _arreglo.length; c++){
                    
                    Keyword comparador=new Keyword(_arreglo[c]);
                   
                    if(_binarioKeywords.contains(comparador)!= false){
                        for(int x=0; x<_binarioKeywords.getNode (comparador).getData().getUrlReferencia().getCantidadElementos();x++){
                        _listaResultados.insertarFinal(corregirDirectorio(_binarioKeywords.getNode (comparador).getData().getUrlReferencia().datoIndice(x)));
                        
                        }
                            
                        
                        System.out.println("Resultado");
                        
                       //_listaResultados.insertarFinal(_binarioKeywords.contains(comparador).getData().getDirectorios().);
                       // _binarioKeywords.delete(comparador);
                        }
                    }
                    
                
            
        System.out.println("Cantidad Resultados "+_listaResultados.getCantidadElementos());
        _listaResultados.imprimir();
        return _listaResultados;
    }
    private String corregirDirectorio(String pDirectorio){
        System.out.println(pDirectorio);
        String[] arreglo= pDirectorio.split("/");
        arreglo[2]=System.getProperty("user.name");
        String palabra = "";
        for(int i=0;i<arreglo.length;i++){
           
           palabra+=arreglo[i];
           palabra+="/";
        }
        return palabra;
    }
    
  
    
    
}
