package Spiderbot;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Bryan
 */
public class Testplace {

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
     String p="www.wikipedia.org\"//vi.wikipedia.org/\"";
      System.out.println(p);
      System.out.println("----------------------");
     String replace = p.replace("/", "");
      System.out.println(replace);
      System.out.println("----------------------");
     String replace2 = replace.replace("\"", "");
      System.out.println(replace2);
      String x="\"https//jsafsasd";
        System.out.println(x.substring(4, 5));
        System.out.println(x.contains("https"));
    }}
