import java.util.Scanner;

public class Genomes {

  public static void main(String [] args) {
    
    try {
      Scanner sk = new Scanner(System.in);
        
      StringSet x = new StringSet();

      while (sk.hasNext()) {
        String word = sk.nextLine();
        x.insert(word);    
      }

      sk.close();

      x.setAnswer();

      String[] answer = x.getInfo();

      System.out.println("The longest word that appears multiple times is: " + answer[2]);
      System.out.println("It appears " + answer[0] + " times, and its length is " + answer[1]);
			
    } catch (Exception e) {
      System.out.println("Cannot Open File");
      System.out.println(e);
    } 
    
  } 
}