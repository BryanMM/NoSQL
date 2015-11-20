/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author bryan
 */
public class server {
  private static int port = 8000;  
  private  static String fileSended= Constantes.Constantes.PATHXML;  
  private FileInputStream fis = null;
  private BufferedInputStream bis = null;
  private OutputStream os = null;
  private ServerSocket client = null;
  private  Socket sock = null;
  public void sendXML() throws IOException{
      try {
            client = new ServerSocket(port);
      while (true) {
        System.out.println("Waiting...");
        try {
          sock = client.accept();
          System.out.println("Accepted connection : ");
          File myFile = new File (fileSended);
          byte [] mybytearray  = new byte [(int)myFile.length()];
          fis = new FileInputStream(myFile);
          bis = new BufferedInputStream(fis);
          bis.read(mybytearray,0,mybytearray.length);
          os = sock.getOutputStream();
          os.write(mybytearray,0,mybytearray.length);
          os.flush();
          System.out.println("Done.");
        }
        finally {
          if (bis != null) bis.close();
          if (os != null) os.close();
          if (sock!=null) sock.close();
        }
      }
    }
    finally {
      if (client != null) client.close();
    }
  }
  }
    

