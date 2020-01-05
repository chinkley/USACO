/*ID: 02charl1
TASK: namenum
LANG: JAVA
*/
//NAME              :   Charlie Hinkley
//GROUP             :   APCS
//LAST MDODIFIED    :   3 December 2019
//PROBLEM ID        :   Milking Cows
//DESCRIPTION       :   Given a brand number of a cow, prints all 
//                      the valid names that can be generated from 
//                      that brand number 
//SOURCES/HELPERS   :   USACO website, Mr. Houtrouw

import java.io.*;
import java.util.*;

public class namenum
{  
   public static void main(String[] args) throws IOException
   {
      Scanner dictIn = new Scanner(new File("dict.txt"));
      Scanner input = new Scanner(new File("namenum.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
      
      //Declares variables
      String num = "", dict = "", serial = "";
      int counter = 0;
      char count;
      
      //Takes in serial number
      serial = input.nextLine();
      
      while(dictIn.hasNext())
      {
         //Takes in dictionary input
         dict = dictIn.nextLine();
         
         //Declares variables
         boolean check = true;
         num = "";
         
         if(dict.length() != serial.length())
         {
            continue;
         }
         
         for(int i = 0; i < dict.length(); i++)
         {
            count = dict.charAt(i);
            
            if(count == 'Z' || count == 'Q')
            {
               check = false;
               break;
            }
            
            if(check == false)
            {
               break;
            }
            
            //Calculates number for letter
            switch(count)
            {
               case 'A':
                  num += "2";
                  break;
               case 'B':
                  num += "2";
                  break;
               case 'C':
                  num += "2";
                  break;
               case 'D':
                  num += "3";
                  break;
               case 'E':
                  num += "3";
                  break;
               case 'F':
                  num += "3";
                  break;
               case 'G':
                  num += "4";
                  break;
               case 'H':
                  num += "4";
                  break;
               case 'I':
                  num += "4";
                  break;
               case 'J':
                  num += "5";
                  break;
               case 'K':
                  num += "5";
                  break;
               case 'L':
                  num += "5";
                  break;
               case 'M':
                  num += "6";
                  break;
               case 'N':
                  num += "6";
                  break;
               case 'O':
                  num += "6";
                  break;
               case 'P':
                  num += "7";
                  break;
               case 'R':
                  num += "7";
                  break;
               case 'S':
                  num += "7";
                  break;
               case 'T':
                  num += "8";
                  break;
               case 'U':
                  num += "8";
                  break;
               case 'V':
                  num += "8";
                  break;
               case 'W':
                  num += "9";
                  break;
               case 'X':
                  num += "9";
                  break;
               case 'Y':
                  num += "9";
                  break;
            }
          }
          
          //Prints the output
          if(num.equals(serial))
          {
            out.println(dict);
            counter++;
          }
      }
       
      if(counter == 0)
      {
         out.println("NONE");
      }
      
      //Exits program 
      out.close();
       
       
   }
}