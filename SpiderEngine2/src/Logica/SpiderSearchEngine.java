/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.IOException;

/**
 *
 * @author Gabo
 */
public class SpiderSearchEngine {
        Facade _manager;
        
        
       
        
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here
        Facade _gamePlay= new Facade();
        _gamePlay.inicializarSpiderbot();
        
    }
    
}
