package milkUSACO;

/*ID: 02charl1
TASK: milk2
LANG: JAVA
*/
//NAME              :   Charlie Hinkley
//GROUP             :   APCS
//LAST MDODIFIED    :   2 December 2019
//PROBLEM ID        :   Milking Cows
//DESCRIPTION       :   Figures out the longest time interval 
//						at least one cow was milked as well as
//						the longest time interval (after milking starts) 
//						during which no cows were being milked 
//SOURCES/HELPERS   :   USACO website, Mr. Houtrouw

import java.io.*;
import java.util.*;

public class milk2 {

	public static void main(String[] args) throws IOException
	{
		//Takes file input
		Scanner s = new Scanner (new File("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));

		//Initializes variables
		boolean sort = false;
		int num = 0, tempStart, tempEnd;
		int first, second, previousFirst = 0, index = 0, maxTest = 0, maxAct = 0;
		int minTest = 0, minAct = 0, startWindow;
				
		//Takes number of farmers input
		num = s.nextInt();
		int[] start = new int [num], end = new int [num];
		
		//Takes time inputs
		for (int j = 0; j < num; j++)
		{
			start[j] = s.nextInt();
			end[j] = s.nextInt();
		}
			
		//Sorts the array
		while (sort == false)
		{
			sort = true;
			
			for (int i = 0; i < num-1; i++)
			{
				if (start[i] > start[i+1])
				{
					tempStart = start[i+1];
					start[i+1] = start [i];
					start[i] = tempStart;
					
					tempEnd = end[i+1];
					end[i+1] = end[i];
					end[i] = tempEnd;
					
					sort = false;
				}
			}
		}
		
		//Initializes variables
		first = start[0];
		second = end[0];
		
		maxTest = second-first;
		maxAct = maxTest;
		
		previousFirst = first;
		startWindow = 0;
		
		//Calculations for max and min
		for (int k = 0; k < num; k++)
		{
			first = start[k];
			second = end[k];
			
			//Calculates maximum
			if((first <= end[index]) && (second > end[index]))
			{
				maxTest = second - start[startWindow];
			}
			else if( first > end[index])
			{
				maxTest = (second - first);
				startWindow = k;
			}
			
			if(maxTest > maxAct)
			{
				maxAct = maxTest;
			}
			
			//Calculates minimum
			if(first > end[index])
			{
				minTest = (first - end[index]);
				
			}
			
			if(minTest > minAct)
			{
				minAct = minTest;
			}
			
			previousFirst = first;
			
			if(second > end[index])
			{
				index = k;
			}
		}
		
		//Outputs result
		out.println("" + maxAct + " " + minAct);
		
		//Exits program
		out.close();
	}

}
