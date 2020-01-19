/*ID: 02charl1
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
			//Takes file input
			Scanner scan = new Scanner (new File("word.in"));
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));
			
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
