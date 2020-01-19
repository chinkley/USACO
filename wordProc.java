/*ID: charliehinkley
TASK: word
LANG: JAVA
*/

//PROBLEM ID        :   Word Processor


import java.io.*;
import java.util.*;

public class wordProc 
{

		public static void main(String[] args) throws IOException
		{
			//File input and output
			Scanner scan = new Scanner (new File("word.in"));
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));
         
			//Declares and input values for variables
         int numWords = 0, numChar = 0, counter = 0, counter2 = 0;
         //Reads in number of words and the character limit
         numWords = scan.nextInt();
         numChar = scan.nextInt();
         scan.nextLine();
         
         String[] input = new String[numWords];    
         
         //Reads in the string into string array
         for (int i = 0; i < input.length; i++) {
            input[i] = scan.next();
         }
         
         //Counts the number of characters in each word
         //And decides if they can be on one line
         for (int j = 0; j < input.length; j++) {
            if (input[j].length() + counter <= numChar) {
               out.print(input[j]);
               counter += input[j].length();
               
               //Adds a space between words, but not at end of line
               if (j+1 < input.length) {
                  if (input[j+1].length() + counter <= numChar) {
                     out.print(" ");
                  }
               }
            }  
            //Moves to next line, takes j back to use the last string tested, 
            //And sets counter to 0        
            else {
               out.println("");
               counter = 0;
               j--;
            }
         }
         
         out.close();
         scan.close();
      }
}
