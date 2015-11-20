
package Logica;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
/**
 *
 * @author bryan
 */
public class client {
  private static int port = 8000;   
  private static String server = Constantes.Constantes.IPADRESS;
  private static String routeFile = Constantes.Constantes.PATHDESCARGA;  
    int bytesRead;
    int current = 0;
    FileOutputStream xmlin = null;
    BufferedOutputStream buffer = null;
    Socket sock = null;

  private static int file_size = 6022386; 
  
    /**
     * Metodo que descarga el XML localmente
     * @throws IOException
     */
    public void getXML() throws IOException{
    
    try {
      sock = new Socket(server, port);
      System.out.println("Connecting...");
      byte [] bytearray  = new byte [file_size];
      InputStream data = sock.getInputStream();
      xmlin = new FileOutputStream(routeFile);
      buffer = new BufferedOutputStream(xmlin);
      bytesRead = data.read(bytearray,0,bytearray.length);
      current = bytesRead;
      do {
         bytesRead =
            data.read(bytearray,current,(bytearray.length-current));
         if(bytesRead >= 0) current += bytesRead;
      } while(bytesRead > -1);

      buffer.write(bytearray, 0 , current);
      buffer.flush();
      System.out.println("File "+routeFile+"downloaded");
    }
    finally {
      if (xmlin != null) xmlin.close();
      if (buffer != null) buffer.close();
      if (sock != null) sock.close();
    }
  }
}
    

