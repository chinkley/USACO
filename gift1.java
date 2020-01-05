/*
 ID: 02charl1
 PROG: gift1
 LANG: JAVA
*/

//PROBLEM ID    :   Greedy Gift Givers 


import java.io.*;
import java.util.*;

public class gift1
{
   public static void main (String[] args) throws IOException
   {  
      //Takes in the file input
      Scanner input = new Scanner(new File("gift1.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
   
      //Declares variables and takes in inputs
      int groupSize = input.nextInt();
      
      String[] names = new String [groupSize];
      int[] bankAccount = new int [groupSize];
      
      //Takes in people input and sets bank accounts to zero
      for (int j = 0; j < groupSize; j++)
      {
         names[j] = input.next();
         bankAccount[j] = 0;
      }
      
      for (int j = 0; j < groupSize; j++)
      {
         //Takes in giving input
         String giver = input.next();
         
         int givingAway = input.nextInt();
         int numReceive = input.nextInt();
         
         //Calculates bank account of the giver
         for (int k = 0; k < groupSize; k++)
         {
            if (giver.equals(names[k]))
            {
               bankAccount[k] -= givingAway;
               
               if (numReceive != 0)
               {
                  bankAccount[k] += givingAway % numReceive;
               }
            }
         }
      
      //Calculates bank account values of the people getting money
      for (int k = 0; k < numReceive; k++)
      {
         String receiver = input.next();
         
         for (int i = 0; i < groupSize; i++)
         {
            if (receiver.equals(names[i]))
            {
               if (numReceive != 0)
               {
                  bankAccount[i] += givingAway / numReceive;
               }
            }
         }
      }
   } 
   
   //Outputs results
   for (int j = 0; j < groupSize; j++)
   {
      out.println("" + names[j] + " " + bankAccount[j]);
   }  
   
   //Exits program
   out.close();
}
}



       
