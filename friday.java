/*ID: 02charl1
TASK: friday
LANG: JAVA
*/

//PROBLEM ID        :   Friday the Thirteenth

import java.io.*;
import java.util.*;

public class friday
{
    public static void main (String[] args) throws IOException
    {
       //Inputs files
       BufferedReader file = new BufferedReader(new FileReader("friday.in"));
       PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
       StringTokenizer st = new StringTokenizer(file.readLine());
       
       
       //Creates and initializes variables
       int yearsNum = 0, daysNum = 0;
       int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
       int[] dayOfWeek = {0, 0, 0, 0, 0, 0, 0};
       final int DAY_MOD = 7, FEB_LEAP_LENGTH = 29, FEB_REG_LENGTH = 28;
       final int START_YEAR = 1900, CENTURY_MOD = 400, LEAP_MOD = 4; 
       final int NOT_CENTURY_MOD = 100, WEEK_LENGTH = 7, MONTHS_LENGTH = 12;
       final int SUN_FRI = 6;
       
       //Receives input from USACO for number of years
       yearsNum = Integer.parseInt(st.nextToken());
       
       
       //Repeats for the number of years 
       for (int yrs = START_YEAR; yrs <= START_YEAR + yearsNum - 1; yrs++)
       {
            //Sets days in February to 29 if it is a leap year
            if(yrs%CENTURY_MOD == 0 || yrs%LEAP_MOD == 0 && yrs%NOT_CENTURY_MOD != 0)
            {
               monthDays[1] = FEB_LEAP_LENGTH;
            }
            
            //Sets days in February to 28 if it is not a leap year
            else
            {
               monthDays[1] = FEB_REG_LENGTH;
            }
            

            //Repeats for all months
            for (int m = 0; m<MONTHS_LENGTH; m++)
            {
               //Adds one to the 13th
               dayOfWeek[daysNum % DAY_MOD]++;
               
               //Calculates next 13th by adding number of days in month
               daysNum+=monthDays[m];
            }
       }
       
       //Repeats for number of days in the week
       for (int d = 0; d < WEEK_LENGTH; d++)
       {
         //If the 13th is on Sunday through Friday
         if (d < SUN_FRI)
         {
            out.print("" + dayOfWeek[d] + " ");
         }
         
         //If the 13th is on Saturday
         else
         {
            out.println("" + dayOfWeek[d]);
         }
       }
       
       //Exits program
       out.close();
    }
}




