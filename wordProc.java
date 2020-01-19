/*ID: kolomoc
TASK: word
LANG: JAVA
*/
//NAME              :   Charlie Hinkley
//GROUP             :   APCS
//LAST MDODIFIED    :   19 January 2020
//PROBLEM ID        :   Word Processor
//DESCRIPTION       :   Outputs as many words on a line without
//                      going over the character limit 
//SOURCES/HELPERS   :   USACO website, Mr. Houtrouw

import java.io.*;
import java.util.*;

public class wordProc 
{

		public static void main(String[] args) throws IOException
		{
			//Takes file input
			Scanner scan = new Scanner (new File("word.in"));
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));
         //Scanner scan = new Scanner(System.in);
			
			//Declares and input values for variables
         int numWords = 0, numChar = 0, counter = 0, counter2 = 0;
         numWords = scan.nextInt();
         numChar = scan.nextInt();
         scan.nextLine();
         
         String[] input = new String[numWords];    
         
         for (int i = 0; i < input.length; i++) {
            input[i] = scan.next();
         }
         
         for (int j = 0; j < input.length; j++) {
            if (input[j].length() + counter <= numChar) {
               System.out.print(input[j]);
               counter += input[j].length();
               
               if (j+1 < input.length) {
                  if (input[j+1].length() + counter <= numChar) {
                     System.out.print(" ");
                  }
               }
            }            
            else {
               System.out.println("");
               counter = 0;
               j--;
            }
         }
         
         
      }
}
