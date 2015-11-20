/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spiderbot;
import Arboles.Heap;
import Arboles.RedBlackT;
import Arboles.Tree_AVL;
import Logica.Keyword;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;
/**
 *
 * @author bryan
 */
public class SpiderDoc {
    String SourceDirectory;
    Pattern p = Pattern.compile("[a-zA-Z']{3,}");
    Tree_AVL keywords = new Tree_AVL();
    RedBlackT Directories = new RedBlackT();
    Heap tmpfile = new Heap(); 


    

   public SpiderDoc(String pSource) throws IOException, FileNotFoundException, TikaException, SAXException{
       SourceDirectory = pSource;
       getFiles(pSource);
   }
   
   private void getFiles(String Source) throws IOException, FileNotFoundException, TikaException, SAXException{
       File _Documents = new File(Source);
       File[] Docs = _Documents.listFiles();
       for(File pFile : Docs){
           if(!pFile.isDirectory()){
                DocParser(pFile.getAbsolutePath());
                tmpfile.insertar(pFile);
                System.out.println("Documento encontrado");}
           else{
               Directories.insert(pFile.getAbsolutePath());
               System.out.println("Es Directorio");
           }
       }
   }
   private void DocParser(String pRoute) throws FileNotFoundException, IOException, TikaException, SAXException{
            StringBuilder text = new StringBuilder();
            InputStream in = new FileInputStream(new File(pRoute));
            BodyContentHandler TextHand = new BodyContentHandler(10*1024*1024);
            AutoDetectParser parser = new AutoDetectParser();
            Metadata meta = new Metadata();
            parser.parse(in,TextHand,meta);
            text.append(TextHand);
            tokenizer(text.toString());
            
            
   
   }
   private void tokenizer(String pText){
       Matcher m = p.matcher(pText);
       while(m.find()){
           Keyword tmp = new Keyword(m.group());
           tmp.setDirectorio(SourceDirectory);
           keywords.Inserta_AVL(tmp);
           System.out.println("Palabra: "+ m.group());
           
       }
       System.out.println(SourceDirectory);
   }
        
    

}
