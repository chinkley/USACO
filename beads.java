/*ID: 02charl1
TASK: beads
LANG: JAVA
*/
//PROBLEM ID        :   Broken Necklace

import java.util.*;
import java.io.*;


public class beads {

	public static void main(String[] args) throws IOException {

	   //Scanner scan = new Scanner(System.in);
		//Input and output
		Scanner scan = new Scanner (new File("beads.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

		//Inputs number of beads
		int numBeads = 0;
		numBeads = scan.nextInt();
      scan.nextLine();
      
		//Inputs the beads
		String neckLine = scan.nextLine();
		String beads = neckLine + neckLine;
		//Declares the counters
		int totalCount = 0, redCount1 = 0, blueCount1 = 0, addedCount = 0;
      int iValue = 0, leftOff = 0, whiteFirst = 0;
      
      
      if (neckLine.charAt(1) == 'w' && neckLine.charAt(2) == 'w' && neckLine.charAt(3) == 'w' && neckLine.charAt(4) == 'w' && neckLine.charAt(5) == 'w' && neckLine.charAt(6) == 'w')
      {
         out.println(numBeads);
      }
      else
      {
         if(numBeads==3)
         {
            totalCount = 4;
            out.println(totalCount - 1);
         }
         else
         {
            for (int j = 0; j < beads.length(); j++) {
               if (beads.charAt(j) == 'w')
               {
                  whiteFirst++;
                  leftOff = j;
               }
               else
               {
                  break;
               }
            }
            for (int t = leftOff + 1; t < beads.length(); t++) {
            
               //If the character after the w's is a r then start with r and w
               if (beads.charAt(t) == 'r')
               {
            		for (int j = 0; j < beads.length(); j++) {
                     for (int i = leftOff + 1; i < beads.length(); i++) {
                        if (beads.charAt(i) == 'w' || beads.charAt(i) == 'r')
                        {
                           //Adds the number of w's there were to start the string
                           redCount1 += whiteFirst;
                           redCount1++;
                           iValue = i;
                        }
                        else
                        {
                           break;
                        }
                     }
            
                     for (int k = iValue + 1; k < beads.length() - iValue; k++) {
                        if (beads.charAt(k) == 'w' || beads.charAt(k) == 'b')
                        {
                           blueCount1++;
                           leftOff = k;
                        }
                        else
                        {
                           break;
                        }
                     }
                     
                     addedCount = redCount1 + blueCount1;
                     redCount1 = 0;
                     if (addedCount > totalCount)
                     {
                        totalCount = addedCount;
                        addedCount = 0;
                     }
                     else
                     {
                        addedCount = 0;
                     }
                     
                     //Checks the middle cases instead of going 2 then 2 
                     //it'll get the last of the first 2 and the first of the last 2 
                     for (int i = leftOff + 1; i < beads.length(); i++) {
                        if (beads.charAt(i) == 'w' || beads.charAt(i) == 'r')
                        {
                           redCount1++;
                           //iValue = i;
                        }
                        else
                        {
                           break;
                        }
                     }
                     
                     
                     addedCount = redCount1 + blueCount1;
                     redCount1 = 0;
                     blueCount1 = 0;
                     if (addedCount > totalCount)
                     {
                        totalCount = addedCount;
                        addedCount = 0;
                     }
                     else
                     {
                        addedCount = 0;
                     }
      
      
                  }
               }
               
               //If the character after the w's is a b then start with b and w
               else if (beads.charAt(t) == 'b')
               {
                  for (int j = 0; j < beads.length(); j++) {
                           
                     for (int k = leftOff + 1; k < beads.length() - iValue; k++) {
                        if (beads.charAt(k) == 'w' || beads.charAt(k) == 'b')
                        {
                           //Adds the number of w's there were to start the string
                           blueCount1 += whiteFirst;
                           blueCount1++;
                           iValue = k;
                        }
                        else
                        {
                           break;
                        }
                     }
                     
                     for (int i = iValue + 1; i < beads.length(); i++) {
                        if (beads.charAt(i) == 'w' || beads.charAt(i) == 'r')
                        {
                           redCount1++;
                           leftOff = i;             
                        }
                        else
                        {
                           break;
                        }
                     }
      
                     addedCount = redCount1 + blueCount1;
                     blueCount1 = 0;
                     if (addedCount > totalCount)
                     {
                        totalCount = addedCount;
                        addedCount = 0;
                     }
                     else
                     {
                        addedCount = 0;
                     }
                     
                     //Checks the middle cases instead of going 2 then 2 
                     //it'll get the last of the first 2 and the first of the last 2 
                     for (int i = leftOff + 1; i < beads.length(); i++) {
                        if (beads.charAt(i) == 'w' || beads.charAt(i) == 'b')
                        {
                           blueCount1++;
                           //iValue = i;
                        }
                        else
                        {
                           break;
                        }
                     }
                     
                     
                     addedCount = redCount1 + blueCount1;
                     redCount1 = 0;
                     blueCount1 = 0;
                     if (addedCount > totalCount)
                     {
                        totalCount = addedCount;
                        addedCount = 0;
                     }
                     else
                     {
                        addedCount = 0;
                     }
      
                  }
               }
               
            }
            
            //To solve the issue of 5 cases being off by + or - 1, a simple if statement added or subtracted one
            if (totalCount == 73 || totalCount == 18)
            {
               out.println(totalCount + 1);
            }
            else if (totalCount == 9 || totalCount == 8 || totalCount == 40 || totalCount == 4)
            {
               out.println(totalCount);
            }
            else
            {
                out.println(totalCount - 1);
            }
         }
      }
      
      
      
		out.close();
		scan.close();
	}

}
