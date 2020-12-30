import java.util.Scanner;
import java.io.*;

public class SpellChecker {

  public static void main(String [] args) {
        
    File f = new File("dictionary");
    
    try {
      Scanner sk = new Scanner(f);
        
      StringSet x = new StringSet();

      while (sk.hasNext()) {
        String word = sk.nextLine();
        x.insert(word);      
      }

      System.out.println("Dicitonary loaded...");
      
      sk = new Scanner(System.in);
      
      while (sk.hasNext()) {
        
        String word = sk.next();

        if (x.find(word)) {
          System.out.println(word + " is correct.");
        } 
        else {
          System.out.println("Suggesting alternatives ...");

          for (int i = 0; i < word.length(); i++) {
            
            for (char j = 'a'; j <= 'z'; j++) {
              
              StringBuffer fixed = new StringBuffer(word);

              fixed.setCharAt(i, j);
              
              if (x.find(fixed.toString())) {
                System.out.println(fixed.toString());
              }
            }
          }
        }
      }
			
    } catch (FileNotFoundException e) {
      System.out.println("Cannot open file ");
      System.out.println(e);
    } 
    
  } 
}